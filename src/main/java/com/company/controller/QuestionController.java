package com.company.controller;

import ch.qos.logback.core.model.Model;
import com.company.dto.response.QuestionResponseDTO;
import com.company.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/questions")
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;

    @GetMapping
    public ResponseEntity<?> getAllQuestions() {
        List<QuestionResponseDTO> questions= questionService.getAllQuestion();
        return ResponseEntity.ok(questions);
    }
}
