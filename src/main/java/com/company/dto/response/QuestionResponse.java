package com.company.dto.response;

import com.company.entity.Choice;

import java.util.List;


public record QuestionResponse(Long id,
                               String question,
                               List<AnswerResponse> answers,
                               Choice choice) {
}


