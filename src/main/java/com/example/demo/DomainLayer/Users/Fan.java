package com.example.demo.DomainLayer.Users;

import com.example.demo.DomainLayer.Alerts.Alert;
import com.example.demo.DomainLayer.DBManager;
import com.example.demo.DomainLayer.LeagueManagment.Complain;
import com.example.demo.DomainLayer.LeagueManagment.Game;
import com.example.demo.DomainLayer.LeagueManagment.PrivatePage;
import com.example.demo.DomainLayer.MyFactory;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.*;

import static com.example.demo.DemoApplication.errorLogger;
import static com.example.demo.DemoApplication.eventLogger;

/**
 * Done.
 */
@Entity
public class Fan extends SystemUser implements Observer, Serializable {

    @OneToMany
    private Set<Complain> myComplains;

    @OneToMany
    private Set<PrivatePage> followingPrivatePages;

    @OneToMany
    private Set<Game> followingMatches;

    @ElementCollection
    private Set<String> searchHistory;

    @OneToMany
    private List<Alert> alerts;


    public Fan () {
        followingPrivatePages = new HashSet<>();
        myComplains = new HashSet<>();
        searchHistory = new HashSet<>();
        alerts = new LinkedList<>();
        followingMatches = new HashSet<>();
    }


    public void setAttributes(int sid){
        setSid(sid);
    }

    /**
     * DB care required
     *
     * UC 3.2
     * In this case pid isn't a number,it is a string represent team name or player name.
     * Adding this fan as a new observer of the argument private page in order to take care of future alerts.
     */
    public boolean followPage(PrivatePage privatePage){
      //  if(DBManagerStub.getPrivatePage(pid) != null){
            followingPrivatePages.add(privatePage);
         //   DBManagerStub.getPrivatePage(pid).addFollower(getSid());
            eventLogger.info( " the fan: "+getSid() + " started to follow the page: "+ privatePage.getPageId());
            return true;
    //    }
    //    return false;
    }

    /**
     * UC 3.3
     */
    public boolean signForMatchAlerts(Game match){
        //Match tempMatch = DBManagerStub.getMatch(mid);
        if ( match != null){
            match.addMatchFollower(this);
            this.followingMatches.add(match);
            eventLogger.info( " the fan: "+getSid() + " signed for match alerts, match: "+ match.getId());
            return true;
        }
        errorLogger.error( " the fan: "+getSid() + " failed to sign for match alerts");

        return false;
    }


    public boolean unsignForMatchAlerts(int mid){
        Game match = (Game) DBManager.getObject(Game.class,mid);
        if (match != null){
            this.followingMatches.remove(mid);
            match.deleteMatchFollower(this.getSid());
            eventLogger.info( " the fan: "+getSid() + " unsigned from match alerts, match: "+ match.toString());
            return true;
        }
        return false;
    }

    /**
     * UC 3.4
     */
    public boolean sendComplain(Date date, String content){
        if (content != null && date!=null){
            Complain complain = MyFactory.createComplain(date,content);
            myComplains.add(complain);
            DBManager.updateObject(this);
            //DBManagerStub.addComplain(complain.getCid(),complain);
            eventLogger.info( " the fan: "+getSid()+ " opened a new complain: "+ complain.cid);
            return true;
        }
        return false;
    }


    /**
     * UC 3.5
     * override searchByName method in system user class in order to preserve search history for fan.
     */
    public HashSet<Object> searchByName(String searchWord){
//        if ( searchWord != null && !searchWord.isEmpty()){
//            searchHistory.add(searchWord);
//            return DBManagerStub.searchByName(searchWord);
//        }
        return null;
    }


    /**
     * fan alerts handler for match events and private pages new content.
     * @param o - represent the notifying object, Match or PrivatePage in fan case.
     * @param arg - the relevant alert(GameEventAlert/GameDateChangedAlert/GameEndedAlert/NewPostOnPageAlert).
     */
    @Override
    public void update(Observable o, Object arg) {
        if (o != null && arg != null) {

                // FOR MATCH ADD EVENT ALERT(foul/goal..) or MATCH ENDED ALERT(3:0 Real Madrid - Barcelona..) or MATCH DATE CHANGED ALERT.
                if (o instanceof Game) {
                    if (this.followingMatches != null && this.followingMatches.contains(((Game) o).getId())) {
                        handleAlert(((Alert) arg));
                    }
                }

                // FOR TEAM PRIVATE PAGE ALERT(news on private page..)
                if (o instanceof PrivatePage) {
                    if (this.followingPrivatePages != null && followingPrivatePages.contains((((PrivatePage) o).getPageId()))) {
                        handleAlert(((Alert) arg));
                    }
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
    public Set<Complain> getMyComplains() {
        return myComplains;
    }

    public void setMyComplains(HashSet<Complain> myComplains) {
        this.myComplains = myComplains;
    }

    public Set<PrivatePage> getFollowingPrivatePages() {
        return followingPrivatePages;
    }

    public void setFollowingPrivatePages(HashSet<PrivatePage> followingPrivatePages) { this.followingPrivatePages = followingPrivatePages; }

    public Set<String> getSearchHistory() {
        return searchHistory;
    }

    public void setSearchHistory(HashSet<String> searchHistory) {
        this.searchHistory = searchHistory;
    }

    public List<Alert> getAlerts() {
        return alerts;
    }

    public void setAlerts(List<Alert> alerts) {
        this.alerts = alerts;
    }

    public Set<Game> getFollowingMatches() {
        return followingMatches;
    }

    public void setMyComplains(Set<Complain> myComplains) {
        this.myComplains = myComplains;
    }

    public void setFollowingPrivatePages(Set<PrivatePage> followingPrivatePages) {
        this.followingPrivatePages = followingPrivatePages;
    }

    public void setFollowingMatches(Set<Game> followingMatches) {
        this.followingMatches = followingMatches;
    }

    public void setSearchHistory(Set<String> searchHistory) {
        this.searchHistory = searchHistory;
    }
}
