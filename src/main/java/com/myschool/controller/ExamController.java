package com.myschool.controller;

import com.myschool.dto.ExamDto;
import com.myschool.dto.MarkDto;
import com.myschool.service.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exam")
@CrossOrigin
@RequiredArgsConstructor
public class ExamController {

    private final ExamService examService;

    @PostMapping("/create")
    public void createExam(@RequestBody ExamDto dto) {
        examService.createExam(dto);
    }

    @GetMapping("/get-all")
    public List<ExamDto> getAllExams() {
        return examService.getAllExams();
    }

    @PostMapping("/add-marks")
    public void addMarks(@RequestBody MarkDto dto) {
        examService.addMarks(dto);
    }

    @GetMapping("/get-marks-by-student/{studentId}")
    public List<MarkDto> getMarksByStudent(@PathVariable Integer studentId) {
        return examService.getMarksByStudent(studentId);
    }

    @GetMapping("/get-marks-by-exam/{examId}")
    public List<MarkDto> getMarksByExam(@PathVariable Integer examId) {
        return examService.getMarksByExam(examId);
    }
}