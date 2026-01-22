package com.myschool.dto;

import lombok.Data;

@Data
public class MarkDto {
    private Integer markId;
    private Integer examId;
    private Integer studentId;
    private Integer subjectId;
    private Double marksObtained;
    private String grade;
}