package com.company.mapper;

import com.company.dto.request.AnswerRequest;
import com.company.dto.response.AnswerResponse;
import com.company.entity.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AnswerMapper {
    AnswerMapper INSTANCE = Mappers.getMapper(AnswerMapper.class);

    AnswerResponse convertAnswerToAnswerResponse(Answer answer);
    Answer convertAnswerResponseToAnswer(AnswerResponse answerResponse);
    Answer convertAnswerRequestToAnswer(AnswerRequest answerRequest);
}

