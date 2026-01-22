package com.myschool.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class TeacherDto {
    private Integer teacherId;
    private Integer schoolId;
    private String qualification;
    private String specialization;
    private LocalDate joiningDate;

}