package com.myschool.service;

import com.myschool.dto.StudentAttendanceDto;
import java.util.List;
import java.time.LocalDate;

public interface AttendanceService {
    void markAttendance(StudentAttendanceDto dto);
    List<StudentAttendanceDto> getStudentAttendance(Integer studentId);
    List<StudentAttendanceDto> getClassAttendanceByDate(Integer classId, LocalDate date);
}