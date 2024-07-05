package com.company.dto.request;

import java.util.List;

public record QuestionAnswerRequest(Long questionId, List<Long> answerIds) {
}
