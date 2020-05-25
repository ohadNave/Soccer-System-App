package com.example.demo.DomainLayer.LeagueManagment;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "team_by_season")
@IdClass(TeamBySeason.TeamBCompositeKey.class)
public class TeamBySeason implements Serializable {

    public static class TeamBCompositeKey implements Serializable{
        private int tid;
        private int year;
    }

    @Id
    private int tid;
    @Id
    private int year;


    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @OneToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "order_item_mapping",
//            joinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")},
//            inverseJoinColumns = {@JoinColumn(name = "item_id", referencedColumnName = "id")})
//    @MapKey(name = "itemName")
    private Map<Integer,TeamFinance> teamQuarters;

    public void setAttributes(Team team, int year){
        this.tid = team.getTid();
        this.year = year;
        this.team = team;
        teamQuarters = new HashMap<>();
        Map<Integer,TeamFinance> teamFinance = new HashMap<>();
        initializeTeamFinanceQuarters(teamFinance);
    }

    /**
     * we consider cells 1-4 as quarters of year, and the 5th cell represent the entire year.
     */
    private void initializeTeamFinanceQuarters(Map<Integer,TeamFinance> teamFinance){
        teamFinance.put(1,new TeamFinance());
        teamFinance.put(2,new TeamFinance());
        teamFinance.put(3,new TeamFinance());
        teamFinance.put(4,new TeamFinance());
        teamFinance.put(5,new TeamFinance());

    }

    /**
     * gets information from 4 years quarters and calculate entire year incomes/outcomes.
     */
    public boolean calculateEntireYear(){
        if (teamQuarters != null ){
            for (int i = 1; i < 5; i++){
                if (teamQuarters.get(i) != null){
                    teamQuarters.get(5).incrementMatchesOutcome(teamQuarters.get(i).getMatchesOutcome());
                    teamQuarters.get(5).incrementMatchesIncome(teamQuarters.get(i).getMatchesIncome());
                    teamQuarters.get(5).incrementBuyingPlayersOutcome(teamQuarters.get(i).getBuyingPlayersOutcome());
                    teamQuarters.get(5).incrementSellingPlayersIncome(teamQuarters.get(i).getSellingPlayersIncome());
                    teamQuarters.get(5).incrementAdvertiseIncome(teamQuarters.get(i).getAdvertiseIncome());
                    teamQuarters.get(5).incrementOwnerInvestmentIncome(teamQuarters.get(i).getOwnerInvestmentIncome());
                    teamQuarters.get(5).incrementSalariesOutcome(teamQuarters.get(i).getSalariesOutcome());
                }
            }
            return true;
        }
        return false;
    }

    // getters and incrementers.



    public int getYear() {
        return year;
    }

    public boolean setYear(int year) {
        if(year>1990 && year<2050){
            this.year = year;
            return true;
        }
        return false;
    }

    public double getSellingPlayersIncome(int quarter) {
        if( quarter > 0 && quarter < 6 )
        return teamQuarters.get(quarter).getSellingPlayersIncome();
        return -1;
    }

    public boolean incrementSellingPlayersIncome(int quarter, double sellingPlayersIncome) {
        if( quarter > 0 && quarter < 6 && sellingPlayersIncome>=0){
            teamQuarters.get(quarter).incrementSellingPlayersIncome(sellingPlayersIncome);
            return true;
        }
        return false;
    }

    public double getBuyingPlayersOutcome(int quarter) {
        if( quarter > 0 && quarter < 6 ) {
            return teamQuarters.get(quarter).getBuyingPlayersOutcome();
        }
        return -1;
    }

    public boolean incrementBuyingPlayersOutcome( int quarter, double buyingPlayersOutcome) {
            if( quarter > 0 && quarter < 6 && buyingPlayersOutcome>=0){
                teamQuarters.get(quarter).incrementBuyingPlayersOutcome(buyingPlayersOutcome);
                return true;
            }
            return false;
    }

    public double getMatchesIncome(int quarter) {
        if( quarter > 0 && quarter < 6 ) {
            return teamQuarters.get(quarter).getMatchesIncome();
        }
        return -1;
    }

    public boolean incrementMatchesIncome(int quarter, double matchesIncome) {
        if( quarter > 0 && quarter < 6 && matchesIncome>=0) {
            teamQuarters.get(quarter).incrementMatchesIncome(matchesIncome);
            return true;
        }
        return false;
    }

    public double getMatchesOutcome(int quarter) {
        if( quarter > 0 && quarter < 6){
            return teamQuarters.get(quarter).getMatchesOutcome();
        }
        return -1;
    }

    public boolean incrementMatchesOutcome(int quarter, double matchesOutcome) {
        if( quarter > 0 && quarter < 6 && matchesOutcome>=0){
            teamQuarters.get(quarter).incrementMatchesOutcome(matchesOutcome);
            return true;
        }
        return false;
    }

    public double getSalariesOutcome(int quarter) {
        if ( quarter > 0 && quarter < 6 ){
            return teamQuarters.get(quarter).getSalariesOutcome();
        }
        return -1;
    }

    public boolean incrementSalariesOutcome(int quarter, double salariesOutcome) {
        if ( quarter > 0 && quarter < 6 && salariesOutcome>=0){
            teamQuarters.get(quarter).incrementSalariesOutcome(salariesOutcome);
            return true;
        }
        return false;
    }

    public double getOwnerInvestmentIncome(int quarter) {
        if ( quarter > 0 && quarter < 6 ) {
            return teamQuarters.get(quarter).getOwnerInvestmentIncome();
        }
        return -1;
    }

    public boolean incrementOwnerInvestmentIncome(int quarter, double ownerInvestmentIncome) {
        if ( quarter > 0 && quarter < 6 && ownerInvestmentIncome>=0) {
            teamQuarters.get(quarter).incrementOwnerInvestmentIncome(ownerInvestmentIncome);
            return true;
        }
        return false;
    }

    public double getAdvertiseIncome(int quarter) {
        if ( quarter > 0 && quarter < 6 ){
            return teamQuarters.get(quarter).getAdvertiseIncome();
        }
      return -1;
    }

    public boolean incrementAdvertiseIncome( int quarter, double advertiseIncome) {
        if ( quarter > 0 && quarter < 6 && advertiseIncome>=0) {
            teamQuarters.get(quarter).incrementAdvertiseIncome(advertiseIncome);
            return true;
        }
        return false;
    }


    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }


    public Map<Integer, TeamFinance> getTeamQuarters() {
        return teamQuarters;
    }

    public void setTeamQuarters(Map<Integer, TeamFinance> teamQuarters) {
        this.teamQuarters = teamQuarters;
    }
}
