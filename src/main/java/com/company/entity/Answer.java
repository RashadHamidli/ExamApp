package com.company.entity;

import com.company.util.CoreEntity;
import com.company.util.CoreEntityListener;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
@EntityListeners(CoreEntityListener.class)
@Table(name = "answers", schema = "public")
public class Answer extends CoreEntity {

    @NotBlank(message = "answer can not be null")
    @Column(nullable = false, columnDefinition = "text")
    String answer;

    @NotNull(message = "correct variant can not be null")
    @Column(nullable = false)
    Boolean isCorrect;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    Question question;

    @Override
    public String toString() {
        return STR."id: \{id} | answer: \{answer}";
    }
}
