package com.example.DB_Tests.DomainLayer.LeagueManagment;

import com.example.DB_Tests.DomainLayer.Alerts.Alert;
import com.example.DB_Tests.DomainLayer.Alerts.I_Observer.ISubjectTeam;
import com.example.DB_Tests.DomainLayer.DBManager;
import com.example.DB_Tests.DomainLayer.Enums.CoachRole;
import com.example.DB_Tests.DomainLayer.Enums.PlayerRole;
import com.example.DB_Tests.DomainLayer.MyFactory;
import com.example.DB_Tests.DomainLayer.Users.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class Team extends Observable implements ISubjectTeam, Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int tid;

    private String name;

    @OneToOne
    private Owner owner;

    @OneToOne(cascade = {CascadeType.ALL})
    private PrivatePage private_page;

    @Column(columnDefinition = "boolean default false")
    private boolean closed;

    @Column(columnDefinition = "boolean default false")
    private boolean active;

    @OneToMany(cascade = {CascadeType.ALL})
    private Set<TeamBySeason> team_seasons;

    @OneToMany(cascade = {CascadeType.ALL})
    private Set<Player> players;

    @OneToMany(cascade = {CascadeType.ALL})
    private Set<Coach> coaches;

    @OneToMany(cascade = {CascadeType.ALL})
    private Set<TeamManager> team_managers;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<Field> field;

    @OneToMany (cascade = {CascadeType.ALL})
    private Set<Game> matches;


    public void setAttributes( Owner owner, String name){
        this.team_seasons = new HashSet<>();
        this.team_managers = new HashSet<>();
        this.field = new ArrayList<>();
        this.coaches = new HashSet<>();
        this.players = new HashSet<>();
        this.matches = new HashSet<>();
        this.name = name;
        setOwner(owner);
        setPrivate_page(MyFactory.createPrivatePage());
        owner.setTeam(this);
    }



    public boolean addPlayers(Set<Integer> player_ids){
        Set<Player> players = new HashSet<>();
        for (Integer pid: player_ids){
            Player player = (Player) DBManager.getObject(Player.class,pid);
            players.add(player);
        }
        if(this.players != null && (this.players.size() + players.size()) < 26 ){
            for(Player p : players){
                p.setTeam(this);
            }
            setPlayers(players);
            return true;
        }
        return false;
    }

    public boolean removePlayer(int player_id){
        Player player = getPlayerByID(player_id);
        if( player != null && this.players != null && this.players.contains(player) ){ //players.size() > 11 &&
            player.setTeam(null);
            players.remove(player);
            return true;
        }
        return false;
    }

    public boolean editPlayerRole(int player_id, PlayerRole role ){
        Player player = getPlayerByID(player_id);
        if( this.players != null ){
            player.setRole(role);
            return true;
        }
        return false;
    }

    public boolean addCoach(int coach_id) {
        Coach coach = getCoachByID(coach_id);
        if( this.coaches != null && coach != null ){
            coaches.add(coach);
            coach.setTeam(this);
            return true;
        }
        return false;
    }

    public boolean removeCoach(int coach_id){
        Coach coach = getCoachByID(coach_id);
        if( this.coaches != null && coach != null){
            coaches.remove(coach);
            return true;
        }
        return false;
    }

    public boolean editCoachRole(int coach_id, CoachRole role){
        Coach coach = getCoachByID(coach_id);
        if( this.coaches != null && coach != null){
            coach.setRole(role);
            return true;
        }
        return false;
    }

    public boolean addField(int field_id) {
        Field field = getFieldByID(field_id);
        if(this.field !=null && field != null){
            this.field.add(field);
            field.setTeam(this);
            return true;
        }
        return false;
    }

    public boolean removeField(int field_id){
        Field field = getFieldByID(field_id);
        if(this.field != null && field != null){
            this.field.remove(field);
            return true;
        }
        return false;
    }

    public boolean editFieldName(int field_id, String newName){
        Field field = getFieldByID(field_id);
        if( this.field != null &&  field != null ){
            if(field.setName(newName)){
                return true;
            }
        }
        return false;
    }

    public boolean startNewSeason(int year){
        if(year > 1990 && year < 2050){
            TeamBySeason teamBySeason = MyFactory.createTeamBySeason(this,year);
            team_seasons.add(teamBySeason);
            return true;
        }
        return false;
    }

    public boolean makeTeamActive(Set<Player>players , Coach coach , TeamManager teamManager, Field field){
        if(players != null && players.size() > 10 && players.size() < 26){
            this.players = players;
            this.coaches.add(coach);
            this.team_managers.add(teamManager);
            this.field.add(field);
            this.active = true;
            return true;
        }
        return false;
    }

    public boolean updateTeamPrivatePage(String content){
        if ( !content.isEmpty() ){
            private_page.addContentToPage(content);
            return true;
        }
        return false;
    }


    public void closeTeamPermanently(){
//        if (this.active)
        owner.setTeam(null);
        this.owner = null;
        closed = true;
    }

    public boolean addTeamManager(TeamManager teamManager) {
        if( teamManager != null ){
            team_managers.add(teamManager);
            teamManager.setTeam(this);
            return true;
        }
        return false;
    }

    public boolean deleteTeamManager(int tid){
        if( team_managers.size() > 0 ) {
            TeamManager teamManager = ((TeamManager) DBManager.getObject(TeamManager.class, tid));
            teamManager.setOwner(null);
            team_managers.remove(teamManager);
            return true;
        }
        return false;
    }

    @Override
    public void notifySystemManager(Alert alert) {
       //DBManagerStub.notifySystemManagers(this,alert);
    }

    @Override
    public void notifyOwner(Alert alert) {
        owner.update(this,alert);
        Set<Owner> owners = owner.getOwners();
        for (Owner owner: owners){
            owner.update(this,alert);
        }
    }

    @Override
    public void notifyTeamManagers(Alert alert) {
        for (TeamManager teamManager : team_managers){
            teamManager.update(this,alert);
        }
    }

    @Override
    public void notifyTeamPrivatePageFollowers(Alert alert) {
      private_page.notifyPageFollowers(alert);
    }

    public boolean setTeamManagerPermisions(int teamManagerId,boolean addPlayerPermission, boolean removePlayerPermission, boolean editPlayerRolePermission, boolean addCoachPermission, boolean removeCoachPermission, boolean editCoachRolePermission, boolean addFieldPermission, boolean removeFieldPermission, boolean editFieldNamePermission ){
        if ( teamManagerId != -1 ){
            for (TeamManager tm: team_managers){
                if (tm.getSid() == teamManagerId){
                    tm.setPermissions( addPlayerPermission,  removePlayerPermission,  editPlayerRolePermission,  addCoachPermission,  removeCoachPermission,  editCoachRolePermission,  addFieldPermission,  removeFieldPermission,  editFieldNamePermission);
                    return true;
                }
            }
        }
        return false;
    }


    /*
    getters and setters
     */

    public Set<TeamManager> getTeamManager() { return team_managers; }


    public Player getPlayerByID(int id){
        for (Player p: this.players){
            if (p.getSid() == id)
                return p;
        }
        return null;
    }

    public Coach getCoachByID(int id){
        for (Coach c: this.coaches){
            if (c.getSid() == id)
                return c;
        }
        return null;
    }

    public Field getFieldByID(int field_id){
        for (Field f: this.field){
            if (f.getFid() == field_id)
                return f;
        }
        return null;
    }

    public String getName() { return name; }

    public boolean setName(String name) {
        if(name!=null){
            this.name = name;
            return true;
        }
        return false;
    }

    public void setTeamActive(){
        this.active = true;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
       this.owner = owner;
    }

    public void setTeamNotActive(){
        this.active = false;
        Alert closedTeamAlert = MyFactory.createTeamIsNowNotActiveAlert(this);
        notifyOwner(closedTeamAlert);
        notifyTeamManagers(closedTeamAlert);
        notifySystemManager(closedTeamAlert);
    }

    @OneToMany(mappedBy = "team")
    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    public Set<Coach> getCoaches() {
        return coaches;
    }

    public void setCoaches(Set<Coach> coaches) {
        this.coaches = coaches;
    }

    public Set<TeamManager> getTeam_managers() {
        return team_managers;
    }

    public void setTeam_managers(Set<TeamManager> team_managers) {
        this.team_managers = team_managers;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<TeamBySeason> getTeam_seasons() {
        return team_seasons;
    }

    public void setTeam_seasons(Set<TeamBySeason> allTeamSeasons) { this.team_seasons = allTeamSeasons; }

    public List<Field> getField() {
        return field;
    }

    public void setField(List<Field> field) {
        this.field = field;
    }

    public Set<Game> getMatches() {
        return matches;
    }

    public void setMatches(Set<Game> matches) {
        this.matches = matches;
    }


    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public PrivatePage getPrivate_page() {
        return private_page;
    }

    public void setPrivate_page(PrivatePage privatePage) {
        this.private_page = privatePage;
    }

    public void addTeamBySeason(TeamBySeason teamBySeason){
        team_seasons.add(teamBySeason);
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }


}
