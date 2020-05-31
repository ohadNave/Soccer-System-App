package com.example.DB_Tests;

import com.example.DB_Tests.DomainLayer.Alerts.Alert;
import com.example.DB_Tests.DomainLayer.DBManager;
import com.example.DB_Tests.DomainLayer.Enums.Certification;
import com.example.DB_Tests.DomainLayer.Enums.EventType;
import com.example.DB_Tests.DomainLayer.Enums.LeagueLevel;
import com.example.DB_Tests.DomainLayer.Enums.RefereeRoll;
import com.example.DB_Tests.DomainLayer.LeagueManagment.*;
import com.example.DB_Tests.DomainLayer.MyFactory;
import com.example.DB_Tests.DomainLayer.Users.FAR;
import com.example.DB_Tests.DomainLayer.Users.Fan;
import com.example.DB_Tests.DomainLayer.Users.Referee;
import com.example.DB_Tests.DomainLayer.Users.Subscriber;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
public class AlertTest {



    @Test
    public void createSubs(){
        Subscriber s1 = MyFactory.createSubscriber("ohad-far2","s","ohad");
        s1.makeFARActive();
        FAR far = s1.getFar();

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
    public void MatchAlertForFan() {
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
    public void MatchAlertForReferee(){
        Subscriber s6 = DBManager.getByUserName("referee - 1");
        List<Alert> list = new ArrayList<>();
        Team team = MyFactory.createTeam(DBManager.getByUserName("owner4 - user").getOwner(),"chen");
        Alert alert = MyFactory.createTeamIsNowNotActiveAlert(team);
        list.add(alert);
        s6.getReferee().setAlerts(list);
        Game game = (Game) DBManager.getObject(Game.class,2);
        game.changeMatchDate(LocalDate.now());
    }

}
