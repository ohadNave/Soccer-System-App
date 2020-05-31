package com.example.DB_Tests.DomainLayer.LeagueManagment;

public interface IScorePolicy {


    boolean execute(Season season, boolean tieScore, Team winnerTeam, Team loosingTeam);
    public String getDescription();

}
