package com.myschool.repository;

import com.myschool.entity.MarkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MarkRepository extends JpaRepository<MarkEntity, Integer> {

    List<MarkEntity> findByStudentStudentId(Integer studentId);

    List<MarkEntity> findByExamExamId(Integer examId);
}