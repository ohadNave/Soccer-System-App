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

public class IntegrationTest {
    Subscriber sb1 = MyFactory.createSubscriber("Gala","123","Gal");
    Subscriber sb = MyFactory.createSubscriber("Gaga","123","Gal");





    /**
     * UC 2.2
     */
    @Test
    public void firstReg(){
        assertNotNull(sb);
    }

    /**
     * 2.3
     */

    @Test
    public void loginTest(){
        Guest gs = MyFactory.createGuest();
        Subscriber sb2 = gs.Login("Gala", "123");
        assertNotNull(sb2);
    }

    /**
     * UC 3.2
     */
    @Test
    public void followPageTest(){
        sb.makeFanActive();
        assertNotNull(sb.getFan());
        Fan fan = sb.getFan();

        sb1.makePlayerActive(PlayerRole.ATTACKER,null);
        Player p = sb1.getPlayer();
        assertNotNull(fan);
        fan.followPage(p.getPrivate_page());
        assertEquals(1,fan.getFollowingPrivatePages().size());
    }

    /**
     * UC 3.3
     */
    @Test
    public void signMatchAlertTest(){

        sb.makeOwnerActive();
        Owner owner = sb.getOwner();
        Set<Referee> ref = new HashSet<>();

        sb1.makeFARActive();
        FAR far = sb1.getFar();
        TeamRequest tm = MyFactory.createTeamRequest("HapoelBeerSheva",owner.getSid());
        far.handleRequest(tm,true);
        Team t = owner.getTeam();
        Field f = MyFactory.createField("T");

        Subscriber sbRef = MyFactory.createSubscriber("refe","1234","rrr");
        sbRef.makeRefereeActive(Certification.BASIC,RefereeRoll.MAIN_REFEREE);
        Referee r1 = sbRef.getReferee();

        ref.add(r1);

        Game mt = MyFactory.createGame(null,null,f,t,t,ref);
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
        fan.sendComplain(null,"as");
        assertEquals(1,fan.getMyComplains().size());
    }

    /**
     * UC 3.6
     */
    @Test
    public void editFanDetTest(){
        sb.makeFanActive();
        SystemUser fan = sb.getFan();
        fan.setName(sb.getId(),"Gaggagag");
        assertEquals("Gaggagag",sb.getName());
    }
    /**
     * UC 4.1
     */
    @Test
    public void editPlayerDetTest(){
        Date d = new Date();
        sb.makePlayerActive(PlayerRole.ATTACKER,null);
        sb.setName("Gag");
        assertEquals("Gag",sb.getName());
    }

    /**
     * UC 4.2
     */
    @Test
    public void addToPageTestPlayer(){
        Date d = new Date();
        sb.makePlayerActive(PlayerRole.ATTACKER,null);
        Player player = sb.getPlayer();
        player.updatePrivatePage("test");
        assertEquals(1,player.getPrivate_page().getContent().size());
    }

    /**
     * UC 5.1
     */
    @Test
    public void editCoachDetTest(){
        Date d = new Date();
        sb.makeCoachActive(CoachRole.GoalkeeprCoach, Certification.BASIC);
        sb.setName("Gag");
        assertEquals("Gag",sb.getName());
    }

    /**
     * 5.2
     */
    @Test
    public void addToPageTestCoach(){
        Date d = new Date();
        sb.makeCoachActive(CoachRole.GoalkeeprCoach, Certification.BASIC);
        Coach coach = sb.getCoach();
        coach.updatePrivatePage("test");
        assertEquals(1,coach.getPrivate_page().getContent().size());
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
        TeamRequest tm = MyFactory.createTeamRequest("HapoelRamatGan",sb.getId());
        far.handleRequest(tm,true);
        Team t = owner.getTeam();

        Field f = MyFactory.createField("T");
        t.addField(f.getFid());

        sb.makeCoachActive(CoachRole.GoalkeeprCoach,Certification.BASIC);
        assertTrue(owner.addCoach(sb.getId()));
        assertTrue(owner.addPlayers(pl));

        assertTrue(owner.removeCoach(sb.getId()));
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
        TeamRequest tm = MyFactory.createTeamRequest("HapoelTelAviv",sb.getId());
        far.handleRequest(tm,true);

        assertTrue(owner.addTeamManager(sb1.getId()));
        assertTrue(owner.deleteTeamManager(sb1.getId()));
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
        TeamRequest tm = MyFactory.createTeamRequest("MaccabiHaifa",sb.getId());
        far.handleRequest(tm,true);

        assertTrue(owner.closeTeam());
    }

    /**
     * 8.1
     */
    @Test
    public void closeTeamPermenentlyTest(){
        sb.makeSystemManagerActive();
        sb.makeOwnerActive();
        sysMan systemManager = sb.getSysMan();
        HashSet<Integer> pl = new HashSet<>();
        Team team = MyFactory.createTeam(sb.getOwner(),"asd");
        assertTrue(systemManager.closeTeamPermanently(team.getTid()));

    }

    /**
     * 8.2
     */
    @Test
    public void removeSubscriberTest(){
        sb.makeSystemManagerActive();
        sysMan systemManager = sb.getSysMan();
        assertTrue(systemManager.removeSubscriber(sb1.getId()));
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
    }

    /**
     * UC 9.1
     */
    @Test
    public void initializeLeagueTest(){
        sb.makeFARActive();
        FAR far = sb.getFar();
        assertTrue(far.initializeLeague(LeagueLevel.NationalLeague,"T"));
    }

    /**
     * UC 9.2
     */
    @Test
    public void initializeSeasonForLeaugeTest(){

        sb.makeFARActive();
        FAR far = sb.getFar();
        far.initializeLeague(LeagueLevel.NationalLeague,"test");
        League lg = far.getAllLeagues().iterator().next();


        sb1.makeOwnerActive();
        Owner owner = sb1.getOwner();

        TeamRequest tm = MyFactory.createTeamRequest("t",owner.getSid());
        far.handleRequest(tm,true);
        Set<Integer> teams = new HashSet<>();
        teams.add(owner.getTeam().getTid());

        boolean bol = far.initializeSeasonForLeague(lg.getLid(),2010,teams);
        assertTrue(far.initializeSeasonForLeague(lg.getLid(),2010,teams));
    }


    /**
     * UC 9.3
     */
    @Test
    public void addRefereeDeleteRefereeTest(){
        sb.makeFARActive();
        FAR far = sb.getFar();
        assertTrue(far.activateReferee("Galaa","123","t",Certification.BASIC,RefereeRoll.MAIN_REFEREE));
        assertTrue(far.activateReferee("Gagaa","123","t",Certification.BASIC,RefereeRoll.MAIN_REFEREE));
    }

    /**
     * UC 9.4
     *
     * */

    @Test
    public void setLeagueReferees(){
        sb.makeFARActive();
        sb.makeRefereeActive(Certification.BASIC,RefereeRoll.MAIN_REFEREE);
        FAR far = sb.getFar();
        far.initializeLeague(LeagueLevel.NationalLeague,"te");
        League lg = far.getAllLeagues().iterator().next();
        Set<Referee> ref= new HashSet<>();
        ref.add(sb.getReferee());
        assertTrue(far.setRefereesForLeague(lg.getLid(),2010,ref));
        assertTrue(far.setRefereesForLeague(lg.getLid(),2010,ref));
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


    }

    /**
     * 9.8
     */
    @Test
    public void getNegativeBalanceTeamsTest(){
        sb.makeOwnerActive();
        Owner owner = sb.getOwner();
        HashSet<Integer> pl = new HashSet<>();

        sb1.makeFARActive();
        FAR far = sb1.getFar();
        TeamRequest tm = MyFactory.createTeamRequest("t",sb.getId());
        far.handleRequest(tm,true);

        far.getNegativeBalanceTeams();
        sb1.makeOwnerActive();


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

    }

    /**
     * 10.2, 10.3, 10.4
     */
    @Test
    public void showFutureGameTest(){

        sb.makeOwnerActive();
        Owner owner = sb.getOwner();
        Set<Referee> ref = new HashSet<>();

        sb1.makeFARActive();
        FAR far = sb1.getFar();
        TeamRequest tm = MyFactory.createTeamRequest("HapoelBeerSheva",owner.getSid());
        far.handleRequest(tm,true);
        Team t = owner.getTeam();
        Field f = MyFactory.createField("T");

        Subscriber sbRef = MyFactory.createSubscriber("refe","1234","rrr");
        sbRef.makeRefereeActive(Certification.BASIC,RefereeRoll.MAIN_REFEREE);
        Referee r1 = sbRef.getReferee();

        ref.add(r1);


        sb.makeRefereeActive(Certification.BASIC,RefereeRoll.MAIN_REFEREE);
        assertNotNull(sb.getReferee());
        Referee rf = sb.getReferee();
        Game m = MyFactory.createGame(null,null,f,t,t,ref);
        HashSet<Integer> te = new HashSet<>();

    }



/*
    @Test
    public void updatePrivatePage() {
        subscriber.makePlayerActive(playerRole.ATTACKER, LocalDate.of(99,2,22));
        Player p = subscriber.getPlayer();
        assertFalse(p.updatePrivatePage(""));
        String s1 = "check my page";
        String s2= "another check";
        Queue<String> content = new LinkedList<>();
        content.add(s1);
        content.add(s2);
        assertTrue(p.updatePrivatePage(s1));
        assertTrue(p.updatePrivatePage(s2));
        assertEquals(content, p.getPrivatePage().getContent());

    }

    @Test
    public void setRole() {
        subscriber.makePlayerActive(playerRole.ATTACKER, LocalDate.of(99,2,22));
        Player p = subscriber.getPlayer();
        assertFalse(p.setRole(null));
        assertTrue(p.setRole(playerRole.ATTACKER));
        assertEquals(p.getRole(),playerRole.ATTACKER);
    }

    @Test
    public void setDateOfBirth() {
        subscriber.makePlayerActive(playerRole.ATTACKER, LocalDate.of(99,2,22));
        Player p = subscriber.getPlayer();
        assertFalse(p.setDateOfBirth(null));
        assertTrue(p.setDateOfBirth(d));
        assertEquals(p.getDateOfBirth(),d);
    }

    @Test
    public void getPrivatePage() {
        subscriber.makePlayerActive(playerRole.ATTACKER, LocalDate.of(99,2,22));
        Player p = subscriber.getPlayer();
        Queue<String> check = new LinkedList<>();
        check.add("check my page");
        check.add("another check");
        assertEquals(check,p.getPrivatePage().getContent());
    }

    @Test
    public void getRole() {
        subscriber.makePlayerActive(playerRole.ATTACKER, LocalDate.of(99,2,22));
        Player p = subscriber.getPlayer();
        assertEquals(p.getRole(),playerRole.ATTACKER);
    }

    @Test
    public void getDateOfBirth() {
        subscriber.makePlayerActive(playerRole.ATTACKER, LocalDate.of(99,2,22));
        Player p = subscriber.getPlayer();
        assertEquals(p.getDateOfBirth(),d);
    }

    @Test
    public void deleteFromDB() {
        subscriber.makePlayerActive(playerRole.ATTACKER, LocalDate.of(99,2,22));
        Player p = subscriber.getPlayer();
        p.deleteFromDB(p.getSid());

    }
    */
}