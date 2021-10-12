package com.artemstukalenko.tournaments.task.repositories;

import com.artemstukalenko.tournaments.task.entity.TeamPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamPlayerRepository extends JpaRepository<TeamPlayer, Integer> {

    @Modifying
    @Query(value = "delete from team_players where team_id = :value", nativeQuery = true)
    void deleteTeamPlayerByTeamId(@Param("value") Integer teamToDeleteId);

    @Modifying
    @Query(value = "delete from team_players where player_id = :value", nativeQuery = true)
    void deleteTeamPlayerByPlayerId(@Param("value") Integer playerToDeleteId);
}
