package com.myschool.repository;

import com.myschool.entity.ParentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ParentRepository extends JpaRepository<ParentEntity, Integer> {
    List<ParentEntity> findByNameContaining(String name);
}