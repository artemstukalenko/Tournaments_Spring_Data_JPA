package com.artemstukalenko.tournaments.task.service.implementators;

import com.artemstukalenko.tournaments.task.dao.TournamentDAO;
import com.artemstukalenko.tournaments.task.entity.Tournament;
import com.artemstukalenko.tournaments.task.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournamentServiceImpl implements TournamentService {

    @Autowired
    private TournamentDAO tournamentDAO;

    @Override
    public List<Tournament> getAllTournaments() {
        return tournamentDAO.getAllTournaments();
    }

    @Override
    public Tournament findTournamentById(int tournamentId) {
        return tournamentDAO.findTournamentById(tournamentId);
    }

    @Override
    public boolean addOrUpdateTournament(Tournament tournamentToAdd) {
        return tournamentDAO.addOrUpdateTournament(tournamentToAdd);
    }

    @Override
    public boolean deleteTournamentById(int tournamentId) {
        return tournamentDAO.deleteTournamentById(tournamentId);
    }

    @Override
    public boolean deleteTournamentByUserId(int userId) {
        return tournamentDAO.deleteTournamentByUserId(userId);
    }
}
