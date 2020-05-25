package com.example.demo.DomainLayer.Users;

import com.example.demo.DomainLayer.Alerts.Alert;
import com.example.demo.DomainLayer.DBManager;
import com.example.demo.DomainLayer.LeagueManagment.Complain;
import com.example.demo.DomainLayer.LeagueManagment.Team;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import static com.example.demo.DemoApplication.LOG;

@Entity
public class sysMan extends SystemUser implements Observer, Serializable {

    @OneToMany
    private static List<Alert> alerts;

    @Column(columnDefinition = "boolean default false")
    private boolean active;


    public sysMan() {
        this.active = false;
        alerts = new LinkedList<>();
    }

    public void setAttributes(int sid){
        setSid(sid);
    }

    public Subscriber createNewSystemManager(String name, String userName, String password){
        if(DBManager.checkUserName(userName)){
            Subscriber subscriber = new Subscriber();
            subscriber.setAttributes(userName,password,name);
            subscriber.makeSystemManagerActive();
            return subscriber;
        }
        return null;
    }


    /**
     * UC 8.1
     * In case of closing team permanently by system user.
     * Takes care of the friendly pointers between relevant team and all of its owners and set them to -1(null).
     */
    public boolean closeTeamPermanently(int tid){
        Team team = (Team) DBManager.getObject(Team.class,tid);
        if ( team!=null ){
            team.closeTeamPermanently();
//            DBManagerStub.closedTeamPermanantly(team.getTid());
            LOG.info("A team: "+team.getName() +"was closed permanently by the system manager");
            return true;
        }
        return false;
    }


    /**
     * UC 8.2
     */
    public boolean removeSubscriber(int sid){
        Subscriber subscriber = ((Subscriber) DBManager.getObject(Subscriber.class, sid));
        if (subscriber != null){
            DBManager.removeObject(subscriber);
            LOG.info("A subscriber: "+ sid + " was removed by the system manager");
            return true;
        }
        return false;
    }

    /**
     *  UC 8.3
     */
    public boolean respondToUserComplain(int cid, String respond){
        Complain complain = (Complain) DBManager.getObject(Complain.class, cid);
        if ( complain!=null && respond!=null && !respond.isEmpty() ){
            complain.setSystemManagerRespond(respond);
            DBManager.updateObject(complain);
            LOG.info("system manager responded to complain id: " +cid);
            return true;
        }
        return false;
    }


    /**
     * Alert - called from team class in case of closing team by its owner.
     * @param o - represents team object.
     * @param arg - TeamIsNowNotActiveAlert.
     */
    @Override
    public void update(Observable o, Object arg) {
        if (o != null && arg != null){
            if (o instanceof Team && arg instanceof Alert) {
                handleAlert(((Alert) arg));
            }
        }
    }


    public boolean handleAlert(Alert alert){
        if (alert != null){
            alerts.add(alert);
            DBManager.updateObject(this);
            return true;
        }
        return false;
    }

    /*
        getters and setters.
     */



    public  List<Alert> getAlerts() {
        return alerts;
    }

    public  void setAlerts(List<Alert> alerts) {
        sysMan.alerts = alerts;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


    /**
     * Duplicate adding to sub structurs - must change!
     */


    public boolean addFar(String userName, String password, String name){
        if (userName != null && password != null && name != null){
            if(DBManager.checkUserName(userName) && !password.isEmpty() && !name.isEmpty()){
                Subscriber subscriber = new Subscriber();
                subscriber.setAttributes(userName,password,name);
                subscriber.makeFARActive();
                return true;
            }
        }
        return false;
    }


//    public boolean handleRegistrationRequest(RegistrationRequest registrationRequest, boolean approved){
//        if(registrationRequest != null && approved){
//            Subscriber subscriber = registrationRequest.getSubscriber();
//
//
//        }
//        return false;
//
//    }

}
