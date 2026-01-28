package com.myschool.repository;
import com.myschool.entity.StudentTransportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface StudentTransportRepository extends JpaRepository<StudentTransportEntity, Integer> {
    List<StudentTransportEntity> findByStudentStudentId(Integer studentId);
}