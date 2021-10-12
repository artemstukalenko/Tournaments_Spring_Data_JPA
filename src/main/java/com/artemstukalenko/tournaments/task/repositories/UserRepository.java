package com.artemstukalenko.tournaments.task.repositories;

import com.artemstukalenko.tournaments.task.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "select * from users where role_id = :id", nativeQuery = true)
    List<User> findUsersByUserRoleId(@Param("id") Integer userRoleId);
}
