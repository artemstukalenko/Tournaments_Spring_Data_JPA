package com.artemstukalenko.tournaments.task.service.implementators;

import com.artemstukalenko.tournaments.task.repositories.ScheduleRepository;
import com.artemstukalenko.tournaments.task.repositories.TeamRepository;
import com.artemstukalenko.tournaments.task.repositories.TeamPlayerRepository;
import com.artemstukalenko.tournaments.task.entity.Team;
import com.artemstukalenko.tournaments.task.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private TeamPlayerRepository teamPlayerRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @Override
    public Team findTeamById(int teamId) {
        return teamRepository.getById(teamId);
    }

    @Override
    @Transactional
    public boolean addOrUpdateTeam(Team teamToAdd) {
        teamRepository.save(teamToAdd);
        return true;
    }

    @Override
    @Transactional
    public boolean deleteTeamById(int teamId) {
        System.out.println("PASSING ID TO DELETE SCHEDULE:    " + teamId);
        scheduleRepository.deleteScheduleByTeamId(teamId);
        System.out.println("DELETE SCHEDULE!!!");
        teamPlayerRepository.deleteTeamPlayerByTeamId(teamId);
        teamRepository.deleteById(teamId);
        return true;
    }

    @Override
    @Transactional
    public boolean deleteTeamByUserId(int userId) {

        for(Team team : teamRepository.findTeamsByUserId(userId)) {
            deleteTeamById(team.getTeamId());
        }

        return true;
    }
}
