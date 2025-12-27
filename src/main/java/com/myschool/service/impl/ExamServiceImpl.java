package com.myschool.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myschool.dto.ExamDto;
import com.myschool.dto.MarkDto;
import com.myschool.entity.*;
import com.myschool.repository.*;
import com.myschool.service.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExamServiceImpl implements ExamService {

    private final ExamRepository examRepository;
    private final MarkRepository markRepository;
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;
    private final AcademicYearRepository yearRepository; // For linking academic year
    private final ObjectMapper mapper;

    @Override
    public void createExam(ExamDto dto) {
        ExamEntity entity = mapper.convertValue(dto, ExamEntity.class);
        if(dto.getAcademicYearId() != null){
            AcademicYearEntity year = yearRepository.findById(dto.getAcademicYearId()).orElse(null);
            entity.setAcademicYear(year);
        }
        examRepository.save(entity);
    }

    @Override
    public List<ExamDto> getAllExams() {
        List<ExamEntity> list = examRepository.findAll();
        List<ExamDto> dtos = new ArrayList<>();
        list.forEach(e -> dtos.add(mapper.convertValue(e, ExamDto.class)));
        return dtos;
    }

    @Override
    public void addMarks(MarkDto dto) {
        MarkEntity entity = new MarkEntity();
        entity.setMarksObtained(dto.getMarksObtained());
        entity.setGrade(dto.getGrade());

        // Set Relationships
        entity.setExam(examRepository.findById(dto.getExamId()).orElse(null));
        entity.setStudent(studentRepository.findById(dto.getStudentId()).orElse(null));
        entity.setSubject(subjectRepository.findById(dto.getSubjectId()).orElse(null));

        markRepository.save(entity);
    }

    @Override
    public List<MarkDto> getMarksByStudent(Integer studentId) {
        List<MarkEntity> list = markRepository.findByStudentStudentId(studentId);
        List<MarkDto> dtos = new ArrayList<>();
        list.forEach(e -> dtos.add(mapper.convertValue(e, MarkDto.class)));
        return dtos;
    }

    @Override
    public List<MarkDto> getMarksByExam(Integer examId) {
        List<MarkEntity> list = markRepository.findByExamExamId(examId);
        List<MarkDto> dtos = new ArrayList<>();
        list.forEach(e -> dtos.add(mapper.convertValue(e, MarkDto.class)));
        return dtos;
    }
}