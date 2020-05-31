package com.example.DB_Tests.ServiceLayer;


import com.example.DB_Tests.DomainLayer.DBManager;
import com.example.DB_Tests.DomainLayer.LeagueManagment.*;
import com.example.DB_Tests.DomainLayer.Request.RegistrationRequest;
import com.example.DB_Tests.DomainLayer.Request.TeamRequest;
import com.example.DB_Tests.DomainLayer.Users.FAR;
import com.example.DB_Tests.DomainLayer.Users.Subscriber;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FARController {

    public FARController(){

    }

    public String[] getLeagues(){

        List<Object> leaguesId = DBManager.getListOfObjects(League.class,"League");
        String[] toReturn = new String[leaguesId.size()*2];
        int i=0;
        for(Object l: leaguesId){
            toReturn[i] = ((League) l).getName();
            toReturn[i+1] = ""+((League) l).getLid();
            i=i+2;
        }
        return toReturn;
    }


    public boolean setLeagueGameSchedulerPolicy(String sid , String leagueId, String gameSchedulerPolicy){

        int sidInt = -1;
        int leagueIdInt = -1;
        try{
            sidInt=Integer.parseInt(sid);
            leagueIdInt=Integer.parseInt(leagueId);
        }
        catch (Exception e){
            return false;
        }
        FAR far = (FAR) DBManager.getObject(FAR.class,sidInt);
        if(far == null){
            return false;
        }
        return far.setLeagueGameSchedulerPolicy(leagueIdInt,new GamePolicy());
    }

    public boolean activeGameSchedulerPolicy(String sid , String leagueId){

        int sidInt = -1;
        int leagueIdInt = -1;
        try{
            sidInt=Integer.parseInt(sid);
            leagueIdInt=Integer.parseInt(leagueId);
        }
        catch (Exception e){
            return false;
        }
        FAR far = (FAR) DBManager.getObject(FAR.class,sidInt);
        if(far == null){
            return false;
        }
        return far.activateGameSchedulePolicyForLeague(leagueIdInt);
    }



    public boolean setLeagueScorePolicy(String sid , String leagueId, String scorePolicy){

        int sidInt=-1;
        int leagueIdInt=-1;
        try{
            sidInt=Integer.parseInt(sid);
            leagueIdInt=Integer.parseInt(leagueId);
        }
        catch (Exception e){
            return false;
        }
        FAR far = (FAR) DBManager.getObject(FAR.class,sidInt);
        if(far == null){
            return false;
        }
        IScorePolicy scorePolicyI = new ScorePolicyA();
        if(scorePolicy.equals("ScorePolicyB")){
            scorePolicyI=new ScorePolicyB();
        }
        return far.setScorePolicyForSeason(leagueIdInt,scorePolicyI);
    }



    public String[] getTeamRequest(){
        String[] toReturn = new String[4];
        RegistrationRequest registrationRequest = DBManager.getNextRequest();
        if(!(registrationRequest instanceof TeamRequest)){
            return null;
        }
        Subscriber subscriber = (Subscriber) DBManager.getObject(Subscriber.class,registrationRequest.getSubscriber_id());
        toReturn[0] = ((TeamRequest)registrationRequest).getTeam_name();
        toReturn[1] = "" + ((TeamRequest)registrationRequest).getSubscriber_id();
        toReturn[2] = subscriber.getName();
        toReturn[3]=""+registrationRequest.getReq_id();
        return toReturn;

    }

    public String[] getGamesForLeague(String leagueId){
        if(leagueId==null){
            return null;
        }
        int leagueInt =-1;
        try{
            leagueInt = Integer.parseInt(leagueId);
        }
        catch (Exception e){
            return null;
        }
        League league = ((League) DBManager.getObject(League.class, leagueInt));
        if(league==null){
            return null;
        }
        Set<Season>seasons = league.getSeasons();
        Set<Game>games = new HashSet<>();
        for(Season s: seasons){
            if(s.getYear()==league.getCurrent_year()){
                games=s.getMatches();
            }
        }
        String[] toReturn = new String[games.size()*3];
        int i=0;
        for(Game game: games){
            Team team1 = (Team) DBManager.getObject(Team.class,game.getTeam_home_id());
            Team team2 = (Team) DBManager.getObject(Team.class,game.getTeam_away_id());
            if(team1!=null && team2!=null){
                toReturn[i] = game.getDate().toString();
                toReturn[i+1] = team1.getName();
                toReturn[i+2]= team2.getName();
                i=i+3;
            }
        }
        return toReturn;
    }

    public boolean handleRegistrationRequest(String sid,String regId, boolean approved){
        if(sid==null || regId==null){
            return false;
        }
        int sidInteger =-1;
        int regIdIdInt = -1;
        try{
            sidInteger = Integer.parseInt(sid);
        }
        catch (Exception e){
            return false;
        }
        FAR far = (FAR) DBManager.getObject(FAR.class,sidInteger);
        if(far == null){
            return false;
        }
        try{
            regIdIdInt = Integer.parseInt(regId);
        }
        catch (Exception e){
            return false;
        }
        RegistrationRequest registrationRequest = (RegistrationRequest) DBManager.getObject(RegistrationRequest.class,regIdIdInt);
        if (registrationRequest == null)
            return false;
        far.handleRequest(registrationRequest,approved);
        return true;

    }
}
