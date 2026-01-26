package com.myschool.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "transportation")
public class TransportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transportId;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private SchoolEntity school;

    private String busNo;
    private String route;
    private String driverName;
}