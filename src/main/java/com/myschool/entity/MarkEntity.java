package com.myschool.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "marks")
public class MarkEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer markId;

    @ManyToOne
    @JoinColumn(name = "exam_id")
    private ExamEntity exam;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentEntity student;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private SubjectEntity subject;

    private Double marksObtained;
    private String grade;
}