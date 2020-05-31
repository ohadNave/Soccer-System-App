package com.example.DB_Tests.DomainLayer.Users;
import com.example.DB_Tests.DomainLayer.Enums.Certification;
import com.example.DB_Tests.DomainLayer.Enums.CoachRole;
import com.example.DB_Tests.DomainLayer.LeagueManagment.PrivatePage;
import com.example.DB_Tests.DomainLayer.LeagueManagment.Team;
import com.example.DB_Tests.DomainLayer.MyFactory;
import javax.persistence.*;
import java.io.Serializable;

import static com.example.DB_Tests.DemoApplication.errorLogger;
import static com.example.DB_Tests.DemoApplication.eventLogger;

/**
 * Done
 */
@Entity
public class Coach extends SystemUser implements Serializable{


    @Enumerated(EnumType.STRING)
    private CoachRole role;

    @Enumerated(EnumType.STRING)
    private Certification certification;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @OneToOne(cascade = {CascadeType.ALL})
    private PrivatePage private_page;


    public void setAttributes(int sid , CoachRole role, Certification certification){
        setPrivate_page(MyFactory.createPrivatePage());
        setSid(sid);
        setRole(role);
        setCertification(certification);
    }

    /**
     * UC 5.2
     * Update coach private page with new content, and send alerts to player's private page followers in accordance.
     */
    public boolean updatePrivatePage(String content){
        if ( content != null && !content.isEmpty()){
         //   PrivatePage privatePage = DBManagerStub.getPrivatePage(this.privatePage.getPageId());
            private_page.addContentToPage(content);
           // DBManagerStub.addPrivatePage(this.privatePage.getPageId());
            eventLogger.info("A private page was updated by: "+ getSid());
            return true;
        }
        errorLogger.error("A private page was failed to update by: "+ getSid());
        return false;
    }


    // GETTERS & SETTERS

    public boolean setCertification(Certification certification) {
        if (certification != null){
            this.certification = certification;
            return true;
        }
        return false;
    }

    public Certification getCertification() {
        return certification;
    }

    public boolean setRole(CoachRole role){
        if(role!=null){
            this.role = role;
            eventLogger.info("A new role was set to coach id: " +getSid() +"role: "+role.name());
            return true;
        }
        errorLogger.error("A new role was failed to set to coach id: " +getSid());
        return false;
    }

    public CoachRole getRole() {
        return role;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public PrivatePage getPrivate_page() {
        return private_page;
    }

    public void setPrivate_page(PrivatePage privatePage) {
        this.private_page = privatePage;
    }
}
