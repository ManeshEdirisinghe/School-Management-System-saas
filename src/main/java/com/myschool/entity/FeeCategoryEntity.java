package com.myschool.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "fee_categories")
public class FeeCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer feeCategoryId;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private SchoolEntity school;

    private String name;
}