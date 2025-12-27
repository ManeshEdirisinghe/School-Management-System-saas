package com.myschool.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "classes")
public class ClassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer classId;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private SchoolEntity school;

    @ManyToOne
    @JoinColumn(name = "academic_year_id")
    private AcademicYearEntity academicYear;

    private String className;
    private String section;

    @ManyToOne
    @JoinColumn(name = "class_teacher_id")
    private TeacherEntity classTeacher;
}