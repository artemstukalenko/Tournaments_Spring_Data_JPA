package com.artemstukalenko.tournaments.task.service.implementators;

import com.artemstukalenko.tournaments.task.repositories.PlayerRepository;
import com.artemstukalenko.tournaments.task.repositories.TeamPlayerRepository;
import com.artemstukalenko.tournaments.task.entity.Player;
import com.artemstukalenko.tournaments.task.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamPlayerRepository teamPlayerRepository;

    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public Player findPlayerById(int playerId) {
        return playerRepository.getById(playerId);
    }

    @Override
    @Transactional
    public boolean addOrUpdatePlayer(Player playerToAdd) {
        playerRepository.save(playerToAdd);
        return true;
    }

    @Override
    @Transactional
    public boolean deletePlayerById(int playerToDeleteId) {
        teamPlayerRepository.deleteTeamPlayerByPlayerId(playerToDeleteId);
        playerRepository.deleteById(playerToDeleteId);
        return true;
    }

    @Override
    @Transactional
    public boolean deletePlayerByUserId(int userId) {

        for (Player player : playerRepository.findPlayersByUserId(userId)) {
            deletePlayerById(player.getId());
        }

        return true;
    }
}
