package com.myschool.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class AcademicYearDto {
    private Integer academicYearId;
    private Integer schoolId;
    private String yearName;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean isActive;
}