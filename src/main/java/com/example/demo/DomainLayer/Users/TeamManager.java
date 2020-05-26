package com.example.demo.DomainLayer.Users;

import com.example.demo.DomainLayer.Alerts.Alert;
import com.example.demo.DomainLayer.DBManager;
import com.example.demo.DomainLayer.Enums.CoachRole;
import com.example.demo.DomainLayer.Enums.PlayerRole;
import com.example.demo.DomainLayer.LeagueManagment.Team;
import com.example.demo.DomainLayer.LeagueManagment.TeamManagerPremissions;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

import static com.example.demo.DemoApplication.errorLogger;
import static com.example.demo.DemoApplication.eventLogger;

@Entity
public class TeamManager extends SystemUser implements Observer , Serializable {

    @OneToOne
    private Owner owner;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @OneToOne
    private TeamManagerPremissions premissions;

    @OneToMany
    private List<Alert> alerts;


    public TeamManager() {
        this.premissions = new TeamManagerPremissions();
        this.alerts = new LinkedList<>();
    }

    public void setAttributes(int sid){
        setSid(sid);
    }

    public void setPermissions(boolean addPlayerPermission, boolean removePlayerPermission, boolean editPlayerRolePermission, boolean addCoachPermission, boolean removeCoachPermission, boolean editCoachRolePermission, boolean addFieldPermission, boolean removeFieldPermission, boolean editFieldNamePermission){
        premissions.setTeamManagerPremissions( addPlayerPermission,  removePlayerPermission,  editPlayerRolePermission,  addCoachPermission,  removeCoachPermission,  editCoachRolePermission,  addFieldPermission,  removeFieldPermission,  editFieldNamePermission);
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
                this.alerts.add(alert);
                DBManager.updateObject(this);
                return true;
            }
        return false;
    }


    public void setOwner(Owner owner) {
        this.owner = owner;
    }


    public boolean addPlayers(Set<Integer> players){
        if(this.premissions.AddPlayerPermission() && owner != null ){
            eventLogger.info("New Players were added to team: "+team.getName()+" ,by Team Manager: "+this.getSid());
            return owner.addPlayers(players);
        }
        errorLogger.error("Team Manager: "+ this.getSid()+ " failed to add Players to Team: "+team.getName());
        return false;
    }

    public boolean removePlayer(int player){
        if( this.premissions.RemovePlayerPermission() && owner != null ){
            eventLogger.info("New Players were removed from team: "+team.getName()+" ,by Team Manager: "+this.getSid());

            return owner.removePlayer(player);
        }
        errorLogger.error("Team Manager: "+ this.getSid()+ " failed to remove Players from Team: "+team.getName());
        return false;
    }

    public boolean editPlayerRole(int player, PlayerRole role){
        if(this.premissions.EditPlayerRolePermission() && owner != null ){
            eventLogger.info("A new Role: "+ role.name() +"set to Player: "+player+ " ,by: "+this.getSid());
            return owner.editPlayerRole(player,role);
        }
        errorLogger.error("Team Manager: "+ this.getSid()+ " failed to edit Player role to Team: "+team.getName());
        return false;
    }

    public boolean addCoach(int coach_id) {
        if( premissions.AddCoachPermission() && owner != null ){
            eventLogger.info("A new Coach: " + coach_id+ " was added to Team: "+this.getSid()+" ,by: "+this.getSid());
            return owner.addCoach(coach_id);
        }
        errorLogger.error("Team Manager: "+ this.getSid()+ " failed to add owner to Team: "+team.getName());
        return false;
    }

    public boolean removeCoach(int coid) {
        if( premissions.RemoveCoachPermission() && owner != null){
            eventLogger.info("A new Coach: " + coid+ " was removed from Team: "+this.getSid()+" ,by: "+this.getSid());

            return owner.removeCoach(coid);
        }
        errorLogger.error("Team Manager: "+ this.getSid()+ " failed to remove Coach from Team: "+team.getName());
        return false;
    }

    public boolean editCoachRole(int coach, CoachRole role){
        if( premissions.EditCoachRolePermission() && owner != null){
            eventLogger.info("A new Role: "+ role.name() +"set to Coach: "+coach+ " ,by: "+this.getSid());
            return owner.editCoachRole(coach,role);
        }
        errorLogger.error("Team Manager: "+ this.getSid()+ " failed to edit Role to Coach: "+coach);

        return false;
    }

    public boolean addField(int field) {
        if( premissions.AddFieldPermission()){
            return owner.addField(field);
        }
        return false;
    }

    public boolean removeField(int fid) {
        if( premissions.RemoveFieldPermission()){
           owner.removeField(fid);
           return true;
        }
        return false;
    }

    public boolean editFieldName(int field, String newName){
        if( premissions.EditFieldNamePermission()){
            return owner.editFieldName(field,newName);
        }
        return false;
    }

    public List<Alert> getAlerts() {
        return alerts;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Owner getOwner() {
        return owner;
    }

    public TeamManagerPremissions getPremissions() {
        return premissions;
    }

    public void setPremissions(TeamManagerPremissions premissions) {
        this.premissions = premissions;
    }

    public void setAlerts(List<Alert> alerts) {
        this.alerts = alerts;
    }
}
