package com.artemstukalenko.tournaments.task.controller;

import com.artemstukalenko.tournaments.task.entity.UserRole;
import com.artemstukalenko.tournaments.task.service.UserRoleService;
import com.artemstukalenko.tournaments.task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String getHomepage(Model model) {

        System.out.println("ROLE " + userRoleService.findRoleById(1));

        return "homepage";
    }

}
