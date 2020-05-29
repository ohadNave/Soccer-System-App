package com.example.demo.DomainLayer.Alerts;

import com.example.demo.DomainLayer.LeagueManagment.GameEvent;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
    public class GameEventAlert extends Alert {

    @OneToOne
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