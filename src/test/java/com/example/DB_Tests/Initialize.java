package com.example.DB_Tests;

import com.example.DB_Tests.DomainLayer.DBManager;
import com.example.DB_Tests.DomainLayer.Enums.*;
import com.example.DB_Tests.DomainLayer.LeagueManagment.*;
import com.example.DB_Tests.DomainLayer.MyFactory;
import com.example.DB_Tests.DomainLayer.Users.Referee;
import com.example.DB_Tests.DomainLayer.Users.Subscriber;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
public class Initialize {

    @Test
    public void initialize(){

        //Creation
        Subscriber sub1 = MyFactory.createSubscriber("far - user","a","b");
        sub1.makeFARActive();

        Subscriber sub2 = MyFactory.createSubscriber("owner1","a","owner1");
        Subscriber sub3 = MyFactory.createSubscriber("owner2","a","owner2");
        Subscriber sub4 = MyFactory.createSubscriber("owner3","a","owner3");
        Subscriber sub5 = MyFactory.createSubscriber("owner4","a","owner4");
        Subscriber sub6 = MyFactory.createSubscriber("owner5","a","owner5");
        Subscriber sub7 = MyFactory.createSubscriber("owner6","a","owner6");
        Subscriber su8 = MyFactory.createSubscriber("owner7","a","owner7");
        Subscriber su9 = MyFactory.createSubscriber("owner8","a","owner8");
        Subscriber su10 = MyFactory.createSubscriber("owner9","a","owner9");
        Subscriber su11 = MyFactory.createSubscriber("owner10","a","owner10");

        sub2.makeOwnerActive();
        sub3.makeOwnerActive();
        sub4.makeOwnerActive();
        sub5.makeOwnerActive();
        sub6.makeOwnerActive();
        sub7.makeOwnerActive();
        su8.makeOwnerActive();
        su9.makeOwnerActive();
        su10.makeOwnerActive();
        su11.makeOwnerActive();


        Subscriber sub8 = MyFactory.createSubscriber("referee1","a","Molina");
        Subscriber sub9 = MyFactory.createSubscriber("referee2","a","Eitan Tavrizi");
        Subscriber sub10 = MyFactory.createSubscriber("referee3","a","Alon Yefet");

        sub8.makeRefereeActive(Certification.BASIC, RefereeRoll.MAIN_REFEREE);
        sub9.makeRefereeActive(Certification.BASIC, RefereeRoll.LINE_REFEREE);
        sub10.makeRefereeActive(Certification.BASIC, RefereeRoll.LINE_REFEREE);

        Set<Referee> referees =new HashSet<>();
        referees.add(sub8.getReferee());
        referees.add(sub9.getReferee());
        referees.add(sub10.getReferee());


        Subscriber sub11 = MyFactory.createSubscriber("fan_user","a","ohad");
        sub11.makeFanActive();


        Team team1 = MyFactory.createTeam(sub2.getOwner(),"Real Madrid");
        Team team2 = MyFactory.createTeam(sub3.getOwner(),"Barcelona");
        Team team3 = MyFactory.createTeam(sub4.getOwner(),"Atletico Madrid");
        Team team4 = MyFactory.createTeam(sub5.getOwner(),"Valencia");

        Field field1 = MyFactory.createField("Santiago Bernabeu");
        Field field2 = MyFactory.createField("Camp Nou");
        Field field3 = MyFactory.createField("Metropolitano");
        Field field4 = MyFactory.createField("Mestailla");

        List<Field> fields1 = new ArrayList<>();
        fields1.add(field1);
        List<Field> fields2 = new ArrayList<>();
        fields2.add(field2);
        List<Field> fields3 = new ArrayList<>();
        fields3.add(field3);
        List<Field> fields4 = new ArrayList<>();
        fields4.add(field4);

        team1.setField(fields1);
        team2.setField(fields2);
        team3.setField(fields3);
        team4.setField(fields4);

        Set<Integer> teams_id = new HashSet<>();
        teams_id.add(team1.getTid());
        teams_id.add(team2.getTid());
        teams_id.add(team3.getTid());
        teams_id.add(team4.getTid());



        Team team5 = MyFactory.createTeam(sub6.getOwner(),"Liverpool");
        Team team6 = MyFactory.createTeam(sub7.getOwner(),"Manchester United");
        Team team7 = MyFactory.createTeam(su8.getOwner(),"Chelsea");
        Team team8 = MyFactory.createTeam(su9.getOwner(),"Tottenham");

        Field field5 = MyFactory.createField("Anfield");
        Field field6 = MyFactory.createField("Old Trafford");
        Field field7 = MyFactory.createField("Stamford Bridge");
        Field field8 = MyFactory.createField("White Heart Lane");

        List<Field> fields5 = new ArrayList<>();
        fields5.add(field5);
        List<Field> fields6 = new ArrayList<>();
        fields6.add(field6);
        List<Field> fields7 = new ArrayList<>();
        fields7.add(field7);
        List<Field> fields8 = new ArrayList<>();
        fields8.add(field8);

        team5.setField(fields5);
        team6.setField(fields6);
        team7.setField(fields7);
        team8.setField(fields8);

        Set<Integer> teams_id2 = new HashSet<>();
        teams_id2.add(team5.getTid());
        teams_id2.add(team6.getTid());
        teams_id2.add(team7.getTid());
        teams_id2.add(team8.getTid());


        //logics
        sub1.getFar().initializeLeague(LeagueLevel.PremierLeague,"LaLiga");
        sub1.getFar().initializeLeague(LeagueLevel.PremierLeague,"Barclays");

        League league1 = (League) DBManager.getObject(League.class,1);
        League league2 = (League) DBManager.getObject(League.class,2);

        sub1.getFar().initializeSeasonForLeague(league1.getLid(), Year.now().getValue(),teams_id);
        sub1.getFar().initializeSeasonForLeague(league2.getLid(), Year.now().getValue(),teams_id2);

        Season season1 = league1.getSeasons().iterator().next();
        Season season2 = league1.getSeasons().iterator().next();

        season1.setSeason_referees(referees);
        season2.setSeason_referees(referees);

        season1.setGamePolicyEnum(GamePolicyEnum.STANDARD);
        season1.setScorePolicyEnum(ScorePolicyEnum.SCORE_POLICY_A);
        season1.setIGamePolicy(new GamePolicy());
        season1.setIScorePolicy(new ScorePolicyA());
        sub1.getFar().activateGameSchedulePolicyForLeague(1);
    }

    @Test
    public void alerts(){
        Subscriber sub11 = DBManager.getByUserName("fan_user");
        Game game = (Game) DBManager.getObject(Game.class,1);
        sub11.getFan().signForMatchAlerts(game);
        game.changeMatchDate(LocalDate.now());
    }
}
