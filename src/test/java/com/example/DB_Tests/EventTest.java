package com.example.DB_Tests;

import com.example.DB_Tests.DomainLayer.DBManager;
import com.example.DB_Tests.DomainLayer.Enums.Certification;
import com.example.DB_Tests.DomainLayer.Enums.EventType;
import com.example.DB_Tests.DomainLayer.Enums.LeagueLevel;
import com.example.DB_Tests.DomainLayer.Enums.RefereeRoll;
import com.example.DB_Tests.DomainLayer.LeagueManagment.*;
import com.example.DB_Tests.DomainLayer.MyFactory;
import com.example.DB_Tests.DomainLayer.Users.FAR;
import com.example.DB_Tests.DomainLayer.Users.Referee;
import com.example.DB_Tests.DomainLayer.Users.Subscriber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
public class EventTest {

    @Test
    public void createEventInGameTest(){
        Subscriber s1 = MyFactory.createSubscriber("ohad-far2","s","ohad");
        s1.makeFARActive();
        FAR far = s1.getFar();
        far.initializeLeague(LeagueLevel.PremierLeague,"La-Liga");

        //create owners
        Subscriber s2 = MyFactory.createSubscriber("owner1","none","none");
        Subscriber s3 = MyFactory.createSubscriber("owner2","none","none");
        Subscriber s4= MyFactory.createSubscriber("owner3","none","none");
        Subscriber sr1 = MyFactory.createSubscriber("ref1","none","none");
        Subscriber sr2 = MyFactory.createSubscriber("ref2","none","none");
        Subscriber sr3= MyFactory.createSubscriber("ref3","none","none");

        Assertions.assertNotNull(s2);
        Assertions.assertNotNull(s3);
        Assertions.assertNotNull(s4);
        Assertions.assertNotNull(sr1);
        Assertions.assertNotNull(sr2);
        Assertions.assertNotNull(sr3);


        s2.makeOwnerActive();
        s3.makeOwnerActive();
        s4.makeOwnerActive();

        sr1.makeRefereeActive(Certification.BASIC, RefereeRoll.MAIN_REFEREE);
        sr2.makeRefereeActive(Certification.BASIC, RefereeRoll.MAIN_REFEREE);
        sr3.makeRefereeActive(Certification.BASIC, RefereeRoll.MAIN_REFEREE);



        Team team2 = MyFactory.createTeam(s2.getOwner(),"RMA");
        Team team3 = MyFactory.createTeam(s3.getOwner(),"BAR");
        Team team4 = MyFactory.createTeam(s4.getOwner(),"ATM");

        List<Team> teams = new ArrayList<>();
        teams.add(team2);
        teams.add(team3);
        teams.add(team4);

        Set<Integer> team_ids = new HashSet<>();
        team_ids.add(team2.getTid());
        team_ids.add(team3.getTid());
        team_ids.add(team4.getTid());
        far.initializeSeasonForLeague(1,2020, team_ids);


        Referee fr1 = sr1.getReferee();
        Referee fr2 = sr2.getReferee();
        Referee fr3 = sr3.getReferee();
        System.out.println("1");
        Set<Referee> referees = new HashSet<>();
        referees.add(fr1);
        referees.add(fr2);
        referees.add(fr3);

        League leagueFromDB = ((League) DBManager.getObject(League.class, 1));
        Assertions.assertNotNull(leagueFromDB);
        Season currSeason = (Season) DBManager.getObject(Season.class, 1);
        Assertions.assertNotNull(currSeason);

        Field f1 = MyFactory.createField("Terner");
        Field f2 = MyFactory.createField("Vasermil");

        Game m1 = MyFactory.createGame(LocalDate.now(), LocalTime.NOON,f1,team2,team3,referees);
        Game m2 = MyFactory.createGame(LocalDate.now(), LocalTime.NOON,f1,team4,team2,referees);
        Set<Game> matches = new HashSet<>();

        matches.add(m1);
        matches.add(m2);

        currSeason.setMatches(matches);

        fr1.addEventToMatch(m1.getId(),10,"Barda gets a yellow card", EventType.YellowCard);
        fr1.addEventToMatch(m1.getId(),23,"Barda gets a red card", EventType.RedCard);
        fr1.addEventToMatch(m1.getId(),55,"Melikson scores", EventType.Goal);
    }
}
