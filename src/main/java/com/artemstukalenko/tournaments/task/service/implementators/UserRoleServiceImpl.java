package com.artemstukalenko.tournaments.task.service.implementators;

import com.artemstukalenko.tournaments.task.repositories.UserRoleRepository;
import com.artemstukalenko.tournaments.task.entity.User;
import com.artemstukalenko.tournaments.task.entity.UserRole;
import com.artemstukalenko.tournaments.task.service.UserRoleService;
import com.artemstukalenko.tournaments.task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private UserService userService;

    @Override
    public List<UserRole> getAllUserRoles() {
        return userRoleRepository.findAll();
    }

    @Override
    public UserRole findRoleById(int roleId) {
        return userRoleRepository.getById(roleId);
    }

    @Override
    @Transactional
    public boolean addOrUpdateRole(UserRole roleToAdd) {
        userRoleRepository.save(roleToAdd);
        return true;
    }

    @Override
    @Transactional
    public boolean deleteRoleById(int roleId) {

        List<User> usersWithThatRole = userService.findUsersByUserRoleId(roleId);

        for (User user : usersWithThatRole) {
            userService.deleteUserById(user.getUserId());
        }

        userRoleRepository.deleteById(roleId);
        return true;
    }

}
