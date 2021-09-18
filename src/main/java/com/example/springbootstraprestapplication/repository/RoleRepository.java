package com.example.springbootstraprestapplication.repository;

import com.example.springbootstraprestapplication.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    public Role findByName(String name);

    public Role findById(long id);
}
