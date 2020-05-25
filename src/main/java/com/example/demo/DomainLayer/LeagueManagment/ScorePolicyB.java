package com.example.demo.DomainLayer.LeagueManagment;

public class ScorePolicyB implements ScorePolicy{
    private String description;
    private int addToWinner;
    private int addToLooser;
    private int addIfNone;


    public ScorePolicyB(){
        description = "";
        addToWinner = 1;
        addToLooser = 0;
        addIfNone = 0;
        description = "Winner team get 1 point";

    }


    @Override
    public boolean execute(Season season, boolean tieScore, Team winnerTeam, Team loosingTeam) {
        return false;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
