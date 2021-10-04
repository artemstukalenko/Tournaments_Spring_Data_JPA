package com.artemstukalenko.tournaments.task.service;

import com.artemstukalenko.tournaments.task.entity.Tournament;

import java.util.List;

public interface TournamentService {

    List<Tournament> getAllTournaments();

    Tournament findTournamentById(int tournamentId);

    boolean addOrUpdateTournament(Tournament tournamentToAdd);

    boolean deleteTournamentById(int tournamentId);

    boolean deleteTournamentByUserId(int userId);
}
