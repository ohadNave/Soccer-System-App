package domain.Domain_Tests;

import com.example.DB_Tests.DomainLayer.Enums.*;
import com.example.DB_Tests.DomainLayer.LeagueManagment.*;
import com.example.DB_Tests.DomainLayer.MyFactory;
import com.example.DB_Tests.DomainLayer.Request.TeamRequest;
import com.example.DB_Tests.DomainLayer.Users.*;
import org.junit.Before;
import org.junit.Test;


import java.util.*;

import static org.junit.Assert.*;



public class AcceptanceTest {
    Subscriber sb1 = MyFactory.createSubscriber("ohad","123","Gal");
    Subscriber sbF = MyFactory.createSubscriber("555","123","Gal");
    Subscriber sb = MyFactory.createSubscriber("Gaga","123","Gal");

    /**
     * 2.2
     */
    @Test
    public void firstReg() throws Exception {
        Subscriber sb1 = MyFactory.createSubscriber("OHADONY","123","Gal");
        Guest sbF = MyFactory.createGuest();
        Subscriber tempSubscriber = sbF.Register("555","123","123","Gal");
        assertNull(tempSubscriber);
    }

    /**
     * 2.3
     */
    @Test
    public void loginTest(){
        Guest gs = new Guest();
        Guest gsF = new Guest();
        Subscriber sb2 = gs.Login("ohad", "123");
        Subscriber faildLog = gsF.Login("ohad","1234");
        assertNotNull(sb2);
        assertNull(faildLog);

    }

    /**
     * UC 3.3
     */
    @Test
    public void signMatchAlertTest(){
        sb.makeOwnerActive();
        Owner o1 = sb.getOwner();

        Team t1 = MyFactory.createTeam(o1,"HBS");
        Team t2 = MyFactory.createTeam(o1,"Macabi Germanim");
        Field f1 = MyFactory.createField("Terner");
        Game mt = MyFactory.createGame(null,null,f1,t1,t2,null);
        sb.makeFanActive();
        Fan fan = sb.getFan();
        fan.signForMatchAlerts(mt);
        assertEquals(1,mt.getMatch_followers().size());

    }


    /**
     * UC 3.4
     */
    @Test
    public void sendComplainTest(){
        sb.makeFanActive();
        Fan fan = sb.getFan();
        Date d = new Date();
        fan.sendComplain(d,"adadad");
        assertEquals(1,fan.getMyComplains().size());

        fan.sendComplain(d,"asda");
        assertNotEquals(1,fan.getMyComplains().size());
    }

    /**
     * UC 3.6
     */
    @Test
    public void editFanDetTest(){
        sb.makeFanActive();
        SystemUser fan = sb.getFan();
        fan.setName(sb.getId(),"Gagagaga");
        assertEquals("Gagagaga",sb.getName());

        fan.setName(sb.getId(),null);
        assertEquals("Gagagaga",sb.getName());
    }
    /**
     * UC 4.1
     */
    @Test
    public void editPlayerDetTest(){
        Date d = new Date();
        sb.makePlayerActive(PlayerRole.ATTACKER,null);
        sb.setName("Gaglalal");
        assertEquals("Gaglalal",sb.getName());

        sb.setName(null);
        assertEquals("Gaglalal",sb.getName());

    }


    /**
     * UC 5.1
     */
    @Test
    public void editCoachDetTest(){
        Date d = new Date();
        sb.makeCoachActive(CoachRole.GoalkeeprCoach, Certification.BASIC);
        sb.setName("Gagigigi");
        assertEquals("Gagigigi",sb.getName());

        sb.setName(null);
        assertEquals("Gagigigi",sb.getName());
    }

    /**
     * Not listed UC
     */
    @Test
    public void teamReqFarTest(){
        sb.makeOwnerActive();
        sb1.makeFARActive();
        FAR far = sb1.getFar();
        TeamRequest tm = MyFactory.createTeamRequest("Beitar",sb.getId());
        TeamRequest tmF = MyFactory.createTeamRequest("Beitar",sb.getId());
        assertTrue(far.handleRequest(tm,true));
        assertFalse(far.handleRequest(tmF,true));

    }

    /**
     * UC 6.1
     */

    @Test
    public void ownerManaging(){
        sb.makeOwnerActive();
        Owner owner = sb.getOwner();
        HashSet<Integer> pl = new HashSet<>();

        sb1.makeFARActive();
        FAR far = sb1.getFar();
        TeamRequest tm = MyFactory.createTeamRequest("HapoelBeerSheva",owner.getSid());
        far.handleRequest(tm,true);
        Team t = owner.getTeam();
        Field f = MyFactory.createField("T");
        t.addField(f.getFid());

        sb.makeCoachActive(CoachRole.GoalkeeprCoach,Certification.BASIC);
        assertTrue(owner.addCoach(sb.getId()));
        assertTrue(owner.addPlayers(pl));

        assertTrue(owner.removeCoach(sb.getId()));

        assertFalse(owner.addCoach(12));

        assertFalse(owner.removeCoach(1));
    }
    /**
     * UC 6.2, 6.3
     */
    @Test
    public void addRemoveOwner(){
        sb.makeOwnerActive();
        Owner owner = sb.getOwner();
        assertTrue(owner.createNewOwner(sb1.getId()));
        assertTrue(owner.removeOwner(sb1.getId()));

        assertFalse(owner.createNewOwner(700));
        assertFalse(owner.removeCoach(9));
    }
    /**
     * UC 6.4, 6.5
     */
    @Test
    public void addRemoveTManager(){
        sb.makeOwnerActive();
        Owner owner = sb.getOwner();
        sb1.makeTeamManagerActive();
        sb1.makeFARActive();
        FAR far = sb1.getFar();
        TeamRequest tm = MyFactory.createTeamRequest("Barcelona",sb.getId());
        far.handleRequest(tm,true);
        assertTrue(owner.addTeamManager(sb1.getId()));
        assertTrue(owner.deleteTeamManager(sb1.getId()));
        assertFalse(owner.addTeamManager(7));
        assertFalse(owner.deleteTeamManager(8));
    }

    /**
     * UC 6.6
     */
    @Test
    public void closeClubTest(){
        sb.makeOwnerActive();
        Owner owner = sb.getOwner();

        sb1.makeFARActive();
        FAR far = sb1.getFar();
        TeamRequest tm = MyFactory.createTeamRequest("t",sb.getId());
        far.handleRequest(tm,true);

        assertTrue(owner.closeTeam());

        assertFalse(owner.closeTeam());
    }

    /**
     * 8.1
     */
    @Test
    public void closeTeamPermenentlyTest(){
        sb.makeSystemManagerActive();
        sysMan systemManager = sb.getSysMan();
        HashSet<Integer> pl = new HashSet<>();

        sb.makeOwnerActive();
        Owner o1 = sb.getOwner();

        Team team = MyFactory.createTeam(o1,"hbs");
        systemManager.closeTeamPermanently(team.getTid());
        assertTrue(systemManager.closeTeamPermanently(team.getTid()));
        assertFalse(systemManager.closeTeamPermanently(team.getTid()));
    }

    /**
     * 8.2
     */
    @Test
    public void removeSubscriberTest(){
        sb.makeSystemManagerActive();
        sysMan systemManager = sb.getSysMan();
        assertTrue(systemManager.removeSubscriber(sb1.getId()));

        assertFalse(systemManager.removeSubscriber(sb1.getId()));
    }
    /**
     * UC 8.3
     */

    @Test
    public void respondToComplainTest(){
        sb.makeSystemManagerActive();
        sysMan systemManager = sb.getSysMan();
        Date d = new Date();
        Complain complain = MyFactory.createComplain(d,"test");
        assertTrue(systemManager.respondToUserComplain(complain.cid,"test"));
        assertFalse(systemManager.respondToUserComplain(4,"test"));    }

    /**
     * UC 9.1
     */
    @Test
    public void initializeLeagueTest(){
        sb.makeFARActive();
        FAR far = sb.getFar();
    }

    /**
     * UC 9.2
     */
    @Test
    public void initializeSeasonForLeaugeTest(){

        sb.makeFARActive();
        FAR far = sb.getFar();

        sb.makeOwnerActive();
        Owner o1 = sb.getOwner();

        far.initializeLeague(LeagueLevel.NationalLeague,"te");
        League lg = far.getAllLeagues().iterator().next();
        sb1.makeOwnerActive();
        Owner owner = sb1.getOwner();

        TeamRequest tm = MyFactory.createTeamRequest("t",sb1.getId());
        far.handleRequest(tm,true);

        Set<Integer> teams = new HashSet<>();
        Team t1 = MyFactory.createTeam(o1,"HBS");
        Team t2 = MyFactory.createTeam(o1,"Macabi Germanim");
        teams.add(t1.getTid());
        teams.add(t2.getTid());

        assertTrue(far.initializeSeasonForLeague(lg.getLid(),2010,teams));
        assertFalse(far.initializeSeasonForLeague(lg.getLid(),0,teams));

    }


    /**
     * UC 9.3
     */
    @Test
    public void addRefereeDeleteRefereeTest(){
        sb.makeFARActive();
        FAR far = sb.getFar();
        assertTrue(far.activateReferee("ohadi","123","t",Certification.BASIC, RefereeRoll.MAIN_REFEREE));
        assertFalse(far.activateReferee("ohad","","t",Certification.BASIC,RefereeRoll.MAIN_REFEREE));
    }


    /**
     * UC 9.5, 9.6, 9.7
     */
    @Test
    public void setScorePolicyForSeasonTest(){
        sb.makeFARActive();
        FAR far = sb.getFar();
        far.initializeLeague(LeagueLevel.NationalLeague,"te");
        League lg = far.getAllLeagues().iterator().next();
        assertTrue(far.setScorePolicyForSeason(lg.getLid(),new ScorePolicyA()));
        assertTrue(far.setLeagueGameSchedulerPolicy(lg.getLid(),new GamePolicy()));
        assertTrue(far.activateGameSchedulePolicyForLeague(lg.getLid()));


        assertFalse(far.setScorePolicyForSeason(lg.getLid(),new ScorePolicyA()));
        assertFalse(far.setLeagueGameSchedulerPolicy(lg.getLid(),new GamePolicy()));


    }


    /**
     * 10.1
     */
    @Test
    public void setRoleAndNameTest(){
        sb.makeRefereeActive(Certification.BASIC,RefereeRoll.MAIN_REFEREE);
        assertNotNull(sb.getReferee());
        Referee rf = sb.getReferee();
        rf.setName(sb.getId(),"Moshe");
        assertEquals("Moshe",sb.getName());

        rf.setName(sb.getId(),null);
        assertEquals("Moshe",sb.getName());


    }

}
