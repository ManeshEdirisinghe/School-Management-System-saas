package com.myschool.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "hostels")
public class HostelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hostelId;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private SchoolEntity school;

    private String type; // Boys, Girls, Mixed
    private Integer capacity;
}