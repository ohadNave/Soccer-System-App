package com.example.DB_Tests.DomainLayer.LeagueManagment;

import com.example.DB_Tests.DomainLayer.DBManager;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Field implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int fid;

    private String name;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "team_id")
    private Team team;

    public void setAttributes(String name){
        this.name = name;
    }


    /*
    getters and setters.
     */
    public String getName() { return name; }

    public boolean setName(String name) {
        if(name != null){
            this.name = name;
            DBManager.updateObject(this);
            return true;
        }
        return false;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
        DBManager.updateObject(this);

    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
        team.addField(this.fid);
        DBManager.updateObject(this);
    }


}
