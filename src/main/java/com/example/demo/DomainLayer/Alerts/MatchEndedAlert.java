package com.example.demo.DomainLayer.Alerts;
import com.example.demo.DomainLayer.LeagueManagment.GameReport;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class MatchEndedAlert extends Alert {

    @OneToOne
    GameReport gameReport;

    public void setAttributes(GameReport gameReport) {
        this.gameReport = gameReport;
    }

    public GameReport getGameReport() {
        return gameReport;
    }

    public void setGameReport(GameReport gameReport) {
        this.gameReport = gameReport;
    }

    @Override
    public String toString() {
        return "Match ended : \n Match details: \n"  + gameReport.toString();
    }
}
