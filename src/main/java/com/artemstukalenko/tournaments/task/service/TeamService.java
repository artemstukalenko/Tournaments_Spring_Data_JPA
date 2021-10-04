package com.artemstukalenko.tournaments.task.service;

import com.artemstukalenko.tournaments.task.entity.Team;

import java.util.List;

public interface TeamService {

    List<Team> getAllTeams();

    Team findTeamById(int teamId);

    boolean addOrUpdateTeam(Team teamToAdd);

    boolean deleteTeamById(int teamId);

    boolean deleteTeamByUserId(int userId);
}
