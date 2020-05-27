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
                    Game game_home = MyFactory.createGame(generateDate(), generateHour(), homeTeam.getField().get(0),homeTeam,awayTeam,season.getRefereesForMatch());
                    Game game_away = MyFactory.createGame(generateDate(), generateHour(), awayTeam.getField().get(0),awayTeam,homeTeam,season.getRefereesForMatch());
                    game_home.setSeason(season);
                    game_away.setSeason(season);
                    matches.add(game_home);
                    matches.add(game_away);
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


    public LocalDate generateDate(){
        Random random = new Random();
        LocalDate localDate = LocalDate.of( Year.now().getValue() , random.nextInt(12 - 1 + 1) + 1,  random.nextInt(28 - 1 + 1) + 1 );
        return  localDate;
    }

    public LocalTime generateHour(){
        Random random = new Random();
        LocalTime localTime = LocalTime.of(random.nextInt(12 - 9 + 1) + 9,0);
        return  localTime;
    }


}
