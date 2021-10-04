package com.artemstukalenko.tournaments.task.dao;

import com.artemstukalenko.tournaments.task.entity.TeamPlayer;

import java.util.List;

public interface TeamPlayerDAO {

    List<TeamPlayer> getAllTeamPlayers();

    TeamPlayer findTeamPlayerById(int teamPlayerId);

    boolean addOrUpdateTeamPlayer(TeamPlayer teamPlayerToAdd);

    boolean deleteTeamPlayerById(int teamPlayerId);

    boolean deleteTeamPlayerByExternalId(int playerId, String columnName);
}
