package com.myschool.service;
import com.myschool.dto.LoginRequestDto;
import com.myschool.dto.LoginResponseDto;

public interface AuthService {
    LoginResponseDto login(LoginRequestDto dto);
}