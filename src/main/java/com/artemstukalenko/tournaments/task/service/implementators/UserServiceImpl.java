package com.artemstukalenko.tournaments.task.service.implementators;

import com.artemstukalenko.tournaments.task.repositories.UserRepository;
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
    private UserRepository userRepository;

    @Autowired
    private TournamentService tournamentService;

    @Autowired
    private TeamService teamService;

    @Autowired
    private PlayerService playerService;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public boolean addOrUpdateUser(User userToAdd) {
        userRepository.save(userToAdd);
        return true;
    }

    @Override
    @Transactional
    public boolean deleteUserById(int userId) {
        teamService.deleteTeamByUserId(userId);
        playerService.deletePlayerByUserId(userId);
        tournamentService.deleteTournamentByUserId(userId);

        userRepository.deleteById(userId);
        return true;
    }

    @Override
    public User findUserById(int userId) {
        return userRepository.getById(userId);
    }

    @Override
    public List<User> findUsersByUserRoleId(int userRoleId) {
        return userRepository.findUsersByUserRoleId(userRoleId);
    }
}
