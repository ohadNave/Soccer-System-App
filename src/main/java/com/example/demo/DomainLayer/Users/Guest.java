package com.example.demo.DomainLayer.Users;

import com.example.demo.DomainLayer.DBManager;
import com.example.demo.DomainLayer.MyFactory;

import java.security.MessageDigest;

public class Guest {


    public Guest() {
    }

    /**
     *UC 2.2
     * After a given guest has been registered he is known as com.example.demo.DomainLayer.Users.Fan.
     * && userName.matches("[A-Za-z]")
     */
    public Subscriber Register(String userName , String password, String passwordAgain ,String name) throws Exception{
        if (   userName != null && userName.matches("[a-zA-Z]+")  && password != null && passwordAgain !=null && name != null){
            if ( !userName.isEmpty()  && !password.isEmpty() && !passwordAgain.isEmpty() && password.equals(passwordAgain) && !name.isEmpty() ){
                if (DBManager.checkUserName(userName) ){
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    messageDigest.digest(password.getBytes());
                    Subscriber subscriber = MyFactory.createSubscriber(userName,password,name);
                    subscriber.makeFanActive();
                    return subscriber;
                }
                else {
                    System.out.println("User name already taken");
                }
            }
        }
        return null;
    }

    /**
     * UC 2.3
     */
    public Subscriber Login(String userName, String password){
        return DBManager.validateLogin(userName, password);
    }
}
