package com.company.exception;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataAccessException;

import java.util.stream.Collectors;

public class CustomException {

    public static void handleOperationException(Exception e) {
        switch (e) {
            case UserNotFoundException userNotFoundException -> {
                System.out.printf("\u001B[31m%s\u001B[0m%n", e.getMessage());
                throw userNotFoundException;
            }
            case InvalidRequestException invalidRequestException -> {
                System.out.printf("\u001B[31m%s\u001B[0m%n", e.getMessage());
                throw invalidRequestException;
            }
            case ValidationException validationException -> {
                System.out.printf("\u001B[31m%s\u001B[0m%n", e.getMessage());
                throw validationException;
            }
            case QuestionNotFoundException questionNotFoundException -> {
                System.out.printf("\u001B[31m%s\u001B[0m%n", e.getMessage());
                throw questionNotFoundException;
            }
            case AnswerNotFoundException answerNotFoundException -> {
                System.out.printf("\u001B[31m%s\u001B[0m%n", e.getMessage());
                throw answerNotFoundException;
            }
            case DataAccessException dataAccessException -> {
                System.out.printf("\u001B[31m%s\u001B[0m%n", e.getMessage());
                throw dataAccessException;
            }
            case ConstraintViolationException constraintViolationException -> {
                System.out.printf("\u001B[31m%s\u001B[0m%n", ((ConstraintViolationException) e).getConstraintViolations().stream()
                        .map(ConstraintViolation::getMessage).collect(Collectors.joining("  or ")));
                throw constraintViolationException;
            }
            case null, default -> handleUnexpectedException(e);
        }
    }

    public static void handleUnexpectedException(Exception e) {
        System.out.printf("\u001B[31mUnexpected error occurred: %s\u001B[0m%n", e.getMessage());
        throw new RuntimeException("An unexpected error occurred", e);
    }
}
