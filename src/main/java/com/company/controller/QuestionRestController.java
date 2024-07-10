package com.company.controller;

import com.company.dto.request.QuestionRequest;
import com.company.dto.request.QuestionUpdateRequest;
import com.company.dto.response.QuestionResponse;
import com.company.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
@RequiredArgsConstructor
public class QuestionRestController {
    private final QuestionService questionService;

    @GetMapping
    public ResponseEntity<List<QuestionResponse>> getAllQuestions() {
        List<QuestionResponse> questions = questionService.getAllQuestion();
        return ResponseEntity.ok(questions);
    }

    @PostMapping
    public ResponseEntity<QuestionResponse> saveQuestion(@RequestBody QuestionRequest questionRequest) {
        QuestionResponse response = questionService.saveQuestion(questionRequest);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionResponse> getQuestionById(@PathVariable String id) {
        QuestionResponse questionResponse = questionService.getQuestionById(id);
        return ResponseEntity.ok(questionResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuestionResponse> updateQuestion(@PathVariable String id, QuestionUpdateRequest questionUpdateRequest) {
        QuestionResponse questionResponse = questionService.updateQuestion(id, questionUpdateRequest);
        return ResponseEntity.ok(questionResponse);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> deleteQuestion(@PathVariable String id) {
        questionService.deleteQuestion(id);
        return ResponseEntity.ok().build();
    }
}
