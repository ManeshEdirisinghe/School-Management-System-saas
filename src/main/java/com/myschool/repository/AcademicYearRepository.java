package com.myschool.repository;

import com.myschool.entity.AcademicYearEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AcademicYearRepository extends JpaRepository<AcademicYearEntity, Integer> {
    Optional<AcademicYearEntity> findByIsActiveTrue(); // Active අවුරුද්ද ගන්න
}