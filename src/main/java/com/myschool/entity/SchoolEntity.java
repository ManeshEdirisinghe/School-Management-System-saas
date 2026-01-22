package com.myschool.entity;

import com.myschool.util.GeneralStatus;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "schools")
public class SchoolEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer schoolId;

    private String name;
    private String code;
    private String address;
    private String contactEmail;
    private String contactPhone;
    private String logoUrl;

    @Enumerated(EnumType.STRING)
    private GeneralStatus status;

    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}