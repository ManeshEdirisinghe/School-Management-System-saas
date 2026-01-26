package com.myschool.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "canteen")
public class CanteenEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer canteenId;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private SchoolEntity school;

    private String type; // Main Canteen, Staff Canteen
    private String openingHours;
}