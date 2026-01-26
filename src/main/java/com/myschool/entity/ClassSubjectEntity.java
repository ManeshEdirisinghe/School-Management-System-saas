package com.myschool.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "class_subjects")
public class ClassSubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer classSubjectId;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private ClassEntity currentClass;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private SubjectEntity subject;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private TeacherEntity teacher;
}