package com.myschool.entity;

import com.myschool.util.GeneralStatus;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private SchoolEntity school;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity role;

    private String username;
    private String passwordHash;
    private String email;
    private String phone;

    @Enumerated(EnumType.STRING)
    private GeneralStatus status;

    private LocalDateTime lastLogin;
    private LocalDateTime createdAt;
}