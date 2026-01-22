package com.myschool.controller;

import com.myschool.dto.SubjectDto;
import com.myschool.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
@CrossOrigin
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectService subjectService;

    @PostMapping("/add")
    public void addSubject(@RequestBody SubjectDto subjectDto) {
        subjectService.addSubject(subjectDto);
    }

    @GetMapping("/get-all")
    public List<SubjectDto> getAll() {
        return subjectService.getAllSubjects();
    }
}