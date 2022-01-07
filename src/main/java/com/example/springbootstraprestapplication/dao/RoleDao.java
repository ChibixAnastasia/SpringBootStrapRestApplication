package com.example.springbootstraprestapplication.dao;

import com.example.springbootstraprestapplication.model.Role;

import java.util.Set;

public interface RoleDao {

    Set<Role> getRolesById(Long[] rolesId);
}
