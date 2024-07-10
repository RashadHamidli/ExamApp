package com.company.entity;

import com.company.util.CoreEntity;
import com.company.util.CoreEntityListener;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EntityListeners(CoreEntityListener.class)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "exams", schema = "public")
public class Exam extends CoreEntity {

    @NotNull(message = "score cannot be null")
    @Max(value = 100)
    @Min(value = 0)
    @Column(name = "score", nullable = false)
    private Double score;


    @OneToMany(mappedBy = "exam", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ExamQuestionAnswer> questionAnswers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
