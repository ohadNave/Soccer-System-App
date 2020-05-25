package com.example.demo.DomainLayer;

import com.example.demo.DomainLayer.Alerts.*;
import com.example.demo.DomainLayer.Enums.*;
import com.example.demo.DomainLayer.LeagueManagment.*;
import com.example.demo.DomainLayer.Request.*;
import com.example.demo.DomainLayer.Users.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Set;

import static com.example.demo.DemoApplication.LOG;

public class MyFactory {

    //    System Users Creation      //
    public static Coach createCoach(int sid , CoachRole role, Certification certification){
        Coach coach = new Coach();
        coach.setAttributes(sid,role,certification);
        return coach;
    }

    public static Fan createFan(int sid){
        Fan fan = new Fan();
        fan.setAttributes(sid);
        return fan;
    }

    public static FAR createFar(int sid){
        FAR far = new FAR();
        far.setAttributes(sid);
        return far;
    }

    public static Guest createGuest(){
        Guest guest = new Guest();
        return guest;
    }


    public static Referee createReferee(Certification certification , RefereeRoll refereeRoll , int sid){
        Referee referee = new Referee();
        referee.setAttributes( certification,refereeRoll , sid);
        return referee;
    }

    public static Owner createOwner(int sid){
        Owner owner = new Owner();
        owner.setAttributes(sid);
        DBManager.updateObject(owner);
        return owner;
    }

    public static Player createPlayer(PlayerRole role, LocalDate dateOfBirth, int sid){
        Player player = new Player();
        player.setAttributes( role,dateOfBirth,sid );
        return player;
    }

    public static Subscriber createSubscriber(String userName, String password, String name){
        Subscriber subscriber = new Subscriber();
        subscriber.setAttributes(userName,password,name);
        DBManager.saveObject(subscriber);
        return subscriber;
    }

    public static sysMan createSystemManager(int sid){
        sysMan sysMan = new sysMan();
        sysMan.setAttributes(sid);
        return sysMan;
    }

    public static TeamManager createTeamManager(int sid){
        TeamManager teamManager = new TeamManager();
        teamManager.setAttributes(sid);
        return teamManager;
    }


    //    Alerts object Creation      //




    //    System object Creation      //


    public static Complain createComplain(Date date,  String content){
        Complain complain = new Complain();
        complain.setAttributes(date,content);
        DBManager.saveObject(complain);
        return complain;
    }

    public static GameReport createGameReport(int winnerTeam, int losingTeam, int winnerGoals, int loserGoals){
        GameReport gameReport = new GameReport();
        gameReport.setAttributes(winnerTeam ,losingTeam ,winnerGoals,loserGoals);
        DBManager.saveObject(gameReport);
        return gameReport;
    }

    public static GameEvent createEvent(int minuteInGame, String description, EventType eventType){
        GameEvent eventi = new GameEvent();
        eventi.setAttributes(minuteInGame,description,eventType);
        DBManager.saveObject(eventi);
        return eventi;
    }

    public static Field createField(String name){
        Field field = new Field();
        field.setAttributes(name);
        DBManager.saveObject(field);
        return field;
    }

    public static League createLeague(LeagueLevel leagueLevel, String name, IGamePolicy IGamePolicy, ScorePolicy scorePolicy){
        League league = new League();
        league.setAttributes(leagueLevel,name, IGamePolicy,scorePolicy);
        DBManager.saveObject(league);
        return league;
    }

    public static Season createSeason(League league, int currentYear, IGamePolicy IGamePolicy, ScorePolicy scorePolicy){
        Season season = new Season();
        season.setAttributes(league,currentYear, IGamePolicy,scorePolicy);
        DBManager.saveObject(season);
        return season;
    }

    public static TeamBySeason createTeamBySeason( Team team, int year){
        TeamBySeason teamBySeason = new TeamBySeason();
        teamBySeason.setAttributes(team,year);
        return teamBySeason;
    }

    public static Team createTeam( Owner owner, String name){
        Team team = new Team();
        team.setAttributes(owner,name);
        DBManager.saveObject(team);
        LOG.info("A new team "+ team.getTid() + " was created by sid : "+ owner.getSid() + ", team name: " + name);
        return team;
    }

    public static PrivatePage createPrivatePage(){
        PrivatePage privatePage = new PrivatePage();
        return privatePage;
    }

    public static Game createMatch(LocalDate date, LocalTime hour, Field field, Team home, Team away, Set<Referee> referees){
        Game match = new Game();
        match.setAttributes(date,hour,field,home.getTid(),away.getTid(),referees);
        DBManager.saveObject(match);
        return match;
    }


    /**
     *  Alerts Creation
     */
    public static GameEventAlert createGameEventAlert(int minute, GameEvent event){
        GameEventAlert gameEventAlert = new GameEventAlert();
        gameEventAlert.setAttributes(minute,event);
        return gameEventAlert;
    }

    public static MatchDateChangedAlert createMatchDateChangedAlert(LocalDate newMatchDate){
        MatchDateChangedAlert matchDateChangedAlert = new MatchDateChangedAlert();
        matchDateChangedAlert.setAttributes(newMatchDate);
        return matchDateChangedAlert;
    }

    public static MatchEndedAlert createMatchEndedAlert(GameReport gameReport){
        MatchEndedAlert matchEndedAlert = new MatchEndedAlert();
        matchEndedAlert.setAttributes(gameReport);
        return matchEndedAlert;
    }

    public static NewPostOnPageAlert createNewPostOnPageAlert(PrivatePage privatePage, String newContent){
        NewPostOnPageAlert newPostOnPageAlert = new NewPostOnPageAlert();
        newPostOnPageAlert.setAttributes(privatePage,newContent);
        return newPostOnPageAlert;
    }

    public static TeamIsNowNotActiveAlert createTeamIsNowNotActiveAlert(Team team){
        TeamIsNowNotActiveAlert teamIsNowNotActiveAlert = new TeamIsNowNotActiveAlert();
        teamIsNowNotActiveAlert.setAttributes(team);
        return teamIsNowNotActiveAlert;
    }

    /**
     *  Request Creation
     */

    public static CoachRequest createCoachRequest(int subscriber, CoachRole role, Certification certification){
        CoachRequest coachRequest = new CoachRequest();
        coachRequest.setAttributes(subscriber,role,certification);
        DBManager.saveObject(coachRequest);

        return coachRequest;
    }

    public static OwnerRequest createOwnerRequest(int subscriber_id){
        OwnerRequest ownerRequest = new OwnerRequest();
        ownerRequest.setAttributes(subscriber_id);
        DBManager.saveObject(ownerRequest);

        return ownerRequest;
    }

    public static PlayerRequest createPlayerRequest(int subscriber_id, PlayerRole role, LocalDate dateOfBirth){
        PlayerRequest playerRequest = new PlayerRequest();
        playerRequest.setAttributes(subscriber_id,role,dateOfBirth);
        DBManager.saveObject(playerRequest);

        return playerRequest;
    }

    public static RefereeRequest createRefereeRequest(int subscriber_id, Certification certification , RefereeRoll refereeRoll){
        RefereeRequest refereeRequest = new RefereeRequest();
        refereeRequest.setAttributes(subscriber_id,certification,refereeRoll);
        DBManager.saveObject(refereeRequest);
        return refereeRequest;
    }

    public static TeamManagerRequest createTeamManagerRequest(int subscriber_id){
        TeamManagerRequest teamManagerRequest = new TeamManagerRequest();
        teamManagerRequest.setAttributes(subscriber_id);
        DBManager.saveObject(teamManagerRequest);
        return teamManagerRequest;
    }

    public static TeamRequest createTeamRequest(String teamName, int subscriber_id){
        TeamRequest requestTeam = new TeamRequest();
        requestTeam.setAttributes(teamName,subscriber_id);
        DBManager.saveObject(requestTeam);
        return requestTeam;
    }





}
