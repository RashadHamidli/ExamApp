package com.company.mapper;

import com.company.dto.request.AnswerRequest;
import com.company.dto.request.QuestionRequest;
import com.company.dto.response.AnswerResponse;
import com.company.dto.response.QuestionResponse;
import com.company.entity.Answer;
import com.company.entity.Choice;
import com.company.entity.Question;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-13T14:58:07+0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
public class QuestionMapperImpl implements QuestionMapper {

    private final AnswerMapper answerMapper = AnswerMapper.INSTANCE;

    @Override
    public QuestionRequest convertQuestionToQuestionRequest(Question question) {
        if ( question == null ) {
            return null;
        }

        String question1 = null;
        String choice = null;
        List<AnswerRequest> answers = null;

        question1 = question.getQuestion();
        if ( question.getChoice() != null ) {
            choice = question.getChoice().name();
        }
        answers = answerListToAnswerRequestList( question.getAnswers() );

        QuestionRequest questionRequest = new QuestionRequest( question1, choice, answers );

        return questionRequest;
    }

    @Override
    public Question convertQuestionRequestToQuestion(QuestionRequest questionRequest) {
        if ( questionRequest == null ) {
            return null;
        }

        Question.QuestionBuilder<?, ?> question = Question.builder();

        question.question( questionRequest.question() );
        if ( questionRequest.choice() != null ) {
            question.choice( Enum.valueOf( Choice.class, questionRequest.choice() ) );
        }
        question.answers( answerRequestListToAnswerList( questionRequest.answers() ) );

        return question.build();
    }

    @Override
    public QuestionResponse convertQuestionToQuestionResponse(Question question) {
        if ( question == null ) {
            return null;
        }

        String id = null;
        String question1 = null;
        List<AnswerResponse> answers = null;
        Choice choice = null;

        id = question.getId();
        question1 = question.getQuestion();
        answers = answerListToAnswerResponseList( question.getAnswers() );
        choice = question.getChoice();

        QuestionResponse questionResponse = new QuestionResponse( id, question1, answers, choice );

        return questionResponse;
    }

    protected AnswerRequest answerToAnswerRequest(Answer answer) {
        if ( answer == null ) {
            return null;
        }

        String answer1 = null;
        Boolean isCorrect = null;

        answer1 = answer.getAnswer();
        isCorrect = answer.getIsCorrect();

        AnswerRequest answerRequest = new AnswerRequest( answer1, isCorrect );

        return answerRequest;
    }

    protected List<AnswerRequest> answerListToAnswerRequestList(List<Answer> list) {
        if ( list == null ) {
            return null;
        }

        List<AnswerRequest> list1 = new ArrayList<AnswerRequest>( list.size() );
        for ( Answer answer : list ) {
            list1.add( answerToAnswerRequest( answer ) );
        }

        return list1;
    }

    protected List<Answer> answerRequestListToAnswerList(List<AnswerRequest> list) {
        if ( list == null ) {
            return null;
        }

        List<Answer> list1 = new ArrayList<Answer>( list.size() );
        for ( AnswerRequest answerRequest : list ) {
            list1.add( answerMapper.convertAnswerRequestToAnswer( answerRequest ) );
        }

        return list1;
    }

    protected List<AnswerResponse> answerListToAnswerResponseList(List<Answer> list) {
        if ( list == null ) {
            return null;
        }

        List<AnswerResponse> list1 = new ArrayList<AnswerResponse>( list.size() );
        for ( Answer answer : list ) {
            list1.add( answerMapper.convertAnswerToAnswerResponse( answer ) );
        }

        return list1;
    }
}
