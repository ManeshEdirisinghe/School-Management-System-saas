package com.myschool.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class StudentAttendanceDto {
    private Integer attendanceId;
    private Integer studentId;
    private Integer classId;
    private LocalDate date;
    private String status; // PRESENT, ABSENT etc.
    private String remarks;
}