package com.myschool.repository;

import com.myschool.entity.ExamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<ExamEntity, Integer> {
}