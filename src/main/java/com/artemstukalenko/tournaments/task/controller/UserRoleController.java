package com.artemstukalenko.tournaments.task.controller;

import com.artemstukalenko.tournaments.task.entity.UserRole;
import com.artemstukalenko.tournaments.task.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/roles")
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    @RequestMapping("/")
    public String showRoles(Model model) {
        model.addAttribute("allRoles", userRoleService.getAllUserRoles());

        return "roles-page.html";
    }

    @RequestMapping("/addRole")
    public String getAddRoleForm(Model model) {

        model.addAttribute("userRole", new UserRole());

        return "add-new-role-form.html";
    }

    @PostMapping("/commitRole")
    public String commitRole(UserRole userRole) {

        userRoleService.addOrUpdateRole(userRole);

        return "forward:/roles/";
    }

    @RequestMapping("/deleteRole/{id}")
    public String deleteRole(@PathVariable("id") int idToDelete) {

        userRoleService.deleteRoleById(idToDelete);

        return "forward:/roles/";
    }

    @RequestMapping("/updateRole/{id}")
    public String getUpdateRoleForm(@PathVariable("id") int idToUpdate, Model model) {

        model.addAttribute("userRole", userRoleService.findRoleById(idToUpdate));

        return "add-new-role-form.html";
    }

}
