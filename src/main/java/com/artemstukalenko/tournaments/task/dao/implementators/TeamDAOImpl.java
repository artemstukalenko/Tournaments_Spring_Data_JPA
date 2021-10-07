package com.artemstukalenko.tournaments.task.dao.implementators;

import com.artemstukalenko.tournaments.task.dao.EntityDAO;
import com.artemstukalenko.tournaments.task.dao.TeamDAO;
import com.artemstukalenko.tournaments.task.entity.Team;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class TeamDAOImpl extends EntityDAO implements TeamDAO {

    @Override
    @Transactional
    public List<Team> getAllTeams() {
        List<Team> allTeams;

        initializeSession();
        allTeams = session.createQuery("from Team", Team.class).getResultList();

        return allTeams;
    }

    @Override
    @Transactional
    public Team findTeamById(int teamId) {
        Team soughtTeam;

        initializeSession();
        soughtTeam = session.get(Team.class, teamId);

        return soughtTeam;
    }

    @Override
    @Transactional
    public boolean addOrUpdateTeam(Team teamToAdd) {

        initializeSession();
        session.saveOrUpdate(teamToAdd);

        return true;
    }

    @Override
    @Transactional
    public boolean deleteTeamById(int teamId) {

        initializeSession();
        Query<Team> queryForDeletingTeamById = session.createQuery("delete from Team " +
                "where teamId = :idToDelete");
        queryForDeletingTeamById.setParameter("idToDelete", teamId);
        queryForDeletingTeamById.executeUpdate();

        return true;
    }

    @Override
    @Transactional
    public boolean deleteTeamByUserId(int userId) {

        initializeSession();
        String deletingQuery = "delete from teams where user_id = :id";
        Query<Team> queryForDeletingTeamByUserId = session
                .createNativeQuery(deletingQuery).setParameter("id", userId);

        queryForDeletingTeamByUserId.executeUpdate();

        return true;
    }

    @Override
    @Transactional
    public List<Team> findTeamsByUserId(int userId) {

        initializeSession();
        String searchingQuery = "from Team where user.id = :id";
        Query<Team> queryForFindingTeamByUserId = session
                .createQuery(searchingQuery)
                .setParameter("id", userId);

        return queryForFindingTeamByUserId.getResultList();
    }
}
