package com.myschool.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class StudentDto {
    private Integer studentId;
    private Integer schoolId;
    private Integer classId;
    private String admissionNumber;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String gender;
    private String address;
    private String status;
}