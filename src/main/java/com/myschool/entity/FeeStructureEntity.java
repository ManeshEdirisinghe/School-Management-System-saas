package com.myschool.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "fee_structures")
public class FeeStructureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer feeStructureId;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private ClassEntity currentClass;

    @ManyToOne
    @JoinColumn(name = "fee_category_id")
    private FeeCategoryEntity feeCategory;

    private Double amount;
}