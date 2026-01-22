package com.myschool.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myschool.dto.TeacherDto;
import com.myschool.entity.TeacherEntity;
import com.myschool.repository.TeacherRepository;
import com.myschool.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final ObjectMapper mapper;

    @Override
    public void addTeacher(TeacherDto dto) {
        TeacherEntity entity = mapper.convertValue(dto, TeacherEntity.class);
        teacherRepository.save(entity);
    }

    @Override
    public List<TeacherDto> getAllTeachers() {
        List<TeacherEntity> list = teacherRepository.findAll();
        List<TeacherDto> dtoList = new ArrayList<>();
        list.forEach(entity -> dtoList.add(mapper.convertValue(entity, TeacherDto.class)));
        return dtoList;
    }
}