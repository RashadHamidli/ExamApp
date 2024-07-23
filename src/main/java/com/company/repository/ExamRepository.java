package com.company.repository;

import com.company.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExamRepository extends JpaRepository<Exam, String> {
    Optional<Exam> findByUserId(String userId);

    Long countByScoreGreaterThan(Double score);
}
