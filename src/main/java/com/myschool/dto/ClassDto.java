package com.myschool.dto;

import lombok.Data;

@Data
public class ClassDto {
    private Integer classId;
    private Integer schoolId;
    private Integer gradeId;
    private Integer yearId;
    private String className;
    private String section;
    private Integer teacherId;
}