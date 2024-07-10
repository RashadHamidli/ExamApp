package com.company.entity;

import com.company.util.CoreEntity;
import com.company.util.CoreEntityListener;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
@EntityListeners(CoreEntityListener.class)
@Table(name = "exams_question_answer", schema = "public")
public class ExamQuestionAnswer extends CoreEntity {

    @NotNull(message = "exam id cannot be null")
    @ManyToOne
    @JoinColumn(name = "exam_id", nullable = false)
    Exam exam;

    @NotNull(message = "question id cannot be null")
    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    Question question;

    @NotNull(message = "answer id cannot be null")
    @ManyToOne
    @JoinColumn(name = "answer_id", nullable = false)
    Answer answer;

}
