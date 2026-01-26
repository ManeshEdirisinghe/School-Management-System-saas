package com.myschool.repository;
import com.myschool.entity.StudentFeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StudentFeeRepository extends JpaRepository<StudentFeeEntity, Integer> {
    List<StudentFeeEntity> findByStudentStudentId(Integer studentId);
}