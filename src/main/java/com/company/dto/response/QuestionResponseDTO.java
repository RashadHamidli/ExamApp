package com.company.dto.response;

import com.company.entity.Question;

import java.util.List;

public record QuestionResponseDTO(String question) {
    public static QuestionResponseDTO fromQuestion(List<Question> questions) {
        return null;
    }
}
