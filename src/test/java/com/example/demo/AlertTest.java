package com.example.demo;

import com.example.demo.DomainLayer.Alerts.Alert;
import com.example.demo.DomainLayer.Alerts.Alert;
import com.example.demo.DomainLayer.DBManager;
import com.example.demo.DomainLayer.Enums.Certification;
import com.example.demo.DomainLayer.Enums.EventType;
import com.example.demo.DomainLayer.Enums.LeagueLevel;
import com.example.demo.DomainLayer.Enums.RefereeRoll;
import com.example.demo.DomainLayer.LeagueManagment.*;
import com.example.demo.DomainLayer.MyFactory;
import com.example.demo.DomainLayer.Users.FAR;
import com.example.demo.DomainLayer.Users.Fan;
import com.example.demo.DomainLayer.Users.Referee;
import com.example.demo.DomainLayer.Users.Subscriber;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
public class AlertTest {

    @Test
    public void matchDateChanged_alert_test(){
        Subscriber s6 = DBManager.getByUserName("referee - 1");
        List<Alert> list = new ArrayList<>();
        Team team = MyFactory.createTeam(DBManager.getByUserName("owner4 - user").getOwner(),"chen");
        Alert alert = MyFactory.createTeamIsNowNotActiveAlert(team);
        list.add(alert);
        s6.getReferee().setAlerts(list);
        Subscriber s7 = DBManager.getByUserName("referee - 2");
        Subscriber s8 = DBManager.getByUserName("referee - 3");
        Game game = (Game) DBManager.getObject(Game.class,2);
        game.changeMatchDate(LocalDate.now());
        Referee referee1 = s6.getReferee();
        Referee referee2 = s7.getReferee();
        Referee referee3 = s8.getReferee();
    }

    @Test
    public void initTest(){
        Subscriber s1 = MyFactory.createSubscriber("ohad-far2","s","ohad");
        s1.makeFARActive();
        FAR far = s1.getFar();


        //create owners
        Subscriber so1 = MyFactory.createSubscriber("owner1","none","none");
        Subscriber so2 = MyFactory.createSubscriber("owner2","none","none");
        Subscriber sf = MyFactory.createSubscriber("Fan123","none","none");

        Subscriber sr1 = MyFactory.createSubscriber("refe1","none","none");
        Subscriber sr2 = MyFactory.createSubscriber("refe2","none","none");
        Subscriber sr3= MyFactory.createSubscriber("refe3","none","none");

        sr1.makeRefereeActive(Certification.BASIC, RefereeRoll.MAIN_REFEREE);
        sr2.makeRefereeActive(Certification.BASIC, RefereeRoll.MAIN_REFEREE);
        sr3.makeRefereeActive(Certification.BASIC, RefereeRoll.MAIN_REFEREE);


        so1.makeOwnerActive();
        so2.makeOwnerActive();

        sf.makeFanActive();



        Team team2 = MyFactory.createTeam(so1.getOwner(),"RMA");
        Team team3 = MyFactory.createTeam(so2.getOwner(),"BAR");

        List<Team> teams = new ArrayList<>();
        teams.add(team2);
        teams.add(team3);

        Set<Integer> team_ids = new HashSet<>();
        team_ids.add(team2.getTid());
        team_ids.add(team3.getTid());



        Referee fr1 = sr1.getReferee();
        Referee fr2 = sr2.getReferee();
        Referee fr3 = sr3.getReferee();

        Set<Referee> referees = new HashSet<>();
        referees.add(fr1);
        referees.add(fr2);
        referees.add(fr3);

        far.initializeLeague(LeagueLevel.PremierLeague,"LaLiga");
        far.initializeSeasonForLeague(1,2020, team_ids);

        League leagueFromDB = ((League) DBManager.getObject(League.class, 1));
        Set<Season> seasons = leagueFromDB.getSeasons();
        Season currSeason = seasons.iterator().next();
        Field f1 = MyFactory.createField("Terner");
        Field f2 = MyFactory.createField("Vasermil");


        List<Field> fields2 = new ArrayList<>();
        fields2.add(f1);
        team2.setField(fields2);
        List<Field> fields3 = new ArrayList<>();
        fields3.add(f2);
        team3.setField(fields3);
        currSeason.setIGamePolicy((new GamePolicy()));
        currSeason.setSeason_referees(referees);
        currSeason.activateGameSchedulePolicy();

    }

    @Test
    public void fanGameEventAlertTest() {
        Subscriber sf = DBManager.getByUserName("Fan123");
        Subscriber sr1 = DBManager.getByUserName("refe1");

        Referee fr1 = sr1.getReferee();
        Fan fan = sf.getFan();

        Game m1 = fr1.getMatches().iterator().next();
        fan.signForMatchAlerts(m1);

        fr1.addEventToMatch(m1.getId(),10,"Barda gets a yellow card", EventType.YellowCard);
        fr1.addEventToMatch(m1.getId(),23,"Barda gets a red card", EventType.RedCard);

    }

    @Test
    public void fanGameEndedAlertTest() {
        Subscriber sf = DBManager.getByUserName("Fan123");
        Subscriber sr1 = DBManager.getByUserName("refe1");
        Fan fan = sf.getFan();
        Referee fr1 = sr1.getReferee();
        Game m1 = fr1.getMatches().iterator().next();
//        fr1.startMatch(m1);
        Team team2 = m1.getTeamFromDB(m1.getTeam_home_id());
        Team team3 = m1.getTeamFromDB(m1.getTeam_away_id());
        fr1.createGameReport(m1.getId(),team2,team3,1,0);
    }

    @Test
    public void matchDateChangedAlertTest(){
        Subscriber sr1 = DBManager.getByUserName("refe1");
        Subscriber sr2 = DBManager.getByUserName("refe2");
        Subscriber sr3= DBManager.getByUserName("refe3");
        Referee fr1 = sr1.getReferee();
        Referee fr2 = sr2.getReferee();
        Referee fr3 = sr3.getReferee();

        Game m1 = fr1.getMatches().iterator().next();

        m1.changeMatchDate(LocalDate.now());


    }

}
