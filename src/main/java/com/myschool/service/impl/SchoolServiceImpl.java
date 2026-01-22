package com.myschool.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myschool.dto.SchoolDto;
import com.myschool.entity.SchoolEntity;
import com.myschool.repository.SchoolRepository;
import com.myschool.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolServiceImpl implements SchoolService {

    private final SchoolRepository schoolRepository;
    private final ObjectMapper mapper;

    @Override
    public void addSchool(SchoolDto dto) {
        SchoolEntity entity = mapper.convertValue(dto, SchoolEntity.class);
        schoolRepository.save(entity);
    }

    @Override
    public List<SchoolDto> getAllSchools() {
        List<SchoolEntity> list = schoolRepository.findAll();
        List<SchoolDto> dtoList = new ArrayList<>();
        list.forEach(entity -> dtoList.add(mapper.convertValue(entity, SchoolDto.class)));
        return dtoList;
    }
}