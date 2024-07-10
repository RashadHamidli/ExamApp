package com.company.repository;

import com.company.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, String> {
    @Query(value = "SELECT * FROM questions ORDER BY RANDOM() LIMIT 10", nativeQuery = true)
    List<Question> findRandomQuestions();
}
