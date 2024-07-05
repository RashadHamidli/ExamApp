package com.company.mapper;

import com.company.dto.request.QuestionRequest;
import com.company.dto.response.QuestionResponse;
import com.company.entity.Question;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {AnswerMapper.class})
public interface QuestionMapper {
    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);

    QuestionRequest convertQuestionToQuestionRequest(Question question);

    Question convertQuestionRequestToQuestion(QuestionRequest questionRequest);

    QuestionResponse convertQuestionToQuestionResponse(Question question);
}
