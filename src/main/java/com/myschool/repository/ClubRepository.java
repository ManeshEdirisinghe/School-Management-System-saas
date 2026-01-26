package com.myschool.repository;
import com.myschool.entity.ClubEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ClubRepository extends JpaRepository<ClubEntity, Integer> {}