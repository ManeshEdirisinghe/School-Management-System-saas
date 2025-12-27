package com.myschool.entity;

import com.myschool.entity.key.StudentParentKey;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "student_parents")
public class StudentParentEntity {

    @EmbeddedId
    private StudentParentKey id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private StudentEntity student;

    @ManyToOne
    @MapsId("parentId")
    @JoinColumn(name = "parent_id")
    private ParentEntity parent;

    private String relationship;

    @Column(name = "is_emergency_contact")
    private Boolean isEmergencyContact;
}