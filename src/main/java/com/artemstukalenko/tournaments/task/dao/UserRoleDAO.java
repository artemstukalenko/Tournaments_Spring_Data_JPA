package com.artemstukalenko.tournaments.task.dao;

import com.artemstukalenko.tournaments.task.entity.UserRole;

import java.sql.SQLException;
import java.util.List;

public interface UserRoleDAO {

    List<UserRole> getAllUserRoles();

    UserRole findRoleById(int roleId);

    boolean addOrUpdateRole(UserRole roleToAdd);

    boolean deleteRoleById(int roleId);
}
