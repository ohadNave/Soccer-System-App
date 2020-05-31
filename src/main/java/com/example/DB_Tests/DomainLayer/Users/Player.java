package com.example.DB_Tests.DomainLayer.Users;

import com.example.DB_Tests.DomainLayer.DBManager;
import com.example.DB_Tests.DomainLayer.Enums.PlayerRole;
import com.example.DB_Tests.DomainLayer.LeagueManagment.PrivatePage;
import com.example.DB_Tests.DomainLayer.LeagueManagment.Team;
import com.example.DB_Tests.DomainLayer.MyFactory;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

import static com.example.DB_Tests.DemoApplication.errorLogger;
import static com.example.DB_Tests.DemoApplication.eventLogger;

/**
 * Done
 */
@Entity
public class Player extends SystemUser implements Serializable {


    @Enumerated(EnumType.STRING)
    private PlayerRole role;

    private LocalDate date_of_birth;

    @OneToOne (cascade = {CascadeType.ALL})
    private PrivatePage private_page;


    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team Team;


    public void setAttributes(PlayerRole role, LocalDate dateOfBirth, int sid) {
        setSid(sid);
        setRole(role);
        setDateOfBirth(dateOfBirth);
        setPrivate_page(MyFactory.createPrivatePage());
    }



    /**
     * UC 4.2
     *  Update player private page with new content, and send alerts to player's private page followers in accordance.
     */
    public boolean updatePrivatePage(String content){
        if ( !content.isEmpty() ){
            //DBManagerStub.getPrivatePage(privatePage.getPageId()).addContentToPage(content);
            private_page.addContentToPage(content);
            eventLogger.info("A private page was updated by: "+ getSid());
            return true;
        }
        errorLogger.error("A private page was failed to update by: "+ getSid());
        return false;
    }


    /*
    getters and setters.
    */

    public boolean setRole(PlayerRole role){
        if(role != null){
            this.role = role;
            DBManager.updateObject(this);
            return true;
        }
        return false;
    }

    public boolean setDateOfBirth(LocalDate date){
        if(date!=null){
            date_of_birth = date;
            DBManager.updateObject(this);
            return true;
        }
        return false;
    }

    public void setPrivate_page(PrivatePage privatePage) {
        this.private_page = privatePage;
        DBManager.updateObject(this);
    }

    public void setTeam(Team team) {
        this.Team = team;
        DBManager.updateObject(this);
    }


    public PlayerRole getRole() {
        return role;
    }

    public LocalDate getDate_of_birth() {
        return date_of_birth;
    }

    public PrivatePage getPrivate_page() {
        return private_page;
    }
    @ManyToOne
    public Team getTeam() {
        return Team;
    }


}
