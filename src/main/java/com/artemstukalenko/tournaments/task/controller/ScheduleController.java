package com.artemstukalenko.tournaments.task.controller;

import com.artemstukalenko.tournaments.task.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/schedules")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    public String getAllSchedules(Model model) {

        model.addAttribute("allSchedules", scheduleService.getAllSchedules());

        return "";
    }

}
