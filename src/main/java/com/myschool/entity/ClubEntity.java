package com.myschool.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "clubs")
public class ClubEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer clubId;

    private String name; // Science Club, Media Unit

    @ManyToOne
    @JoinColumn(name = "teacher_in_charge_id")
    private TeacherEntity teacherInCharge; // FK to Teacher (Staff)
}