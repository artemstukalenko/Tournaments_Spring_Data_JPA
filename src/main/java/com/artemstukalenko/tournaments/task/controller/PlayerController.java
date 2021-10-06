package com.artemstukalenko.tournaments.task.controller;

import com.artemstukalenko.tournaments.task.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @RequestMapping("/")
    public String getAllPlayers(Model model) {

        model.addAttribute("allPlayers", playerService.getAllPlayers());

        return "";
    }

}
