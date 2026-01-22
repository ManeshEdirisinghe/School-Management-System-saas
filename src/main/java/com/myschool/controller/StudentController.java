package com.myschool.controller;

import com.myschool.dto.StudentDto;
import com.myschool.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/add")
    public void addStudent(@RequestBody StudentDto studentDto) {
        studentService.addStudent(studentDto);
    }

    @GetMapping("/get-all")
    public List<StudentDto> getAll() {
        return studentService.getAllStudents();
    }

    @GetMapping("/get-by-id/{id}")
    public StudentDto getById(@PathVariable Integer id) {
        return studentService.getStudentById(id);
    }
}