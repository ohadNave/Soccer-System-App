package com.example.DB_Tests.DomainLayer.LeagueManagment;

import com.example.DB_Tests.DomainLayer.DBManager;
import com.example.DB_Tests.DomainLayer.Enums.EventType;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class GameEvent implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int eid;
    private LocalDateTime local_time;
    private int minute_in_game;
    private String description;

    @ManyToOne
    @JoinColumn(name = "match_id")
    private Game match;

    @Enumerated(EnumType.STRING)
    public EventType event_type;


    public void setAttributes( int minuteInGame, String description, EventType eventType){
        this.local_time = LocalDateTime.now();
        this.minute_in_game = minuteInGame;
        this.description = description;
        this.event_type = eventType;
    }

    /*
    getters and setters.
     */

    public LocalDateTime getLocal_time() {
        return local_time;
    }

    public void setLocal_time(LocalDateTime local_time) {
        this.local_time = local_time;
        DBManager.updateObject(this);
    }


    public int getMinute_in_game() {
        return minute_in_game;
    }

    public void setMinute_in_game(int minute_in_game) {
        this.minute_in_game = minute_in_game;
        DBManager.updateObject(this);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        DBManager.updateObject(this);
    }

    public EventType getEvent_type() {
        return event_type;
    }

    public void setEvent_type(EventType event_type) {
        this.event_type = event_type;
        DBManager.updateObject(this);
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
        DBManager.updateObject(this);

    }

    public Game getMatch() {
        return match;
    }

    public void setMatch(Game match) {
        this.match = match;
    }
}
