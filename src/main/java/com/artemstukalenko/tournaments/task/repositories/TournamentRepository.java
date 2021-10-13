package com.artemstukalenko.tournaments.task.repositories;

import com.artemstukalenko.tournaments.task.entity.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Integer> {

    @Modifying
    @Query(value = "delete from tournaments where user_id = :id", nativeQuery = true)
    void deleteTournamentByUserId(@Param("id") Integer userId);

    @Query(value = "select * from tournaments where user_id = :id", nativeQuery = true)
    List<Tournament> findTournamentsByUserId(@Param("id") int userId);
}
