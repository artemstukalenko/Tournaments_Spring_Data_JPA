package com.artemstukalenko.tournaments.task.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String getHomepage(Model model) {

        return "homepage-with-bootstrap.html";

    }

}
