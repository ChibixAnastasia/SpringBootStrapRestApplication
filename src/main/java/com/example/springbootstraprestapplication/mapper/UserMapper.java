package com.example.springbootstraprestapplication.mapper;

import com.example.springbootstraprestapplication.dto.UserDto;
import com.example.springbootstraprestapplication.model.User;
import com.example.springbootstraprestapplication.service.RoleService;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    private final RoleService roleService;

    public UserMapper(RoleService roleService) {
        this.roleService = roleService;
    }

    public User dtoToEntity(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setAge(userDto.getAge());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setRoles(roleService.findRolesById(userDto.getRolesId()));
        return user;
    }
}
