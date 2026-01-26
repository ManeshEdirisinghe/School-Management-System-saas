package com.myschool.repository;

import com.myschool.entity.ClassSubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ClassSubjectRepository extends JpaRepository<ClassSubjectEntity, Integer> {
    List<ClassSubjectEntity> findByCurrentClassClassId(Integer classId);
}