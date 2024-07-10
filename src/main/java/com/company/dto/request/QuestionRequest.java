package com.company.dto.request;

import java.io.Serializable;
import java.util.List;


public record QuestionRequest(String question,
                              String choice,
                              List<AnswerRequest> answers)implements Serializable {

}
