package com.myschool.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myschool.dto.RoleDto;
import com.myschool.dto.UserDto;
import com.myschool.entity.RoleEntity;
import com.myschool.entity.UserEntity;
import com.myschool.repository.RoleRepository;
import com.myschool.repository.UserRepository;
import com.myschool.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final ObjectMapper mapper;

    @Override
    public void addUser(UserDto dto) {
        userRepository.save(mapper.convertValue(dto, UserEntity.class));
    }

    @Override
    public void addRole(RoleDto dto) {
        roleRepository.save(mapper.convertValue(dto, RoleEntity.class));
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<UserEntity> list = userRepository.findAll();
        List<UserDto> dtos = new ArrayList<>();
        list.forEach(e -> dtos.add(mapper.convertValue(e, UserDto.class)));
        return dtos;
    }

    @Override
    public List<RoleDto> getAllRoles() {
        List<RoleEntity> list = roleRepository.findAll();
        List<RoleDto> dtos = new ArrayList<>();
        list.forEach(e -> dtos.add(mapper.convertValue(e, RoleDto.class)));
        return dtos;
    }
}