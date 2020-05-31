package com.example.DB_Tests;

import com.example.DB_Tests.DomainLayer.DBManager;
import com.example.DB_Tests.DomainLayer.MyFactory;
import com.example.DB_Tests.DomainLayer.Users.FAR;
import com.example.DB_Tests.DomainLayer.Users.Subscriber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TeamTest {


    @Test
    void registerTeamTest(){
        Subscriber sub_far = MyFactory.createSubscriber("farNewTeam","a","b");
        sub_far.makeFARActive();
        FAR far = sub_far.getFar();
        Subscriber sub_owner = MyFactory.createSubscriber("ownerNewTeam","a","b");
        sub_owner.makeOwnerActive();
        sub_owner.getOwner().openTeamRequest("MTA");
        far.handleRequest(DBManager.getNextRequest(),true);
        Assertions.assertTrue(far.handleRequest(DBManager.getNextRequest(),true));
    }

    @Test
    void registerTeamWithExistingName(){
        Subscriber sub_far = MyFactory.createSubscriber("farNewTeam","a","b");
        sub_far.makeFARActive();
        FAR far = sub_far.getFar();
        Subscriber sub_owner = MyFactory.createSubscriber("ownerNewTeam1","a","b");
        sub_owner.makeOwnerActive();
        Subscriber sub_owner2 = MyFactory.createSubscriber("ownerNewTeam2","a","b");
        sub_owner2.makeOwnerActive();
        sub_owner.getOwner().openTeamRequest("MTA");
        far.handleRequest(DBManager.getNextRequest(),true);
        Assertions.assertTrue(far.handleRequest(DBManager.getNextRequest(),true));
    }
    
}
