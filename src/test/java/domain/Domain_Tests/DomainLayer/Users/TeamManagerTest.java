package domain.Domain_Tests.DomainLayer.Users;

import org.junit.Test;

//package DomainLayer.Users;
//
//import DomainLayer.Alerts.IAlert;
//import DomainLayer.Alerts.TeamIsNowNotActiveAlert;
//import DomainLayer.DBManagerStub;
//import DomainLayer.Enums.Certification;
//import DomainLayer.Enums.CoachRole;
//import DomainLayer.Enums.playerRole;
//import DomainLayer.LeagueManagment.Field;
//import DomainLayer.LeagueManagment.Team;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.time.LocalDate;
//import java.util.HashSet;
//
//import static org.junit.Assert.*;
//
public class TeamManagerTest {

    @Test
    private void v(){

    }
}

    //    Subscriber tm;
//
//    @Before
//    public void reset(){
//        tm=new Subscriber("avi","123","12");
//        tm.makeTeamManagerActive();
//        tm.getTeamManager().setPermissions(true,true,true,true,true,true,true,true,true);
//
//
//    }
//
//
//
//    @Test
//    public void setPermissions() {
//
//        tm.getTeamManager().setPermissions(true,true,true,true,true,true,true,true,true);
//        //tm.getTeamManager().
//    }
//
//
//
//    @Test
//    public void update() {
//        Subscriber o=new Subscriber("ss","ss","ss");
//        o.makeOwnerActive();
//        Team t=new Team("winners",o.getId());
//        t.setActive(true);
//        DBManagerStub.addTeam(t.getTid(),t);
//        IAlert alert=new TeamIsNowNotActiveAlert(t);
//        IAlert alert2=new TeamIsNowNotActiveAlert(t);
//        tm.getTeamManager().update(t,alert);
//        tm.getTeamManager().update(t,alert2);
//        TeamManager tm1=DBManagerStub.getTeamManager(tm.getId());
//        int sizeAlert=tm1.getAlerts().size();
//        assertEquals(sizeAlert,2);
//    }
//
//
//    @Test
//    public void setOwner() {
//        Subscriber o=new Subscriber("12","12","1");
//        o.makeOwnerActive();
//        tm.getTeamManager().setOwner(o.getId());
//       assertEquals(tm.getTeamManager().getOwnerId(),o.getId());
//    }
//
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
//    public void addPlayers() {
//        Subscriber o=new Subscriber("12","12","1");
//        o.makeOwnerActive();
//        tm.getTeamManager().setOwner(o.getId());
//        Team t=new Team("win",o.getId());
//        DBManagerStub.addTeam(t.getTid(),t);
//        o.getOwner().setTeam(t.getTid());
//         boolean add= tm.getTeamManager().addPlayers(playersCreation());
//         assertTrue(add);
//         Team t2=DBManagerStub.getTeam(t.getTid());
//         int size=t2.getPlayers().size();
//         int size2=DBManagerStub.getOwner(tm.getTeamManager().getOwnerId()).getTeam().getPlayers().size();
//         assertEquals(size,size2);
//
//
//    }
//    @Test
//    public void addPlayersNull() {
//        Subscriber o=new Subscriber("12","12","1");
//        o.makeOwnerActive();
//        tm.getTeamManager().setOwner(o.getId());
//        Team t=new Team("win",o.getId());
//        DBManagerStub.addTeam(t.getTid(),t);
//        o.getOwner().setTeam(t.getTid());
//        boolean add= tm.getTeamManager().addPlayers(null);
//        assertFalse(add);
////        Team t2=DBManagerStub.getTeam(t.getTid());
////        int size=t2.getPlayers().size();
////        int size2=DBManagerStub.getOwner(tm.getTeamManager().getOwnerId()).getTeam().getPlayers().size();
////        assertEquals(size,size2);
//
//
//    }
//
//    @Test
//    public void removePlayer() {
//        LocalDate date1 = LocalDate.of(1990, 4, 19);
//        Subscriber s1 = new Subscriber("1", "1", "1");
//        s1.makePlayerActive(playerRole.ATTACKER, date1);
//        Subscriber o=new Subscriber("12","12","1");
//        o.makeOwnerActive();
//        tm.getTeamManager().setOwner(o.getId());
//        Team t=new Team("win",o.getId());
//        DBManagerStub.addTeam(t.getTid(),t);
//        o.getOwner().setTeam(t.getTid());
//        boolean add= tm.getTeamManager().addPlayers(playersCreation());
//        assertTrue(add);
//        Team t2=DBManagerStub.getTeam(t.getTid());
//        HashSet<Integer>player=new HashSet<>();
//        player.add(s1.getId());
//        tm.getTeamManager().addPlayers(player);
//      //  int size=t2.getPlayers().size();
//      //  int size2=DBManagerStub.getOwner(tm.getTeamManager().getOwnerId()).getTeam().getPlayers().size();
//       // assertEquals(size,size2);
//       boolean remove= tm.getTeamManager().removePlayer(s1.getId());
//       assertTrue(remove);
//       boolean isExist=DBManagerStub.getOwner(tm.getTeamManager().getOwnerId()).getTeam().getPlayers().contains(s1.getId());
//       assertFalse(isExist);
//
//    }
//
//    @Test
//    public void removePlayerNull() {
//        LocalDate date1 = LocalDate.of(1990, 4, 19);
//        Subscriber s1 = new Subscriber("1", "1", "1");
//        s1.makePlayerActive(playerRole.ATTACKER, date1);
//        Subscriber o=new Subscriber("12","12","1");
//        o.makeOwnerActive();
//        tm.getTeamManager().setOwner(o.getId());
//        Team t=new Team("win",o.getId());
//        DBManagerStub.addTeam(t.getTid(),t);
//        o.getOwner().setTeam(t.getTid());
//        boolean add= tm.getTeamManager().addPlayers(playersCreation());
//        assertTrue(add);
//        Team t2=DBManagerStub.getTeam(t.getTid());
//        HashSet<Integer>player=new HashSet<>();
//        player.add(s1.getId());
//        tm.getTeamManager().addPlayers(player);
//        //  int size=t2.getPlayers().size();
//        //  int size2=DBManagerStub.getOwner(tm.getTeamManager().getOwnerId()).getTeam().getPlayers().size();
//        // assertEquals(size,size2);
//        boolean remove= tm.getTeamManager().removePlayer(0);
//        assertFalse(remove);
//        boolean isExist=DBManagerStub.getOwner(tm.getTeamManager().getOwnerId()).getTeam().getPlayers().contains(s1.getId());
//        assertTrue(isExist);
//
//    }
//
//    @Test
//    public void editPlayerRole() {
//        LocalDate date1 = LocalDate.of(1990, 4, 19);
//        Subscriber s1 = new Subscriber("1", "1", "1");
//        s1.makePlayerActive(playerRole.ATTACKER, date1);
//        Subscriber o=new Subscriber("12","12","1");
//        o.makeOwnerActive();
//        tm.getTeamManager().setOwner(o.getId());
//        Team t=new Team("win",o.getId());
//        DBManagerStub.addTeam(t.getTid(),t);
//        o.getOwner().setTeam(t.getTid());
//        boolean add= tm.getTeamManager().addPlayers(playersCreation());
//        assertTrue(add);
//        Team t2=DBManagerStub.getTeam(t.getTid());
//        HashSet<Integer>player=new HashSet<>();
//        player.add(s1.getId());
//        tm.getTeamManager().addPlayers(player);
//        //  int size=t2.getPlayers().size();
//        //  int size2=DBManagerStub.getOwner(tm.getTeamManager().getOwnerId()).getTeam().getPlayers().size();
//        // assertEquals(size,size2);
//        boolean edit= tm.getTeamManager().editPlayerRole(s1.getId(),playerRole.DEFENDER);
//        assertTrue(edit);
//        assertEquals(playerRole.DEFENDER,s1.getPlayer().getRole());
//    }
//
//    @Test
//    public void editPlayerRoleNull() {
//        LocalDate date1 = LocalDate.of(1990, 4, 19);
//        Subscriber s1 = new Subscriber("1", "1", "1");
//        s1.makePlayerActive(playerRole.ATTACKER, date1);
//        Subscriber o=new Subscriber("12","12","1");
//        o.makeOwnerActive();
//        tm.getTeamManager().setOwner(o.getId());
//        Team t=new Team("win",o.getId());
//        DBManagerStub.addTeam(t.getTid(),t);
//        o.getOwner().setTeam(t.getTid());
//        boolean add= tm.getTeamManager().addPlayers(playersCreation());
//        assertTrue(add);
//        Team t2=DBManagerStub.getTeam(t.getTid());
//        HashSet<Integer>player=new HashSet<>();
//        player.add(s1.getId());
//        tm.getTeamManager().addPlayers(player);
//        //  int size=t2.getPlayers().size();
//        //  int size2=DBManagerStub.getOwner(tm.getTeamManager().getOwnerId()).getTeam().getPlayers().size();
//        // assertEquals(size,size2);
//        boolean edit= tm.getTeamManager().editPlayerRole(s1.getId(),null);
//        assertFalse(edit);
//        assertEquals(playerRole.ATTACKER,s1.getPlayer().getRole());
//    }
//
//
//    @Test
//    public void addCoach() {
//        Subscriber s1 = new Subscriber("1", "1", "1");
//        s1.makeCoachActive(CoachRole.AttackerCoach, Certification.INTERMIDATE);
//        Subscriber o=new Subscriber("12","12","1");
//        o.makeOwnerActive();
//        tm.getTeamManager().setOwner(o.getId());
//        Team t=new Team("win",o.getId());
//        DBManagerStub.addTeam(t.getTid(),t);
//        o.getOwner().setTeam(t.getTid());
//        boolean add=tm.getTeamManager().addCoach(s1.getId());
//        assertTrue(add);
//        boolean isExist=DBManagerStub.getOwner(tm.getTeamManager().getOwnerId()).getTeam().getCoaches().contains(s1.getId());
//        assertTrue(isExist);
//
//
//
//    }
//
//    @Test
//    public void addCoachNull() {
//        Subscriber s1 = new Subscriber("1", "1", "1");
//        s1.makeCoachActive(CoachRole.AttackerCoach, Certification.INTERMIDATE);
//        Subscriber o=new Subscriber("12","12","1");
//        o.makeOwnerActive();
//        tm.getTeamManager().setOwner(o.getId());
//        Team t=new Team("win",o.getId());
//        DBManagerStub.addTeam(t.getTid(),t);
//        o.getOwner().setTeam(t.getTid());
//        boolean add=tm.getTeamManager().addCoach(0);
//        assertFalse(add);
//        boolean isExist=DBManagerStub.getOwner(tm.getTeamManager().getOwnerId()).getTeam().getCoaches().contains(s1.getId());
//        assertFalse(isExist);
//
//
//
//    }
//
//
//    @Test
//    public void removeCoach() {
//
//        Subscriber s1 = new Subscriber("1", "1", "1");
//        s1.makeCoachActive(CoachRole.AttackerCoach, Certification.INTERMIDATE);
//        Subscriber o=new Subscriber("12","12","1");
//        o.makeOwnerActive();
//        tm.getTeamManager().setOwner(o.getId());
//        Team t=new Team("win",o.getId());
//        DBManagerStub.addTeam(t.getTid(),t);
//        o.getOwner().setTeam(t.getTid());
//        boolean add=tm.getTeamManager().addCoach(s1.getId());
//        assertTrue(add);
//        boolean isExist=DBManagerStub.getOwner(tm.getTeamManager().getOwnerId()).getTeam().getCoaches().contains(s1.getId());
//        assertTrue(isExist);
//        boolean remove=tm.getTeamManager().removeCoach(s1.getId());
//        assertTrue(remove);
//        boolean isExist2=DBManagerStub.getOwner(tm.getTeamManager().getOwnerId()).getTeam().getCoaches().contains(s1.getId());
//        assertFalse(isExist2);
//    }
//    @Test
//    public void removeCoachNull() {
//
//        Subscriber s1 = new Subscriber("1", "1", "1");
//        s1.makeCoachActive(CoachRole.AttackerCoach, Certification.INTERMIDATE);
//        Subscriber o=new Subscriber("12","12","1");
//        o.makeOwnerActive();
//        tm.getTeamManager().setOwner(o.getId());
//        Team t=new Team("win",o.getId());
//        DBManagerStub.addTeam(t.getTid(),t);
//        o.getOwner().setTeam(t.getTid());
//        boolean add=tm.getTeamManager().addCoach(s1.getId());
//        assertTrue(add);
//        boolean isExist=DBManagerStub.getOwner(tm.getTeamManager().getOwnerId()).getTeam().getCoaches().contains(s1.getId());
//        assertTrue(isExist);
//        boolean remove=tm.getTeamManager().removeCoach(0);
//        assertFalse(remove);
//        boolean isExist2=DBManagerStub.getOwner(tm.getTeamManager().getOwnerId()).getTeam().getCoaches().contains(s1.getId());
//        assertTrue(isExist2);
//    }
//
//    @Test
//    public void editCoachRole() {
//
//        Subscriber s1 = new Subscriber("1", "1", "1");
//        s1.makeCoachActive(CoachRole.AttackerCoach, Certification.INTERMIDATE);
//        Subscriber o=new Subscriber("12","12","1");
//        o.makeOwnerActive();
//        tm.getTeamManager().setOwner(o.getId());
//        Team t=new Team("win",o.getId());
//        DBManagerStub.addTeam(t.getTid(),t);
//        o.getOwner().setTeam(t.getTid());
//        boolean add=tm.getTeamManager().addCoach(s1.getId());
//        assertTrue(add);
//        boolean isExist=DBManagerStub.getOwner(tm.getTeamManager().getOwnerId()).getTeam().getCoaches().contains(s1.getId());
//        assertTrue(isExist);
//        boolean edit=tm.getTeamManager().editCoachRole(s1.getId(),CoachRole.DefenderCoach);
//        assertTrue(edit);
//        assertEquals(CoachRole.DefenderCoach,s1.getCoach().getRole());
//
//
//    }
//
//    @Test
//    public void editCoachRoleNull() {
//
//        Subscriber s1 = new Subscriber("1", "1", "1");
//        s1.makeCoachActive(CoachRole.AttackerCoach, Certification.INTERMIDATE);
//        Subscriber o=new Subscriber("12","12","1");
//        o.makeOwnerActive();
//        tm.getTeamManager().setOwner(o.getId());
//        Team t=new Team("win",o.getId());
//        DBManagerStub.addTeam(t.getTid(),t);
//        o.getOwner().setTeam(t.getTid());
//        boolean add=tm.getTeamManager().addCoach(s1.getId());
//        assertTrue(add);
//        boolean isExist=DBManagerStub.getOwner(tm.getTeamManager().getOwnerId()).getTeam().getCoaches().contains(s1.getId());
//        assertTrue(isExist);
//        boolean edit=tm.getTeamManager().editCoachRole(s1.getId(),null);
//        assertFalse(edit);
//        assertEquals(CoachRole.AttackerCoach,s1.getCoach().getRole());
//
//
//    }
//
//    @Test
//    public void addField() {
//        Subscriber o=new Subscriber("12","12","1");
//        o.makeOwnerActive();
//        tm.getTeamManager().setOwner(o.getId());
//        Team t=new Team("win",o.getId());
//        t.setActive(true);
//        DBManagerStub.addTeam(t.getTid(),t);
//        o.getOwner().setTeam(t.getTid());
//        Field f=new Field("TOTO");
//
//        boolean add=tm.getTeamManager().addField(f.getFid());
//        assertTrue(add);
//        boolean isExist2=DBManagerStub.getOwner(tm.getTeamManager().getOwnerId()).getTeam().getFields().contains(f.getFid());
//        assertTrue(isExist2);
//
//    }
//
//    @Test
//    public void addFieldNull() {
//        Subscriber o=new Subscriber("12","12","1");
//        o.makeOwnerActive();
//        tm.getTeamManager().setOwner(o.getId());
//        Team t=new Team("win",o.getId());
//        t.setActive(true);
//        DBManagerStub.addTeam(t.getTid(),t);
//        o.getOwner().setTeam(t.getTid());
//        Field f=new Field("TOTO");
//
//        boolean add=tm.getTeamManager().addField(0);
//        assertFalse(add);
//        boolean isExist2=DBManagerStub.getOwner(tm.getTeamManager().getOwnerId()).getTeam().getFields().contains(f.getFid());
//        assertFalse(isExist2);
//
//    }
//
//    @Test
//    public void removeFieldNull() {
//
//            Subscriber o=new Subscriber("12","12","1");
//            o.makeOwnerActive();
//            tm.getTeamManager().setOwner(o.getId());
//            Team t=new Team("win",o.getId());
//            t.setActive(true);
//            DBManagerStub.addTeam(t.getTid(),t);
//            o.getOwner().setTeam(t.getTid());
//            Field f=new Field("TOTO");
//
//            boolean add=tm.getTeamManager().addField(f.getFid());
//            assertTrue(add);
//            boolean isExist2=DBManagerStub.getOwner(tm.getTeamManager().getOwnerId()).getTeam().getFields().contains(f.getFid());
//            assertTrue(isExist2);
//
//        boolean remove=tm.getTeamManager().removeField(f.getFid());
//        assertTrue(remove);
//        boolean isExist3=DBManagerStub.getOwner(tm.getTeamManager().getOwnerId()).getTeam().getFields().contains(f.getFid());
//        assertFalse(isExist3);
//
//        }
//
//    @Test
//    public void removeField() {
//
//        Subscriber o=new Subscriber("12","12","1");
//        o.makeOwnerActive();
//        tm.getTeamManager().setOwner(o.getId());
//        Team t=new Team("win",o.getId());
//        t.setActive(true);
//        DBManagerStub.addTeam(t.getTid(),t);
//        o.getOwner().setTeam(t.getTid());
//        Field f=new Field("TOTO");
//
//        boolean add=tm.getTeamManager().addField(f.getFid());
//        assertTrue(add);
//        boolean isExist2=DBManagerStub.getOwner(tm.getTeamManager().getOwnerId()).getTeam().getFields().contains(f.getFid());
//        assertTrue(isExist2);
//
//        boolean remove=tm.getTeamManager().removeField(0);
//        assertFalse(remove);
//        boolean isExist3=DBManagerStub.getOwner(tm.getTeamManager().getOwnerId()).getTeam().getFields().contains(f.getFid());
//        assertTrue(isExist3);
//
//    }
//
//
//    @Test
//    public void editFieldName() {
//        Subscriber o=new Subscriber("12","12","1");
//        o.makeOwnerActive();
//        tm.getTeamManager().setOwner(o.getId());
//        Team t=new Team("win",o.getId());
//        t.setActive(true);
//        DBManagerStub.addTeam(t.getTid(),t);
//        o.getOwner().setTeam(t.getTid());
//        Field f=new Field("TOTO");
//
//        boolean add=tm.getTeamManager().addField(f.getFid());
//        assertTrue(add);
//        boolean isExist2=DBManagerStub.getOwner(tm.getTeamManager().getOwnerId()).getTeam().getFields().contains(f.getFid());
//        assertTrue(isExist2);
//        boolean edit=tm.getTeamManager().editFieldName(f.getFid(),"TOTO2");
//        assertTrue(edit);
//        assertEquals("TOTO2",f.getName());
//    }
//
//    @Test
//    public void editFieldNameNull() {
//        Subscriber o=new Subscriber("12","12","1");
//        o.makeOwnerActive();
//        tm.getTeamManager().setOwner(o.getId());
//        Team t=new Team("win",o.getId());
//        t.setActive(true);
//        DBManagerStub.addTeam(t.getTid(),t);
//        o.getOwner().setTeam(t.getTid());
//        Field f=new Field("TOTO");
//
//        boolean add=tm.getTeamManager().addField(f.getFid());
//        assertTrue(add);
//        boolean isExist2=DBManagerStub.getOwner(tm.getTeamManager().getOwnerId()).getTeam().getFields().contains(f.getFid());
//        assertTrue(isExist2);
//        boolean edit=tm.getTeamManager().editFieldName(f.getFid(),null);
//        assertFalse(edit);
//        assertEquals("TOTO",f.getName());
//    }
//
//    @Test
//    public void deleteFromDB() {
////        Subscriber o=new Subscriber("12","12","1");
////        o.makeOwnerActive();
////        tm.getTeamManager().setOwner(o.getId());
////        Team t=new Team("win",o.getId());
////        t.setActive(true);
////        DBManagerStub.addTeam(t.getTid(),t);
////        o.getOwner().setTeam(t.getTid());
//        boolean delete=tm.getTeamManager().deleteFromDB(tm.getId());
//        assertTrue(delete);
//        TeamManager s=DBManagerStub.getTeamManager(tm.getId());
//        assertNull(s);
//
//    }
//
//
//}