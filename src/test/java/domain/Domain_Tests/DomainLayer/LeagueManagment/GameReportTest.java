package domain.Domain_Tests.DomainLayer.LeagueManagment;
import com.example.DB_Tests.DomainLayer.LeagueManagment.Report;
import com.example.DB_Tests.DomainLayer.LeagueManagment.Team;
import com.example.DB_Tests.DomainLayer.MyFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameReportTest {

    Report gr;
    Team winners;
    Team losers;


    @Before
    public void reset(){
        gr= MyFactory.createGameReport(1,2,3,2);
         winners=MyFactory.createTeam(null,"winners");
        losers=MyFactory.createTeam(null,"losers");
    }


    @Test
    public void setWinnerTeam() {
        Team other=MyFactory.createTeam(null,"other");

        gr.setWinnerTeam(other.getTid());
        String s=gr.getWinnerTeam().getName();
        assertEquals(s,"other");
    }


    @Test
    public void setLosingTeam() {
        Team other=MyFactory.createTeam(null,"other");

        gr.setLosingTeam(other.getTid());
        String s=gr.getLosingTeam().getName();
        assertEquals(s,"other");
    }



    @Test
    public void setWinnerGoals() {


        gr.setWinner_goals(5);
        int s=gr.getWinner_goals();
        assertEquals(s,5);
    }


    @Test
    public void setLoserGoals() {
        gr.setLoser_goals(3);
        int s=gr.getLoser_goals();
        assertEquals(s,3);
    }
}