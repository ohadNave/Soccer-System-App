package com.example.DB_Tests;

import com.example.DB_Tests.DomainLayer.Users.Guest;
import com.example.DB_Tests.DomainLayer.Users.Subscriber;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class LoginTest {

    /**
     * correct password
     */
    @Test
    public void loginTest(){
        Guest guest = new Guest();
        Subscriber subscriber = guest.Login("far - user","a");
        Assert.notNull(subscriber.getFar(),"");
    }

    /**
     * bad password
     */
    @Test
    public void loginTest2(){
        Guest guest = new Guest();
        Subscriber subscriber = guest.Login("far - user","b");
        Assert.isNull(subscriber,"");
    }
}
