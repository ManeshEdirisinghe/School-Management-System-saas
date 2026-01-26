package com.myschool.dto;
import lombok.Data;

@Data
public class ClassSubjectDto {
    private Integer classSubjectId;
    private Integer classId;
    private Integer subjectId;
    private Integer teacherId;
}