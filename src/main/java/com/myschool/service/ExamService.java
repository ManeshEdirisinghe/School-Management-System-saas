package com.myschool.service;

import com.myschool.dto.ExamDto;
import com.myschool.dto.MarkDto;
import java.util.List;

public interface ExamService {
    void createExam(ExamDto examDto);
    List<ExamDto> getAllExams();

    void addMarks(MarkDto markDto);
    List<MarkDto> getMarksByStudent(Integer studentId);
    List<MarkDto> getMarksByExam(Integer examId);
}