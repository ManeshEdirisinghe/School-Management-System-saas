package com.myschool.repository;
import com.myschool.entity.TransportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TransportRepository extends JpaRepository<TransportEntity, Integer> {}