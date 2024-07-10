package com.company.dto.request;

import java.util.List;

public record QuestionAnswerRequest(String questionId,
                                    List<String> answerIds) {
}
