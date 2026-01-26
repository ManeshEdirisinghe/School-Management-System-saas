package com.myschool.controller;

import com.myschool.dto.StudentAttendanceDto;
import com.myschool.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/attendance")
@CrossOrigin
@RequiredArgsConstructor
public class AttendanceController {

    private final AttendanceService attendanceService;

    @PostMapping("/mark")
    public void markAttendance(@RequestBody StudentAttendanceDto dto) {
        attendanceService.markAttendance(dto);
    }

    @GetMapping("/get-by-student/{studentId}")
    public List<StudentAttendanceDto> getStudentAttendance(@PathVariable Integer studentId) {
        return attendanceService.getStudentAttendance(studentId);
    }

    @GetMapping("/get-by-class-date/{classId}/{date}")
    public List<StudentAttendanceDto> getClassAttendance(@PathVariable Integer classId, @PathVariable String date) {
        // Date String එක LocalDate වලට හරවන්න වෙනවා (YYYY-MM-DD format)
        LocalDate localDate = LocalDate.parse(date);
        return attendanceService.getClassAttendanceByDate(classId, localDate);
    }
}