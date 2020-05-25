package com.example.demo.DomainLayer.LeagueManagment;

public interface ScorePolicy {

    boolean execute(Season season, boolean tieScore, Team winnerTeam, Team loosingTeam);
    public String getDescription();

}
