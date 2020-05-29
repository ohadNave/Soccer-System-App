package com.example.demo.DomainLayer.Alerts;

import com.example.demo.DomainLayer.Users.Referee;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.sql.Ref;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class MatchDateChangedAlert extends Alert{

    LocalDate newMatchDate;

    public void setAttributes(LocalDate newMatchDate) {
        this.newMatchDate = newMatchDate;
    }

    public LocalDate getNewMatchDate() {
        return newMatchDate;
    }

    public void setNewMatchDate(LocalDate newMatchDate) {
        this.newMatchDate = newMatchDate;
    }


    @Override
    public String toString() {
        return "Match date has been changed into " + newMatchDate.toString();
    }


}


