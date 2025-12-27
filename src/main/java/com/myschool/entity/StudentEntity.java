package com.myschool.entity;

import com.myschool.util.Gender;
import com.myschool.util.StudentStatus;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "students")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private SchoolEntity school;

    private String admissionNumber;
    private LocalDate admissionDate;

    @ManyToOne
    @JoinColumn(name = "current_class_id")
    private ClassEntity currentClass;

    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private StudentStatus status;
}