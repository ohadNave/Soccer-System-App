package domain.Domain_Tests.DomainLayer.LeagueManagment;

import com.example.DB_Tests.DomainLayer.LeagueManagment.Field;
import com.example.DB_Tests.DomainLayer.LeagueManagment.Team;
import com.example.DB_Tests.DomainLayer.Users.Subscriber;
import org.junit.jupiter.api.Test;

//package DomainLayer.LeagueManagment;
//
//import DomainLayer.Alerts.IAlert;
//import DomainLayer.Alerts.TeamIsNowNotActiveAlert;
//import DomainLayer.DBManagerStub;
//import DomainLayer.Enums.Certification;
//import DomainLayer.Enums.CoachRole;
//import DomainLayer.Enums.playerRole;
//import DomainLayer.Users.Coach;
//import DomainLayer.Users.Owner;
//import DomainLayer.Users.Subscriber;
//import DomainLayer.Users.TeamManager;
//import com.example.demo.DomainLayer.LeagueManagment.Field;
//import com.example.demo.DomainLayer.LeagueManagment.Team;
//import com.example.demo.DomainLayer.Users.Subscriber;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.util.Date;
//import java.util.HashSet;
//import java.util.Hashtable;
//
//import static org.junit.Assert.*;
//
public class TeamTest {

    Subscriber o;
    Team t;
    Subscriber tm;
    Subscriber c;
    Field f;
    @Test
    public void test(){

    }
}
//
//    @Before
//    public void reset(){
//        o=new Subscriber("Avi","123","Avi");
//        o.makeOwnerActive();
//        tm= new Subscriber("Gadi","123","Avi");
//        tm.makeTeamManagerActive();
//        c=new Subscriber("Ido","123","Avi");
//        c.makeCoachActive(CoachRole.DefenderCoach, Certification.PROFFESIONAL);
//        f=new Field("TOTO");
//        t=new Team("test",o.getId());
//        t.makeTeamActive(playersCreation(),c.getId(),tm.getId(),f.getFid());
//
//    }
//    public HashSet<Integer> playersCreation() {
//        LocalDate date1 = LocalDate.of(1990, 3, 19);
//        LocalDate date2 = LocalDate.of(1990, 4, 19);
//        LocalDate date3 = LocalDate.of(1990, 5, 19);
//
//        HashSet<Integer> players = new HashSet<>();
//        Subscriber s1 = new Subscriber("1", "1", "1");
//        s1.makePlayerActive(playerRole.ATTACKER, date1);
//        Subscriber s2 = new Subscriber("2", "2", "2");
//        s2.makePlayerActive(playerRole.ATTACKER, date1);
//        Subscriber s3 = new Subscriber("3", "3", "3");
//        s3.makePlayerActive(playerRole.ATTACKER, date1);
//        Subscriber s4 = new Subscriber("4", "4", "4");
//        s4.makePlayerActive(playerRole.ATTACKER, date1);
//        Subscriber s5 = new Subscriber("5", "5", "5");
//        s5.makePlayerActive(playerRole.ATTACKER, date1);
//        Subscriber s6 = new Subscriber("6", "6", "6");
//        s6.makePlayerActive(playerRole.ATTACKER, date1);
//        Subscriber s7 = new Subscriber("7", "7", "7");
//        s7.makePlayerActive(playerRole.ATTACKER, date1);
//        Subscriber s8 = new Subscriber("8", "8", "8");
//        s8.makePlayerActive(playerRole.ATTACKER, date1);
//        Subscriber s9 = new Subscriber("9", "9", "9");
//        s9.makePlayerActive(playerRole.ATTACKER, date1);
//        Subscriber s10 = new Subscriber("10", "10", "10");
//        s10.makePlayerActive(playerRole.ATTACKER, date1);
//        Subscriber s11 = new Subscriber("11", "11", "11");
//        s11.makePlayerActive(playerRole.ATTACKER, date1);
//        Subscriber s12 = new Subscriber("12", "12", "12");
//        s12.makePlayerActive(playerRole.ATTACKER, date1);
//
//
//        players.add(s1.getId());
//        players.add(s2.getId());
//        players.add(s3.getId());
//        players.add(s4.getId());
//        players.add(s5.getId());
//        players.add(s6.getId());
//        players.add(s7.getId());
//        players.add(s8.getId());
//        players.add(s9.getId());
//        players.add(s10.getId());
//        players.add(s11.getId());
//        players.add(s12.getId());
//
//        return players;
//    }
//
//    @Test
//    public void closeTeamPermanently() {
//        t.closeTeamPermanently();
//        assertTrue(t.isClosedPermanently());
//        Owner owner =t.getOwner();
//        assertNull(owner);
//
//    }
//
//    @Test
//    public void addTeamManager() {
//        Subscriber tm1= new Subscriber("Avi","123","12");
//        boolean team= tm1.makeTeamManagerActive();
//        assertTrue(team);
//        boolean add=t.addTeamManager(tm1.getId());
//        assertTrue(add);
//        boolean isExist=t.getTeamManagers().contains(tm1.getId());
//        assertTrue(isExist);
//
//    }
//
//    @Test
//    public void deleteTeamManager() {
//        Subscriber tm1= new Subscriber("Avi","123","12");
//        boolean team= tm1.makeTeamManagerActive();
//        Subscriber tm2= new Subscriber("Avi","123","12");
//        boolean team2= tm1.makeTeamManagerActive();
//        assertTrue(team);
//        boolean add=t.addTeamManager(tm1.getId());
//        boolean add2=t.addTeamManager(tm2.getId());
//        boolean add3=t.deleteTeamManager(tm1.getId());
//        assertTrue(add);
//        boolean isExist=t.getTeamManagers().contains(tm1.getId());
//        assertFalse(isExist);
//    }
//
//    @Test
//    public void addPlayers() {
//        LocalDate date1 = LocalDate.of(1990, 3, 19);
//        // Player p1= new Player("18","1222","Gadi", playerRole.DEFENDER,date1);
//        Subscriber s1 = new Subscriber("1", "1", "1");
//        s1.makePlayerActive(playerRole.ATTACKER, date1);
//        HashSet<Integer> player = new HashSet<>();
//        player.add(s1.getId());
//        boolean add=t.addPlayers(player);
//        assertTrue(add);
//        boolean isExist=t.getPlayers().contains(s1.getId());
//        assertTrue(isExist);
//
//    }
//
//    @Test
//    public void removePlayer() {
//        LocalDate date1 = LocalDate.of(1990, 3, 19);
//        // Player p1= new Player("18","1222","Gadi", playerRole.DEFENDER,date1);
//        Subscriber s1 = new Subscriber("1", "1", "1");
//        s1.makePlayerActive(playerRole.ATTACKER, date1);
//        HashSet<Integer> player = new HashSet<>();
//        player.add(s1.getId());
//        boolean add=t.addPlayers(player);
//        assertTrue(add);
//        boolean isExist=t.getPlayers().contains(s1.getId());
//        assertTrue(isExist);
//        boolean remove=t.removePlayer(s1.getId());
//        boolean isExist2=t.getPlayers().contains(s1.getId());
//        assertFalse(isExist2);
//
//
//
//
//    }
//
//    @Test
//    public void editPlayerRole() {
//        LocalDate date1 = LocalDate.of(1990, 3, 19);
//        Subscriber s1 = new Subscriber("1", "1", "1");
//        s1.makePlayerActive(playerRole.ATTACKER, date1);
//        HashSet<Integer> player = new HashSet<>();
//        player.add(s1.getId());
//        boolean add=t.addPlayers(player);
//        boolean edit=t.editPlayerRole(s1.getId(),playerRole.DEFENDER);
//        assertTrue(edit);
//        assertEquals(playerRole.DEFENDER,s1.getPlayer().getRole());
//    }
//
//    @Test
//    public void editPlayerRoleNull() {
//        LocalDate date1 = LocalDate.of(1990, 3, 19);
//        Subscriber s1 = new Subscriber("1", "1", "1");
//        s1.makePlayerActive(playerRole.ATTACKER, date1);
//        HashSet<Integer> player = new HashSet<>();
//        player.add(s1.getId());
//        boolean add=t.addPlayers(player);
//        boolean edit=t.editPlayerRole(s1.getId(),null);
//        assertTrue(edit);
//        assertEquals(playerRole.ATTACKER,s1.getPlayer().getRole());
//    }
//
//    @Test
//    public void addCoach() {
//        Subscriber s1 = new Subscriber("1", "1", "1");
//        boolean active=s1.makeCoachActive(CoachRole.DefenderCoach,Certification.PROFFESIONAL);
//        assertTrue(active);
//        boolean add=t.addCoach(s1.getId());
//        assertTrue(add);
//        boolean isExist=t.getCoaches().contains(s1.getId());
//        assertTrue(isExist);
//    }
//    @Test
//    public void addCoachExist() {
//        Subscriber s1 = new Subscriber("1", "1", "1");
//        boolean active=s1.makeCoachActive(CoachRole.DefenderCoach,Certification.PROFFESIONAL);
//        assertTrue(active);
//        t.addCoach(s1.getId());
//        boolean add=t.addCoach(s1.getId());
//        assertFalse(add);
//        boolean isExist=t.getCoaches().contains(s1.getId());
//        assertTrue(isExist);
//    }
//
//    @Test
//    public void removeCoach() {
//        Subscriber s1 = new Subscriber("1", "1", "1");
//        boolean active=s1.makeCoachActive(CoachRole.DefenderCoach,Certification.PROFFESIONAL);
//        assertTrue(active);
//        boolean add=t.addCoach(s1.getId());
//        assertTrue(add);
//        boolean remove=t.removeCoach(s1.getId());
//        boolean isExist=t.getCoaches().contains(s1.getId());
//        assertFalse(isExist);
//
//    }
//
//    @Test
//    public void editCoachRole() {
//        Subscriber s1 = new Subscriber("1", "1", "1");
//        boolean active=s1.makeCoachActive(CoachRole.DefenderCoach,Certification.PROFFESIONAL);
//        assertTrue(active);
//        boolean add=t.addCoach(s1.getId());
//        assertTrue(add);
//        boolean edit=t.editCoachRole(s1.getId(),CoachRole.AttackerCoach);
//        assertTrue(edit);
//        boolean isExist=t.getCoaches().contains(s1.getId());
//        assertTrue(isExist);
//    }
//
//    @Test
//    public void editCoachRoleNull() {
//        Subscriber s1 = new Subscriber("1", "1", "1");
//        boolean active=s1.makeCoachActive(CoachRole.DefenderCoach,Certification.PROFFESIONAL);
//        assertTrue(active);
//        boolean add=t.addCoach(s1.getId());
//        assertTrue(add);
//        boolean edit=t.editCoachRole(s1.getId(),null);
//        assertFalse(edit);
//        boolean isExist=t.getCoaches().contains(s1.getId());
//        assertTrue(isExist);
//        assertEquals(CoachRole.DefenderCoach,s1.getCoach().getRole());
//    }
//
//    @Test
//    public void addField() {
//        Field f=new Field("TOTO");
//        //DBManagerStub.addField(f.getFid(),f);
//        boolean add=t.addField(f.getFid());
//        boolean isExist=t.getFields().contains(f.getFid());
//        assertTrue(isExist);
//
//    }
//
//    @Test
//    public void removeField() {
//        Field f=new Field("TOTO");
//        //DBManagerStub.addField(f.getFid(),f);
//        boolean add=t.addField(f.getFid());
//        boolean isExist=t.getFields().contains(f.getFid());
//        assertTrue(isExist);
//        boolean remove=t.removeField(f.getFid());
//        assertTrue(remove);
//        boolean isExist2=t.getFields().contains(f.getFid());
//        assertFalse(isExist2);
//
//    }
//
//    @Test
//    public void editFieldName() {
//        Field f=new Field("TOTO");
//        //DBManagerStub.addField(f.getFid(),f);
//        boolean add=t.addField(f.getFid());
//        boolean isExist=t.getFields().contains(f.getFid());
//        assertTrue(isExist);
//        boolean edit=t.editFieldName(f.getFid(),"TOTO2");
//        assertTrue(edit);
//        assertEquals("TOTO2",f.getName());
//    }
//
//    @Test
//    public void startNewSeason() {
//        boolean start=t.startNewSeason(2020);
//        assertTrue(start);
//        boolean isExist=t.getAllTeamSeasons().containsKey(2020);
//        assertTrue(isExist);
//
//
//    }
//
//    @Test
//    public void startNewSeasonNull() {
//        boolean start=t.startNewSeason(0);
//        assertFalse(start);
//
//
//
//    }
//
//    @Test
//    public void makeTeamActive() {
//        tm= new Subscriber("Gadi","123","Avi");
//        tm.makeTeamManagerActive();
//        c=new Subscriber("Ido","123","Avi");
//        c.makeCoachActive(CoachRole.DefenderCoach, Certification.PROFFESIONAL);
//        f=new Field("TOTO");
//        t.makeTeamActive(playersCreation(),c.getId(),tm.getId(),f.getFid());
//        boolean cExist=t.getCoaches().contains(c.getId());
//        assertTrue(cExist);
//        boolean tmExist=t.getTeamManagers().contains(tm.getId());
//        assertTrue(tmExist);
//        boolean fExist=t.getFields().contains(f.getFid());
//        assertTrue(fExist);
//        assertTrue(t.isActive());
//    }
//
//    @Test
//    public void updateTeamPrivatePage() {
//        String content="testest";
//        boolean update=t.updateTeamPrivatePage(content);
//        assertTrue(update);
//        boolean isExist=t.getPrivatePage().getContent().contains("testest");
//        assertTrue(isExist);
//    }
//
//    @Test
//    //waiting for dev of ohad
//    public void notifySystemManager() {
//    }
//
//    @Test
//    public void notifyOwners() {
//        IAlert alert=new TeamIsNowNotActiveAlert(t);
//        t.notifyOwners(alert);
//        int size=t.getOwner().getAlerts().size();
//        assertEquals(size,1);
//    }
//
//    @Test
//    public void notifyTeamManagers() {
//        IAlert alert=new TeamIsNowNotActiveAlert(t);
//        t.notifyTeamManagers(alert);
//        for (Integer tm: t.getTeamManagers()) {
//           int size= DBManagerStub.getTeamManager(tm).getAlerts().size();
//            assertEquals(size,1);
//        }
//
//    }
//
//    @Test
//    public void notifyTeamPrivatePageFollowers() {
//        Subscriber f1=new Subscriber("Avi","aaa","aa");
//        f1.makeFanActive();
//        f1.getFan().followPage(t.getPrivatePage().getPageId());
//        Subscriber f2=new Subscriber("Avi","aaa","aa");
//        f2.makeFanActive();
//        f2.getFan().followPage(t.getPrivatePage().getPageId());
//
//        HashSet<Integer> funs=new HashSet<>();
//        funs.add(f1.getId());
//        funs.add(f2.getId());
//        t.getPrivatePage().setFollowers(funs);
//        IAlert alert=new TeamIsNowNotActiveAlert(t);
//        t.notifyTeamPrivatePageFollowers(alert);
//        for (Integer tm: t.getPrivatePage().getFollowers()) {
//            int size= DBManagerStub.getFan(tm).getAlerts().size();
//            assertEquals(size,1);
//        }
//
//    }
//
//    @Test
//    public void setTeamManagerPermisions() {
//        Subscriber s1 = new Subscriber("18", "1222", "Gadi");
//        boolean m = s1.makeTeamManagerActive();
//        t.addTeamManager(s1.getId());
//        assertTrue(m);
//        boolean set = t.setTeamManagerPermisions(s1.getId(), true, true, false, false, true, true, true, false, true);
//        assertTrue(set);
//    }
//
//
//
//
//    @Test
//    public void getName() {
//       assertEquals(t.getName(),"test");
//    }
//
//    @Test
//    public void setName() {
//        t.setName("TOTO");
//        assertEquals(t.getName(),"TOTO");
//
//
//    }
//
//    @Test
//    public void setTeamActive() {
//        t.setTeamActive();
//        assertTrue(t.isActive());
//    }
//
//
//
//    @Test
//    public void setOwner() {
//        o=new Subscriber("Avi","123","Avi");
//        o.makeOwnerActive();
//        t.setOwner(o.getId());
//        assertEquals(o.getId(),t.getOwner().getSid());
//
//    }
//
//    @Test
//    public void setTeamNotActive() {
//        t.setTeamNotActive();
//        assertFalse(t.isActive());
//    }
//
//    @Test
//    public void setCoaches() {
//        HashSet<Integer> coaches=new HashSet<>();
//
//        Subscriber s10 = new Subscriber("10", "10", "10");
//        s10.makeCoachActive(CoachRole.DefenderCoach,Certification.PROFFESIONAL);
//        Subscriber s11 = new Subscriber("11", "11", "11");
//        s11.makeCoachActive(CoachRole.DefenderCoach,Certification.PROFFESIONAL);
//        coaches.add(s10.getId());
//        coaches.add(s11.getId());
//        t.setCoaches(coaches);
//        boolean isExist=t.getCoaches().contains(s10.getId());
//        assertTrue(isExist);
//    }
//
//
//
//    @Test
//    public void setActive() {
//        t.setActive(true);
//        assertTrue(t.isActive());
//    }
//
//
//    @Test
//    public void setMatches() {
//        Date d= new Date();
//        Match m= new Match(d, LocalTime.now(),1,1,1,1,1,1);
//        HashSet<Integer>match=new HashSet<>();
//        match.add(m.getMatchId());
//        t.setMatches(match);
//        boolean isExist=t.getMatches().contains(m.getMatchId());
//        assertTrue(isExist);
//
//    }
//
//
//
//
//
//
//
//}