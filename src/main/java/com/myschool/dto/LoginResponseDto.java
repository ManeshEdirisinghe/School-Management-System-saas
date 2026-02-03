package com.myschool.dto;
import lombok.Data;

@Data
public class LoginResponseDto {
    private Integer userId;
    private String username;
    private String role;
    private Integer specificId;
    private String name;
}