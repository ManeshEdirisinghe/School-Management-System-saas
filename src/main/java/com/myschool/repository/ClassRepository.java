package com.myschool.repository;

import com.myschool.entity.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ClassRepository extends JpaRepository<ClassEntity, Integer> {

    List<ClassEntity> findBySchoolSchoolId(Integer schoolId);

    List<ClassEntity> findByClassName(String className);
}