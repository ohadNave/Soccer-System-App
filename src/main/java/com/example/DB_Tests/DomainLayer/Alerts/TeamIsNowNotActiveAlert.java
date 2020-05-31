package com.example.DB_Tests.DomainLayer.Alerts;

import com.example.DB_Tests.DomainLayer.LeagueManagment.Team;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class TeamIsNowNotActiveAlert extends Alert{

    @OneToOne
    private Team team;

    public TeamIsNowNotActiveAlert() { }

    public void setAttributes(Team team) {
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Team " + team.getName() + " is now not active";
    }
}
