package com.myschool.dto;

import lombok.Data;

@Data
public class SubjectDto {
    private Integer subjectId;
    private Integer schoolId;
    private String subjectName;
    private String subjectCode;
}