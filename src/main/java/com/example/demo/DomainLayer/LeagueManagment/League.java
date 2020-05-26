package com.example.demo.DomainLayer.LeagueManagment;

import com.example.demo.DomainLayer.DBManager;
import com.example.demo.DomainLayer.Enums.LeagueLevel;
import com.example.demo.DomainLayer.MyFactory;
import com.example.demo.DomainLayer.Users.Referee;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Year;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class League implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int lid;

    private String name;

    private int current_year;

    @Enumerated(EnumType.STRING)
    private LeagueLevel league_level;

    @OneToMany (cascade = {CascadeType.ALL})
    @Column(name = "season")
    private Set<Season> seasons;


    public void setAttributes(LeagueLevel level, String name, IGamePolicy IGamePolicy, ScorePolicy scorePolicy){
        this.league_level = level;
        this.name = name;
        this.current_year = Year.now().getValue();
        seasons = new HashSet<>();
    }

    public boolean setScorePolicyForSeason(Integer year, ScorePolicy scorePolicy){

        for(Season s : seasons){
            if(s.getYear()==year){
                s.setScorePolicy(scorePolicy);
                return true;
            }
        }
//        if(DBManagerStub.getSeason(lid,year)!=null && scorePolicy!=null){
//            Season season = DBManagerStub.getSeason(lid,year);
//            season.setScorePolicy(scorePolicy);
//            DBManagerStub.addSeason(lid,year,season);
//            return true;
//        }
        return false;
    }

    public boolean setSeasonSchedulerPolicy(Integer year, IGamePolicy IGamePolicy){
        for(Season s : seasons){
            if(s.getYear()==year){
                s.setIGamePolicy(IGamePolicy);
                return true;
            }
        }
//        if(DBManagerStub.getSeason(lid,year) != null && gameSchedulerPolicy != null){
//            Season season = DBManagerStub.getSeason(lid,year);
//            season.setGameSchedulerPolicy(gameSchedulerPolicy);
//            DBManagerStub.addSeason(lid,year,season);
//            return true;
//        }

        return false;
    }

    public boolean activateGameSchedulePolicyForSeason(int year){
        for(Season s : seasons){
            if(s.getYear()==year){
                return s.activateGameSchedulePolicy();
            }
        }
//        if(DBManagerStub.getSeason(lid,year)!=null){
//            Season season = DBManagerStub.getSeason(lid,year);
//            season.activateGameSchedulePolicy();
//            DBManagerStub.addSeason(lid,year,season);
//            return true;
//        }
        return false;
    }

    private boolean startSeason(List<Team> teams, IGamePolicy IGamePolicy, ScorePolicy scorePolicy){
        if(teams != null){
            Season season = MyFactory.createSeason(this, current_year, IGamePolicy, scorePolicy);
            season.initializeTeams(teams);
            seasons.add(season);
            return true;
        }
        return false;
    }

    public boolean setMainRefereesForSeason(int year, Set<Referee> referees){
        if(seasons.contains(year) && referees!=null){
//            Season season = DBManagerStub.getSeason(lid,year);
//            season.setSeasonReferees(referees);
//            DBManagerStub.addSeason(lid,year,season);
            return true;
        }
        return false;
    }




    public boolean startNewSeason(int year , List<Team> teams, IGamePolicy IGamePolicy, ScorePolicy scorePolicy){
        if( year <= 0){
            return false;
        }
        else{
            current_year = year;
            return startSeason(teams, IGamePolicy, scorePolicy);
        }
    }


    /*
    getters and setters.
     */
    public LeagueLevel getLeague_level() {
        return league_level;
    }

    public void setLeague_level(LeagueLevel leagueLevel) {
        if(leagueLevel!=null) {
            this.league_level = leagueLevel;
            DBManager.updateObject(this);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name!=null && !name.isEmpty()){
            this.name = name;
            DBManager.updateObject(this);
        }
    }

    public int getLid() {
        return lid;
    }

    public Set<Season> getSeasons() {
        return seasons;
    }

    public void setLid(int lid) {
        this.lid = lid;
        DBManager.updateObject(this);

    }

    public int getCurrent_year() {
        return current_year;
    }

    public void setCurrent_year(int currentYear) {
        this.current_year = currentYear;
        DBManager.updateObject(this);

    }

    public void setSeasons(Set<Season> seasons) {
        this.seasons = seasons;
        for(Season s : seasons){
            s.setLeague(this);
        }
        DBManager.updateObject(this);
    }


}
