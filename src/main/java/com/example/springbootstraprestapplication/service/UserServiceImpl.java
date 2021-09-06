package com.example.springbootstraprestapplication.service;

import com.example.springbootstraprestapplication.model.Role;
import com.example.springbootstraprestapplication.model.User;
import com.example.springbootstraprestapplication.repository.RoleRepository;
import com.example.springbootstraprestapplication.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }
    @Override
    @Transactional
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void removeUser(long id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User getUserById(long id) {
        return userRepository.getById(id);
    }

    @Override
    @Transactional
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    @Transactional
    public Role findRoleByName(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByEmail(s);
    }
}
