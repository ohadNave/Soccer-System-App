package com.example.DB_Tests.DomainLayer.LeagueManagment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TeamFinance {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int tid;

    private double sellingPlayersIncome;
    private double buyingPlayersOutcome;
    private double MatchesIncome;
    private double MatchesOutcome;
    private double SalariesOutcome;
    private double ownerInvestmentIncome;
    private double advertiseIncome;

    public TeamFinance() {
        this.sellingPlayersIncome = 0;
        this.buyingPlayersOutcome = 0;
        this.MatchesIncome = 0;
        this.MatchesOutcome = 0;
        this.SalariesOutcome = 0;
        this.ownerInvestmentIncome = 0;
        this.advertiseIncome = 0;
    }




    // All functions below helps to manage team income and outcomes.
    public double getTotalIncome(){
        return sellingPlayersIncome+MatchesIncome+ownerInvestmentIncome+advertiseIncome;
    }

    public double getTotalOutcome(){
        return buyingPlayersOutcome+MatchesOutcome+SalariesOutcome;
    }

    public double getSellingPlayersIncome() {
        return sellingPlayersIncome;
    }

    public boolean incrementSellingPlayersIncome(double sellingPlayersIncome) {
        if ( sellingPlayersIncome > 0 ){
            this.sellingPlayersIncome += sellingPlayersIncome;
            return true;
        }
        return false;
    }

    public double getBuyingPlayersOutcome() {
        return buyingPlayersOutcome;
    }

    public boolean incrementBuyingPlayersOutcome(double buyingPlayersOutcome) {
        if ( buyingPlayersOutcome > 0 ) {
            this.buyingPlayersOutcome += buyingPlayersOutcome;
            return true;
        }
        return false;
    }

    public double getMatchesIncome() {
        return MatchesIncome;
    }

    public void incrementMatchesIncome(double matchesIncome) {
        MatchesIncome += matchesIncome;
    }

    public double getMatchesOutcome() {
        return MatchesOutcome;
    }

    public boolean incrementMatchesOutcome(double matchesOutcome) {
        if(matchesOutcome > 0){
            MatchesOutcome += matchesOutcome;
            return true;
        }
        return false;
    }

    public double getSalariesOutcome() {
        return SalariesOutcome;
    }

    public void incrementSalariesOutcome(double salariesOutcome) {
        SalariesOutcome += salariesOutcome;
    }

    public double getOwnerInvestmentIncome() {
        return ownerInvestmentIncome;
    }

    public boolean incrementOwnerInvestmentIncome(double ownerInvestmentIncome) {
        if ( ownerInvestmentIncome > 0 ){
            this.ownerInvestmentIncome += ownerInvestmentIncome;
            return true;
        }
        return false;
    }

    public double getAdvertiseIncome() {
        return advertiseIncome;
    }

    public boolean incrementAdvertiseIncome(double advertiseIncome) {
        if(advertiseIncome > 0) {
            this.advertiseIncome += advertiseIncome;
            return true;
        }
        return false;
    }
}
