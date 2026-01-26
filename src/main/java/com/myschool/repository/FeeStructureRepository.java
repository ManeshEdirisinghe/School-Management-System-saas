package com.myschool.repository;
import com.myschool.entity.FeeStructureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FeeStructureRepository extends JpaRepository<FeeStructureEntity, Integer> {
    List<FeeStructureEntity> findByCurrentClassClassId(Integer classId);
}