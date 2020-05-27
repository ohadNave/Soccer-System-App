package com.example.demo;

import com.example.demo.DomainLayer.DBManager;
import com.example.demo.DomainLayer.Enums.LeagueLevel;
import com.example.demo.DomainLayer.LeagueManagment.League;
import com.example.demo.DomainLayer.LeagueManagment.Team;
import com.example.demo.DomainLayer.MyFactory;
import com.example.demo.DomainLayer.Users.FAR;
import com.example.demo.DomainLayer.Users.Subscriber;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
public class LeagueTests {


    @Test
    void LeagueTest(){
        Subscriber s1 = MyFactory.createSubscriber("ohad-far","s","ohad");
        s1.makeFARActive();
        FAR far = s1.getFar();
        far.initializeLeague(LeagueLevel.PremierLeague,"La-Liga");
    }

    @Test
    void seasonForLeagueTest(){

        Subscriber s1 = MyFactory.createSubscriber("ohad-far2","s","ohad");
        s1.makeFARActive();
        FAR far = s1.getFar();
        far.initializeLeague(LeagueLevel.PremierLeague,"La-Liga");


        Subscriber s2 = MyFactory.createSubscriber("owner1","none","none");
        Subscriber s3 = MyFactory.createSubscriber("owner2","none","none");
        Subscriber s4= MyFactory.createSubscriber("owner3","none","none");

        s2.makeOwnerActive();
        s3.makeOwnerActive();
        s4.makeOwnerActive();

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
        League leagueFromDB = ((League) DBManager.getObject(League.class, 1));
    }

}
