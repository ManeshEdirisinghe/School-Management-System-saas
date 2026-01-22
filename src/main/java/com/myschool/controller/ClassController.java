package com.myschool.controller;

import com.myschool.dto.ClassDto;
import com.myschool.service.ClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/class")
@CrossOrigin
@RequiredArgsConstructor
public class ClassController {

    private final ClassService classService;

    @PostMapping("/add")
    public void addClass(@RequestBody ClassDto classDto) {
        classService.addClass(classDto);
    }

    @GetMapping("/get-all")
    public List<ClassDto> getAllClasses() {
        return classService.getAllClasses();
    }

    @GetMapping("/get-by-id/{id}")
    public ClassDto getClassById(@PathVariable Integer id) {
        return classService.getClassById(id);
    }
}