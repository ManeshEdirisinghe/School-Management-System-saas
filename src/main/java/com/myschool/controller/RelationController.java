package com.myschool.controller;

import com.myschool.dto.StudentParentDto;
import com.myschool.service.RelationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/relation")
@CrossOrigin
@RequiredArgsConstructor
public class RelationController {
    private final RelationService relationService;

    @PostMapping("/link-student-parent")
    public void linkStudentParent(@RequestBody StudentParentDto dto) {
        relationService.addStudentParentRelation(dto);
    }
}