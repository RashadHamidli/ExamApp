package com.company.mapper;

import com.company.dto.request.AnswerRequest;
import com.company.dto.response.AnswerResponse;
import com.company.entity.Answer;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-24T00:17:56+0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
public class AnswerMapperImpl implements AnswerMapper {

    @Override
    public AnswerResponse convertAnswerToAnswerResponse(Answer answer) {
        if ( answer == null ) {
            return null;
        }

        String id = null;
        String answer1 = null;

        id = answer.getId();
        answer1 = answer.getAnswer();

        AnswerResponse answerResponse = new AnswerResponse( id, answer1 );

        return answerResponse;
    }

    @Override
    public Answer convertAnswerResponseToAnswer(AnswerResponse answerResponse) {
        if ( answerResponse == null ) {
            return null;
        }

        Answer.AnswerBuilder<?, ?> answer = Answer.builder();

        answer.id( answerResponse.id() );
        answer.answer( answerResponse.answer() );

        return answer.build();
    }

    @Override
    public Answer convertAnswerRequestToAnswer(AnswerRequest answerRequest) {
        if ( answerRequest == null ) {
            return null;
        }

        Answer.AnswerBuilder<?, ?> answer = Answer.builder();

        answer.answer( answerRequest.answer() );
        answer.isCorrect( answerRequest.isCorrect() );

        return answer.build();
    }
}
