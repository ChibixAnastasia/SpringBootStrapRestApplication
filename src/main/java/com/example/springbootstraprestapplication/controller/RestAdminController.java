package com.example.springbootstraprestapplication.controller;

import com.example.springbootstraprestapplication.dto.UserDto;
import com.example.springbootstraprestapplication.mapper.UserMapper;
import com.example.springbootstraprestapplication.model.Role;
import com.example.springbootstraprestapplication.model.User;
import com.example.springbootstraprestapplication.service.RoleService;
import com.example.springbootstraprestapplication.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;



@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestAdminController {

    private final UserService userService;

    private final RoleService roleService;

    private final UserMapper userMapper;

    public RestAdminController(UserService userService, RoleService roleService, UserMapper userMapper) {
        this.userService = userService;
        this.roleService = roleService;
        this.userMapper = userMapper;
    }

    @GetMapping("/current")
    public ResponseEntity<User> currentUser(Principal principal) {
        User user = (User) userService.loadUserByUsername(principal.getName());
        return ResponseEntity.ok().body(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> allUsers() {
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> user(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(userService.getUserById(id));
    }

    @PostMapping("/new")
    public ResponseEntity<User> newUser(@RequestBody UserDto userDto) {
        User user = userMapper.dtoToEntity(userDto);
        userService.saveUser(user);
        return ResponseEntity.ok().body(user);
    }

    @PutMapping("/edit")
    public ResponseEntity<User> update(@RequestBody UserDto userDto) {
        User user = userMapper.dtoToEntity(userDto);
        userService.updateUser(user);
        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        userService.removeUser(id);
    }

}
