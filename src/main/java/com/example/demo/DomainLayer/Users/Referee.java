package com.example.demo.DomainLayer.Users;

import com.example.demo.DomainLayer.Alerts.Alert;
import com.example.demo.DomainLayer.DBManager;
import com.example.demo.DomainLayer.Enums.Certification;
import com.example.demo.DomainLayer.Enums.EventType;
import com.example.demo.DomainLayer.Enums.MatchStatus;
import com.example.demo.DomainLayer.Enums.RefereeRoll;
import com.example.demo.DomainLayer.LeagueManagment.*;
import com.example.demo.DomainLayer.MyFactory;
import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


@Entity
public class Referee extends SystemUser implements Observer, Serializable {

    @Enumerated(EnumType.STRING)
    private RefereeRoll roll;

    @Enumerated(EnumType.STRING)
    private Certification certification;

    @ManyToMany( cascade = CascadeType.ALL)
    private Set<Game>matches;


    @OneToMany(cascade = CascadeType.ALL)
    private List<Alert> alerts;


    public Referee() {
        this.alerts = new LinkedList<>();
    }

    public void setAttributes(Certification certification, RefereeRoll refereeRoll, int sid){
        this.setSid(sid);
        this.setRoll(refereeRoll);
        this.certification = certification;
        matches = new HashSet<>();
        alerts = new ArrayList<>();
    }


//
//    public boolean startMatch(Match match){
//        if (match.getStatus() == MatchStatus.YET_TO_COME){
//            match.setStatus(MatchStatus.IN_PROGRESS);
//            current_match = match;
//            return true;
//        }
//        return false;
//    }


    /**
     * DB care required.
     * UC 10.2
     */
    public HashSet<String> showFutureGames(){
        if( matches != null ){
            HashSet<String> matchesData = new HashSet<>();
            for (Game match: matches) {
                matchesData.add(match.toString());
            }
            return matchesData;
        }
        return null;
    }


    /**
     * UC 10.3
     */
    public boolean addEventToMatch(int matchId, int minuteInGame, String description, EventType eventType){
        Game match = (Game) DBManager.getObject(Game.class,matchId);
        if( match !=null && matches!=null && minuteInGame > 0 && minuteInGame < 125 && !description.isEmpty() && eventType != null )
        {
            GameEvent newEvent = MyFactory.createEvent(minuteInGame,description,eventType);
            newEvent.setMatch(match);
            match.addEvent(newEvent);
            return true;
        }
        return false;
    }



    /**
     * UC 10.4 partA
     */
    public boolean editGameEvent(GameEvent event, int minuteInGame, String description, EventType eventType){
        if(event!=null && minuteInGame > 0 && minuteInGame < 125 && !description.isEmpty() && eventType != null){
            event.setDescription(description);
            event.setEvent_type(eventType);
            event.setMinute_in_game(minuteInGame);
            return true;
        }
        return false;
    }

    /**
     * UC 10.4 partB
     */
    public boolean createGameReport(int matchId , Team homeTeam, Team awayTeam, int homeGoals, int awayGoals){
        Game match = (Game) DBManager.getObject(Game.class,matchId);
        if (match != null && this.roll == RefereeRoll.MAIN_REFEREE && homeTeam!=null && awayTeam!=null && homeGoals>=0 && awayGoals>=0 && homeTeam != awayTeam){
            GameReport gameReport = MyFactory.createGameReport(homeTeam.getTid(),awayTeam.getTid(), homeGoals,awayGoals);
            match.setGameReport(gameReport);
            gameReport.setMatch(match);
            Season season = match.getSeason();
            if (homeGoals == awayGoals){
                season.getIScorePolicy().execute(season, true, homeTeam,awayTeam);
            }
            else {
                season.getIScorePolicy().execute(season, false, homeTeam,awayTeam);
            }
            return true;
        }
        return false;
    }


    /**
     * fan alerts handler for match events.
     * @param o - represent the notifying object Match.
     * @param arg - the relevant alert(GameDateChangedAlert).
     */
    @Override
    public void update(Observable o, Object arg) {
        if (o != null && arg != null){
            if (arg instanceof Alert &&  o instanceof Game){
                Game tempMatch = ((Game)o);
                    if (this.matches != null && matches.contains((tempMatch))){
                       handleAlert(((Alert) arg));
                    }
            }
        }
    }

    /**
     * require DB care.
     * @param alert
     */
    public void handleAlert(Alert alert){
        if (alert != null){
            this.alerts.add(alert);
            //DBManager.updateObject(this);
        }
    }

    /*
    getters and setters.
    */
    public Set<Game> getMatches() {
        return matches;
    }

    public void setMatches(HashSet<Game> matches) {
        if(matches!=null){
            this.matches = matches;
        }
    }

    public Certification getCertification() {
        return certification;
    }

    public boolean setCertification(Certification certification) {
        if(certification!=null){
            this.certification = certification;
            return true;
        }
        return false;
    }

    public void setAlerts(List<Alert> alerts) {
        this.alerts = alerts;
    }

    public List<Alert> getAlerts() {
        return alerts;
    }

    public RefereeRoll getRoll() {
        return roll;
    }

    public void setRoll(RefereeRoll roll) {
        this.roll = roll;
    }

    public void setMatches(Set<Game> matches) {
        this.matches = matches;
    }

    public Set<Game> getAllMatchesFromDB(){
        List<Object> objectLeague = DBManager.getListOfObjects(Game.class,"Matches");
        Set<Game> matches = new HashSet<>();
        for (Object o : objectLeague){
            matches.add(((Game) o));
        }
        return matches;
    }

    public boolean startMatch(Game m1){
        if(m1.getStatus()== MatchStatus.YET_TO_COME) {
            m1.setStatus(MatchStatus.IN_PROGRESS);
            return true;
        }
        return false;
    }
//
//    public boolean endMatch(Game m1){
//        if(m1.getStatus()==MatchStatus.IN_PROGRESS) {
//            m1.setStatus(MatchStatus.FINISHED);
//            return true;
//        }
//        return false;
//    }

    public void addGame(Game game){
//        Set<Game> newGames = new HashSet<>();
//        for (Game g :matches){
//            matches.add(g);
//        }
        matches.add(game);
//        setMatches(newGames);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Referee)) return false;
        if (!super.equals(o)) return false;
        Referee referee = (Referee) o;
        return getSid() == referee.getSid();
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(super.hashCode(), roll);
//    }
}

