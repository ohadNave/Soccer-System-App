package com.example.DB_Tests.DomainLayer.Alerts;

import com.example.DB_Tests.DomainLayer.LeagueManagment.GameEvent;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
    public class GameEventAlert extends Alert {

    @OneToOne (cascade = CascadeType.ALL)
    private GameEvent event;

    public void setAttributes(int minute, GameEvent event) {
        this.event = event;
    }

    public GameEvent getEvent() {
        return event;
    }

    public void setEvent(GameEvent event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "New match event from type " + event.event_type + " added in the " + event.getMinute_in_game() + " minute";
    }
}