package com.example.springbootstraprestapplication.controller;


import com.example.springbootstraprestapplication.model.User;
import com.example.springbootstraprestapplication.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {


    private final UserService userService;


    public AdminController(UserService userService) {
        this.userService = userService;

    }

    @GetMapping()
    public String mainPage(Model model, Principal principal){
        User user = (User) userService.loadUserByUsername(principal.getName());
        model.addAttribute("user", user);
        model.addAttribute("users", userService.getAllUsers());
        return "admin";
    }


    /*@PostMapping("/edit")
    public String updateUser(@RequestParam("id") long id,
                             @RequestParam(value = "firstname", required = false) String firstName,
                             @RequestParam(value = "lastname", required = false) String lastName,
                             @RequestParam(value = "email", required = false) String email,
                             @RequestParam(value = "password", required = false) String password,
                             @RequestParam(name = "roles", required = false) String[] roles) {
        User user = userService.getUserById(id);

        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        Set<Role> role = new HashSet<>();
        for(String r: roles) {
            role.add(userService.findRoleByName(r));
        }
        user.setRoles(role);
        userService.updateUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.removeUser(id);
        return "redirect:/admin";
    }

    @PostMapping("/new")
    public String newUser(@RequestParam("name") String firstName,
                          @RequestParam("lastname") String lastName,
                          @RequestParam("email") String email,
                          @RequestParam("password") String password,
                          @RequestParam("roles") String [] roles) {
        Set<Role> role = new HashSet<>();
        for(String r: roles) {
            role.add(userService.findRoleByName(r));
        }
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        user.setRoles(role);
        userService.saveUser(user);
        return "redirect:/admin";
    }*/

}
