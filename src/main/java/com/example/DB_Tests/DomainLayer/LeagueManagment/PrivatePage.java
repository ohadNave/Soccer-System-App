package com.example.DB_Tests.DomainLayer.LeagueManagment;
import com.example.DB_Tests.DomainLayer.Alerts.Alert;
import com.example.DB_Tests.DomainLayer.Alerts.I_Observer.ISubjectPrivatePage;
import com.example.DB_Tests.DomainLayer.MyFactory;
import com.example.DB_Tests.DomainLayer.Users.Fan;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "private_page")
public class PrivatePage extends Observable implements ISubjectPrivatePage, Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int pid;

    @ElementCollection
    private List<String> content;

    @OneToMany
    private Set<Fan> followers;


    public PrivatePage(){
        this.followers = new HashSet<>();
        this.content = new LinkedList<>();
    }

    /*
    getters and setters.
     */

    public boolean addContentToPage(String newContent) {
        if (this.content != null && !newContent.isEmpty()){
            Alert newPostOnPageAlert = MyFactory.createNewPostOnPageAlert(this,newContent);
            this.content.add(newContent);
            notifyPageFollowers(newPostOnPageAlert);
            return true;
        }
        return false;
    }

    /**
     * DB care required.
     */
    public void notifyPageFollowers(Alert newPostOnPageAlert){
        if (newPostOnPageAlert != null){
            for (Fan fan : followers){
                //Fan fan = DBManagerStub.getFan(follower);
                fan.update(this,newPostOnPageAlert);
            }
        }
    }


    public int getPageId() { return pid; }

    public Set<Fan> getFollowers() {
        return followers;
    }

    public void setFollowers(HashSet<Fan> followers) {
        if(followers!=null && !followers.isEmpty()){
            this.followers = followers;
        }
    }


    public List<String> getContent() { return content; }


    /**
     * DB care required.
     */
    public boolean addFollower(Fan fan){
//        if (this.followers != null && !this.followers.contains(fan) && DBManagerStub.getFan(fan) != null){
            if (this.followers != null && !this.followers.contains(fan)){
            this.followers.add(fan);
            return true;
        }
        return false;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public void setContent(List<String> content) {
        this.content = content;
    }

    public void setFollowers(Set<Fan> followers) {
        this.followers = followers;
    }


}
