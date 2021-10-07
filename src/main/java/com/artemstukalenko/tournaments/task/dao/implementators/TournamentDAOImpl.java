package com.artemstukalenko.tournaments.task.dao.implementators;

import com.artemstukalenko.tournaments.task.dao.EntityDAO;
import com.artemstukalenko.tournaments.task.dao.TournamentDAO;
import com.artemstukalenko.tournaments.task.entity.Tournament;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class TournamentDAOImpl extends EntityDAO implements TournamentDAO {

    @Override
    @Transactional
    public List<Tournament> getAllTournaments() {
        List<Tournament> allTournaments;

        initializeSession();
        allTournaments = session.createQuery("from Tournament", Tournament.class).getResultList();

        return allTournaments;
    }

    @Override
    @Transactional
    public Tournament findTournamentById(int tournamentId) {
        Tournament soughtTournament;

        initializeSession();
        soughtTournament = session.get(Tournament.class, tournamentId);

        return soughtTournament;
    }

    @Override
    @Transactional
    public boolean addOrUpdateTournament(Tournament tournamentToAdd) {

        initializeSession();
        session.saveOrUpdate(tournamentToAdd);

        return true;
    }

    @Override
    @Transactional
    public boolean deleteTournamentById(int tournamentId) {

        initializeSession();
        Query<Tournament> queryForDeletingTournamentById = session
                .createQuery("delete from Tournament where tournamentId = :idToDelete");
        queryForDeletingTournamentById.setParameter("idToDelete", tournamentId);
        queryForDeletingTournamentById.executeUpdate();

        return true;
    }

    @Override
    @Transactional
    public boolean deleteTournamentByUserId(int userId) {

        initializeSession();
        String deletingQuery = "delete from Tournament where user.id = :id";
        Query<Tournament> queryForDeletingTournamentByUserId = session
                .createQuery(deletingQuery).setParameter("id", userId);
        queryForDeletingTournamentByUserId.executeUpdate();

        return true;
    }
}
