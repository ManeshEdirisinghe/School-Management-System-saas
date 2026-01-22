package com.myschool.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myschool.dto.ClassDto;
import com.myschool.entity.ClassEntity;
import com.myschool.repository.ClassRepository;
import com.myschool.service.ClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClassServiceImpl implements ClassService {

    private final ClassRepository classRepository;
    private final ObjectMapper mapper;

    @Override
    public void addClass(ClassDto dto) {
        ClassEntity entity = mapper.convertValue(dto, ClassEntity.class);
        classRepository.save(entity);
    }

    @Override
    public List<ClassDto> getAllClasses() {
        List<ClassEntity> entities = classRepository.findAll();
        List<ClassDto> dtos = new ArrayList<>();
        for (ClassEntity entity : entities) {
            dtos.add(mapper.convertValue(entity, ClassDto.class));
        }
        return dtos;
    }

    @Override
    public ClassDto getClassById(Integer id) {
        Optional<ClassEntity> byId = classRepository.findById(id);
        return byId.map(entity -> mapper.convertValue(entity, ClassDto.class)).orElse(null);
    }
}