package com.artemstukalenko.tournaments.task.controller;

import com.artemstukalenko.tournaments.task.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @RequestMapping("/")
    public String getAllTeams(Model model) {

        model.addAttribute("allTeams", teamService.getAllTeams());

        return "";
    }

}
