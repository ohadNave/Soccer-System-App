package com.example.demo;

import com.example.demo.DomainLayer.DBManager;
import com.example.demo.DomainLayer.MyFactory;
import com.example.demo.DomainLayer.Users.FAR;
import com.example.demo.DomainLayer.Users.Subscriber;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TeamTest {


    @Test
    void registerTeamTest(){
        Subscriber sub_far = MyFactory.createSubscriber("far","a","b");
        sub_far.makeFARActive();
        FAR far = sub_far.getFar();

        Subscriber sub_owner = MyFactory.createSubscriber("owner1","a","b");

        sub_owner.makeOwnerActive();

        sub_owner.getOwner().openTeamRequest("MTA");
        far.handleRequest(DBManager.getNextRequest(),true);

        //same team name on new team owner - should return null
//        sub_owner2.getOwner().openTeamRequest("HBS");
//        Assert.isNull(sub_owner2.getOwner().getTeam(),"Test Passed");
    }



//    @Test
//    void sameTeamNameTest(){
//        Subscriber sub_far = MyFactory.createSubscriber("far","a","b");
//        sub_far.makeFARActive();
//
//        Subscriber sub_owner1 = MyFactory.createSubscriber("owner1","a","b");
//
//
//
//        Team team2 = MyFactory.createTeam(sub_owner.getOwner(),"HBS");
//        owner.openTeamRequest("HBS");
//        sub_far.getFar().handleRegistrationRequest(DBManagerStub.getNextRequest(),true);
//    }

}
