package com.company.mapper;

import com.company.dto.response.UserExamResponse;
import com.company.entity.Exam;
import com.company.entity.User;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-24T00:20:31+0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
public class ExamMapperImpl implements ExamMapper {

    @Override
    public UserExamResponse convertToExamMapper(Exam exam) {
        if ( exam == null ) {
            return null;
        }

        Double score = null;
        String name = null;
        String surname = null;

        score = exam.getScore();
        name = examUserName( exam );
        surname = examUserSurname( exam );

        UserExamResponse userExamResponse = new UserExamResponse( score, name, surname );

        return userExamResponse;
    }

    @Override
    public Exam convertToExam(UserExamResponse userExamResponse) {
        if ( userExamResponse == null ) {
            return null;
        }

        Exam.ExamBuilder<?, ?> exam = Exam.builder();

        exam.score( userExamResponse.score() );

        return exam.build();
    }

    private String examUserName(Exam exam) {
        if ( exam == null ) {
            return null;
        }
        User user = exam.getUser();
        if ( user == null ) {
            return null;
        }
        String name = user.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String examUserSurname(Exam exam) {
        if ( exam == null ) {
            return null;
        }
        User user = exam.getUser();
        if ( user == null ) {
            return null;
        }
        String surname = user.getSurname();
        if ( surname == null ) {
            return null;
        }
        return surname;
    }
}
