package com.myschool.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myschool.dto.StudentDto;
import com.myschool.entity.StudentEntity;
import com.myschool.repository.StudentRepository;
import com.myschool.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ObjectMapper mapper;

    @Override
    public void addStudent(StudentDto dto) {
        StudentEntity entity = mapper.convertValue(dto, StudentEntity.class);
        studentRepository.save(entity);
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<StudentEntity> list = studentRepository.findAll();
        List<StudentDto> dtoList = new ArrayList<>();
        list.forEach(entity -> dtoList.add(mapper.convertValue(entity, StudentDto.class)));
        return dtoList;
    }

    @Override
    public StudentDto getStudentById(Integer id) {
        Optional<StudentEntity> byId = studentRepository.findById(id);
        return byId.map(entity -> mapper.convertValue(entity, StudentDto.class)).orElse(null);
    }
}