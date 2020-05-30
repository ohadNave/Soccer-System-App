package com.example.demo;

import com.example.demo.DomainLayer.MyFactory;
import com.example.demo.DomainLayer.Users.Guest;
import com.example.demo.DomainLayer.Users.Subscriber;
import org.junit.jupiter.api.Test;

public class loginTest {

    @Test
    public void Register(){
        Guest guest = new Guest();
        Subscriber subscriber = guest.Login("User-reg","12345");

    }
}
