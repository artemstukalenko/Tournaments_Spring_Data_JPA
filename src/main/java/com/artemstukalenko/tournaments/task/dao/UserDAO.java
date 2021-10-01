package com.artemstukalenko.tournaments.task.dao;

import com.artemstukalenko.tournaments.task.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {

    List<User> getAllUsers();

    boolean addNewUser(User userToAdd);

    boolean deleteUserById(int userId);

    User findUserById(int userId);

    boolean updateUser(int userToUpdateId, User updatedUserObject);

    List<User> findUsersByUserRoleId(int userRoleId);
}
