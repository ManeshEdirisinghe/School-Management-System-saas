package com.myschool.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myschool.dto.SubjectDto;
import com.myschool.entity.SubjectEntity;
import com.myschool.repository.SubjectRepository;
import com.myschool.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;
    private final ObjectMapper mapper;

    @Override
    public void addSubject(SubjectDto dto) {
        SubjectEntity entity = mapper.convertValue(dto, SubjectEntity.class);
        subjectRepository.save(entity);
    }

    @Override
    public List<SubjectDto> getAllSubjects() {
        List<SubjectEntity> list = subjectRepository.findAll();
        List<SubjectDto> dtoList = new ArrayList<>();
        list.forEach(entity -> dtoList.add(mapper.convertValue(entity, SubjectDto.class)));
        return dtoList;
    }
}