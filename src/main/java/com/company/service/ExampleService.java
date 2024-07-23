package com.company.service;

import com.company.dto.request.ExamRequest;
import com.company.dto.request.QuestionAnswerRequest;
import com.company.dto.response.QuestionResponse;
import com.company.dto.response.UserExamResponse;
import com.company.dto.response.UserRankResponse;
import com.company.entity.*;
import com.company.exception.*;
import com.company.mapper.ExamMapper;
import com.company.repository.ExamRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExampleService {
    private final UserService userService;
    private final QuestionService questionService;
    private final AnswerService answerService;
    private final ExamRepository examRepository;

    public List<QuestionResponse> getExample() {
        try {
            return questionService.getRandomQuestion(10);
        } catch (Exception e) {
            CustomException.handleUnexpectedException(e);
        }
        return null;
    }


    @Transactional
    public Double createExample(ExamRequest examRequest) {
        try {
            double totalResult = examRequest.questionAnswers().stream()
                    .flatMapToDouble(questionAnswer -> questionAnswer.answerIds().stream()
                            .mapToDouble(
                                    answerId -> answerService.checkCorrectAnswer(
                                            answerId, questionAnswer.questionId()
                                    )
                            ))
                    .sum();

            double percentage = calculatePercentage(totalResult, 10);
            saveExam(examRequest, percentage);
            return percentage;
        } catch (UserNotFoundException | QuestionNotFoundException | AnswerNotFoundException | ValidationException e) {
            CustomException.handleOperationException(e);
        } catch (Exception e) {
            CustomException.handleUnexpectedException(e);
        }
        return null;
    }

    @Transactional
    protected void saveExam(ExamRequest examRequest, double percentage) {
        Exam exam = new Exam();
        User user = userService.findById(examRequest.userId());
        exam.setUser(user);
        exam.setScore(percentage);

        List<ExamQuestionAnswer> examQuestionAnswers = new ArrayList<>();

        for (QuestionAnswerRequest questionAnswer : examRequest.questionAnswers()) {
            Question question = questionService.getQuestionByQuestionId(questionAnswer.questionId());
            for (String answerId : questionAnswer.answerIds()) {
                Answer answer = answerService.getAnswerByAnswerId(answerId);
                ExamQuestionAnswer examQuestionAnswer = new ExamQuestionAnswer();
                examQuestionAnswer.setExam(exam);
                examQuestionAnswer.setQuestion(question);
                examQuestionAnswer.setAnswer(answer);
                examQuestionAnswers.add(examQuestionAnswer);
            }
        }

        exam.setQuestionAnswers(examQuestionAnswers);
        examRepository.save(exam);
    }

    private Double calculatePercentage(double totalScore, int numberOfQuestions) {
        return totalScore * 100 / numberOfQuestions;
    }

    public ResponseEntity<List<UserExamResponse>> getTopUserExam() {
        Pageable topTen = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "score"));
        List<Exam> content = examRepository.findAll(topTen).getContent();
        List<UserExamResponse> list = content.stream().map(ExamMapper.INSTANCE::convertToExamMapper).toList();
        return ResponseEntity.ok(list);
    }

    public ResponseEntity<UserRankResponse> getUserRank(String userId) {
        Double userScore = examRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("User not found"))
                .getScore();

        Long rank = examRepository.countByScoreGreaterThan(userScore) + 1;

        return ResponseEntity.ok(new UserRankResponse(userId, userScore, rank));
    }
}
