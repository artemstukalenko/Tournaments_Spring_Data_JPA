package com.artemstukalenko.tournaments.task.service.implementators;

import com.artemstukalenko.tournaments.task.dao.UserRoleDAO;
import com.artemstukalenko.tournaments.task.entity.UserRole;
import com.artemstukalenko.tournaments.task.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleDAO userRoleDAO;

    @Override
    public List<UserRole> getAllUserRoles() {
        return userRoleDAO.getAllUserRoles();
    }

    @Override
    public UserRole findRoleById(int roleId) {
        return null;
    }

    @Override
    public boolean addNewRole(UserRole roleToAdd) {
        return false;
    }

    @Override
    public boolean deleteRoleById(int roleId) {
        return false;
    }

    @Override
    public boolean updateRole(int roleToUpdate, UserRole updatedRole) {
        return false;
    }
}
