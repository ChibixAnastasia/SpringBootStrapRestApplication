package com.example.springbootstraprestapplication.controller;



import com.example.springbootstraprestapplication.model.User;
import com.example.springbootstraprestapplication.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/users")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String user(Model model, Principal principal) {
        User user = (User) userService.loadUserByUsername(principal.getName());
        model.addAttribute("user", user);
        return "user";
    }









}
