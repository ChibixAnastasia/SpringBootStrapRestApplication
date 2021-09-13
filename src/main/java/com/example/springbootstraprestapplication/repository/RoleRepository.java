package com.example.springbootstraprestapplication.repository;

import com.example.springbootstraprestapplication.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


public interface RoleRepository extends JpaRepository<Role, Long> {
    public Role findById(long id);
}
