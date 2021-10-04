package com.artemstukalenko.tournaments.task.service;

import com.artemstukalenko.tournaments.task.entity.UserRole;

import java.util.List;

public interface UserRoleService {

    public List<UserRole> getAllUserRoles();

    UserRole findRoleById(int roleId);

    boolean addOrUpdateRole(UserRole roleToAdd);

    boolean deleteRoleById(int roleId);
}
