package com.myschool.dto;
import lombok.Data;

@Data
public class StudentParentDto {
    private Integer studentId;
    private Integer parentId;
    private String relationship; // Father, Mother
    private Boolean isEmergencyContact;
}