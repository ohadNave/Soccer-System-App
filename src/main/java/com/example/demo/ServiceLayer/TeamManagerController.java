package com.example.demo.ServiceLayer;


import com.example.demo.DomainLayer.Enums.CoachRole;
import com.example.demo.DomainLayer.Enums.PlayerRole;
import com.example.demo.DomainLayer.Users.TeamManager;

import java.util.Set;


public class TeamManagerController {

    private TeamManager teamManager;

    /**
     * Editing team assets buttons after a permission from team's owner.
     */

    public void addPlayer(Set<Integer> player_ids)  { this.teamManager.addPlayers(player_ids); }

    public void removePlayer(int pid){
        this.teamManager.removePlayer(pid);
    }

    public void editPlayerRole(int pid, PlayerRole role){
        this.teamManager.editPlayerRole(pid, role);
    }

    public void addCoach(int coid) {
        this.teamManager.addCoach(coid);
    }

    public void removeCoach(int coid) {
        this.teamManager.removeCoach(coid);
    }

    public void editCoachRole (int coid, CoachRole role){
        this.teamManager.editCoachRole(coid,role);
    }

    public void addField(int field_id) {
        this.teamManager.addField(field_id);
    }

    public void removeField(int field_id) {
        this.teamManager.removeField(field_id);
    }

    public void editFieldName(int field_id, String newName){
        this.teamManager.editFieldName(field_id,newName);
    }

}
