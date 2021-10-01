package com.artemstukalenko.tournaments.task.controller;

import com.artemstukalenko.tournaments.task.entity.UserRole;
import com.artemstukalenko.tournaments.task.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private UserRoleService userRoleService;

    @RequestMapping("/")
    public String getHomepage(Model model) {

        List<UserRole> allRoles = userRoleService.getAllUserRoles();

        model.addAttribute("allRoles", allRoles);

        return "homepage";
    }

}
