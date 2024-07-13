package com.company.controller.rest;

import com.company.dto.request.ExamRequest;
import com.company.dto.response.QuestionResponse;
import com.company.service.ExampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/exams")
@RequiredArgsConstructor
public class ExamRestController {
    private final ExampleService exampleService;
    @GetMapping
    public List<QuestionResponse> createExample(){
        return exampleService.getExample();
    }
    @PostMapping
    public ResponseEntity<Map<String, Double>> createExample(@RequestBody ExamRequest examRequest){
        Double totalResult = exampleService.createExample(examRequest);
        Map<String, Double> response = new HashMap<>();
        response.put("Exam result", totalResult);
        return ResponseEntity.ok(response);
    }

}
