package com.myschool.repository;

import com.myschool.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<TeacherEntity, Integer> {
    TeacherEntity findByUserUserId(Integer userId);
}