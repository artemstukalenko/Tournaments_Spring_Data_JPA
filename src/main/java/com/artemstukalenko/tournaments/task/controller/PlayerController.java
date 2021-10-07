package com.artemstukalenko.tournaments.task.controller;

import com.artemstukalenko.tournaments.task.entity.Player;
import com.artemstukalenko.tournaments.task.service.PlayerService;
import com.artemstukalenko.tournaments.task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String getAllPlayers(Model model) {

        model.addAttribute("allPlayers", playerService.getAllPlayers());

        return "players-page.html";
    }

    @RequestMapping("/addPlayer")
    public String getAddPlayerForm(Model model) {

        model.addAttribute("player", new Player());
        model.addAttribute("allUsers", userService.getAllUsers());

        return "player-form.html";
    }

    @RequestMapping("/commitPlayer")
    public String commitPlayer(Player player) {

        player.setUser(userService.findUserById(player.getUser().getUserId()));

        playerService.addOrUpdatePlayer(player);

        return "forward:/players/";
    }

    @RequestMapping("/deletePlayer/{id}")
    public String deletePlayer(@PathVariable("id") int idToDelete) {

        playerService.deletePlayerById(idToDelete);

        return "forward:/players/";
    }

    @RequestMapping("/updatePlayer/{id}")
    public String getFormToUpdatePlayer(@PathVariable("id") int idToUpdate,
                                        Model model) {

        model.addAttribute("player", playerService.findPlayerById(idToUpdate));
        model.addAttribute("allUsers", userService.getAllUsers());

        return "player-form.html";
    }
}
