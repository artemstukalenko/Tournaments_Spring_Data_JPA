package com.artemstukalenko.tournaments.task.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tournaments")
public class Tournament extends AppEntity {

    @Id
    @Column(name = "tournament_id")
    private int tournamentId;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "tournament_name")
    private String tournamentName;
    @Column(name = "venue")
    private String venue;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;

    public Tournament(int tournamentId, User user, String tournamentName, String venue, LocalDate startDate, LocalDate endDate) {
        this.tournamentId = tournamentId;
        this.user = user;
        this.tournamentName = tournamentName;
        this.venue = venue;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Tournament(User user, String tournamentName, String venue, LocalDate startDate, LocalDate endDate) {
        this.user = user;
        this.tournamentName = tournamentName;
        this.venue = venue;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Tournament() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tournament that = (Tournament) o;
        return tournamentId == that.tournamentId && Objects.equals(user, that.user) && Objects.equals(tournamentName, that.tournamentName) && Objects.equals(venue, that.venue) && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tournamentId, user, tournamentName, venue, startDate, endDate);
    }

    @Override
    public String toString() {
        return "Tournament{" +
                "tournamentId=" + tournamentId +
                ", user=" + user +
                ", tournamentName='" + tournamentName + '\'' +
                ", venue='" + venue + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }

    public int getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(int tournamentId) {
        this.tournamentId = tournamentId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
