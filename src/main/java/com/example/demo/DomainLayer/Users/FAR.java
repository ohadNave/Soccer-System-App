package com.example.demo.DomainLayer.Users;

import com.example.demo.DomainLayer.DBManager;
import com.example.demo.DomainLayer.Enums.Certification;
import com.example.demo.DomainLayer.Enums.LeagueLevel;
import com.example.demo.DomainLayer.Enums.RefereeRoll;
import com.example.demo.DomainLayer.LeagueManagment.*;
import com.example.demo.DomainLayer.MyFactory;
import com.example.demo.DomainLayer.Request.*;

import javax.persistence.Entity;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.example.demo.DemoApplication.errorLogger;
import static com.example.demo.DemoApplication.eventLogger;

/**
 * Done
 */
@Entity
public class FAR extends SystemUser implements Serializable {

    @Transient
    private static BudgetControl budgetControl = new BudgetControl();


    public void setAttributes(int sid){
        setSid(sid);
        budgetControl = new BudgetControl();
    }

    /**
     * UC 9.1
     * first creation of a given league.
     * @return
     */
//    public boolean initializeLeague(LeagueLevel leagueLevel, String name, IGamePolicy gamePolicy, ScorePolicy scorePolicy){
//        if( name.matches("[A-Za-z]") && leagueLevel!=null && name!=null && !name.isEmpty() && gamePolicy!=null && scorePolicy!=null){
//                League league = MyFactory.createLeague(leagueLevel,name, gamePolicy,scorePolicy);
//                LOG.info("A league was initiated by FAR: "+ getSid());
//                return true;
//        }
//        return false;
//    }

    public boolean initializeLeague(LeagueLevel leagueLevel, String name){
        if( name.matches("[A-Za-z]+") && leagueLevel!=null && name!=null ){
            MyFactory.createLeague(leagueLevel,name);
            eventLogger.info("A league was initiated by FAR: "+ getSid());
            return true;
        }
        errorLogger.error("A league was failed to initiate by FAR: "+ getSid());
        return false;
    }


    /**
     * UC 9.2
     * Initialize a specific season for an exiting league.
     */
    public boolean initializeSeasonForLeague(int leagueId, int year, Set<Integer> team_ids ){

        if (team_ids != null){
            List<Team> teamsForSeason = new ArrayList<>();
            League league = ((League) DBManager.getObject(League.class, leagueId));
            for (Integer tid: team_ids){
                Team team = ((Team) DBManager.getObject(Team.class, tid));
                teamsForSeason.add(team);
            }
            if(league != null && teamsForSeason !=null && year >= 2019 ){
                if(league.startNewSeason(year , teamsForSeason)){
                    for(Team t : teamsForSeason){
                        budgetControl.initializeTeamFinance(t,year);
                    }
                    eventLogger.info("A new season was initiated to league: " +league.getName()+" year: " +year +" by: "+this.getSid());
                    return true;
                }
            }
        }

        errorLogger.error("A new season was failed to initiate to league");
        return false;
    }

    /**
     * Far is the only one who can  define and undefine referees in the system.
     *UC 9.3
     */

    public boolean activateReferee(String userName, String password, String name, Certification certification, RefereeRoll refereeRoll){
        if(userName!=null && !userName.isEmpty() && password!=null && !password.isEmpty() && name!=null && !name.isEmpty() && DBManager.checkUserName(userName)){
            Subscriber subscriber = MyFactory.createSubscriber(userName,password,name);
            subscriber.makeRefereeActive(certification , refereeRoll);
            eventLogger.info("A referee: " + userName + " was activated by FAR: " + getSid());
            return true;
        }
        errorLogger.error("A referee was failed to activate by FAR: " + getSid());
        return false;
    }


    public boolean deactivateReferee(int id){
            Subscriber subscriber = ((Subscriber) DBManager.getObject(Subscriber.class, id));
        if(subscriber != null) {
            subscriber.makeRefereeNotActive();
            eventLogger.info("A referee: " + id + " was removed by FAR: " + getSid());
            return true;
        }
        errorLogger.error("A referee was failed to remove by FAR: " + getSid());
        return false;
    }


    /**
     *UC 9.4
     */
    public boolean setRefereesForLeague(int leagueId, int year, Set<Referee>referees){
        League league = ((League) DBManager.getObject(League.class, leagueId));
        if(league != null && year>=0 && referees!=null){
            eventLogger.info("referees were set to league: " +league.getName() + " by FAR: " +getSid());
            league.setMainRefereesForSeason(year,referees);
            DBManager.updateObject(league);
            return true;
        }
        errorLogger.error("referees were failed to set to league by FAR: " +getSid());
        return false;
    }


    /**
     *UC 9.5
     */
    public boolean setScorePolicyForSeason(int leagueId , IScorePolicy scorePolicy){
        League league = ((League) DBManager.getObject(League.class, leagueId));
        if(league != null && scorePolicy != null){
            league.setScorePolicyForSeason(league.getCurrent_year(),scorePolicy);
            eventLogger.info("A score policy was set to league: "+league.getName()+", year:"+ league.getCurrent_year() +" by FAR: "+getSid());
            DBManager.updateObject(league);
            return true;
        }
        errorLogger.error("A score policy was failed to set to league by FAR: "+getSid());
        return false;
    }

    /**
     *UC 9.6
     */
    public boolean setLeagueGameSchedulerPolicy(int leagueId, IGamePolicy IGamePolicy){
        League league = ((League) DBManager.getObject(League.class, leagueId));
        if(league!=null && IGamePolicy !=null){
            eventLogger.info("A Game Scheduler policy was set to league: "+league.getName()+", year: "+ league.getCurrent_year() +" by FAR :"+getSid());
            league.setSeasonSchedulerPolicy(league.getCurrent_year(), IGamePolicy);
            DBManager.updateObject(league);
            return true;
        }
        errorLogger.error("A Game Scheduler policy was failed to set to league by FAR :"+getSid());
        return false;

    }

    /**
     *UC 9.7
     */
    public boolean activateGameSchedulePolicyForLeague(int leagueId){
        League league = ((League) DBManager.getObject(League.class, leagueId));

        if(league!=null){
            eventLogger.info("A Game Scheduler policy was activated set to league: "+league.getName() +" by FAR: "+getSid());
            league.activateGameSchedulePolicyForSeason(league.getCurrent_year());
            DBManager.updateObject(league);
            return true;
        }
        errorLogger.error("A Game Scheduler policy was failed to activate set to league by FAR: "+getSid());
        return false;
    }

    /**
     * UC 9.8
     * Gets a set of "bad" teams - teams that their balance is negative in a given quarter.
     */
    public Set<Team> getNegativeBalanceTeams(){ return budgetControl.QuarterCheck(); }


    /**
     * used in case of new league creation - cant add team who has closed by system manager in the past.
     */
    public boolean checkTeamsStatus(Team[]teams){
        for (Team t: teams){
            if (t.isClosed())
                return false;
        }
        return true;
    }

    public boolean handleRequest(RegistrationRequest registrationRequest, boolean approved){
        if(registrationRequest != null && approved){
            Subscriber subscriber = (Subscriber) DBManager.getObject(Subscriber.class,registrationRequest.getSubscriber_id());
            if(registrationRequest instanceof TeamRequest){
                    TeamRequest requestTeam = (TeamRequest)registrationRequest;
                    Team team = MyFactory.createTeam(subscriber.getOwner(), requestTeam.getTeam_name());
                    team.setActive(true);
                    subscriber.getOwner().setTeam(team);
            }
            else{
                if(registrationRequest instanceof RefereeRequest){
                    RefereeRequest refereeRequest = (RefereeRequest)registrationRequest;
                    subscriber.makeRefereeActive(refereeRequest.getCertification() , refereeRequest.getRefereeRoll() );
                }
                else if(registrationRequest instanceof TeamManagerRequest){
                    TeamManagerRequest teamManagerRequest = (TeamManagerRequest)registrationRequest;
                    subscriber.makeTeamManagerActive();
                }

                else if(registrationRequest instanceof PlayerRequest){
                    PlayerRequest request = (PlayerRequest) registrationRequest;
                    subscriber.makePlayerActive(request.getRole(), request.getDateOfBirth());
                }

                else if(registrationRequest instanceof CoachRequest){
                    CoachRequest request = (CoachRequest) registrationRequest;
                    subscriber.makeCoachActive(request.getRole(),request.getCertification());
                }

                else if(registrationRequest instanceof OwnerRequest){
                    subscriber.makeOwnerActive();
                }
            }
            DBManager.updateObject(subscriber);
            DBManager.incrementReqID();
            return true;
        }
        DBManager.incrementReqID();
        return false;
    }

    public boolean checkTeamName(String teamName){
      return DBManager.checkTeamName(teamName);
    }


    public Set<League> getAllLeagues(){
        List<Object> objectLeague = DBManager.getListOfObjects(League.class,"League");
        Set<League> leagues = new HashSet<>();
        for (Object o : objectLeague){
            leagues.add(((League) o));
        }
        return leagues;
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }


}
