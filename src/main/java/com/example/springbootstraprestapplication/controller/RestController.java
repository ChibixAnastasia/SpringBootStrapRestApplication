package com.example.springbootstraprestapplication.controller;

import com.example.springbootstraprestapplication.model.Role;
import com.example.springbootstraprestapplication.model.User;
import com.example.springbootstraprestapplication.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Set;


@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    private final UserService userService;

    public RestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/roles")
    public ResponseEntity<List<Role>> allRoles() {
        return ResponseEntity.ok().body(userService.getAllRoles());
    }

    @GetMapping("/current")
    public ResponseEntity<User> currentUser(Principal principal) {
        User user = (User) userService.loadUserByUsername(principal.getName());
        return ResponseEntity.ok().body(user);
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
        Set<Role> roles = user.getRoles();
        for(Role role : roles) {
            System.out.println(role);
        }
        userService.saveUser(user);
        return ResponseEntity.ok().body(user);
    }

    @PutMapping()
    public ResponseEntity<User> update(@RequestBody User user) {
        Set<Role> role = user.getRoles();
        for(Role roles: role) {
            System.out.println(roles.getName());
        }
        userService.updateUser(user);
        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        userService.removeUser(id);
    }

}
