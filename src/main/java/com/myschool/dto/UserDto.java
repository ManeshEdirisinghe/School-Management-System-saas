package com.myschool.dto;
import lombok.Data;
@Data
public class UserDto {
    private Integer userId;
    private Integer schoolId;
    private Integer roleId;
    private String username;
    private String passwordHash;
    private String email;
    private String status;
}