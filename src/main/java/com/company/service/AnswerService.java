package com.company.service;

import com.company.dto.request.AnswerRequest;
import com.company.dto.response.AnswerResponse;
import com.company.entity.Answer;
import com.company.exception.AnswerNotFoundException;
import com.company.exception.CustomException;
import com.company.exception.ValidationException;
import com.company.mapper.AnswerMapper;
import com.company.repository.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnswerService {
    private final AnswerRepository answerRepository;

    public AnswerResponse updateAnswerById(String id, AnswerRequest answerRequest) {
        try {
            Answer foundAnswer = getAnswerById(id);
            Answer answer = AnswerMapper.INSTANCE.convertAnswerRequestToAnswer(answerRequest);
            foundAnswer.setAnswer(answer.getAnswer());
            foundAnswer.setIsCorrect(answer.getIsCorrect());
            answerRepository.saveAndFlush(foundAnswer);
            return AnswerMapper.INSTANCE.convertAnswerToAnswerResponse(foundAnswer);
        } catch (ValidationException | AnswerNotFoundException e) {
            CustomException.handleOperationException(e);
        } catch (Exception e) {
            CustomException.handleUnexpectedException(e);
        }
        return null;
    }

    public double checkCorrectAnswer(String answerId, String questionId) {
        Answer answer = answerRepository.getReferenceById(answerId);

        if (questionId.equals(answer.getQuestion().getId()) && Boolean.TRUE.equals(answer.getIsCorrect())) {
            return switch (answer.getQuestion().getChoice()) {
                case SINGLE -> 1;
                case DOUBLE -> 0.5;
                case TRIPLE -> 1.0 / 3;
            };
        }
        return 0;
    }

    private Answer getAnswerById(String id) {
        return answerRepository.findById(id).orElseThrow(() -> new AnswerNotFoundException("answer not found"));
    }

    public Answer getAnswerByAnswerId(String answerId) {
        return answerRepository.findById(answerId).orElseThrow(() -> new AnswerNotFoundException("answer not found"));
    }
}
