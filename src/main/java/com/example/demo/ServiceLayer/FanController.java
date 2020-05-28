package com.example.demo.ServiceLayer;

import com.example.demo.DomainLayer.Alerts.Alert;
import com.example.demo.DomainLayer.DBManager;
import com.example.demo.DomainLayer.Users.Subscriber;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class FanController {

    public Queue<String> getAlerts(String sid){
        Queue<String> alertsToReturn = new ArrayDeque<>();
        int sidInt= -1;

        try{
            sidInt = Integer.parseInt(sid);
        }
        catch (Exception e){
            return null;
        }
        Subscriber subscriber = (Subscriber) DBManager.getObject(Subscriber.class,sidInt);
        if(subscriber == null){
            return null;
        }

        if(subscriber.getFan()==null){
            return null;
        }
        for(Alert a : subscriber.getFan().getAlerts()){
            alertsToReturn.add(a.toString());
        }
        return alertsToReturn;
    }

    public List<String> getPrevAlerts(String sid){
        int sidInt= -1;
        try{
            sidInt = Integer.parseInt(sid);
        }
        catch (Exception e){
            return null;
        }
        Subscriber subscriber = (Subscriber) DBManager.getObject(Subscriber.class,sidInt);
        if(subscriber == null){
            return null;
        }
        if(subscriber.getFan()==null){
            return null;
        }

        return subscriber.getFan().getPrevAlerts();
    }
}
