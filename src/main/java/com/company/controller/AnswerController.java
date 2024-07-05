package com.company.controller;

import com.company.dto.request.AnswerRequest;
import com.company.dto.response.AnswerResponse;
import com.company.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/answers")
@RequiredArgsConstructor
public class AnswerController {

    private final AnswerService answerService;

    @PutMapping("/{id}")
    public ResponseEntity<AnswerResponse> updateAnswer(@PathVariable Long id, @RequestBody AnswerRequest answerRequest) {
        AnswerResponse answerResponse = answerService.updateAnswerById(id, answerRequest);
        return ResponseEntity.ok(answerResponse);
    }

}
