package com.artemstukalenko.tournaments.task.service.implementators;

import com.artemstukalenko.tournaments.task.dao.TeamPlayerDAO;
import com.artemstukalenko.tournaments.task.entity.TeamPlayer;
import com.artemstukalenko.tournaments.task.service.TeamPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamPlayerServiceImpl implements TeamPlayerService {

    @Autowired
    private TeamPlayerDAO teamPlayerDAO;

    @Override
    public List<TeamPlayer> getAllTeamPlayers() {
        return teamPlayerDAO.getAllTeamPlayers();
    }

    @Override
    public TeamPlayer findTeamPlayerById(int teamPlayerId) {
        return teamPlayerDAO.findTeamPlayerById(teamPlayerId);
    }

    @Override
    public boolean addOrUpdateTeamPlayer(TeamPlayer teamPlayerToAdd) {
        return teamPlayerDAO.addOrUpdateTeamPlayer(teamPlayerToAdd);
    }

    @Override
    public boolean deleteTeamPlayerById(int teamPlayerId) {
        return teamPlayerDAO.deleteTeamPlayerById(teamPlayerId);
    }
}
