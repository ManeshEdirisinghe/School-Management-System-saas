package com.myschool.controller;

import com.myschool.dto.TeacherAttendanceDto;
import com.myschool.service.TeacherAttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/teacher-attendance")
@CrossOrigin
@RequiredArgsConstructor
public class TeacherAttendanceController {

    private final TeacherAttendanceService attendanceService;

    @PostMapping("/mark")
    public void markAttendance(@RequestBody TeacherAttendanceDto dto) {
        attendanceService.markAttendance(dto);
    }

    @GetMapping("/get-by-teacher/{teacherId}")
    public List<TeacherAttendanceDto> getByTeacher(@PathVariable Integer teacherId) {
        return attendanceService.getAttendanceByTeacher(teacherId);
    }

    @GetMapping("/get-by-date/{date}")
    public List<TeacherAttendanceDto> getByDate(@PathVariable String date) {
        return attendanceService.getAttendanceByDate(LocalDate.parse(date));
    }
}