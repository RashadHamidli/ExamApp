package com.company.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "answers")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String answer;
    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;
    @NotNull
    private Boolean isCorrect;

    @Override
    public String toString(){
        return STR."id: \{id} | answer: \{answer}";
    }
}
