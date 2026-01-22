package com.myschool.controller;

import com.myschool.dto.RoleDto;
import com.myschool.dto.UserDto;
import com.myschool.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/add-user")
    public void addUser(@RequestBody UserDto dto) {
        userService.addUser(dto);
    }

    @PostMapping("/add-role")
    public void addRole(@RequestBody RoleDto dto) {
        userService.addRole(dto);
    }

    @GetMapping("/get-all-users")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/get-all-roles")
    public List<RoleDto> getAllRoles() {
        return userService.getAllRoles();
    }
}