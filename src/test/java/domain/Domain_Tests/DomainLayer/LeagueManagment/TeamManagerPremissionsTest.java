package domain.Domain_Tests.DomainLayer.LeagueManagment;

import com.example.DB_Tests.DomainLayer.LeagueManagment.TeamManagerPremissions;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TeamManagerPremissionsTest {
    TeamManagerPremissions tp;

    @Before
    public void reset(){
        tp=new TeamManagerPremissions();

    }

    @Test
    public void setTeamManagerPremissions() {
        tp.setTeamManagerPremissions(true,true,true,true,true,true,true,true,true);
    }

    @Test
    public void setAddPlayerPermission() {
        tp.setAddPlayerPermission(false);
        assertFalse(tp.AddPlayerPermission());

    }

    @Test
    public void setRemovePlayerPermission() {
        tp.setRemovePlayerPermission(true);
        assertTrue(tp.RemovePlayerPermission());
    }

    @Test
    public void setEditPlayerRolePermission() {
        tp.setEditPlayerRolePermission(true);
        assertTrue(tp.EditPlayerRolePermission());
    }

    @Test
    public void setAddCoachPermission() {
        tp.setAddCoachPermission(false);
        assertFalse(tp.AddCoachPermission());
    }

    @Test
    public void setRemoveCoachPermission() {
        tp.setRemoveCoachPermission(false);
        assertFalse(tp.RemoveCoachPermission());
    }

    @Test
    public void setEditCoachRolePermission() {
        tp.setEditCoachRolePermission(true);
        assertTrue(tp.EditCoachRolePermission());
    }

    @Test
    public void setAddFieldPermission() {
        tp.setAddFieldPermission(true);
        assertTrue(tp.AddFieldPermission());
    }

    @Test
    public void setRemoveFieldPermission() {
        tp.setRemoveFieldPermission(false);
        assertFalse(tp.RemoveFieldPermission());
    }

    @Test
    public void setEditFieldNamePermission() {
        tp.setEditFieldNamePermission(true);
        assertTrue(tp.EditFieldNamePermission());
    }


}