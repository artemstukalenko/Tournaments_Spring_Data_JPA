package com.artemstukalenko.tournaments.task.controller;

import com.artemstukalenko.tournaments.task.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tournaments")
public class TournamentController {

    @Autowired
    private TournamentService tournamentService;

    @RequestMapping("/")
    public String getAllTournaments(Model model) {

        model.addAttribute("allTournaments", tournamentService.getAllTournaments());

        return "";
    }

}
