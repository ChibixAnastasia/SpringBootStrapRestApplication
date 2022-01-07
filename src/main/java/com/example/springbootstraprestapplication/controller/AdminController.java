package com.example.springbootstraprestapplication.controller;


import com.example.springbootstraprestapplication.model.User;
import com.example.springbootstraprestapplication.service.RoleService;
import com.example.springbootstraprestapplication.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/admin/user")
public class AdminController {


    private final UserService userService;



    public AdminController(UserService userService) {
        this.userService = userService;

    }

    @GetMapping
    public String mainPage(Model model, Principal principal){
        User user = (User) userService.loadUserByUsername(principal.getName());
        model.addAttribute("user", user);
        //model.addAttribute("users", userService.getAllUsers());
        return "admin";
    }

}
