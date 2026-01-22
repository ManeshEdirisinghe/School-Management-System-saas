package com.myschool.service;

import com.myschool.dto.TeacherDto;
import java.util.List;

public interface TeacherService {
    void addTeacher(TeacherDto teacherDto);
    List<TeacherDto> getAllTeachers();
}