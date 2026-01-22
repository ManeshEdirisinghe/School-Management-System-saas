package com.myschool.entity;

import com.myschool.util.ExamType;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "exams")
public class ExamEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer examId;

    private String examName; // Grade 10 - 1st Term

    @Enumerated(EnumType.STRING)
    private ExamType examType;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "academic_year_id")
    private AcademicYearEntity academicYear;
}