package com.myschool.repository;
import com.myschool.entity.StudentHostelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface StudentHostelRepository extends JpaRepository<StudentHostelEntity, Integer> {
    List<StudentHostelEntity> findByStudentStudentId(Integer studentId);
}