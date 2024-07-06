package com.company.service;

import com.company.dto.request.ExampleRequest;
import com.company.dto.response.QuestionResponse;
import com.company.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExampleService {
    private final QuestionService questionService;
    private final AnswerService answerService;

    public List<QuestionResponse> getExample() {
        try {
            return questionService.getRandomQuestion(10);
        } catch (Exception e) {
            CustomException.handleUnexpectedException(e);
        }
        return null;
    }

    public Double createExample(ExampleRequest exampleRequest) {
        try {
            double totalResult = exampleRequest.questionAnswers().stream()
                    .flatMapToDouble(questionAnswer -> questionAnswer.answerIds().stream()
                            .mapToDouble(answerId -> answerService.checkCorrectAnswer(answerId, questionAnswer.questionId())))
                    .sum();
            return calculatePercentage(totalResult, 10);
        } catch (Exception e) {
            CustomException.handleUnexpectedException(e);
        }
        return null;
    }

    private Double calculatePercentage(double totalScore, int numberOfQuestions) {
        return totalScore * 100 / numberOfQuestions;
    }

}
