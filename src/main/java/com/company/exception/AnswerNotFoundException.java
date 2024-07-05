package com.company.exception;

public class AnswerNotFoundException extends RuntimeException {
    public AnswerNotFoundException(String answerNotFound) {
        super(answerNotFound);
    }
}
