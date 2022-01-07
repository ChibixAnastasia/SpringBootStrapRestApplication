package com.example.springbootstraprestapplication.service;

import com.example.springbootstraprestapplication.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {

    //Role findRoleByName(String name);

    Set<Role> findRolesById(Long[] rolesId);

    //List<Role> getAllRoles();

}
