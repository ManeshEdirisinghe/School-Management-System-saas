package com.myschool.entity.key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;

@Data
@EqualsAndHashCode
@Embeddable
public class StudentParentKey implements Serializable {
    @Column(name = "student_id")
    private Integer studentId;

    @Column(name = "parent_id")
    private Integer parentId;
}