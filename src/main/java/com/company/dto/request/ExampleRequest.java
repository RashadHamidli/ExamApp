package com.company.dto.request;

import java.util.List;

public record ExampleRequest(List<QuestionAnswerRequest> questionAnswers) {
}
