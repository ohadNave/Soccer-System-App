package com.example.demo.DomainLayer.Users;

import com.example.demo.DomainLayer.Alerts.Alert;
import com.example.demo.DomainLayer.DBManager;
import com.example.demo.DomainLayer.Enums.CoachRole;
import com.example.demo.DomainLayer.Enums.PlayerRole;
import com.example.demo.DomainLayer.LeagueManagment.Team;
import com.example.demo.DomainLayer.LeagueManagment.TeamBySeason;
import com.example.demo.DomainLayer.MyFactory;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

import static com.example.demo.DemoApplication.errorLogger;
import static com.example.demo.DemoApplication.eventLogger;

@Entity
public class Owner extends SystemUser implements Observer, Serializable {

    @OneToOne (fetch = FetchType.EAGER)
    private Team team;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Owner> owners;

    @OneToMany(cascade = CascadeType.ALL)
    @Column(name = "alert")
    private List<Alert> alerts;

    @ElementCollection
    private List<String> prevAlerts;


    public Owner() {
        owners = new HashSet<>();
        alerts = new ArrayList<>();
        prevAlerts= new ArrayList<>();
    }


    public void setAttributes(int sid){
        setSid(sid);
    }

    /**
     * UC 6.1
    */
    public boolean addPlayers(Set<Integer> players){
        if( team != null && players != null ){
                if(team.addPlayers(players)){
                    eventLogger.info("New players were added to the team: " + this.team.getTid()+" by: "+ getSid());
                    return true;
                }
        }
        errorLogger.error("New players were failed to add to the team: " + this.team.getTid()+" by: "+ getSid());

        return false;
    }


    public boolean removePlayer(int player_id){
        if(this.team != null ){
            if(team.removePlayer(player_id)) {
                return  true;
            }

        }
        return false;
    }

    public boolean editPlayerRole(int player_id, PlayerRole role){
        if( this.team != null  && role != null ){
            if(team.editPlayerRole(player_id, role)){
                return  true;
            }
        }
        return false;
    }

    public boolean addCoach(int coach_id) {
        if( team != null ){
            if (!team.getCoaches().contains(coach_id)){
                if( team.addCoach(coach_id)){
                    return  true;
                }
            }
        }
        return false;
    }

    public boolean removeCoach(int coid) {
        if( this.team != null ){
            if(team.removeCoach(coid)){
                return  true;
            }

        }
        return false;
    }

    public boolean editCoachRole (int coach, CoachRole role){
        if( this.team != null  && role != null ){
            if(team.editCoachRole(coach,role)){
                return  true;
            }

        }
        return false;
    }

    public boolean addField( int field_id) {
        if( this.team != null ){
            return team.addField(field_id);

        }
        return false;
    }

    public boolean removeField(int field_id) {
        if( this.team != null ){
            if(team.removeField(field_id)){
                return true;
            }


        }
        return false;
    }

    public boolean editFieldName(int field_id, String newName){
        if( this.team != null  && newName != null && !newName.isEmpty() ){
            if(team.editFieldName(field_id, newName)){
                return true;
            }
        }
        return false;
    }

    /**
     * UC 6.2
     * In case of existing owner who would like to create another owner for his team.
     */
    public boolean createNewOwner(int sid){
        Subscriber newSubscriberOwner = ((Subscriber) DBManager.getObject(Subscriber.class, sid));
        if(newSubscriberOwner != null){
            newSubscriberOwner.makeOwnerActive();
            owners.add(newSubscriberOwner.getOwner());
            eventLogger.info("A new owner " + sid + ", was set to the team: "+ team.getTid()+" by: " +getSid());
            //DBManagerStub.updateObject(newSubscriberOwner);
            return true;
        }
        errorLogger.error("A new owner " + sid + ", was failed to set to the team: "+ team.getTid()+" by: " +getSid());
        return false;
    }

    /**
     * UC 6.3
     * recursive function - delete an owner and all of his past owner creations recursively.
     */
    public boolean removeOwner(int ownerToDelete){
        Owner deletedOwner = (Owner) DBManager.getObject(Owner.class, ownerToDelete);
        for(Owner owner : deletedOwner.owners){
            removeOwner(owner.getSid());
            deletedOwner.owners.remove(owner);
            owner.setTeam(null);
            eventLogger.info("A new owner " + owner + ", was removed from the team: "+ team.getTid()+" by: " +getSid());
        }
        owners.remove(deletedOwner);
        deletedOwner.setTeam(null);
        return true;
    }

    /**
     *UC 6.4
     */
    public boolean addTeamManager(int tmid) {
        if( this.team != null ){
            TeamManager teamManager = ((TeamManager) DBManager.getObject(TeamManager.class, tmid));
            if(team.addTeamManager(teamManager)){
                teamManager.setOwner(this);
                DBManager.updateObject(this);
                eventLogger.info("A new team manager " + tmid + " was added to team: "+ team.getTid() +". Made by owner: " + getSid());
                return true;
            }
        }
        eventLogger.error("A new team manager " + tmid + " was failed to add to team. Made by owner: " + getSid());
        return false;
    }

    /**
     * UC 6.5
     */
    public boolean deleteTeamManager(int teamManager){
        if( this.team != null ){
            if(team.deleteTeamManager(teamManager)){
                DBManager.updateObject(this);
                eventLogger.info("The team manager "+ teamManager+" was deleted from team: "+ team.getTid() +". Made by owner: " + getSid());
                return true;
            }
        }
        errorLogger.error("The team manager "+ teamManager+" was failed to delete from team. Made by owner: " + getSid());
        return false;
    }

    /**
     *UC 6.6
     * Owner can close his team.
     * In this case the team becomes not active and alerts being sent to other team's owner,team managers and system mangers.
     */
    public boolean closeTeam(){
        if ( this.team != null ){
            if (team.isActive()){
                team.setTeamNotActive();
                eventLogger.info("The team " + team.getTid() + " was closed by Owner: " + getSid() );
                return true;
            }
        }
        errorLogger.error("The team " + team.getTid() + " was failed to close by Owner: " + getSid() );
        return false;
    }


    /**
     * UC 6.7
     * all the methods below relevant for owner financial control for any given team of his.
     */
    public double getSellingPlayersIncome(int currentYear ,int quarter) {
        if( team != null ) {
            Set<TeamBySeason> teamBySeasons = team.getTeam_seasons();
            for (TeamBySeason teamBySeason : teamBySeasons){
                if (teamBySeason.getYear() == currentYear){
                    return teamBySeason.getSellingPlayersIncome(quarter);
                }
            }
        }
        return -1;
    }

    public boolean incrementSellingPlayersIncome(int currentYear , int quarter, double sellingPlayersIncome) {
        if( team != null ) {
            Set<TeamBySeason> teamBySeasons = team.getTeam_seasons();
            for (TeamBySeason teamBySeason : teamBySeasons){
                if (teamBySeason.getYear() == currentYear){
                     if(teamBySeason.incrementSellingPlayersIncome(quarter,sellingPlayersIncome)){
                         DBManager.updateObject(this);
                         return true;
                     }
                }
            }
        }
        return false;
    }

    public double getBuyingPlayersOutcome( int currentYear ,int quarter) {
        if( team != null ) {
            Set<TeamBySeason> teamBySeasons = team.getTeam_seasons();
            for (TeamBySeason teamBySeason : teamBySeasons){
                if (teamBySeason.getYear() == currentYear){
                    return teamBySeason.getBuyingPlayersOutcome(quarter);
                }
            }
        }
        return -1;
    }




    public boolean incrementBuyingPlayersOutcome(int currentYear, int quarter, double buyingPlayersOutcome) {
        if( team != null ) {
            Set<TeamBySeason> teamBySeasons = team.getTeam_seasons();
            for (TeamBySeason teamBySeason : teamBySeasons){
                if (teamBySeason.getYear() == currentYear){
                    if(teamBySeason.incrementBuyingPlayersOutcome(quarter,buyingPlayersOutcome)){
                        DBManager.updateObject(this);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public double getMatchesIncome(int currentYear ,int quarter) {
        if( team != null ) {
            Set<TeamBySeason> teamBySeasons = team.getTeam_seasons();
            for (TeamBySeason teamBySeason : teamBySeasons){
                if (teamBySeason.getYear() == currentYear){
                    return teamBySeason.getMatchesIncome(quarter);
                }
            }
        }
        return -1;
    }

    public boolean incrementMatchesIncome(int currentYear, int quarter, double matchesIncome) {
        if( team != null ) {
            Set<TeamBySeason> teamBySeasons = team.getTeam_seasons();
            for (TeamBySeason teamBySeason : teamBySeasons){
                if (teamBySeason.getYear() == currentYear){
                    if(teamBySeason.incrementMatchesIncome(quarter,matchesIncome)){
                        DBManager.updateObject(this);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public double getMatchesOutcome(int currentYear ,int quarter) {
        if( team != null ) {
            Set<TeamBySeason> teamBySeasons = team.getTeam_seasons();
            for (TeamBySeason teamBySeason : teamBySeasons){
                if (teamBySeason.getYear() == currentYear){
                    return teamBySeason.getMatchesOutcome(quarter);
                }
            }
        }
        return -1;
    }

    public boolean incrementMatchesOutcome(int currentYear, int quarter, double matchesOutcome) {
        if( team != null ) {
            Set<TeamBySeason> teamBySeasons = team.getTeam_seasons();
            for (TeamBySeason teamBySeason : teamBySeasons){
                if (teamBySeason.getYear() == currentYear){
                    if(teamBySeason.incrementMatchesOutcome(quarter,matchesOutcome)){
                        DBManager.updateObject(this);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public double getSalariesOutcome(int currentYear ,int quarter) {
        if( team != null ) {
            Set<TeamBySeason> teamBySeasons = team.getTeam_seasons();
            for (TeamBySeason teamBySeason : teamBySeasons){
                if (teamBySeason.getYear() == currentYear){
                    return teamBySeason.getSalariesOutcome(quarter);
                }
            }
        }
        return -1;
    }

    public boolean incrementSalariesOutcome( int currentYear, int quarter, double salariesOutcome) {
        if( team != null ) {
            Set<TeamBySeason> teamBySeasons = team.getTeam_seasons();
            for (TeamBySeason teamBySeason : teamBySeasons){
                if (teamBySeason.getYear() == currentYear){
                    if(teamBySeason.incrementSalariesOutcome(quarter,salariesOutcome)){
                        DBManager.updateObject(this);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public double getOwnerInvestmentIncome( int currentYear ,int quarter) {
        if( team != null ) {
            Set<TeamBySeason> teamBySeasons = team.getTeam_seasons();
            for (TeamBySeason teamBySeason : teamBySeasons){
                if (teamBySeason.getYear() == currentYear){
                    return teamBySeason.getOwnerInvestmentIncome(quarter);
                }
            }
        }
        return -1;
    }

    public boolean incrementOwnerInvestmentIncome( int currentYear, int quarter, double ownerInvestmentIncome) {
        if( team != null ) {
            Set<TeamBySeason> teamBySeasons = team.getTeam_seasons();
            for (TeamBySeason teamBySeason : teamBySeasons){
                if (teamBySeason.getYear() == currentYear){
                    if(teamBySeason.incrementOwnerInvestmentIncome(quarter,ownerInvestmentIncome)){
                        DBManager.updateObject(this);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public double getAdvertiseIncome(int currentYear ,int quarter) {
        if( team != null ) {
            Set<TeamBySeason> teamBySeasons = team.getTeam_seasons();
            for (TeamBySeason teamBySeason : teamBySeasons){
                if (teamBySeason.getYear() == currentYear){
                    return teamBySeason.getAdvertiseIncome(quarter);
                }
            }
        }
        return -1;
    }

    public boolean incrementAdvertiseIncome(int currentYear, int quarter, double AdvertiseIncome) {
        if( team != null ) {
            Set<TeamBySeason> teamBySeasons = team.getTeam_seasons();
            for (TeamBySeason teamBySeason : teamBySeasons){
                if (teamBySeason.getYear() == currentYear){
                    if(teamBySeason.incrementAdvertiseIncome(quarter,AdvertiseIncome)){
                        DBManager.updateObject(this);
                        return true;
                    }
                }
            }
        }
        return false;
    }


    /*
    --------------------------------------------------------------------------------------------------------------------
     */

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

    /**
     * @@@@@@@@
     * @param alert
     * @return
     */
    public boolean handleAlert(Alert alert){
            if (alert != null) {
               alerts.add(alert);
                DBManager.updateObject(this);
                return true;
            }
        return false;
    }

    /**
     * In case of an owner who would like to register a new team to system.
     */
    public boolean openTeamRequest(String teamName){
        if( this.team == null && DBManager.checkTeamName(teamName)){
            MyFactory.createTeamRequest(teamName, this.getSid());
            eventLogger.info("A new team request was created by sid : "+ getSid() + ", team name: " + teamName);
            return true;
        }
        System.out.println("same team name or no current team for owner");
        return false;
    }

    /*
    getters and setters.
     */
    public boolean setTeamManagersPermissions(int teamManager, boolean addPlayerPermission, boolean removePlayerPermission, boolean editPlayerRolePermission, boolean addCoachPermission, boolean removeCoachPermission, boolean editCoachRolePermission, boolean addFieldPermission, boolean removeFieldPermission, boolean editFieldNamePermission ){
        if (teamManager != -1){
            return team.setTeamManagerPermisions( teamManager,addPlayerPermission,  removePlayerPermission,  editPlayerRolePermission,  addCoachPermission,  removeCoachPermission,  editCoachRolePermission,  addFieldPermission,  removeFieldPermission,  editFieldNamePermission);
        }
        return false;
    }

    public List<Alert> getAlerts() {
        List<Alert> newAlert = new ArrayList<>();
        for (Alert a: alerts){
            newAlert.add(a);
            prevAlerts.add(a.toString());
        }
        alerts.clear();
        return newAlert;
    }

    public void setAlerts(List<Alert> alerts) {
        this.alerts = alerts;
    }

    public List<String> getPrevAlerts() {
        return prevAlerts;
    }

    public void setPrevAlerts(List<String> prevAlerts) {
        this.prevAlerts = prevAlerts;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }

    public Set<Owner> getOwners() {
        return owners;
    }

    public void setOwners(Set<Owner> myOwners) {
        this.owners = myOwners;
        for(Owner owner : owners){
            owner.setTeam(team);
        }
    }

}
