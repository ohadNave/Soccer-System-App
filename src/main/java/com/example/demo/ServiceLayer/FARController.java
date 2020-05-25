package com.example.demo.ServiceLayer;


import com.example.demo.DomainLayer.DBManager;
import com.example.demo.DomainLayer.LeagueManagment.*;
import com.example.demo.DomainLayer.Request.RegistrationRequest;
import com.example.demo.DomainLayer.Request.TeamRequest;
import com.example.demo.DomainLayer.Users.FAR;
import com.example.demo.DomainLayer.Users.Subscriber;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FARController {

    public FARController(){

    }

    public Set<League> getLeagues(){
        Set<League> toReturn = new HashSet<>();
        List<Object> leaguesId = DBManager.getListOfObjects(League.class,"League");
        for(Object l: leaguesId){
            toReturn.add(((League) l));
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
        ScorePolicy scorePolicyI = new ScorePolicyA();
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
        return far.handleRequest(registrationRequest,approved);
    }
}
