package com.artemstukalenko.tournaments.task.repositories;

import com.artemstukalenko.tournaments.task.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

}
