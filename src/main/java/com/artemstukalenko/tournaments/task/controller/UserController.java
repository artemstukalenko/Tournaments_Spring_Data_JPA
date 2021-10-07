package com.artemstukalenko.tournaments.task.controller;

import com.artemstukalenko.tournaments.task.entity.User;
import com.artemstukalenko.tournaments.task.service.UserRoleService;
import com.artemstukalenko.tournaments.task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;

    @RequestMapping("/")
    public String getAllUsers(Model model) {

        model.addAttribute("allUsers", userService.getAllUsers());

        return "users-page.html";
    }

    @RequestMapping("/addUser")
    public String getAddUserForm(Model model) {

        model.addAttribute("user", new User());
        model.addAttribute("availableRoles", userRoleService.getAllUserRoles());

        return "user-form.html";
    }

    @RequestMapping("/commitUser")
    public String commitUser(User user) {

        user.setUserRole(userRoleService.findRoleById(user.getUserRole().getRoleId()));

        userService.addOrUpdateUser(user);

        return "forward:/users/";
    }

    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int idToDelete) {

        userService.deleteUserById(idToDelete);

        return "forward:/users/";
    }

    @RequestMapping("/updateUser/{id}")
    public String getFormToUpdateUser(@PathVariable("id") int idToUpdate, Model model) {

        model.addAttribute("user", userService.findUserById(idToUpdate));
        model.addAttribute("availableRoles", userRoleService.getAllUserRoles());

        return "user-form.html";
    }
}
