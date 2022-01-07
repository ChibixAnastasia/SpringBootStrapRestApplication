package com.example.springbootstraprestapplication.dao;

import com.example.springbootstraprestapplication.model.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class RoleDaoImpl implements RoleDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Set<Role> getRolesById(Long[] rolesId) {
        List<Long> list = Arrays.asList(rolesId);
        return new HashSet<Role>(entityManager.createQuery("SELECT r FROM Role r WHERE r.id IN (:idRoles)", Role.class)
                            .setParameter("idRoles", list)
                            .getResultList());
    }
}
