package com.myschool.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "academic_years")
public class AcademicYearEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer academicYearId;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private SchoolEntity school;

    private String yearName;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean isActive;
}