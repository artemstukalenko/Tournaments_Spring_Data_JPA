package com.artemstukalenko.tournaments.task.controller;

import com.artemstukalenko.tournaments.task.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private UserRoleService userRoleService;

    @RequestMapping("/")
    public String showRoles(Model model) {
        model.addAttribute("allRoles", userRoleService.getAllUserRoles());

        return "roles-page.html";
    }

}
