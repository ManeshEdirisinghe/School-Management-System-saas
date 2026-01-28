package com.myschool.repository;
import com.myschool.entity.StudentClubEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface StudentClubRepository extends JpaRepository<StudentClubEntity, Integer> {
    List<StudentClubEntity> findByStudentStudentId(Integer studentId);
}