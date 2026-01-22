package com.myschool.dto;

import lombok.Data;

@Data
public class SchoolDto {
    private Integer schoolId;
    private String name;
    private String code;
    private String address;
    private String contactEmail;
    private String contactPhone;
    private String status;
}