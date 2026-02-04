package com.myschool.service.impl;

import com.myschool.dto.LoginRequestDto;
import com.myschool.dto.LoginResponseDto;
import com.myschool.entity.*;
import com.myschool.repository.*;
import com.myschool.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;

    @Override
    public LoginResponseDto login(LoginRequestDto dto) {
        // --- LOG 1: එන Request එක බලමු ---
        System.out.println("Login Request ආවා: Username = " + dto.getUsername());
        System.out.println("Login Request ආවා: Password = " + dto.getPassword());

        Optional<UserEntity> userOpt = userRepository.findByUsername(dto.getUsername());

        if (userOpt.isPresent()) {
            UserEntity user = userOpt.get();
            // --- LOG 2: DB එකේ තියෙන දත්ත බලමු ---
            System.out.println("User හමුවුණා: " + user.getUsername());
            System.out.println("DB Password: " + user.getPassword());

            if (user.getPassword() != null && user.getPassword().equals(dto.getPassword())) {
                System.out.println("✅ Password හරියටම ගැලපුණා!");

                LoginResponseDto response = new LoginResponseDto();
                response.setUserId(user.getUserId());
                response.setUsername(user.getUsername());

                String roleName = user.getRole().getRoleName();
                response.setRole(roleName);

                if ("TEACHER".equalsIgnoreCase(roleName)) {
                    TeacherEntity teacher = teacherRepository.findByUserUserId(user.getUserId());
                    if (teacher != null) {
                        response.setSpecificId(teacher.getTeacherId());
                        response.setName(user.getUsername());
                    }
                } else if ("STUDENT".equalsIgnoreCase(roleName)) {
                    StudentEntity student = studentRepository.findByUserUserId(user.getUserId());
                    if (student != null) {
                        response.setSpecificId(student.getStudentId());
                        response.setName(student.getFirstName());
                    }
                }
                return response;
            } else {
                System.out.println("❌ Password වැරදියි! (DB එකේ සහ Input එක සමාන නෑ)");
            }
        } else {
            System.out.println("❌ User කෙනෙක් හමුවුණේ නෑ: " + dto.getUsername());
        }
        return null;
    }
}