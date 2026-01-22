package com.myschool.repository;

import com.myschool.entity.StudentAttendanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.time.LocalDate;

public interface StudentAttendanceRepository extends JpaRepository<StudentAttendanceEntity, Integer> {
    // ළමයෙක්ගේ සම්පූර්ණ පැමිණීම ගන්න
    List<StudentAttendanceEntity> findByStudentStudentId(Integer studentId);

    // පන්තියක නිශ්චිත දවසක පැමිණීම ගන්න (ගුරුවරුන්ට ලේසියි)
    List<StudentAttendanceEntity> findByCurrentClassClassIdAndDate(Integer classId, LocalDate date);
}