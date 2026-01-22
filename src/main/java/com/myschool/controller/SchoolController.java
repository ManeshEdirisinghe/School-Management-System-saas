package com.myschool.controller;

import com.myschool.dto.SchoolDto;
import com.myschool.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/school")
@CrossOrigin
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;

    @PostMapping("/add")
    public void addSchool(@RequestBody SchoolDto schoolDto) {
        schoolService.addSchool(schoolDto);
    }

    @GetMapping("/get-all")
    public List<SchoolDto> getAll() {
        return schoolService.getAllSchools();
    }
}