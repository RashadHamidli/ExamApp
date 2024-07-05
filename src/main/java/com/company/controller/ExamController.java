package com.company.controller;

import com.company.dto.request.ExampleRequest;
import com.company.dto.response.QuestionResponse;
import com.company.service.ExampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exams")
@RequiredArgsConstructor
public class ExamController {
    private final ExampleService exampleService;
    @GetMapping
    public List<QuestionResponse> createExample(){
        return exampleService.getExample();
    }
    @PostMapping
    public String createExample(@RequestBody ExampleRequest exampleRequest){
        Double totalResult = exampleService.createExample(exampleRequest);
        return STR."total result: \{totalResult}";
    }
}
