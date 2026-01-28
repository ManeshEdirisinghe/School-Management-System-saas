package com.myschool.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class TeacherAttendanceDto {
    private Integer attendanceId;
    private Integer teacherId;
    private LocalDate date;
    private String status;
    private String remarks;
}