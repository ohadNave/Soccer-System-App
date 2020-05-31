package com.example.DB_Tests.DomainLayer.Alerts;
import com.example.DB_Tests.DomainLayer.LeagueManagment.Report;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class MatchEndedAlert extends Alert {

    @OneToOne
    Report report;

    public void setAttributes(Report report) {
        this.report = report;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    @Override
    public String toString() {
        return "Match ended : \n Match details: \n"  + report.toString();
    }
}
