package com.artemstukalenko.tournaments.task.service;

import com.artemstukalenko.tournaments.task.entity.TeamPlayer;

import java.util.List;

public interface TeamPlayerService {

    List<TeamPlayer> getAllTeamPlayers();

    TeamPlayer findTeamPlayerById(int teamPlayerId);

    boolean addOrUpdateTeamPlayer(TeamPlayer teamPlayerToAdd);

    boolean deleteTeamPlayerById(int teamPlayerId);

}
