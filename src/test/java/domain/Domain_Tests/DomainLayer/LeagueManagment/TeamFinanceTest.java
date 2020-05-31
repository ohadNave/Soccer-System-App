package domain.Domain_Tests.DomainLayer.LeagueManagment;

import com.example.DB_Tests.DomainLayer.LeagueManagment.TeamFinance;
import org.junit.Test;

import static org.junit.Assert.*;

public class TeamFinanceTest {
    TeamFinance teamFinance = new TeamFinance();

    @Test
    public void getTotalIncome() {
        teamFinance.incrementSellingPlayersIncome(50);
        teamFinance.incrementMatchesIncome(50);
       // Field privateStringField = TeamFinance.class.getDeclaredField("sellingPlayersIncome");
        assertEquals(100.0,teamFinance.getTotalIncome(),0.00001);
        //check
    }

    @Test
    public void getTotalOutcome() {
        teamFinance.incrementMatchesOutcome(50);
        teamFinance.incrementSellingPlayersIncome(50);
        teamFinance.incrementBuyingPlayersOutcome(51);
        assertEquals(101, teamFinance.getTotalOutcome(), 0.00001);
    }

    @Test
    public void getSellingPlayersIncome() {
        teamFinance.incrementSellingPlayersIncome(60);
        assertEquals(60,teamFinance.getSellingPlayersIncome(),0.00001);
    }

    @Test
    public void incrementSellingPlayersIncome() {
        assertFalse(teamFinance.incrementSellingPlayersIncome(0));
        assertTrue(teamFinance.incrementSellingPlayersIncome(100));
        assertEquals(100,teamFinance.getSellingPlayersIncome(),0.00001);
    }

    @Test
    public void getBuyingPlayersOutcome() {
        teamFinance.incrementSellingPlayersIncome(100);
        teamFinance.incrementBuyingPlayersOutcome(100);
        assertEquals(100,teamFinance.getBuyingPlayersOutcome(),0.00001);


    }

    @Test
    public void incrementBuyingPlayersOutcome() {
        assertFalse(teamFinance.incrementBuyingPlayersOutcome(0));
        teamFinance.incrementSellingPlayersIncome(100);
        assertTrue(teamFinance.incrementBuyingPlayersOutcome(100));
        assertEquals(100,teamFinance.getBuyingPlayersOutcome(),0.00001);


    }

    @Test
    public void getMatchesIncome() {
        teamFinance.incrementMatchesIncome(50);
        assertEquals(50,teamFinance.getMatchesIncome(),0.00001);
    }

    @Test
    public void incrementMatchesIncome() {
        teamFinance.incrementMatchesIncome(50);
        teamFinance.incrementMatchesIncome(501);
        assertEquals(551,teamFinance.getTotalIncome(),0.00001);
    }

    @Test
    public void getMatchesOutcome() {
        teamFinance.incrementMatchesOutcome(50);
        assertEquals(50, teamFinance.getMatchesOutcome(), 0.00001);
    }

    @Test
    public void incrementMatchesOutcome() {
        assertFalse(teamFinance.incrementMatchesOutcome(0));
        assertTrue(teamFinance.incrementMatchesOutcome(70));
        assertTrue(teamFinance.incrementMatchesOutcome(75));
        assertEquals(145, teamFinance.getMatchesOutcome(), 0.00001);
    }

    @Test
    public void getSalariesOutcome() {
        teamFinance.incrementSalariesOutcome(80);
        teamFinance.incrementSalariesOutcome(90);
        assertEquals(170,teamFinance.getSalariesOutcome(),0.00001);
    }

    @Test
    public void incrementSalariesOutcome() {
        teamFinance.incrementSalariesOutcome(100);
        assertEquals(100,teamFinance.getSalariesOutcome(),0.00001);
    }

    @Test
    public void getOwnerInvestmentIncome() {
        teamFinance.incrementOwnerInvestmentIncome(110);
        assertEquals(110,teamFinance.getOwnerInvestmentIncome(),0.00001);
    }

    @Test
    public void incrementOwnerInvestmentIncome() {
        assertFalse(teamFinance.incrementOwnerInvestmentIncome(0));
        assertTrue(teamFinance.incrementOwnerInvestmentIncome(120));
        assertEquals(120, teamFinance.getOwnerInvestmentIncome(),0.00001);
    }

    @Test
    public void getAdvertiseIncome() {
        teamFinance.incrementAdvertiseIncome(130);
        assertEquals(130,teamFinance.getAdvertiseIncome(),0.00001);
    }

    @Test
    public void incrementAdvertiseIncome() {
        assertFalse(teamFinance.incrementAdvertiseIncome(0));
        assertTrue(teamFinance.incrementAdvertiseIncome(140));
        teamFinance.incrementAdvertiseIncome(150);
        assertEquals(290, teamFinance.getAdvertiseIncome(),0.00001);
    }
}