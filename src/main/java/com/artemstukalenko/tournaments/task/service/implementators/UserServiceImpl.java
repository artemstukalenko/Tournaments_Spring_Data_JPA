package com.artemstukalenko.tournaments.task.service.implementators;

import com.artemstukalenko.tournaments.task.dao.PlayerDAO;
import com.artemstukalenko.tournaments.task.dao.TeamDAO;
import com.artemstukalenko.tournaments.task.dao.TournamentDAO;
import com.artemstukalenko.tournaments.task.dao.UserDAO;
import com.artemstukalenko.tournaments.task.entity.User;
import com.artemstukalenko.tournaments.task.service.PlayerService;
import com.artemstukalenko.tournaments.task.service.TeamService;
import com.artemstukalenko.tournaments.task.service.TournamentService;
import com.artemstukalenko.tournaments.task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private TournamentService tournamentService;

    @Autowired
    private TeamService teamService;

    @Autowired
    private PlayerService playerService;

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public boolean addOrUpdateUser(User userToAdd) {
        return userDAO.addOrUpdateUser(userToAdd);
    }

    @Override
    @Transactional
    public boolean deleteUserById(int userId) {
        teamService.deleteTeamByUserId(userId);
        playerService.deletePlayerByUserId(userId);
        tournamentService.deleteTournamentByUserId(userId);

        return userDAO.deleteUserById(userId);
    }

    @Override
    public User findUserById(int userId) {
        return userDAO.findUserById(userId);
    }

    @Override
    public List<User> findUsersByUserRoleId(int userRoleId) {
        return userDAO.findUsersByUserRoleId(userRoleId);
    }
}
