package com.artemstukalenko.tournaments.task.controller;

import com.artemstukalenko.tournaments.task.service.TeamPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/teamplayers")
public class TeamPlayers {

    @Autowired
    private TeamPlayerService teamPlayerService;

    @RequestMapping("/")
    public String getAllTeamplayers(Model model) {

        model.addAttribute("allTeamplayers", teamPlayerService.getAllTeamPlayers());

        return "";
    }

}
