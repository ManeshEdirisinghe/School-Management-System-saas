package com.myschool.service;

import com.myschool.dto.StudentDto;
import java.util.List;

public interface StudentService {
    void addStudent(StudentDto studentDto);
    List<StudentDto> getAllStudents();
    StudentDto getStudentById(Integer id);
}