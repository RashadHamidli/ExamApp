package com.company.service;

import com.company.dto.request.ExampleRequest;
import com.company.dto.response.QuestionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExampleService {
    private final QuestionService questionService;
    private final AnswerService answerService;

    public List<QuestionResponse> getExample() {
        return questionService.getRandomQuestion(10);
    }

    public Double createExample(ExampleRequest exampleRequest) {
        return exampleRequest.questionAnswers().stream()
                .mapToDouble(questionAnswer -> {
                    Long questionId = questionAnswer.questionId();
                    return questionAnswer.answerIds().stream()
                            .mapToDouble(answerId -> answerService.checkCorrectAnswer(answerId, questionId))
                            .sum();
                })
                .sum();
    }

}
