package com.example.demo.DomainLayer.Users;

import com.example.demo.DomainLayer.DBManager;
import com.example.demo.DomainLayer.Enums.Certification;
import com.example.demo.DomainLayer.Enums.CoachRole;
import com.example.demo.DomainLayer.Enums.RefereeRoll;
import com.example.demo.DomainLayer.Enums.PlayerRole;
import com.example.demo.DomainLayer.MyFactory;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Subscriber implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    protected int id;

    @Column(name = "username")
    private String userName;
    private String name;
    private String password;

    @Column(columnDefinition = "boolean default false")
    private boolean active;

    @OneToOne(cascade = {CascadeType.ALL})
    private Coach coach;
    @OneToOne(cascade = {CascadeType.ALL})
    private Player player;
    @OneToOne(cascade = {CascadeType.ALL})
    private Fan fan;
    @OneToOne(cascade = {CascadeType.ALL})
    private FAR far;
    @OneToOne(cascade = {CascadeType.ALL})
    private Referee referee;
    @OneToOne(cascade = {CascadeType.ALL})
    private Owner owner;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="tmid")
    private TeamManager teamManager;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="smid")
    private sysMan sysMan;


    public void setAttributes(String userName, String password, String name) {
        this.userName = userName;
        this.password = password;
        this.name = name;
    }





    public boolean makeCoachActive(CoachRole role, Certification certification){
        if(coach==null && role!=null && certification!=null){
            this.coach = MyFactory.createCoach(this.id,role,certification);
            DBManager.updateObject(this);
            return true;
        }
        return false;
    }

    public boolean makeCoachNotActive(){
        if( coach != null){
            coach=null;
            DBManager.updateObject(this);
            return true;
        }
        return false;
    }



    public boolean makeFanActive(){
        if(fan == null){
            this.fan = MyFactory.createFan(this.getId());
            DBManager.updateObject(this);
            return true;
        }
        return false;
    }

    public boolean makeFanNotActive(){
        if(fan != null){
            if(fan.deleteDB(this.id)){
                fan=null;
                return true;
            }
        }
        return false;
    }



    public boolean makeRefereeActive(Certification certification, RefereeRoll refereeRoll){
        if (referee == null){
            this.referee = MyFactory.createReferee(certification, refereeRoll, this.id);
            DBManager.updateObject(this);
            return true;
        }

        return false;
    }



    public boolean makeRefereeNotActive(){
        if(referee != null){
           if(referee.deleteDB(this.id)){
                referee = null;
                return true;
            }
        }
        return false;
    }


    public boolean makePlayerActive(PlayerRole role, LocalDate dateOfBirth){
        if(player == null){
            this.player = MyFactory.createPlayer(role,dateOfBirth,this.id);
            DBManager.updateObject(this);
            return true;
        }
        return false;
    }

    public boolean makePlayerNotActive(){
        if (player != null){
            if(player.deleteDB(this.id)){
                player = null;
                return true;
            }
        }
        return false;
    }


    public boolean makeTeamManagerActive(){
        if(teamManager == null){
            this.teamManager = MyFactory.createTeamManager(this.id);
            DBManager.updateObject(this);
            return true;
        }
        return false;
    }

    public boolean makeTeamManagerNotActive(){
        if(teamManager != null){
            if(teamManager.deleteDB(this.id)){
                this.teamManager = null;
                return true;
            }
        }
        return false;
    }


    public boolean makeOwnerActive(){
        if(owner == null){
            this.owner = MyFactory.createOwner(this.id);
            DBManager.updateObject(this);
            return true;
        }
        return false;
    }

    public boolean makeOwnerNotActive(){
        if(owner != null){
            if(owner.deleteDB(this.id)){
                this.owner = null;
                return true;
            }
        }
        return false;
    }



    public boolean makeFARActive(){
        if(far == null){
            this.far = MyFactory.createFar(this.id);
            DBManager.updateObject(this);
            return true;
        }
        return false;
    }

    public boolean makeFarNotActive(){
        if(far!=null){
            if(far.deleteDB(this.id)){
                far=null;
                return true;
            }
        }
        return false;
    }


            //              Requests          //

    public boolean makeSystemManagerActive(){
        if(sysMan == null){
            this.sysMan = MyFactory.createSystemManager(this.id);
            DBManager.updateObject(this);
            return true;
        }
        return false;
    }

    public boolean makeSystemManagerNotActive(){
        if(sysMan !=null){
            if(sysMan.deleteDB(this.id)){
                sysMan =null;
                return true;
            }
        }
        return false;
    }


    public void makeRefereeRequest(Certification certification , RefereeRoll refereeRoll){
        if(certification!=null){
            MyFactory.createRefereeRequest(this.getId(),certification,refereeRoll);
        }
    }

    public void makeTeamManagerRequest(){
        MyFactory.createTeamManagerRequest(this.getId());
    }
    public void makePlayerRequest(PlayerRole role, LocalDate dateOfBirth){
        if(role!=null && dateOfBirth!=null) {
            MyFactory.createPlayerRequest(this.getId(), role, dateOfBirth);
        }
    }

    public void makeCoachRequest(CoachRole role, Certification certification){
        if(role!=null && certification!=null) {
           MyFactory.createCoachRequest(this.getId(), role, certification);
        }
    }

    public void makeOwnerRequest(){
        MyFactory.createOwnerRequest(this.getId());
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Fan getFan() {
        return fan;
    }

    public void setFan(Fan fan) {
        this.fan = fan;
    }

    public FAR getFar() {
        return far;
    }

    public void setFar(FAR far) {
        this.far = far;
    }

    public Referee getReferee() {
        return referee;
    }

    public void setReferee(Referee referee) {
        this.referee = referee;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public TeamManager getTeamManager() {
        return teamManager;
    }

    public void setTeamManager(TeamManager teamManager) {
        this.teamManager = teamManager;
    }

    public com.example.demo.DomainLayer.Users.sysMan getSysMan() {
        return sysMan;
    }

    public void setSysMan(com.example.demo.DomainLayer.Users.sysMan sysMan) {
        this.sysMan = sysMan;
    }

    @Override
    public String toString() {
        return "Subscriber";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subscriber)) return false;
        Subscriber that = (Subscriber) o;
        return id == that.id &&
                userName.equals(that.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName);
    }
}

