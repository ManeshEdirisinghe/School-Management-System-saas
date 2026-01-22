package com.myschool.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "subjects")
public class SubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer subjectId;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private SchoolEntity school;

    private String subjectName;
    private String subjectCode;
}