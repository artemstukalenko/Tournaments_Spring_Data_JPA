package com.artemstukalenko.tournaments.task.dao.implementators;

import com.artemstukalenko.tournaments.task.dao.EntityDAO;
import com.artemstukalenko.tournaments.task.dao.TeamPlayerDAO;
import com.artemstukalenko.tournaments.task.entity.TeamPlayer;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class TeamPlayerDAOImpl extends EntityDAO implements TeamPlayerDAO {

    @Override
    @Transactional
    public List<TeamPlayer> getAllTeamPlayers() {
        List<TeamPlayer> allTeamPlayers;

        initializeSession();
        allTeamPlayers = session.createQuery("from TeamPlayer", TeamPlayer.class).getResultList();

        return allTeamPlayers;
    }

    @Override
    @Transactional
    public TeamPlayer findTeamPlayerById(int teamPlayerId) {
        TeamPlayer soughtTeamPlayer;

        initializeSession();
        soughtTeamPlayer = session.get(TeamPlayer.class, teamPlayerId);

        return soughtTeamPlayer;
    }

    @Override
    @Transactional
    public boolean addOrUpdateTeamPlayer(TeamPlayer teamPlayerToAdd) {

        initializeSession();
        session.saveOrUpdate(teamPlayerToAdd);

        return true;
    }

    @Override
    @Transactional
    public boolean deleteTeamPlayerById(int teamPlayerId) {

        initializeSession();
        Query<TeamPlayer> queryForDeletingTeamPlayerById = session
                .createQuery("delete from TeamPlayer where teamPlayerId = :idToDelete");
        queryForDeletingTeamPlayerById.setParameter("idToDelete", teamPlayerId);
        queryForDeletingTeamPlayerById.executeUpdate();

        return true;
    }

    @Override
    @Transactional
    public boolean deleteTeamPlayerByExternalId(int playerId, String columnName) {

        String deletingQuery = "delete from team_players where :column = :id";

        initializeSession();
        Query<TeamPlayer> queryForCustomDeletion = session.createNativeQuery(deletingQuery)
                .setParameter("column", columnName)
                .setParameter("id", playerId);
        queryForCustomDeletion.executeUpdate();

        return true;
    }
}
