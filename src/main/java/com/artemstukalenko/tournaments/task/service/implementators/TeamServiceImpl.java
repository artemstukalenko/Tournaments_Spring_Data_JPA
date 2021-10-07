package com.artemstukalenko.tournaments.task.service.implementators;

import com.artemstukalenko.tournaments.task.dao.ScheduleDAO;
import com.artemstukalenko.tournaments.task.dao.TeamDAO;
import com.artemstukalenko.tournaments.task.dao.TeamPlayerDAO;
import com.artemstukalenko.tournaments.task.entity.Team;
import com.artemstukalenko.tournaments.task.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamDAO teamDAO;

    @Autowired
    private TeamPlayerDAO teamPlayerDAO;

    @Autowired
    private ScheduleDAO scheduleDAO;

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
    @Transactional
    public boolean deleteTeamById(int teamId) {
        scheduleDAO.deleteScheduleByExternalId(teamId, "team_id");
        teamPlayerDAO.deleteTeamPlayerByExternalId(teamId, "team_id");
        return teamDAO.deleteTeamById(teamId);
    }

    @Override
    public boolean deleteTeamByUserId(int userId) {

        for(Team team : teamDAO.findTeamsByUserId(userId)) {
            deleteTeamById(team.getTeamId());
        }

        return true;
    }
}
