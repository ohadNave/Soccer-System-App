package com.example.demo.ServiceLayer;



import com.example.demo.DomainLayer.Alerts.Alert;
import com.example.demo.DomainLayer.DBManager;
import com.example.demo.DomainLayer.Enums.EventType;
import com.example.demo.DomainLayer.Enums.RefereeRoll;
import com.example.demo.DomainLayer.LeagueManagment.Game;
import com.example.demo.DomainLayer.LeagueManagment.Team;
import com.example.demo.DomainLayer.Users.Referee;
import com.example.demo.DomainLayer.Users.Subscriber;

import java.util.*;

public class RefereeController {

    public Queue<String> getAlerts(String sid){
        Queue<String> alertsToReturn = new ArrayDeque<>();
        int sidInt= -1;

        try{
            sidInt = Integer.parseInt(sid);
        }
        catch (Exception e){
            return null;
        }
        Subscriber subscriber = (Subscriber) DBManager.getObject(Subscriber.class,sidInt);
        if(subscriber == null){
            return null;
        }

        if(subscriber.getReferee()==null){
            return null;
        }
        for(Alert a : subscriber.getReferee().getAlerts()){
            alertsToReturn.add(a.toString());
        }
        return alertsToReturn;
    }

    public boolean addEvent(String sid, String matchId, String minuteInGame, String description, String eventType){
        int matchInt=-1;
        int minuteInGameInt=-1;
        int sidInt=-1;
        try{
            matchInt=Integer.parseInt(matchId);
            minuteInGameInt=Integer.parseInt(minuteInGame);
            sidInt = Integer.parseInt(sid);
        }
        catch (Exception e){
            return false;
        }
        Subscriber subscriber = (Subscriber) DBManager.getObject(Subscriber.class,sidInt);
        if(subscriber==null){
            return false;
        }
        Referee lineReferee = subscriber.getReferee();
        if( lineReferee ==null){
            return false;
        }
        EventType event ;
        if(eventType.equals("RedCard")){
            event=EventType.RedCard;
        }
        else if(eventType.equals("YellowCard")){
            event=EventType.YellowCard;
        }
        else if(eventType.equals("Offside")){
            event= EventType.Offside;
        }
        else if(eventType.equals("Goal")){
            event=EventType.Goal;
        }
        else if(eventType.equals("FOUL")){
            event=EventType.FOUL;
        }
        else if(eventType.equals("Injury")){
            event=EventType.Injury;
        }
        else if(eventType.equals("Substitotion")){
            event=EventType.Substitotion;
        }
        else{
            return false;
        }
        return lineReferee.addEventToMatch(matchInt,minuteInGameInt,description,event);
    }

    public String [] getListOfGames(String sid){
        int intSid = -1;
        try{
            intSid = Integer.parseInt(sid);
        }
        catch (Exception e){
            return null;
        }
        Subscriber subscriber = (Subscriber) DBManager.getObject(Subscriber.class,intSid);
        if(subscriber == null){
            return null;
        }
        Referee lineReferee = subscriber.getReferee();
        if(lineReferee == null){
            return null;
        }
        Set<Game> matches = lineReferee.getMatches();
        String[] toReturn = new String[matches.size()*2];
        int i=0;
        for(Game game : matches){
            toReturn[i]=game.getDate().toString();
            toReturn[i+1]=""+game.getId();
            i=i+2;
        }

        return toReturn;
    }

    public String[] getTeamsNames(String mid){
        String[] toReturn = new String[4];
        toReturn[0]="not found";
        toReturn[1] = "not found";
        int midInt =-1;
        try{
            midInt = Integer.parseInt(mid);
        }
        catch (Exception e){
            return toReturn;
        }
        Game game = (Game) DBManager.getObject(Game.class,midInt);
        if(game == null){
            return toReturn;
        }
        Team team1 = (Team) DBManager.getObject(Team.class,game.getTeam_home_id());
        Team team2 = (Team) DBManager.getObject(Team.class,game.getTeam_away_id());
        if(team1 == null || team2 == null){
            return toReturn;
        }
        toReturn[0] = team1.getName();
        toReturn[1] = team2.getName();
        toReturn[2] = ""+team1.getTid();
        toReturn[3] = ""+team2.getTid();
        return toReturn;
    }

    public boolean makeReport(String sid, String mid ,String home_id, String away_id , String winnerGoals , String looserGoals){
        int sidInt=-1;
        int midInt=-1;
        int homeGoals=-1;
        int awayGoals=-1;
        int homeInt=-1;
        int awayInt=-1;
        try{
            sidInt = Integer.parseInt(sid);
            midInt = Integer.parseInt(mid);
            homeGoals = Integer.parseInt(winnerGoals);
            awayGoals = Integer.parseInt(looserGoals);
            homeInt=Integer.parseInt(home_id);
            awayInt=Integer.parseInt(away_id);
        }
        catch (Exception e){
            return false;
        }
        Subscriber subscriber = (Subscriber) DBManager.getObject(Subscriber.class,sidInt);
        if(subscriber == null){
            return false;
        }
        Referee mainReferee = subscriber.getReferee();
        if(mainReferee != null && mainReferee.getRoll() == RefereeRoll.MAIN_REFEREE){
            Team homeTeam = (Team) DBManager.getObject(Team.class,homeInt);
            Team awayTeam = (Team) DBManager.getObject(Team.class,awayInt);
            if(awayTeam != null || homeTeam != null){
                return mainReferee.createGameReport(midInt,homeTeam,awayTeam,homeGoals,awayGoals);
            }
        }
        return false;
    }
}
