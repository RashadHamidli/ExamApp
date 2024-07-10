package com.company.dto.request;

import java.util.List;

public record ExamRequest(String userId,
                          List<QuestionAnswerRequest> questionAnswers) {
}
