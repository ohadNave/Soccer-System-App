package com.example.demo.DomainLayer.LeagueManagment;

import com.example.demo.DomainLayer.DBManager;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "gamereport")
public class GameReport implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long gr_id;

    private int winner_team_id;

    private int losing_team_id;

    private int winner_goals;

    private int loser_goals;

    @OneToOne
    private Game match;


    public void setAttributes(int winnerTeam, int losingTeam, int winnerGoals, int loserGoals){
        this.winner_team_id = winnerTeam;
        this.losing_team_id = losingTeam;
        this.winner_goals = winnerGoals;
        this.loser_goals = loserGoals;
    }

    /*
    getters and setters.
     */
    public Team getWinnerTeam() {
        return (Team) DBManager.getObject(Team.class, winner_team_id);
    }

    public void setWinnerTeam(int winnerTeam) {
        this.winner_team_id = winnerTeam;
        DBManager.updateObject(this);
    }

    public Team getLosingTeam() {
        return (Team) DBManager.getObject(Team.class, losing_team_id);
    }

    public void setLosingTeam(int losingTeam) {
        this.losing_team_id = losingTeam;
        DBManager.updateObject(this);

    }

    public int getWinner_goals() {
        return winner_goals;
    }

    public void setWinner_goals(int winner_goals) {
        this.winner_goals = winner_goals;
        DBManager.updateObject(this);

    }

    public int getLoser_goals() {
        return loser_goals;
    }

    public void setLoser_goals(int loser_goals) {
        this.loser_goals = loser_goals;
        DBManager.updateObject(this);

    }

    public long getGr_id() {
        return gr_id;
    }

    public void setGr_id(long gr_id) {
        this.gr_id = gr_id;
        DBManager.updateObject(this);

    }

    public int getWinner_team_id() {
        return winner_team_id;
    }

    public void setWinner_team_id(int winner_team_id)
    {
        this.winner_team_id = winner_team_id;
        DBManager.updateObject(this);

    }

    public int getLosing_team_id() {
        return losing_team_id;
    }

    public void setLosing_team_id(int losing_team_id) {
        this.losing_team_id = losing_team_id;
        DBManager.updateObject(this);

    }

    @Override
    public String toString() {
        return null;
//                ", home=" + tid_home +
//                ", away=" + tid_away +
//                '}';
    }

    public Game getMatch() {
        return match;
    }

    public void setMatch(Game match) {
        this.match = match;
        DBManager.updateObject(this);

    }
}
