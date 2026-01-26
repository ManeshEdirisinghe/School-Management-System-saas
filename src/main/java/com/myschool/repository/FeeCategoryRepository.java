package com.myschool.repository;
import com.myschool.entity.FeeCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeeCategoryRepository extends JpaRepository<FeeCategoryEntity, Integer> {}