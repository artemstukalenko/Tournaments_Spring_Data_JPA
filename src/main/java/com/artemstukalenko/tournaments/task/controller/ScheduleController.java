package com.artemstukalenko.tournaments.task.controller;

import com.artemstukalenko.tournaments.task.entity.Schedule;
import com.artemstukalenko.tournaments.task.service.ScheduleService;
import com.artemstukalenko.tournaments.task.service.TeamService;
import com.artemstukalenko.tournaments.task.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/schedules")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private TeamService teamService;

    @Autowired
    private TournamentService tournamentService;

    @RequestMapping("/")
    public String getAllSchedules(Model model) {

        model.addAttribute("allSchedules", scheduleService.getAllSchedules());

        return "schedules-page.html";
    }

    @RequestMapping("/addSchedule")
    public String getAddScheduleForm(Model model) {

        model.addAttribute("schedule", new Schedule());
        model.addAttribute("allTeams", teamService.getAllTeams());
        model.addAttribute("allTournaments", tournamentService.getAllTournaments());

        return "schedule-form.html";
    }

    @RequestMapping("/commitSchedule")
    public String commitSchedule(Schedule schedule) {

        schedule.setTournament(tournamentService.findTournamentById(schedule.getTournament().getTournamentId()));
        schedule.setTeam(teamService.findTeamById(schedule.getTeam().getTeamId()));

        scheduleService.addOrUpdateSchedule(schedule);

        return "forward:/schedules/";
    }

    @RequestMapping("/deleteSchedule/{id}")
    public String deleteSchedule(@PathVariable("id") int idToDelete) {

        scheduleService.deleteScheduleById(idToDelete);

        return "forward:/schedules/";
    }

    @RequestMapping("/updateSchedule/{id}")
    public String getFormToUpdateSchedule(@PathVariable("id") int idToUpdate,
                                          Model model) {

        model.addAttribute("schedule", scheduleService.findScheduleById(idToUpdate));
        model.addAttribute("allTeams", teamService.getAllTeams());
        model.addAttribute("allTournaments", tournamentService.getAllTournaments());

        return "schedule-form.html";
    }

}
