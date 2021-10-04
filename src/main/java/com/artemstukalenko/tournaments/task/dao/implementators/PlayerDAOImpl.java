package com.artemstukalenko.tournaments.task.dao.implementators;

import com.artemstukalenko.tournaments.task.dao.EntityDAO;
import com.artemstukalenko.tournaments.task.dao.PlayerDAO;
import com.artemstukalenko.tournaments.task.entity.Player;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class PlayerDAOImpl extends EntityDAO implements PlayerDAO {

    @Override
    @Transactional
    public List<Player> getAllPlayers() {
        List<Player> allPlayers;

        initializeSession();
        allPlayers = session.createQuery("from Player", Player.class)
                .getResultList();

        return allPlayers;
    }

    @Override
    @Transactional
    public Player findPlayerById(int playerId) {
        Player soughtPlayer;

        initializeSession();
        soughtPlayer = session.get(Player.class, playerId);

        return soughtPlayer;
    }

    @Override
    @Transactional
    public boolean addOrUpdatePlayer(Player playerToAdd) {

        initializeSession();
        session.saveOrUpdate(playerToAdd);

        return true;
    }

    @Override
    @Transactional
    public boolean deletePlayerById(int playerId) {

        initializeSession();
        Query<Player> queryForDeletingPlayerById = session.createQuery("delete from Player " +
                "where id = :idToDelete");
        queryForDeletingPlayerById.setParameter("idToDelete", playerId);
        queryForDeletingPlayerById.executeUpdate();

        return true;
    }

    @Override
    @Transactional
    public boolean deletePlayerByUserId(int userId) {

        initializeSession();
        String deletingQuery = "delete from players where user_id = :id";
        Query<Player> queryForDeletingPlayerByUserId = session
                .createNativeQuery(deletingQuery).setParameter("id", userId);

        return true;
    }
}
