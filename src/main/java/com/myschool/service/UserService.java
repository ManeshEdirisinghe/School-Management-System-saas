package com.myschool.service;

import com.myschool.dto.UserDto;
import com.myschool.dto.RoleDto;
import java.util.List;

public interface UserService {
    void addUser(UserDto userDto);
    void addRole(RoleDto roleDto);
    List<UserDto> getAllUsers();
    List<RoleDto> getAllRoles();
}