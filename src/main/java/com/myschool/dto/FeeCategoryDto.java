package com.myschool.dto;
import lombok.Data;

@Data
public class FeeCategoryDto {
    private Integer feeCategoryId;
    private Integer schoolId;
    private String name;
}