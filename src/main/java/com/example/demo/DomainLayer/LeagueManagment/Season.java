package com.example.demo.DomainLayer.LeagueManagment;

import com.example.demo.DomainLayer.Enums.RefereeRoll;
import com.example.demo.DomainLayer.MyFactory;
import com.example.demo.DomainLayer.Users.Referee;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Season implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int season_id;

    private int year;

    @OneToMany
    @Column(name = "season_teams")
    private List<Team> teams_league; //represent teams position in table < 1, Real Madrid Id> < 2, Barcelona> etc'...

    @ElementCollection
    private List<Integer> team_scores;

    @OneToMany
    private Set<Referee> season_referees;

    @OneToMany (cascade = {CascadeType.ALL})
    @Column(name = "matches")
    private Set<Game> matches;

    @ManyToOne
    @JoinColumn(name = "league_id")
    private League league;

    @Transient
    private IGamePolicy IGamePolicy;
    @Transient
    private ScorePolicy scorePolicy;


    public void setAttributes(League league, int currentYear, IGamePolicy IGamePolicy, ScorePolicy scorePolicy){
        this.year = currentYear;
        this.teams_league = new ArrayList<>();
        this.IGamePolicy = IGamePolicy;
        this.scorePolicy = scorePolicy;
        this.season_referees = new HashSet<>();
        this.matches =new HashSet<>();
        this.team_scores = new ArrayList<>();
        setLeague(league);
    }


    /**
     * DB care required
     * @param teams
     * @return
     */
    public boolean initializeTeams(List<Team> teams){
        if( teams != null ){
            for(int i = 0 ; i < teams.size() ; i++){
                teams_league.add(teams.get(i));
                TeamBySeason teamBySeason = MyFactory.createTeamBySeason(teams.get(i), year );
            }
            return true;
        }
        return false;
    }

    public boolean activateGameSchedulePolicy(){
        if(teams_league != null && IGamePolicy != null ){
            IGamePolicy.activate(this);
            return true;
        }
        return false;
    }

    /*
    getters and setters.
     */
    public IGamePolicy getIGamePolicy() {
        return IGamePolicy;
    }


    public Set<Referee> getSeason_referees() {
        return season_referees;
    }

    public void setSeason_referees(Set<Referee> referees) {
        this.season_referees = referees;
    }

    public void setIGamePolicy(IGamePolicy IGamePolicy) { this.IGamePolicy = IGamePolicy; }

    public ScorePolicy getScorePolicy() {
        return scorePolicy;
    }

    public void setScorePolicy(ScorePolicy scorePolicy) {
        this.scorePolicy = scorePolicy;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setTeams_league(List<Team> teams_league) {
            this.teams_league = teams_league;
    }

    public List<Team> getTeams_league() {
        return teams_league;
    }

    public void setMatches(HashSet<Game> matches) {
            this.matches = matches;
    }

    public Set<Game> getMatches() {
        return matches;
    }

    public int getSeason_id() {
        return season_id;
    }

    public void setSeason_id(int season_id) {
        this.season_id = season_id;
    }

    public void setMatches(Set<Game> matches) {
        this.matches = new HashSet<>(matches);

        for(Game match : matches){
            match.setSeason(this);
        }

        //DBManagerStub.updateObject(this);
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public List<Integer> getTeam_scores() {
        return team_scores;
    }

    public void setTeam_scores(List<Integer> team_scores) {
        this.team_scores = team_scores;
    }

    public Set<Referee> getRefereesForMatch(){
        Set<Referee> toReturn = new HashSet<>();

        List<Referee> refereeList = new ArrayList<>(season_referees);

        int j = (int)(Math.random()*(season_referees.size()-1));
        int counterMainReferee=0;
        int counterLineReferee=0;
        for(int i=0 ; i<refereeList.size() ; i++){
            Referee referee;
            if(j<refereeList.size()){
                referee = refereeList.get(j);
            }
            else{
                referee = refereeList.get(j-refereeList.size());
            }
            if(referee.getRoll()== RefereeRoll.MAIN_REFEREE){
                if(counterMainReferee==0){
                    toReturn.add(referee);
                    counterMainReferee++;
                }
            }
            else if(referee.getRoll()== RefereeRoll.LINE_REFEREE){
                if(counterLineReferee<2){
                    toReturn.add(referee);
                    counterLineReferee++;
                }
            }
            if(counterMainReferee==1 && counterLineReferee==2){
                return  toReturn;
            }
            j++;
        }
        return toReturn;
    }
}
