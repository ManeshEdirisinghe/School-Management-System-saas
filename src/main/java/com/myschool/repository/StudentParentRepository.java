package com.myschool.repository;

import com.myschool.entity.StudentParentEntity;
import com.myschool.entity.key.StudentParentKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentParentRepository extends JpaRepository<StudentParentEntity, StudentParentKey> {
}