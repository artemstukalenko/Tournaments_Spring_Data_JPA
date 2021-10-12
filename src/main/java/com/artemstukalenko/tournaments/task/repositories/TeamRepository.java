package com.artemstukalenko.tournaments.task.repositories;

import com.artemstukalenko.tournaments.task.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {

    @Query(value = "select * from teams where user_id = :id", nativeQuery = true)
    List<Team> findTeamsByUserId(@Param("id") Integer userId);
}
