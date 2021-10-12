package com.artemstukalenko.tournaments.task.service.implementators;

import com.artemstukalenko.tournaments.task.repositories.ScheduleRepository;
import com.artemstukalenko.tournaments.task.repositories.TournamentRepository;
import com.artemstukalenko.tournaments.task.entity.Tournament;
import com.artemstukalenko.tournaments.task.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TournamentServiceImpl implements TournamentService {

    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }

    @Override
    public Tournament findTournamentById(int tournamentId) {
        return tournamentRepository.getById(tournamentId);
    }

    @Override
    @Transactional
    public boolean addOrUpdateTournament(Tournament tournamentToAdd) {
        tournamentRepository.save(tournamentToAdd);
        return true;
    }

    @Override
    @Transactional
    public boolean deleteTournamentById(int tournamentId) {
        scheduleRepository.deleteScheduleByTournamentId(tournamentId);
        tournamentRepository.deleteById(tournamentId);
        return true;
    }

    @Override
    @Transactional
    public boolean deleteTournamentByUserId(int userId) {
        tournamentRepository.deleteTournamentByUserId(userId);
        return true;
    }
}
