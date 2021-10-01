package com.artemstukalenko.tournaments.task.dao.implementators;

import com.artemstukalenko.tournaments.task.dao.EntityDAO;
import com.artemstukalenko.tournaments.task.dao.UserDAO;
import com.artemstukalenko.tournaments.task.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.SQLException;
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
    public boolean addNewUser(User userToAdd) {
        return false;
    }

    @Override
    public boolean deleteUserById(int userId) {
        return false;
    }

    @Override
    public User findUserById(int userId) {
        return null;
    }

    @Override
    public boolean updateUser(int userToUpdateId, User updatedUserObject) {
        return false;
    }

    @Override
    public List<User> findUsersByUserRoleId(int userRoleId) {
        return null;
    }
}
