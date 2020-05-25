package com.example.demo.DomainLayer;

import com.example.demo.DomainLayer.Users.Guest;
import com.example.demo.DomainLayer.Users.Subscriber;

public class System {

    static public boolean initialzied = false;

    /**
     * UC 1.1
     */
    public static void InitializeSystem(){
        Subscriber subscriber = MyFactory.createSubscriber("ohad", "nave", "ohad nave");
        subscriber.makeSystemManagerActive();
        initialzied = true;
    }

}
