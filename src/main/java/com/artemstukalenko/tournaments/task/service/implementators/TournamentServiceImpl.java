package com.artemstukalenko.tournaments.task.service.implementators;

import com.artemstukalenko.tournaments.task.dao.ScheduleDAO;
import com.artemstukalenko.tournaments.task.dao.TournamentDAO;
import com.artemstukalenko.tournaments.task.entity.Tournament;
import com.artemstukalenko.tournaments.task.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TournamentServiceImpl implements TournamentService {

    @Autowired
    private TournamentDAO tournamentDAO;

    @Autowired
    private ScheduleDAO scheduleDAO;

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
    @Transactional
    public boolean deleteTournamentById(int tournamentId) {
        scheduleDAO.deleteScheduleByExternalId(tournamentId, "tournament_id");
        return tournamentDAO.deleteTournamentById(tournamentId);
    }

    @Override
    public boolean deleteTournamentByUserId(int userId) {
        return tournamentDAO.deleteTournamentByUserId(userId);
    }
}
