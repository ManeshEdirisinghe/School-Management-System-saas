package com.myschool.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class ExamDto {
    private Integer examId;
    private String examName;
    private String examType; // Enum as String
    private LocalDate date;
    private Integer academicYearId;
}