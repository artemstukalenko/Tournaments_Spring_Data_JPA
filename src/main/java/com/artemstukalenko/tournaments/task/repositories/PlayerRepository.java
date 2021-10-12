package com.artemstukalenko.tournaments.task.repositories;

import com.artemstukalenko.tournaments.task.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

    @Query(value = "select * from players where user_id = :id", nativeQuery = true)
    List<Player> findPlayersByUserId(@Param("id") Integer userId);
}
