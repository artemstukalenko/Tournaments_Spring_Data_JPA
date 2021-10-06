package com.artemstukalenko.tournaments.task.controller;

import com.artemstukalenko.tournaments.task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String getAllUsers(Model model) {

        model.addAttribute("allUsers", userService.getAllUsers());

        return "";
    }

}
