package com.company.mapper;

import com.company.dto.response.UserExamResponse;
import com.company.entity.Exam;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExamMapper {
    ExamMapper INSTANCE = Mappers.getMapper(ExamMapper.class);

    @Mapping(source = "score", target = "score")
    @Mapping(source = "user.name", target = "name")
    @Mapping(source = "user.surname", target = "surname")
    UserExamResponse convertToExamMapper(Exam exam);
    Exam convertToExam(UserExamResponse userExamResponse);
}
