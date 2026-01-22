package com.myschool.service;

import com.myschool.dto.ClassDto;
import java.util.List;

public interface ClassService {
    void addClass(ClassDto classDto);
    List<ClassDto> getAllClasses();
    ClassDto getClassById(Integer id);
}