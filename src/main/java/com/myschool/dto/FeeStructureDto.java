package com.myschool.dto;
import lombok.Data;

@Data
public class FeeStructureDto {
    private Integer feeStructureId;
    private Integer classId;
    private Integer feeCategoryId;
    private Double amount;
}