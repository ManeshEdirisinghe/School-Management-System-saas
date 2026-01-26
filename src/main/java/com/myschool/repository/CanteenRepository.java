package com.myschool.repository;
import com.myschool.entity.CanteenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CanteenRepository extends JpaRepository<CanteenEntity, Integer> {}