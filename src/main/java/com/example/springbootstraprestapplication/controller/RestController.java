package com.example.springbootstraprestapplication.controller;

import com.example.springbootstraprestapplication.model.User;
import com.example.springbootstraprestapplication.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    private final UserService userService;

    public RestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<List<User>> allUsers() {
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> user(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(userService.getUserById(id));
    }

    @PostMapping()
    public ResponseEntity<User> newUser(@RequestBody User user) {
        userService.saveUser(user);
        return ResponseEntity.ok().body(user);
    }

    @PutMapping()
    public ResponseEntity<User> update(@RequestBody User user) {
        userService.updateUser(user);
        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        userService.removeUser(id);
    }



}
