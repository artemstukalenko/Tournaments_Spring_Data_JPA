package com.artemstukalenko.tournaments.task.controller;

import com.artemstukalenko.tournaments.task.entity.TeamPlayer;
import com.artemstukalenko.tournaments.task.service.PlayerService;
import com.artemstukalenko.tournaments.task.service.TeamPlayerService;
import com.artemstukalenko.tournaments.task.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/teamplayers")
public class TeamPlayersController {

    @Autowired
    private TeamPlayerService teamPlayerService;

    @Autowired
    private TeamService teamService;

    @Autowired
    private PlayerService playerService;

    @RequestMapping("/")
    public String getAllTeamplayers(Model model) {

        model.addAttribute("allTeamplayers", teamPlayerService.getAllTeamPlayers());

        return "teamplayers-page.html";
    }

    @RequestMapping("/addTeamPlayer")
    public String addTeamPlayerForm(Model model) {

        model.addAttribute("teamPlayer", new TeamPlayer());
        model.addAttribute("allTeams", teamService.getAllTeams());
        model.addAttribute("allPlayers", playerService.getAllPlayers());

        return "teamplayer-form.html";
    }

    @RequestMapping("/commitTeamPlayer")
    public String commitTeamPlayer(TeamPlayer teamPlayer) {

        teamPlayer.setTeam(teamService.findTeamById(teamPlayer.getTeam().getTeamId()));
        teamPlayer.setPlayer(playerService.findPlayerById(teamPlayer.getPlayer().getId()));

        teamPlayerService.addOrUpdateTeamPlayer(teamPlayer);

        return "forward:/teamplayers/";
    }

    @RequestMapping("/deleteTeamPlayer/{id}")
    public String deleteTeamPlayer(@PathVariable("id") int idToDelete) {

        teamPlayerService.deleteTeamPlayerById(idToDelete);

        return "forward:/teamplayers/";
    }

    @RequestMapping("/updateTeamPlayer/{id}")
    public String getFormToUpdateTeamPlayer(@PathVariable("id") int idToUpdate,
                                            Model model) {

        model.addAttribute("teamPlayer", teamPlayerService.findTeamPlayerById(idToUpdate));
        model.addAttribute("allTeams", teamService.getAllTeams());
        model.addAttribute("allPlayers", playerService.getAllPlayers());

        return "teamplayer-form.html";
    }
}
