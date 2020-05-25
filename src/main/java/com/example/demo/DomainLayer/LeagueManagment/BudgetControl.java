package com.example.demo.DomainLayer.LeagueManagment;

import java.time.Year;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BudgetControl {



    private Map<Integer,Map<Team,Integer> > teams; //<id,<team, year>>

    public BudgetControl(){
        teams = new HashMap<>();
    }

    public void initializeTeamFinance(Team team, int year){
        Map<Team,Integer> tempMap = new HashMap<>();
        tempMap.put(team,year);
        teams.put(team.getTid(),tempMap);
    }

    /**
     * Budget Control #1 rule - team total income in a quarter must be bigger then it outcome.
     * @return the teams that their outcomes are larger then their incomes(in order to send their owner notification).
     */
    public Set<Team> QuarterCheck(){

        Set<Team> badBalanceTeams = new HashSet<>();
        for (Map<Team,Integer> team_and_year : teams.values()){
            for (Team t : team_and_year.keySet()){
                Set<TeamBySeason>  teamBySeasons = t.getTeam_seasons();
                for (TeamBySeason teamBySeason : teamBySeasons){
                    if (teamBySeason.getYear() == Year.now().getValue()){
                        Map<Integer, TeamFinance> yearlyTeamFinanceData = teamBySeason.getTeamQuarters();
                        for(int i = 1 ; i < 5 ; i++){
                            TeamFinance tempTeamFinance = yearlyTeamFinanceData.get(i);
                            if(tempTeamFinance.getTotalOutcome() > tempTeamFinance.getTotalIncome()){
                                badBalanceTeams.add(t);
                                break;
                            }
                        }
                    }
                }
            }
        }
        return badBalanceTeams;
    }

    public Map<Integer, Map<Team, Integer>> getTeams() {
        return teams;
    }

    public void setTeams(Map<Integer, Map<Team, Integer>> teams) {
        this.teams = teams;
    }
}
