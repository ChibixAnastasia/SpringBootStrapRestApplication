package com.example.springbootstraprestapplication.dao;

import com.example.springbootstraprestapplication.model.User;

import java.util.List;

public interface UserDao {

    void delete(long id);

    void save(User user);

    List<User> getAllUsers();

    User getUserById(long id);

    void update(User user);

    User getUserByUsername(String username);
}
