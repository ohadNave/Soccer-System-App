package com.example.DB_Tests.DomainLayer.Alerts;

import javax.persistence.Entity;
import java.time.LocalDate;

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


