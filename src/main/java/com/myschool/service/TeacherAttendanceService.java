package com.myschool.service;

import com.myschool.dto.TeacherAttendanceDto;
import java.util.List;
import java.time.LocalDate;

public interface TeacherAttendanceService {
    void markAttendance(TeacherAttendanceDto dto);
    List<TeacherAttendanceDto> getAttendanceByTeacher(Integer teacherId);
    List<TeacherAttendanceDto> getAttendanceByDate(LocalDate date);
}