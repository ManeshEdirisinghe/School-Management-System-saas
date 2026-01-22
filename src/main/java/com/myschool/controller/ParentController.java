package com.myschool.controller;

import com.myschool.dto.ParentDto;
import com.myschool.service.ParentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parent")
@CrossOrigin
@RequiredArgsConstructor
public class ParentController {

    private final ParentService parentService;

    @PostMapping("/add")
    public void addParent(@RequestBody ParentDto parentDto) {
        parentService.addParent(parentDto);
    }

    @GetMapping("/get-all")
    public List<ParentDto> getAll() {
        return parentService.getAllParents();
    }
}