package com.artemstukalenko.tournaments.task.service;

import com.artemstukalenko.tournaments.task.entity.Player;

import java.util.List;

public interface PlayerService {

    List<Player> getAllPlayers();

    Player findPlayerById(int playerId);

    boolean addOrUpdatePlayer(Player playerToAdd);

    boolean deletePlayerById(int playerToDeleteId);

    boolean deletePlayerByUserId(int userId);
}
