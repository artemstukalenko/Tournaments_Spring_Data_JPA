package com.artemstukalenko.tournaments.task.service.implementators;

import com.artemstukalenko.tournaments.task.repositories.UserRepository;
import com.artemstukalenko.tournaments.task.entity.User;
import com.artemstukalenko.tournaments.task.service.PlayerService;
import com.artemstukalenko.tournaments.task.service.TeamService;
import com.artemstukalenko.tournaments.task.service.TournamentService;
import com.artemstukalenko.tournaments.task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
@Transactional
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
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public boolean addOrUpdateUser(User userToAdd) {
        userRepository.save(userToAdd);
        return true;
    }

    @Override
    public boolean deleteUserById(int userId) {
        teamService.deleteTeamByUserId(userId);
        playerService.deletePlayerByUserId(userId);
        tournamentService.deleteTournamentByUserId(userId);

        userRepository.deleteById(userId);
        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public User findUserById(int userId) {
        Optional<User> foundUser = userRepository.findById(userId);
        return Optional.ofNullable(foundUser).get().orElse(new User());
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findUsersByUserRoleId(int userRoleId) {
        return userRepository.findUsersByUserRoleId(userRoleId);
    }
}
