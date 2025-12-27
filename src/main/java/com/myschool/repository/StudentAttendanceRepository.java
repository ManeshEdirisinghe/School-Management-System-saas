package com.myschool.repository;

import com.myschool.entity.StudentAttendanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.time.LocalDate;

public interface StudentAttendanceRepository extends JpaRepository<StudentAttendanceEntity, Integer> {
    List<StudentAttendanceEntity> findByStudentStudentId(Integer studentId);

    List<StudentAttendanceEntity> findByCurrentClassClassIdAndDate(Integer classId, LocalDate date);
}