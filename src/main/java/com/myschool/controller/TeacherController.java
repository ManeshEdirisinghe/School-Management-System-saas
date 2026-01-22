package com.myschool.controller;

import com.myschool.dto.TeacherDto;
import com.myschool.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
@CrossOrigin
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @PostMapping("/add")
    public void addTeacher(@RequestBody TeacherDto teacherDto) {
        teacherService.addTeacher(teacherDto);
    }

    @GetMapping("/get-all")
    public List<TeacherDto> getAll() {
        return teacherService.getAllTeachers();
    }
}