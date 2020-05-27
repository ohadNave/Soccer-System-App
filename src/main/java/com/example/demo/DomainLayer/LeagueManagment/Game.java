package com.example.demo.DomainLayer.LeagueManagment;

import com.example.demo.DomainLayer.Alerts.Alert;
import com.example.demo.DomainLayer.Alerts.GameEventAlert;
import com.example.demo.DomainLayer.Alerts.I_Observer.ISubjectMatch;
import com.example.demo.DomainLayer.Alerts.MatchDateChangedAlert;
import com.example.demo.DomainLayer.Alerts.MatchEndedAlert;
import com.example.demo.DomainLayer.DBManager;
import com.example.demo.DomainLayer.Enums.MatchStatus;
import com.example.demo.DomainLayer.MyFactory;
import com.example.demo.DomainLayer.Users.Fan;
import com.example.demo.DomainLayer.Users.Referee;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

@Entity
public class Game extends Observable implements ISubjectMatch, Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private MatchStatus status;

    private LocalDate date;

    private LocalTime hour;

    @OneToOne (cascade = {CascadeType.ALL})
    private Field field;

    @ManyToMany (cascade = {CascadeType.ALL})
    private Set<Referee> referee;

    @OneToMany (cascade = {CascadeType.ALL})
    private Set<GameEvent> game_events;

    @OneToOne(cascade = CascadeType.ALL)
    private GameReport game_report;

    @OneToMany (cascade = {CascadeType.ALL})
    private Set<Fan> match_followers;

    @OneToOne
    private Season season; // maybe will deleted.

    private int team_home_id;

    private int team_away_id;


    public void setAttributes(LocalDate date, LocalTime hour, Field field, int home_id, int away_id, Set<Referee> referees){
        this.status =  MatchStatus.YET_TO_COME ;
        this.date = date;
        this.hour = hour;
        this.field = field;
        this.match_followers = new HashSet<>();
        this.game_events =new HashSet<>();
        this.referee = referees;
        this.team_home_id = home_id;
        this.team_away_id = away_id;
        for(Referee r : referee){
            r.addGame(this);
        }
    }



    /**
     * UC 10.3
     * has to add timer*****
     */
    public boolean addEvent(GameEvent event){
        if(event != null && game_events != null ){
            game_events.add(event);
            GameEventAlert gameEventAlert = MyFactory.createGameEventAlert(event.getMinute_in_game(),event);
            notifyMatchFollowers(gameEventAlert);
           // DBManager.updateObject(event);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "com.example.d7emo.DomainLayer.LeagueManagment.Match{" +
                "date=" + date +
                ", hour=" + hour +
                ", field=" + field +
                ", home=" + team_home_id +
                ", away=" + team_away_id +
                '}';
    }

    public boolean setGameReport(GameReport gameReport) {
        if (gameReport != null){
            this.game_report = gameReport;
            endMatch(this.game_report);
            return true;
        }
        return false;
    }




    /**
     * Used in case of this match date has been changed.
     * Notifies referees and match followers.
     */
    public void changeMatchDate(LocalDate newDate){
        if (newDate != null){
            this.date = newDate;
            MatchDateChangedAlert matchDateChangedAlert = MyFactory.createMatchDateChangedAlert(newDate);
            notifyReferees(matchDateChangedAlert);
            notifyMatchFollowers(matchDateChangedAlert);
        }
    }


    /**
     * In case that a match has ended, change match status to finished and notify the match fans followers.
     * Creates new game report.
     * * Notifies match followers.
     */
    public boolean endMatch(GameReport gameReport){
        if (status == MatchStatus.IN_PROGRESS ){
            this.status = MatchStatus.FINISHED;
            MatchEndedAlert matchHasEndedAlert = MyFactory.createMatchEndedAlert(gameReport);
            notifyMatchFollowers(matchHasEndedAlert);
            return true;
        }
        return false;
    }

    /**
     * @param newAlert - MatchDateChangedAlert.
     */
    @Override
    public void notifyReferees(Alert newAlert) {
        for (Referee r : referee){
//            DBManager.detachObject(r);
            r.update(this,newAlert);
        }
    }

    /**
     * DB care required.
     * @param newAlert - GameEventAlert/MatchHasEndedAlert.
     */
    @Override
    public void notifyMatchFollowers(Alert newAlert) {
        for (Fan fan : match_followers){
            fan.update(this,newAlert);
        }
    }

    public Team getTeamFromDB(int tid){
        return ((Team) DBManager.getObject(Team.class, tid));
    }

    /*
    getters and setters.
     */

    public void addMatchFollower(Fan matchFollower){
        this.match_followers.add(matchFollower);
        DBManager.updateObject(this);
    }

    public void deleteMatchFollower(int matchFollower){
        this.match_followers.remove(matchFollower);
        DBManager.updateObject(this);

    }

    public MatchStatus getStatus() {
        return status;
    }

    public void setStatus(MatchStatus matchStatus) {
        this.status = matchStatus;
        //DBManagerStub.updateObject(this);
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
        DBManager.updateObject(this);

    }

    public LocalTime getHour() {
        return hour;
    }

    public void setHour(LocalTime hour) {
        this.hour = hour;
        DBManager.updateObject(this);

    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
        DBManager.updateObject(this);
    }

    public Set<GameEvent> getGame_events() {
        return game_events;
    }

    public void setGame_events(Set<GameEvent> game_events) {
        this.game_events = game_events;
        DBManager.updateObject(this);
    }


    public GameReport getGame_report() {
        return game_report;
    }

    public  Set<Fan> getMatch_followers(){ return match_followers;}

    public int getId() {
        return id;
    }

    public void setId(int matchId) {
        this.id = matchId;
        DBManager.updateObject(this);
    }

    public Set<Referee> getReferee() {
        return referee;
    }

    public void setReferee(Set<Referee> referees) {
        for(Referee r : referees){
            r.getMatches().add(this);
        }
        this.referee = referees;
    }

    public void setMatch_followers(HashSet<Fan> match_followers) {
        this.match_followers = match_followers;
        DBManager.updateObject(this);
    }

    public void setGameEvents(Set<GameEvent> gameEvents) {
        this.game_events = gameEvents;
        DBManager.updateObject(this);
    }

    public void setMatchFollowers(Set<Fan> matchFollowers) {
        this.match_followers = matchFollowers;
        for(Fan f : matchFollowers){
            f.getFollowingMatches().add(this);
        }
        DBManager.updateObject(this);
    }

    public int getTeam_home_id() {
        return team_home_id;
    }

    public void setTeam_home_id(int home_tid) {
        this.team_home_id = home_tid;
        DBManager.updateObject(this);

    }

    public int getTeam_away_id() {
        return team_away_id;
    }

    public void setTeam_away_id(int away_tid) {
        this.team_away_id = away_tid;
        DBManager.updateObject(this);

    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
        DBManager.updateObject(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Game)) return false;
        Game game = (Game) o;
        return id == game.id;
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }
}
