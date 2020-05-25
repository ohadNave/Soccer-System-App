package com.example.demo.DomainLayer.Users;
import com.example.demo.DomainLayer.Enums.Certification;
import com.example.demo.DomainLayer.Enums.CoachRole;
import com.example.demo.DomainLayer.LeagueManagment.PrivatePage;
import com.example.demo.DomainLayer.LeagueManagment.Team;
import com.example.demo.DomainLayer.MyFactory;
import javax.persistence.*;
import java.io.Serializable;
import static com.example.demo.DemoApplication.LOG;

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
        LOG.info("A new coach created, id: " + getSid());
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
            LOG.info("A private page was updated by: "+ getSid());
            return true;
        }
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
            LOG.info("A new role was set to coach id: " +getSid() +"role: "+role.name());
            return true;
        }
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
