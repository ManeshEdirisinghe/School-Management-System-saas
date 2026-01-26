package com.myschool.entity;

import com.myschool.util.PaymentStatus;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "student_fees")
public class StudentFeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentFeeId;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentEntity student;

    @ManyToOne
    @JoinColumn(name = "fee_structure_id")
    private FeeStructureEntity feeStructure;

    private LocalDate dueDate;
    private Double amountPaid; // දැනට ගෙවා ඇති මුදල

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;
}