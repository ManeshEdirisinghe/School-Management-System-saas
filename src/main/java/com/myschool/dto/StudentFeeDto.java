package com.myschool.dto;
import lombok.Data;
import java.time.LocalDate;

@Data
public class StudentFeeDto {
    private Integer studentFeeId;
    private Integer studentId;
    private Integer feeStructureId;
    private LocalDate dueDate;
    private Double amountPaid;
    private String status;
}