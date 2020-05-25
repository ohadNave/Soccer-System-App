package com.example.demo.DomainLayer.LeagueManagment;


import java.util.List;

public class ScorePolicyA implements ScorePolicy {
    private String description;
    private int addToWinner;
    private int addToLooser;
    private int addIfNone;

    public ScorePolicyA(){
        description ="";
        addToWinner=3;
        addToLooser=0;
        addIfNone=1;
        description = "Winner team get 3 point, looser team get 0 point else each team get 1 point";

    }

    @Override
    public boolean execute( Season season , boolean tieScore, Team winnerTeam, Team loosingTeam) {
        if(season != null){
            List<Integer> scores = season.getTeam_scores();
            int winner_table_position = getTeamPosition(season.getTeams_league(),winnerTeam);
            int loser_table_position = getTeamPosition(season.getTeams_league(),loosingTeam);
            if(winner_table_position != -1 && loser_table_position != -1){
                if (tieScore){
                    scores.set(winner_table_position, scores.get(winner_table_position) + addIfNone);
                    scores.set(loser_table_position, scores.get(loser_table_position) + addIfNone);
                }
                else {
                    scores.set(winner_table_position, scores.get(winner_table_position) + addToWinner);
                    scores.set(loser_table_position, scores.get(loser_table_position) + addToLooser);
                }
            }
            }
        return false;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public int getTeamPosition(List<Team> teams_table,Team team){
        for (int i = 0; i < teams_table.size() ; i++) {
                if (teams_table.get(i) == team)
                    return i;
        }
        return -1;
    }
}
