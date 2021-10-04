package com.artemstukalenko.tournaments.task.dao;

import com.artemstukalenko.tournaments.task.entity.Tournament;

import java.sql.SQLException;
import java.util.List;

public interface TournamentDAO {

    List<Tournament> getAllTournaments();

    Tournament findTournamentById(int tournamentId);

    boolean addOrUpdateTournament(Tournament tournamentToAdd);

    boolean deleteTournamentById(int tournamentId);

    boolean deleteTournamentByUserId(int userId);
}
