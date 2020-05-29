package com.example.demo.DomainLayer;

import com.example.demo.DataLayer.DaoMySQL;
import com.example.demo.DomainLayer.Alerts.Alert;
import com.example.demo.DomainLayer.Request.RegistrationRequest;
import com.example.demo.DomainLayer.Users.*;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.example.demo.DemoApplication.errorLogger;
import static com.example.demo.DemoApplication.eventLogger;

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
            errorLogger.error("database lost connection, unable to get object id: " +id+", class: "+ classType);
            errorLogger.error(e);
            return null;
        }
    }

    public static synchronized void saveObject(Object o){
        try{
            daoMySQL.save(o);
            String objName = o.getClass().getName();
            eventLogger.info("A new object: " + objName+ " was added to the dataBase");
        }
        catch (Exception e){
            errorLogger.error("database lost connection, unable to save object: "+o);
            errorLogger.error(e);
        }
    }

    public static synchronized void updateObject(Object o){
        try{
            String objName = o.getClass().getName();
            daoMySQL.update(o);
            eventLogger.info("A new object: " + objName+ " was updated in the dataBase");

        }
        catch (Exception e){
            errorLogger.error("database lost connection, unable to update object: "+o);
            errorLogger.error(e);
        }
    }

    public static void removeObject(Object o){
        try{
            String objName = o.getClass().getName();
            daoMySQL.delete(o);
            eventLogger.info("A new object: " + objName+ " was removed from the dataBase");
        }
        catch (Exception e){
            errorLogger.error("database lost connection, unable to remove object: "+o);
            errorLogger.error(e);
        }
    }

    public static void detachObject(Object o){
        try{
            daoMySQL.detach(o);
        }
        catch (Exception e){
            errorLogger.error("database lost connection, unable to detach object: "+o);
            errorLogger.error(e);
        }
    }

    public static List<Object> getListOfObjects(Class classType, String table){
        try{
            return daoMySQL.getAll(classType,table);
        }
        catch (Exception e){
            errorLogger.error("database lost connection, unable to get list of objects");
            errorLogger.error(e);
            return null;
        }
    }

    public static Subscriber getByUserName(String userName){
        return daoMySQL.getByUserName(userName);
    }

    /**
     * For register
     */
    public static boolean checkUserName(String userName){
        if (userName != null && userName.length() > 4){
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
