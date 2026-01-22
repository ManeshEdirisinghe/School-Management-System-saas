package com.myschool.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "parents")
public class ParentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer parentId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user; // Login info

    private String name;
    private String occupation;
    private String contactNumber;
}