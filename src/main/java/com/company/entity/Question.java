package com.company.entity;

import com.company.util.CoreEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EntityListeners(AuditingEntityListener.class)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "questions", schema = "public")
public class Question extends CoreEntity {
    @NotBlank(message = "question cannot be null or empty")
    @Column(name = "question", nullable = false, columnDefinition = "text")
    String question;

    @NotNull(message = "choice cannot be null")
    @Enumerated(EnumType.STRING)
    @Column(name = "choice", nullable = false)
    Choice choice;

    @NotNull
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "question")
    @Size(min = 5, max = 5)
    List<Answer> answers;

    @Override
    public String toString() {
        return STR."id: \{id} | questions: \{question} | answers \{answers} | choice: \{choice}";
    }
}
