package com.artemstukalenko.tournaments.task.service.implementators;

import com.artemstukalenko.tournaments.task.repositories.TeamPlayerRepository;
import com.artemstukalenko.tournaments.task.entity.TeamPlayer;
import com.artemstukalenko.tournaments.task.service.TeamPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TeamPlayerServiceImpl implements TeamPlayerService {

    @Autowired
    private TeamPlayerRepository teamPlayerRepository;

    @Override
    @Transactional(readOnly = true)
    public List<TeamPlayer> getAllTeamPlayers() {
        return teamPlayerRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public TeamPlayer findTeamPlayerById(int teamPlayerId) {
        Optional<TeamPlayer> foundTeamPlayer = teamPlayerRepository.findById(teamPlayerId);
        return Optional.ofNullable(foundTeamPlayer).get().orElse(new TeamPlayer());
    }

    @Override
    public boolean addOrUpdateTeamPlayer(TeamPlayer teamPlayerToAdd) {
        teamPlayerRepository.save(teamPlayerToAdd);
        return true;
    }

    @Override
    public boolean deleteTeamPlayerById(int teamPlayerId) {
        teamPlayerRepository.deleteById(teamPlayerId);
        return true;
    }
}
