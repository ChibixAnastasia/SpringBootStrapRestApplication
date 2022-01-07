package com.example.springbootstraprestapplication.service;

import com.example.springbootstraprestapplication.dao.RoleDao;
import com.example.springbootstraprestapplication.model.Role;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService{

    private final RoleDao roleRepository;

    public RoleServiceImpl(RoleDao roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Set<Role> findRolesById(Long[] rolesId) {
        return roleRepository.getRolesById(rolesId);
    }



}
