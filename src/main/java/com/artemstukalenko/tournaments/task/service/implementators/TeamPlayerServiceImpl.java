package com.artemstukalenko.tournaments.task.service.implementators;

import com.artemstukalenko.tournaments.task.repositories.TeamPlayerRepository;
import com.artemstukalenko.tournaments.task.entity.TeamPlayer;
import com.artemstukalenko.tournaments.task.service.TeamPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TeamPlayerServiceImpl implements TeamPlayerService {

    @Autowired
    private TeamPlayerRepository teamPlayerRepository;

    @Override
    public List<TeamPlayer> getAllTeamPlayers() {
        return teamPlayerRepository.findAll();
    }

    @Override
    public TeamPlayer findTeamPlayerById(int teamPlayerId) {
        return teamPlayerRepository.getById(teamPlayerId);
    }

    @Override
    @Transactional
    public boolean addOrUpdateTeamPlayer(TeamPlayer teamPlayerToAdd) {
        teamPlayerRepository.save(teamPlayerToAdd);
        return true;
    }

    @Override
    @Transactional
    public boolean deleteTeamPlayerById(int teamPlayerId) {
        teamPlayerRepository.deleteById(teamPlayerId);
        return true;
    }
}
