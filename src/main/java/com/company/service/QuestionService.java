package com.company.service;

import com.company.dto.response.QuestionResponseDTO;
import com.company.entity.Question;
import com.company.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private QuestionRepository questionRepository;

    public List<QuestionResponseDTO> getAllQuestion() {
        List<Question> questions = questionRepository.findAll();
        QuestionResponseDTO.fromQuestion(questions);
        return null;
    }
}
