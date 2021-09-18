package com.example.springbootstraprestapplication.service;

import com.example.springbootstraprestapplication.model.Role;
import com.example.springbootstraprestapplication.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


public interface UserService extends UserDetailsService {

    void saveUser(User user);

    void removeUser(long id);

    void updateUser(User user);

    List<User> getAllUsers();

    User getUserById(long id);

    User findUserByEmail(String email);

    Role findRoleByName(String name);

    Role findRoleById(long id);

    List<Role> getAllRoles();
}
