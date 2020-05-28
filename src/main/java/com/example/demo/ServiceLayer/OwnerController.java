package com.example.demo.ServiceLayer;
import com.example.demo.DomainLayer.Alerts.Alert;
import com.example.demo.DomainLayer.DBManager;
import com.example.demo.DomainLayer.Users.Owner;
import com.example.demo.DomainLayer.Users.Subscriber;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class OwnerController {


    public OwnerController(){}

    public Queue<String> getAlerts(String sid){
        Queue<String> q = new LinkedList<>();
        ((LinkedList<String>) q).add("first alertttttttt");
        ((LinkedList<String>) q).add("second alertttttttt");
        return q;
//        Queue<String> alertsToReturn = new ArrayDeque<>();
//        int sidInt= -1;
//
//        try{
//            sidInt = Integer.parseInt(sid);
//        }
//        catch (Exception e){
//            return null;
//        }
//        Subscriber subscriber = (Subscriber) DBManager.getObject(Subscriber.class,sidInt);
//        if(subscriber == null){
//            return null;
//        }
//
//        if(subscriber.getOwner() == null){
//            return null;
//        }
//        for(Alert a : subscriber.getOwner().getAlerts()){
//            alertsToReturn.add(a.toString());
//        }
//        return alertsToReturn;
    }

    public boolean sendTeamRequest(String teamName , String sid){
        if(teamName==null){
            return false;
        }
        int intSid=-1;

        try {
            intSid = Integer.parseInt(sid);
        }
        catch (Exception e){
            return false;
        }
        Subscriber subscriber = (Subscriber) DBManager.getObject(Subscriber.class,intSid);
        if(subscriber==null){
            return false;
        }
        Owner owner = subscriber.getOwner();
        if(owner==null){
            return false;
        }
        return owner.openTeamRequest(teamName);
    }
}
