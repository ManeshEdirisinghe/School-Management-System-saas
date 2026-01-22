package com.myschool.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myschool.dto.ParentDto;
import com.myschool.entity.ParentEntity;
import com.myschool.repository.ParentRepository;
import com.myschool.service.ParentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ParentServiceImpl implements ParentService {

    private final ParentRepository parentRepository;
    private final ObjectMapper mapper;

    @Override
    public void addParent(ParentDto dto) {
        ParentEntity entity = mapper.convertValue(dto, ParentEntity.class);
        parentRepository.save(entity);
    }

    @Override
    public List<ParentDto> getAllParents() {
        List<ParentEntity> list = parentRepository.findAll();
        List<ParentDto> dtoList = new ArrayList<>();
        list.forEach(entity -> dtoList.add(mapper.convertValue(entity, ParentDto.class)));
        return dtoList;
    }
}