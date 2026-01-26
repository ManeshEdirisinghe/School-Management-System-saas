package com.myschool.repository;

import com.myschool.entity.TimetableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TimetableRepository extends JpaRepository<TimetableEntity, Integer> {

    List<TimetableEntity> findByCurrentClassClassId(Integer classId);

    List<TimetableEntity> findByCurrentClassClassIdAndDayOfWeek(Integer classId, String dayOfWeek);
}