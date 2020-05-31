package domain.Domain_Tests.DomainLayer.Users;

import org.junit.jupiter.api.Test;

//package DomainLayer.Users;
//
//import DomainLayer.Alerts.GameEventAlert;
//import DomainLayer.Alerts.IAlert;
//import DomainLayer.DBManagerStub;
//import DomainLayer.Enums.*;
//import DomainLayer.LeagueManagment.*;
//import DomainLayer.Users.Coach;
//import DomainLayer.Users.Owner;
//import DomainLayer.Users.Player;
//import DomainLayer.Users.TeamManager;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.time.LocalDate;
//import java.util.HashMap;
//import java.util.HashSet;
//
//import static org.junit.Assert.*;
//import static org.junit.Assert.assertEquals;
//import DomainLayer.Enums.CoachRole;
//import DomainLayer.Enums.playerRole;
////import DomainLayer.I_Observer.ISubjectTeam;
//import DomainLayer.LeagueManagment.Field;
//import DomainLayer.LeagueManagment.Team;
//import DomainLayer.Users.*;
//import org.junit.Test;
//import sun.print.PSPrinterJob;
//
//import javax.print.attribute.standard.NumberUp;
//import java.time.LocalDate;
//import java.util.HashSet;
//import java.time.LocalDate;
//
//import static org.junit.Assert.*;
////
public class OwnerTest {

    @Test
    private void d(){

    }
}
//    //
//    Subscriber s;
//    DBManagerStub data = new DBManagerStub();
//
//    //
////
////
////      //  Coach coach= new Coach("1","12223","Tamir", CoachRole.DefenderCoach);
//    Team team;
//
//    //      //  Owner o1=new Owner("BigAvi","1233","Avi",coach,team);
//    @Before
//    public void reset2() {
//        s = new Subscriber("bigAvi", "123", "Avi");
//        team = new Team("winners", s.getId());
//
//        s.makeOwnerActive();
//        s.getOwner().setTeam(team.getTid());
//        data.addTeam(team.getTid(), team);
//
//    }
//
//    //
////        //TeamManager tm=new TeamManager("123","345","12",o1);
////        //Field f=new Field("test");
////        //Team team2=new Team("test",playersCreation(),coach,tm,f,o1);
////
//////        public  void reset(){
//////            team.makeTeamActive(playersCreation(),coach,tm,f);
//////        }
////
////
//    @Test
//
//    //failed - there is no team to owner
//    public void addPlayers() {
//        // reset();
//        boolean succeed = s.getOwner().addPlayers(playersCreation());
//        assertTrue(succeed);
//        int size = s.getOwner().getTeam().getPlayers().size();
//        assertEquals(size, 12);
//    }
//
//    @Test
//
//    //failed - there is no team to owner
//    public void addPlayersNull() {
//        // reset();
//        boolean succeed = s.getOwner().addPlayers(null);
//        assertFalse(succeed);
//        int size = s.getOwner().getTeam().getPlayers().size();
//        assertEquals(size, 0);
//    }
//
//    //
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
//    //        @Test
////        public void addPlayersNullTeam(){
////            Team team = null;
////            boolean succeed =o1.addPlayers(null);
////            assertFalse(succeed);
////        }
////
////
//    @Test
//    //passed - there is no access to this.players.size in Team-it's null
//    public void removePlayer() {
//        s.getOwner().addPlayers(playersCreation());
//        LocalDate date1 = LocalDate.of(1990, 3, 19);
//        // Player p1= new Player("18","1222","Gadi", playerRole.DEFENDER,date1);
//        Subscriber s1 = new Subscriber("1", "1", "1");
//        s1.makePlayerActive(playerRole.ATTACKER, date1);
//        HashSet<Integer> player = new HashSet<>();
//        player.add(s1.getId());
//
//        boolean succeeded2 = s.getOwner().addPlayers(player);
//        assertTrue(succeeded2);
//        int size = s.getOwner().getTeam().getPlayers().size();
//        boolean succeesed = s.getOwner().removePlayer(s1.getId());
//        assertTrue(succeesed);
//        boolean notExist = s.getOwner().getTeam().getPlayers().contains(s1);
//        assertEquals(size - 1, s.getOwner().getTeam().getPlayers().size());
//        assertFalse(notExist);
//    }
//
//    @Test
//    //passed - there is no access to this.players.size in Team-it's null
//    public void removePlayerNotExist() {
//        s.getOwner().addPlayers(playersCreation());
//        LocalDate date1 = LocalDate.of(1990, 3, 19);
//        // Player p1= new Player("18","1222","Gadi", playerRole.DEFENDER,date1);
//        Subscriber s1 = new Subscriber("1", "1", "1");
//        s1.makePlayerActive(playerRole.ATTACKER, date1);
//        HashSet<Integer> player = new HashSet<>();
//        player.add(s1.getId());
//
//        boolean succeeded2 = s.getOwner().addPlayers(player);
//        assertTrue(succeeded2);
//        int size = s.getOwner().getTeam().getPlayers().size();
//        boolean succeesed = s.getOwner().removePlayer(0);
//        assertFalse(succeesed);
//        boolean notExist = s.getOwner().getTeam().getPlayers().contains(s1);
//        assertEquals(size, s.getOwner().getTeam().getPlayers().size());
//        assertFalse(notExist);
//    }
//
//    @Test
//    public void editPlayerRole() {
//        s.getOwner().addPlayers(playersCreation());
//        LocalDate date1 = LocalDate.of(1990, 3, 19);
//        Subscriber s1 = new Subscriber("18", "1222", "Gadi");
//        s1.makePlayerActive(playerRole.DEFENDER, date1);
//        // Player p1= new Player("18","1222","Gadi", playerRole.DEFENDER,date1);
//        HashSet<Integer> player = new HashSet<>();
//        player.add(s1.getId());
//        boolean succeeded2 = s.getOwner().addPlayers(player);
//        boolean suc = s.getOwner().editPlayerRole(s1.getId(), playerRole.ATTACKER);
//        assertTrue(suc);
//        assertEquals(playerRole.ATTACKER, s1.getPlayer().getRole());
//    }
//
//    @Test
//    public void editPlayerRoleNull() {
//        s.getOwner().addPlayers(playersCreation());
//        LocalDate date1 = LocalDate.of(1990, 3, 19);
//        Subscriber s1 = new Subscriber("18", "1222", "Gadi");
//        s1.makePlayerActive(playerRole.DEFENDER, date1);
//        // Player p1= new Player("18","1222","Gadi", playerRole.DEFENDER,date1);
//        HashSet<Integer> player = new HashSet<>();
//        player.add(s1.getId());
//        boolean succeeded2 = s.getOwner().addPlayers(player);
//        boolean suc = s.getOwner().editPlayerRole(s1.getId(), null);
//        assertFalse(suc);
//        assertEquals(playerRole.DEFENDER, s1.getPlayer().getRole());
//    }
//
//    @Test
//    public void addCoach() {
//        Subscriber s1 = new Subscriber("18", "1222", "Gadi");
//        boolean passed = s1.makeCoachActive(CoachRole.DefenderCoach, Certification.PROFFESIONAL);
//        assertTrue(passed);
//        boolean add = s.getOwner().addCoach(s1.getId());
//        assertTrue(add);
//        boolean isExist = s.getOwner().getTeam().getCoaches().contains(s1.getId());
//        assertTrue(isExist);
//    }
//
//    @Test
//    public void addCoachExist() {
//        Subscriber s1 = new Subscriber("18", "1222", "Gadi");
//        boolean passed = s1.makeCoachActive(CoachRole.DefenderCoach, Certification.PROFFESIONAL);
//        assertTrue(passed);
//        boolean add = s.getOwner().addCoach(s1.getId());
//        boolean add2 = s.getOwner().addCoach(s1.getId());
//
//        assertFalse(add2);
//
//    }
//
//    @Test
//
//    public void removeCoach() {
//        Subscriber s1 = new Subscriber("18", "1222", "Gadi");
//        boolean passed = s1.makeCoachActive(CoachRole.DefenderCoach, Certification.PROFFESIONAL);
//        assertTrue(passed);
//        boolean add = s.getOwner().addCoach(s1.getId());
//        assertTrue(add);
//        boolean remove = s.getOwner().removeCoach(s1.getId());
//        assertTrue(remove);
//        boolean isExist = s.getOwner().getTeam().getCoaches().contains(s1.getId());
//        assertFalse(isExist);
//    }
//
//    @Test
//
//    public void removeCoachNotExist() {
//
//        boolean remove = s.getOwner().removeCoach(0);
//        assertFalse(remove);
//
//    }
//
//    @Test
//
//    public void editCoachRole() {
//        Subscriber s1 = new Subscriber("18", "1222", "Gadi");
//        boolean passed = s1.makeCoachActive(CoachRole.DefenderCoach, Certification.PROFFESIONAL);
//        assertTrue(passed);
//        s.getOwner().addCoach(s1.getId());
//        boolean add = s.getOwner().editCoachRole(s1.getId(), CoachRole.AttackerCoach);
//        assertTrue(add);
//        assertEquals(CoachRole.AttackerCoach, s1.getCoach().getRole());
//
//
//    }
//
//    @Test
//    public void editCoachRoleNull() {
//        Subscriber s1 = new Subscriber("18", "1222", "Gadi");
//        boolean passed = s1.makeCoachActive(CoachRole.DefenderCoach, Certification.PROFFESIONAL);
//        assertTrue(passed);
//        s.getOwner().addCoach(s1.getId());
//        boolean add = s.getOwner().editCoachRole(s1.getId(), null);
//        assertFalse(add);
//        assertEquals(CoachRole.DefenderCoach, s1.getCoach().getRole());
//
//    }
//
//    @Test
//    public void addField() {
//        team.setActive(true);
//        Field f = new Field("TOTO");
//        //   DBManagerStub.addField(f.getFid(), f);
//        boolean passed = s.getOwner().addField(f.getFid());
//        assertTrue(passed);
//        boolean isExist = s.getOwner().getTeam().getFields().contains(f.getFid());
//        assertTrue(isExist);
//    }
//
//    @Test
//    //failed- wrote to gal and ohad
//    public void addFieldNull() {
//        Field f = new Field("TOTO");
//        boolean passed = s.getOwner().addField(0);
//        assertFalse(passed);
//        boolean isExist = team.getFields().contains(f.getFid());
//        assertFalse(isExist);
//    }
//
//    @Test
//    public void removeField() {
//        team.setActive(true);
//        Field f = new Field("TOTO");
//        DBManagerStub.addField(f.getFid(), f);
//        boolean passed = s.getOwner().addField(f.getFid());
//        boolean remove = s.getOwner().removeField(f.getFid());
//        assertTrue(remove);
//        boolean notExist = team.getFields().contains(f.getFid());
//        assertFalse(notExist);
//    }
//
//
//    @Test
//    public void editFieldName() {
//        Field f = new Field("TOTO");
//        team.setActive(true);
//        boolean passed = s.getOwner().addField(f.getFid());
//        boolean edit = s.getOwner().editFieldName(f.getFid(), "TOTO1");
//        assertTrue(edit);
//        assertEquals("TOTO1", DBManagerStub.getField(f.getFid()).getName());
//    }
//
//    @Test
//    public void editFieldNameNull() {
//        Field f = new Field("TOTO");
//        boolean passed = s.getOwner().addField(f.getFid());
//        boolean setName = s.getOwner().editFieldName(f.getFid(), null);
//        assertFalse(setName);
//        assertEquals(f.getName(), "TOTO");
//
//
//    }
//
//    @Test
//    public void createNewOwner() {
//
//        Subscriber s1 = new Subscriber("18", "1222", "Gadi");
//        boolean passed2 = s.getOwner().createNewOwner(s1.getId());
//        assertTrue(passed2);
//        boolean isExist = s.getOwner().getOwners().contains(s1.getId());
//        assertTrue(isExist);
//
//    }
//
//    @Test
//    public void createNewOwnerNull() {
//
//
//        boolean passed2 = s.getOwner().createNewOwner(0);
//        assertFalse(passed2);
//
//    }
//
//    @Test
//    public void removeOwner() {
//        Subscriber s1 = new Subscriber("18", "1222", "Gadi");
//        boolean passed2 = s.getOwner().createNewOwner(s1.getId());
//        assertTrue(passed2);
//        boolean remove = s.getOwner().removeOwner(s1.getId());
//        assertTrue(remove);
//        boolean isExist = s.getOwner().getOwners().contains(s1.getId());
//        assertFalse(isExist);
//    }
//
//    @Test
//    public void removeOwnerNull() {
//
//        boolean notExist = s.getOwner().removeOwner(0);
//        assertFalse(notExist);
//
//    }
//
//    @Test
//    public void addTeamManager() {
//        Subscriber s1 = new Subscriber("18", "1222", "Gadi");
//        boolean tm = s1.makeTeamManagerActive();
//        DBManagerStub.updateSubscriber(s1.getId(), s1);
//        assertTrue(tm);
//        boolean passed = s.getOwner().addTeamManager(s1.getId());
//        assertTrue(passed);
//        boolean isExist = s.getOwner().getTeam().getTeamManagers().contains(s1.getId());
//        assertTrue(isExist);
//    }
//
//    @Test
//    public void deleteTeamManager1() {
//        Subscriber s1 = new Subscriber("18", "1222", "Gadi");
//        boolean tm = s1.makeTeamManagerActive();
//        DBManagerStub.updateSubscriber(s1.getId(), s1);
//        assertTrue(tm);
//        boolean passed = s.getOwner().addTeamManager(s1.getId());
//        assertTrue(passed);
//        boolean isExist = s.getOwner().getTeam().getTeamManagers().contains(s1.getId());
//        assertTrue(isExist);
//        boolean remove = s.getOwner().deleteTeamManager(s1.getId());
//        assertTrue(remove);
//        boolean notExist = s.getOwner().getTeam().getTeamManagers().contains(s1.getId());
//        assertFalse(notExist);
//
//    }
//
//
//    @Test
//    //2 tm-there is option to delete
//    public void deleteTeamManager2() {
//        Subscriber s1 = new Subscriber("18", "1222", "Gadi");
//        boolean tm = s1.makeTeamManagerActive();
//        Subscriber s2 = new Subscriber("19", "1222", "Avi");
//        s2.makeTeamManagerActive();
//
//        DBManagerStub.updateSubscriber(s1.getId(), s1);
//        DBManagerStub.updateSubscriber(s2.getId(), s2);
//
//
//        s.getOwner().addTeamManager(s1.getId());
//        s.getOwner().addTeamManager(s2.getId());
//
//        boolean remove = s.getOwner().deleteTeamManager(s1.getId());
//        assertTrue(remove);
//        boolean notExist = s.getOwner().getTeam().getTeamManagers().contains(s1.getId());
//        assertFalse(notExist);
//
//    }
//
//    @Test
//    //2 tm-there is option to delete
//    public void deleteTeamManagerNull() {
//        Subscriber s1 = new Subscriber("18", "1222", "Gadi");
//
//        boolean remove = s.getOwner().deleteTeamManager(0);
//        assertFalse(remove);
//
//
//    }
//
//    @Test
//    public void closeTeam() {
//        team.setActive(true);
//        boolean closed = s.getOwner().closeTeam();
//        assertTrue(closed);
//        int size=s.getOwner().getAlerts().size();
//        assertEquals(size, 1);
//    }
//
//
//    @Test
//    //no reset for allTimeSeasom in DB-EXCEPTION
//    public void getSellingPlayersIncomeNoTimeBySeaons() {
//
//        double compare = s.getOwner().getSellingPlayersIncome(2000, 1);
//        assertEquals(-1, compare, 0);
//
//    }
//
//    @Test
//    public void incrementSellingPlayersIncome() {
//        s.getOwner().getTeam().startNewSeason(2020);
//        boolean increment = s.getOwner().incrementSellingPlayersIncome(2020, 1, 5000);
//        assertTrue(increment);
//        double compare = s.getOwner().getSellingPlayersIncome(2020, 1);
//        assertEquals(5000, compare, 0);
//
//    }
//
//
//    @Test
//    public void incrementBuyingPlayersOutcome() {
//        s.getOwner().getTeam().startNewSeason(2020);
//        boolean increment = s.getOwner().incrementBuyingPlayersOutcome(2020, 1, 5000);
//        assertTrue(increment);
//        double compare = s.getOwner().getBuyingPlayersOutcome(2020, 1);
//        assertEquals(5000, compare, 0);
//
//    }
//
//    //
////        @Test
////        public void getMatchesIncome() {
////            TeamBySeason t1=new TeamBySeason("t1",o1.getTeam(),2000);
////            o1.getTeam().startNewSeason(2000,t1);
////            boolean increment=o1.incrementMatchesIncome(2000,1,7000);
////            double get=o1.getMatchesIncome(2000,1);
////            assertEquals(7000,get,0);
////
////
////
////        }
////
//    @Test
//    public void incrementMatchesIncome() {
//        s.getOwner().getTeam().startNewSeason(2020);
//        boolean increment = s.getOwner().incrementMatchesIncome(2020, 1, 5000);
//        assertTrue(increment);
//        double compare = s.getOwner().getMatchesIncome(2020, 1);
//        assertEquals(5000, compare, 0);
//
//    }
////
////        @Test
////        public void getMatchesOutcome() {
////            TeamBySeason t1=new TeamBySeason("t1",o1.getTeam(),2000);
////            o1.getTeam().startNewSeason(2000,t1);
////            boolean increment=o1.incrementMatchesOutcome(2000,1,8000);
////            double get=o1.getMatchesOutcome(2000,1);
////            assertEquals(8000,get,0);
////        }
//
//    @Test
//    public void incrementMatchesOutcome() {
//        s.getOwner().getTeam().startNewSeason(2020);
//        boolean increment = s.getOwner().incrementMatchesOutcome(2020, 1, 5000);
//        assertTrue(increment);
//        double compare = s.getOwner().getMatchesOutcome(2020, 1);
//        assertEquals(5000, compare, 0);
//    }
//
//    //
////
////
////        @Test
////        public void getSalariesOutcome() {
////            TeamBySeason t1=new TeamBySeason("t1",o1.getTeam(),2000);
////            o1.getTeam().startNewSeason(2000,t1);
////            boolean increment=o1.incrementSalariesOutcome(2000,1,8000);
////            double get=o1.getSalariesOutcome(2000,1);
////            assertEquals(8000,get,0);
////
////        }
////
//    @Test
//    public void incrementSalariesOutcome() {
//        s.getOwner().getTeam().startNewSeason(2020);
//        boolean increment = s.getOwner().incrementSalariesOutcome(2020, 1, 5000);
//        assertTrue(increment);
//        double compare = s.getOwner().getSalariesOutcome(2020, 1);
//        assertEquals(5000, compare, 0);
//    }
//
//    //
////        @Test
////        public void getOwnerInvestmentIncome() {
////            TeamBySeason t1=new TeamBySeason("t1",o1.getTeam(),2000);
////            o1.getTeam().startNewSeason(2000,t1);
////            boolean increment=o1.incrementOwnerInvestmentIncome(2000,1,8000);
////            double get=o1.getOwnerInvestmentIncome(2000,1);
////            assertEquals(8000,get,0);
////        }
////
//    @Test
//    public void incrementOwnerInvestmentIncome() {
//        s.getOwner().getTeam().startNewSeason(2020);
//        boolean increment = s.getOwner().incrementOwnerInvestmentIncome(2020, 1, 5000);
//        assertTrue(increment);
//        double compare = s.getOwner().getOwnerInvestmentIncome(2020, 1);
//        assertEquals(5000, compare, 0);
//    }
//
//    //
////        @Test
////        public void getAdvertiseIncome() {
////            TeamBySeason t1=new TeamBySeason("t1",o1.getTeam(),2000);
////            o1.getTeam().startNewSeason(2000,t1);
////            boolean increment=o1.incrementAdvertiseIncome(2000,1,8000);
////            double get=o1.getAdvertiseIncome(2000,1);
////            assertEquals(8000,get,0);
////        }
////
////    @Test
////    public void getAdvertiseIncomeNoSeason() {
////
////        double get=o1.getAdvertiseIncome(2000,1);
////        assertEquals(-1,get,0);
////    }
////
//    @Test
//    public void incrementAdvertiseIncome() {
//        s.getOwner().getTeam().startNewSeason(2020);
//        boolean increment = s.getOwner().incrementAdvertiseIncome(2020, 1, 5000);
//        assertTrue(increment);
//        double compare = s.getOwner().getAdvertiseIncome(2020, 1);
//        assertEquals(5000, compare, 0);
//    }
//
//    //
////    @Test
////    public void incrementAdvertiseIncomeNoSeason() {
////        boolean increment=o1.incrementAdvertiseIncome(2000,1,8000);
////        assertFalse(increment);
////    }
////
////        @Test
////        public void removeTeamLink() {
////            o1.removeTeamLink();
////
////
////        }
////
//    @Test
//    public void setTeamManagersPermisions() {
//        Subscriber s1 = new Subscriber("18", "1222", "Gadi");
//        boolean m = s1.makeTeamManagerActive();
//        s.getOwner().addTeamManager(s1.getId());
//        assertTrue(m);
//        boolean set = s.getOwner().setTeamManagersPermissions(s1.getId(), true, true, false, false, true, true, true, false, true);
//        assertTrue(set);
//    }
//
//
//    @Test
//    //there is no update to DB after set team so the team is not update with owner
//    public void setTeam() {
//        Team team2 = new Team("winners2", s.getId());
//        DBManagerStub.addTeam(team2.getTid(),team2);
//        s.getOwner().setTeam(team2.getTid());
//        assertEquals(s.getOwner().getTeam().getName(), "winners2");
//    }
//
//    @Test
//    public void update() {
//        Team t3 = new Team("winners", s.getId());
//        Event e = new Event(12, "test", EventType.FOUL, "ehud");
//        IAlert iAlert = new GameEventAlert(12, e);
//        s.getOwner().update(t3, iAlert);
//        assertEquals(1, s.getOwner().getAlerts().size());
//
//    }
//
//    @Test
//    public void openTeamRequest() {
//        s.getOwner().setTeam(-1);
//        boolean req = s.getOwner().openTeamRequest("test", s.getId());
//        assertTrue(req);
//
//    }
//
//    @Test
//
//    public void deleteFromDB() {
//        LocalDate date1 = LocalDate.of(1990, 3, 19);
//
//        Subscriber s1 = new Subscriber("1", "1", "1");
//        s1.makeOwnerActive();
//        boolean rem=s.getOwner().deleteFromDB(s1.getId());
//        assertTrue(rem);
//        Owner p=DBManagerStub.getOwner(s1.getId());
//        assertNull(p);
//
//    }
//
//    @Test
//
//    public void deleteFromDBNull() {
////        LocalDate date1 = LocalDate.of(1990, 3, 19);
////
////        Subscriber s1 = new Subscriber("1", "1", "1");
////        s1.makePlayerActive(playerRole.ATTACKER, date1);
//        boolean rem=s.getOwner().deleteFromDB(0);
//        assertFalse(rem);
////        Player p=DBManagerStub.getPlayer(s1.getId());
////        assertNull(p);
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
//
