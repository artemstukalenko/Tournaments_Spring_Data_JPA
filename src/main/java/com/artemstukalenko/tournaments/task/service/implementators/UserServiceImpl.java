package com.artemstukalenko.tournaments.task.service.implementators;

import com.artemstukalenko.tournaments.task.dao.UserDAO;
import com.artemstukalenko.tournaments.task.entity.User;
import com.artemstukalenko.tournaments.task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
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
