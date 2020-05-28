package com.example.demo;

import com.example.demo.DomainLayer.DBManager;
import com.example.demo.DomainLayer.Enums.Certification;
import com.example.demo.DomainLayer.Enums.LeagueLevel;
import com.example.demo.DomainLayer.Enums.RefereeRoll;
import com.example.demo.DomainLayer.LeagueManagment.*;
import com.example.demo.DomainLayer.MyFactory;
import com.example.demo.DomainLayer.Users.FAR;
import com.example.demo.DomainLayer.Users.Referee;
import com.example.demo.DomainLayer.Users.Subscriber;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Year;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@SpringBootTest
public class ScorePolicyTest {
    @Test
    public void createSubs(){
        Subscriber sub2 = MyFactory.createSubscriber("FAR-user","none","none");
        sub2.makeFARActive();
        Subscriber sub3 = MyFactory.createSubscriber("owner1 - user","none","none");
        Subscriber sub4 = MyFactory.createSubscriber("owner2 - user","none","none");
        Subscriber sub5 = MyFactory.createSubscriber("owner3 - user","none","none");
        Subscriber sub6 = MyFactory.createSubscriber("owner4 - user","none","none");
        sub3.makeOwnerActive();
        sub4.makeOwnerActive();
        sub5.makeOwnerActive();
        sub6.makeOwnerActive();

        Subscriber sub7 = MyFactory.createSubscriber("referee - 1","none","none");
        Subscriber sub8= MyFactory.createSubscriber("referee - 2","none","none");
        Subscriber sub9= MyFactory.createSubscriber("referee - 3","none","none");
        sub7.makeRefereeActive(Certification.PROFFESIONAL, RefereeRoll.MAIN_REFEREE);
        sub8.makeRefereeActive(Certification.BASIC, RefereeRoll.LINE_REFEREE);
        sub9.makeRefereeActive(Certification.BASIC, RefereeRoll.LINE_REFEREE);

        Subscriber sub10 = MyFactory.createSubscriber("fan - 1","none","none");
        sub10.makeFanActive();
    }



    @Test
    public void createTeams(){

        Subscriber s1 = DBManager.getByUserName("FAR-user");

        Subscriber s2 = DBManager.getByUserName("owner1 - user");
        Subscriber s3 =  DBManager.getByUserName("owner2 - user");
        Subscriber s4 =  DBManager.getByUserName("owner3 - user");
        Subscriber s5 =  DBManager.getByUserName("owner4 - user");

        Team team1 = MyFactory.createTeam(s2.getOwner(),"Real Madrid");
        Team team2 = MyFactory.createTeam(s3.getOwner(),"Barcelona");


        Field field1 = MyFactory.createField("Santiago Bernabeu");
        Field field2 = MyFactory.createField("Camp Nou");


        List<Field> fields1 = new ArrayList<>();
        fields1.add(field1);
        List<Field> fields2 = new ArrayList<>();
        fields2.add(field2);



        team1.setField(fields1);
        team2.setField(fields2);



        Set<Integer> teams_id = new HashSet<>();
        teams_id.add(team1.getTid());
        teams_id.add(team2.getTid());


        FAR far = s1.getFar();
        far.initializeLeague(LeagueLevel.PremierLeague,"LaLiga");
        far.initializeSeasonForLeague(1, Year.now().getValue(),teams_id);
        League league = (League) DBManager.getObject(League.class,1);
        Season season = league.getSeasons().iterator().next();
        season.setIScorePolicy(new ScorePolicyA());
        season.setIGamePolicy(new GamePolicy());
    }

    @Test
    public void createMatches(){
        League league = (League) DBManager.getObject(League.class,1);
        Season season = league.getSeasons().iterator().next();
        Subscriber s6 = DBManager.getByUserName("referee - 1");
        Subscriber s7 = DBManager.getByUserName("referee - 2");
        Subscriber s8 = DBManager.getByUserName("referee - 3");

        Set<Referee> referees = new HashSet<>();
        referees.add(s6.getReferee());
        referees.add(s7.getReferee());
        referees.add(s8.getReferee());

        season.setSeason_referees(referees);
        season.activateGameSchedulePolicy();
    }
    @Test
    public void endMatches(){
        Subscriber s6 = DBManager.getByUserName("referee - 1");
        Referee ref1 = s6.getReferee();
        int i = 0;
        for(Game game : ref1.getMatches()){
            ref1.createGameReport(game.getId(),game.getTeamFromDB(game.getTeam_home_id()),game.getTeamFromDB(game.getTeam_away_id()),i,0);
            i++;
        }

        League league = (League) DBManager.getObject(League.class,1);
        Season season = league.getSeasons().iterator().next();
        System.out.println(season.getIScorePolicy());

    }
}
