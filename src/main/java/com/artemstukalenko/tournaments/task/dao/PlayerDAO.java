package com.artemstukalenko.tournaments.task.dao;

import com.artemstukalenko.tournaments.task.entity.Player;

import java.sql.SQLException;
import java.util.List;

public interface PlayerDAO {

    List<Player> getAllPlayers();

    Player findPlayerById(int playerId);

    boolean addOrUpdatePlayer(Player playerToAdd);

    boolean deletePlayerById(int playerId);

    boolean deletePlayerByUserId(int userId);
}
