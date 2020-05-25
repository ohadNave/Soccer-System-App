package com.example.demo.DomainLayer.LeagueManagment;


import com.example.demo.DomainLayer.MyFactory;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Year;
import java.util.*;

public class GamePolicy implements IGamePolicy {
    private String description;

    public GamePolicy(){
        description = "Each team play against all the other teams twice, one time at home and ont time away";

    }
    @Override
    public boolean activate(Season season) {
        if(season != null){
            Set<Game> matches = new HashSet<>();
            List<Team> seasonTeams = season.getTeams_league();
            for(int i = 0 ; i < seasonTeams.size() - 1 ; i++){
                for(int j = i + 1 ; j<seasonTeams.size(); j++){
                    Team homeTeam = seasonTeams.get(i);
                    Team awayTeam = seasonTeams.get(j);
                    LocalDate localDate1= LocalDate.of( Year.now().getValue() , (int)(Math.random() * 12),  (int)(Math.random() * 28) );
                    LocalDate localDate2= LocalDate.of( Year.now().getValue() , (int)(Math.random() * 12),  (int)(Math.random() * 28) );
                    LocalTime localTime = LocalTime.of(12+(int)(Math.random()*9),0);
                    Game match = MyFactory.createMatch(localDate1, localTime, homeTeam.getField().get(0),homeTeam,awayTeam,null);
                    LocalTime localTime2 = LocalTime.of(12+(int)(Math.random()*9),0);
                    Game match2 = MyFactory.createMatch(localDate2, localTime2, awayTeam.getField().get(0),awayTeam,homeTeam,null );
                    match.setSeason(season);
                    match2.setSeason(season);
                    matches.add(match);
                    matches.add(match2);
                }
            }
            season.setMatches(matches);

            return true;
        }
        return false;
    }

    @Override
    public String getDescription() {
        return description;
    }

}
