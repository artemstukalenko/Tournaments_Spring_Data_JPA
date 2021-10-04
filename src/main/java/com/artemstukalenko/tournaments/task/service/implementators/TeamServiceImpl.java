package com.artemstukalenko.tournaments.task.service.implementators;

import com.artemstukalenko.tournaments.task.dao.TeamDAO;
import com.artemstukalenko.tournaments.task.entity.Team;
import com.artemstukalenko.tournaments.task.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamDAO teamDAO;

    @Override
    public List<Team> getAllTeams() {
        return teamDAO.getAllTeams();
    }

    @Override
    public Team findTeamById(int teamId) {
        return teamDAO.findTeamById(teamId);
    }

    @Override
    public boolean addOrUpdateTeam(Team teamToAdd) {
        return teamDAO.addOrUpdateTeam(teamToAdd);
    }

    @Override
    public boolean deleteTeamById(int teamId) {
        return teamDAO.deleteTeamById(teamId);
    }

    @Override
    public boolean deleteTeamByUserId(int userId) {
        return teamDAO.deleteTeamByUserId(userId);
    }
}
