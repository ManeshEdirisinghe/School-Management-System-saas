package com.myschool.repository;

import com.myschool.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
    StudentEntity findByAdmissionNumber(String admissionNumber);
}