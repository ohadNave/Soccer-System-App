package com.example.demo;

import com.example.demo.DomainLayer.DBManager;
import com.example.demo.DomainLayer.LeagueManagment.Team;
import com.example.demo.DomainLayer.MyFactory;
import com.example.demo.DomainLayer.Users.FAR;
import com.example.demo.DomainLayer.Users.Subscriber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class TeamTest {


    @Test
    void registerTeamTest(){
        Subscriber sub_far = MyFactory.createSubscriber("far2 - register team","a","b");
        sub_far.makeFARActive();
        FAR far = sub_far.getFar();
        Subscriber sub_owner = MyFactory.createSubscriber("owner2 - new team","a","b");
        sub_owner.makeOwnerActive();
        sub_owner.getOwner().openTeamRequest("MTA");
        far.handleRequest(DBManager.getNextRequest(),true);
        Assertions.assertTrue(far.handleRequest(DBManager.getNextRequest(),true));
    }



    @Test
    void sameTeamNameTest(){
        Subscriber sub_far = MyFactory.createSubscriber("far","a","b");
        sub_far.makeFARActive();
        Subscriber sub_owner1 = MyFactory.createSubscriber("owner1","a","b");
        Team team2 = MyFactory.createTeam(sub_owner1.getOwner(),"HBS");
        sub_owner1.getOwner().openTeamRequest("HBS");
        sub_far.getFar().handleRequest(DBManager.getNextRequest(),true);
    }

}
