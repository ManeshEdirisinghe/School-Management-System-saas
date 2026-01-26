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

    private String name;

    @ManyToOne
    @JoinColumn(name = "teacher_in_charge_id")
    private TeacherEntity teacherInCharge;
}