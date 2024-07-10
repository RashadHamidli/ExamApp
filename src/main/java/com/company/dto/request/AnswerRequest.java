package com.company.dto.request;

import java.io.Serializable;

public record AnswerRequest(String answer,
                            Boolean isCorrect) implements Serializable {

}
