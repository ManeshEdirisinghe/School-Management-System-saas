package com.myschool.repository;

import com.myschool.entity.TeacherAttendanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.time.LocalDate;

public interface TeacherAttendanceRepository extends JpaRepository<TeacherAttendanceEntity, Integer> {

    List<TeacherAttendanceEntity> findByTeacherTeacherId(Integer teacherId);

    List<TeacherAttendanceEntity> findByDate(LocalDate date);
}