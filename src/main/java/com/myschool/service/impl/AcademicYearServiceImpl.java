package com.myschool.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myschool.dto.AcademicYearDto;
import com.myschool.entity.AcademicYearEntity;
import com.myschool.repository.AcademicYearRepository;
import com.myschool.service.AcademicYearService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AcademicYearServiceImpl implements AcademicYearService {

    private final AcademicYearRepository repository;
    private final ObjectMapper mapper;

    @Override
    public void addYear(AcademicYearDto dto) {
        repository.save(mapper.convertValue(dto, AcademicYearEntity.class));
    }

    @Override
    public List<AcademicYearDto> getAllYears() {
        List<AcademicYearEntity> list = repository.findAll();
        List<AcademicYearDto> dtos = new ArrayList<>();
        list.forEach(e -> dtos.add(mapper.convertValue(e, AcademicYearDto.class)));
        return dtos;
    }
}