package com.example.DB_Tests.DomainLayer.Request;

import javax.persistence.Entity;

@Entity
public class TeamRequest extends RegistrationRequest{

    private String team_name;


    public void setAttributes(String teamName, int subscriber_id){
        this.team_name = teamName;
        setSubscriber_id(subscriber_id);
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

}
