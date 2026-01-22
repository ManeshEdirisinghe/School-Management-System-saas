package com.myschool.controller;

import com.myschool.dto.AcademicYearDto;
import com.myschool.service.AcademicYearService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/academic-year")
@CrossOrigin
@RequiredArgsConstructor
public class AcademicYearController {
    private final AcademicYearService service;

    @PostMapping("/add")
    public void addYear(@RequestBody AcademicYearDto dto) {
        service.addYear(dto);
    }

    @GetMapping("/get-all")
    public List<AcademicYearDto> getAll() {
        return service.getAllYears();
    }
}