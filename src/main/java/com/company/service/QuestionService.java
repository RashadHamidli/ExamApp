package com.company.service;

import com.company.dto.request.QuestionRequest;
import com.company.dto.request.QuestionUpdateRequest;
import com.company.dto.response.QuestionResponse;
import com.company.entity.Choice;
import com.company.entity.Question;
import com.company.exception.CustomException;
import com.company.exception.QuestionNotFoundException;
import com.company.exception.ValidationException;
import com.company.mapper.QuestionMapper;
import com.company.repository.QuestionRepository;
import com.company.util.LoggerUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final Logger logger = LoggerFactory.getLogger(QuestionService.class);
    private final QuestionRepository questionRepository;

    public List<QuestionResponse> getAllQuestion() {
        try {
            List<Question> questions = questionRepository.findAll();
            if (questions.isEmpty()) {
                throw new QuestionNotFoundException("No Questions found");
            }
            LoggerUtil.getLoggerInfo(logger, "getAllQuestion", questions);
            return questions.stream().map(QuestionMapper.INSTANCE::convertQuestionToQuestionResponse).toList();
        } catch (ValidationException | QuestionNotFoundException e) {
            CustomException.handleOperationException(e);
        } catch (Exception e) {
            CustomException.handleUnexpectedException(e);
        }
        return null;
    }

    public QuestionResponse saveQuestion(QuestionRequest questionRequest) {
        try {
            Question question = QuestionMapper.INSTANCE.convertQuestionRequestToQuestion(questionRequest);
            question.getAnswers().forEach(answer -> answer.setQuestion(question));
            Question savedQuestion = questionRepository.save(question);
            LoggerUtil.getLoggerInfo(logger, "saveQuestion", savedQuestion);
            return QuestionMapper.INSTANCE.convertQuestionToQuestionResponse(savedQuestion);
        } catch (ValidationException | QuestionNotFoundException e) {
            CustomException.handleOperationException(e);
        } catch (Exception e) {
            CustomException.handleUnexpectedException(e);
        }
        return null;
    }

    @Transactional
    public QuestionResponse updateQuestion(Long id, QuestionUpdateRequest questionUpdateRequest) {
        try {
            Question question = getQuestionByQuestionId(id);
            question.setQuestion(questionUpdateRequest.question());
            question.setChoice(Choice.valueOf(questionUpdateRequest.choice()));
            Question saved = questionRepository.saveAndFlush(question);
            LoggerUtil.getLoggerInfo(logger, "updateQuestion", saved);
            return QuestionMapper.INSTANCE.convertQuestionToQuestionResponse(saved);
        } catch (ValidationException | QuestionNotFoundException e) {
            CustomException.handleOperationException(e);
        } catch (Exception e) {
            CustomException.handleUnexpectedException(e);
        }
        return null;
    }

    @Transactional
    public void deleteQuestion(Long id) {
        try {
            Question question = getQuestionByQuestionId(id);
            question.setStatus("inActive");
            LoggerUtil.getLoggerInfo(logger, "deleteQuestion", question);
            questionRepository.saveAndFlush(question);
        } catch (ValidationException | QuestionNotFoundException e) {
            CustomException.handleOperationException(e);
        } catch (Exception e) {
            CustomException.handleUnexpectedException(e);
        }
    }

    @Transactional
    public QuestionResponse getQuestionById(Long id) {
        try {
            Question question = getQuestionByQuestionId(id);
            LoggerUtil.getLoggerInfo(logger, "getQuestionById", question);
            return QuestionMapper.INSTANCE.convertQuestionToQuestionResponse(question);
        } catch (ValidationException | QuestionNotFoundException e) {
            CustomException.handleOperationException(e);
        } catch (Exception e) {
            CustomException.handleUnexpectedException(e);
        }
        return null;
    }

    public List<QuestionResponse> getRandomQuestion(int count) {
        try {
            List<Question> randomQuestions = questionRepository.findRandomQuestions();
            return randomQuestions.stream().map(QuestionMapper.INSTANCE::convertQuestionToQuestionResponse).toList();
        } catch (ValidationException | QuestionNotFoundException e) {
            CustomException.handleOperationException(e);
        } catch (Exception e) {
            CustomException.handleUnexpectedException(e);
        }
        return null;
    }

    @Transactional(Transactional.TxType.SUPPORTS)
    protected Question getQuestionByQuestionId(Long questionId) {
        return questionRepository.findById(questionId).orElseThrow(() -> new QuestionNotFoundException("Question not found"));
    }
}
