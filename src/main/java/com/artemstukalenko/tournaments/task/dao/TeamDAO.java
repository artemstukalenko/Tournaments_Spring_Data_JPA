package com.artemstukalenko.tournaments.task.dao;

import com.artemstukalenko.tournaments.task.entity.Team;

import java.sql.SQLException;
import java.util.List;

public interface TeamDAO {

    List<Team> getAllTeams();

    Team findTeamById(int teamId);

    boolean addOrUpdateTeam(Team teamToAdd);

    boolean deleteTeamById(int teamId);

    boolean deleteTeamByUserId(int userId);

    List<Team> findTeamsByUserId(int userId);
}
