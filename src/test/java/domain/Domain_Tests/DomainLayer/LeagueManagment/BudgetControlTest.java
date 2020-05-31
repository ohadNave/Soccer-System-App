package domain.Domain_Tests.DomainLayer.LeagueManagment;

import com.example.DB_Tests.DomainLayer.LeagueManagment.BudgetControl;
import com.example.DB_Tests.DomainLayer.LeagueManagment.Team;
import com.example.DB_Tests.DomainLayer.LeagueManagment.TeamBySeason;
import com.example.DB_Tests.DomainLayer.LeagueManagment.TeamFinance;
import com.example.DB_Tests.DomainLayer.MyFactory;
import com.example.DB_Tests.DomainLayer.Users.Owner;
import com.example.DB_Tests.DomainLayer.Users.Subscriber;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class BudgetControlTest {
    BudgetControl budgetControl = new BudgetControl();
    @Test
    public void updateTeamFinance() {
        String userName="user name";
        String password="1234";
        String name="name";
        Subscriber subscriberOwner = MyFactory.createSubscriber(userName,password,name);
        subscriberOwner.makeOwnerActive();
        Owner owner=subscriberOwner.getOwner();
        Team team = MyFactory.createTeam(owner,"asd");
        HashMap<Integer, TeamFinance> teamFinance = new HashMap<>();
        int year = 2020;
        budgetControl.initializeTeamFinance(team,year);
        assertTrue(budgetControl.getTeams().containsKey(team.getTid()));
        assertTrue(budgetControl.getTeams().containsValue(year));
    }

    @Test
    public void quarterCheck() {
        String userName="user name";
        String password="1234";
        String name="name";
        int year = 2020;
        Subscriber subscriberOwner = MyFactory.createSubscriber(userName,password,name);
        subscriberOwner.makeOwnerActive();
        Owner owner=subscriberOwner.getOwner();
        Team team = MyFactory.createTeam(owner,"check");
        TeamBySeason teamBySeason = MyFactory.createTeamBySeason(team,year);
        teamBySeason.incrementMatchesIncome(1,100);
        teamBySeason.incrementMatchesOutcome(1,200);
        budgetControl.initializeTeamFinance(team,year);
        assertTrue(budgetControl.QuarterCheck().contains(team.getTid()));
    }

    @Test
    public void getTeams() {


        //check if teams is not empty
        String userName="user name";
        String password="1234";
        String name="name";
        int year = 2020;
        Subscriber subscriberOwner = MyFactory.createSubscriber(userName,password,name);
        subscriberOwner.makeOwnerActive();
        Owner owner=subscriberOwner.getOwner();
        Team team = MyFactory.createTeam(owner,"check");
        TeamBySeason teamBySeason = MyFactory.createTeamBySeason(team,year);
        teamBySeason.incrementMatchesIncome(1,100);
        teamBySeason.incrementMatchesOutcome(1,200);
        budgetControl.initializeTeamFinance(team,year);
        assertTrue(budgetControl.getTeams().containsKey(team.getTid()));
        assertEquals(new Integer(year),budgetControl.getTeams().get(team.getTid()));

    }
}