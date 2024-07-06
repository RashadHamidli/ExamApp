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

    public AnswerResponse updateAnswerById(Long id, AnswerRequest answerRequest) {
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

    public double checkCorrectAnswer(Long answerId, Long questionId) {
        Answer answer = answerRepository.getReferenceById(answerId);

        if (questionId.equals(answer.getQuestion().getId()) && Boolean.TRUE.equals(answer.getIsCorrect())) {
            return switch (answer.getQuestion().getChoice()) {
                case SINGLE_CHOICE -> 1;
                case DOUBLE_CHOICE -> 0.5;
                case THREE_CHOICE -> 1.0 / 3;
            };
        }
        return 0;
    }

    private Answer getAnswerById(Long id) {
        return answerRepository.findById(id).orElseThrow(() -> new AnswerNotFoundException("answer not found"));
    }
}
