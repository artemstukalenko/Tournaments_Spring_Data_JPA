package com.artemstukalenko.tournaments.task.service.implementators;

import com.artemstukalenko.tournaments.task.dao.PlayerDAO;
import com.artemstukalenko.tournaments.task.entity.Player;
import com.artemstukalenko.tournaments.task.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerDAO playerDAO;

    @Override
    public List<Player> getAllPlayers() {
        return playerDAO.getAllPlayers();
    }

    @Override
    public Player findPlayerById(int playerId) {
        return playerDAO.findPlayerById(playerId);
    }

    @Override
    public boolean addOrUpdatePlayer(Player playerToAdd) {
        return playerDAO.addOrUpdatePlayer(playerToAdd);
    }

    @Override
    public boolean deletePlayerById(int playerToDeleteId) {
        return playerDAO.deletePlayerById(playerToDeleteId);
    }

    @Override
    public boolean deletePlayerByUserId(int userId) {
        return playerDAO.deletePlayerByUserId(userId);
    }
}
