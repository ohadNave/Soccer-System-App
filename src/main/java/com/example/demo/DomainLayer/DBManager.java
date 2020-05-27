package com.example.demo.DomainLayer;

import com.example.demo.DataLayer.DaoMySQL;
import com.example.demo.DomainLayer.Request.RegistrationRequest;
import com.example.demo.DomainLayer.Users.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DBManager {

    private static DBManager instance = new DBManager(); ;
    public static DBManager getInstance() { return instance; }
    private static DaoMySQL daoMySQL = new DaoMySQL();

    private static int next_req_id = 1;

    public static Object getObject(Class classType, int id){
        try{
            return daoMySQL.get(classType,id);
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static void saveObject(Object o){
        try{
            daoMySQL.save(o);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void updateObject(Object o){
        try{
            daoMySQL.update(o);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void removeObject(Object o){
        try{
            daoMySQL.delete(o);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void detachObject(Object o){
        try{
            daoMySQL.detach(o);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static List<Object> getListOfObjects(Class classType, String table){
        try{
            return daoMySQL.getAll(classType,table);
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    /**
     * For register
     */
    public static boolean checkUserName(String userName){
        if (  userName != null && userName.length() > 4  ){
            return daoMySQL.checkUserName(userName);
        }
        return false;
    }

    public static boolean checkTeamName(String teamName){
        if (  teamName != null && teamName.length() > 2  ){
            return daoMySQL.checkTeamName(teamName);

        }
        return false;
    }

    /**
     * For login
     */
    public static Subscriber validateLogin(String username, String pass){
        return daoMySQL.getSubscriber(username,pass);
    }


    public static RegistrationRequest getNextRequest(){
        Object request =  daoMySQL.get(RegistrationRequest.class,next_req_id);
       return ((RegistrationRequest) request);
    }


//    public static Alert getNextAlert(){
//        Object request =  daoMySQL.get(RegistrationRequest.class,next_req_id);
//        return ((Alert) request);
//    }



    public static synchronized void incrementReqID() {
         next_req_id++;
    }

    public static synchronized int getNext_req_id() {
        return next_req_id;
    }

    public static synchronized void setNext_req_id(int next_req_id) {
        DBManager.next_req_id = next_req_id;
    }
}
