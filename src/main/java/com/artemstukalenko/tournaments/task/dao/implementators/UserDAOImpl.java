package com.artemstukalenko.tournaments.task.dao.implementators;

import com.artemstukalenko.tournaments.task.dao.EntityDAO;
import com.artemstukalenko.tournaments.task.dao.UserDAO;
import com.artemstukalenko.tournaments.task.entity.User;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDAOImpl extends EntityDAO implements UserDAO {

    @Override
    @Transactional
    public List<User> getAllUsers() {
        List<User> allUsers;

        initializeSession();
        allUsers = session.createQuery("from User", User.class).getResultList();

        return allUsers;
    }

    @Override
    @Transactional
    public boolean addOrUpdateUser(User userToAdd) {

        initializeSession();
        session.saveOrUpdate(userToAdd);

        return true;
    }

    @Override
    @Transactional
    public boolean deleteUserById(int userId) {

        initializeSession();
        Query<User> queryForDeletingUserById = session.createQuery("delete from User " +
                "where userId = :idToDelete");
        queryForDeletingUserById.setParameter("idToDelete", userId);
        queryForDeletingUserById.executeUpdate();

        return true;
    }

    @Override
    @Transactional
    public User findUserById(int userId) {
        User soughtUser;

        initializeSession();
        soughtUser = session.get(User.class, userId);

        return soughtUser;
    }

    @Override
    @Transactional
    public List<User> findUsersByUserRoleId(int userRoleId) {
        List<User> soughtUsers;

        initializeSession();
        String selectionQuery = "from User where userRole.id = :id";
        Query<User> queryForFindingUserByRoleId = session.createQuery(selectionQuery)
                .setParameter("id", userRoleId);

        soughtUsers = queryForFindingUserByRoleId.getResultList();

        return soughtUsers;
    }
}
