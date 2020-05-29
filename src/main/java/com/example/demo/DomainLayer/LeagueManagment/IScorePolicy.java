package com.example.demo.DomainLayer.LeagueManagment;

import java.util.ArrayList;
import java.util.List;

public interface IScorePolicy {


    boolean execute(Season season, boolean tieScore, Team winnerTeam, Team loosingTeam);
    public String getDescription();

}
