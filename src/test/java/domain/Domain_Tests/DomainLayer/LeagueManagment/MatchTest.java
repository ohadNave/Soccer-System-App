package domain.Domain_Tests.DomainLayer.LeagueManagment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MatchTest {
    @Test
    public void test() {
    }
}
//}
//    Match m;
//
//    Subscriber r1;
//    Subscriber r2;
//    Subscriber r3;
//
//    @Before
//    public void reset(){
//        Subscriber o=new Subscriber("Avi","12","1");
//        o.makeOwnerActive();
//        Subscriber o2=new Subscriber("Gadi","12","1");
//        o2.makeOwnerActive();
//        Team home=new Team("home",o.getId());
//        DBManagerStub.addTeam(home.getTid(),home);
//        Team away=new Team("away",o2.getId());
//        DBManagerStub.addTeam(away.getTid(),away);
//        Date d=new Date();
//        Field f=new Field("TOTO");
//         r1=new Subscriber("r1","12","1");
//        r1.makeMainRefereeActive(Certification.PROFFESIONAL);
//
//       r2=new Subscriber("r2","12","1");
//        r2.makeLineRefereeActive(Certification.PROFFESIONAL);
//
//         r3=new Subscriber("r3","12","1");
//        r3.makeLineRefereeActive(Certification.PROFFESIONAL);
//
//        Subscriber fun1=new Subscriber("f","12","1");
//        fun1.makeFanActive();
//        Subscriber fun2=new Subscriber("f","12","1");
//        fun2.makeFanActive();
//
//        m=new Match(d, LocalTime.now(),f.getFid(),home.getTid(),away.getTid(),r1.getId(),r3.getId(),r2.getId());
//        m.addMatchFollower(fun1.getId());
//        m.addMatchFollower(fun1.getId());
//        fun1.getFan().signForMatchAlerts(m.getMatchId());
//        fun2.getFan().signForMatchAlerts(m.getMatchId());
//
//        HashSet<Integer> matches=new HashSet<>();
//        matches.add(m.getMatchId());
//
//        r1.getMainReferee().setMatches(matches);
//        r2.getLineReferre().setMatches(matches);
//
//        r3.getLineReferre().setMatches(matches);
//
//
//
//
//
//
//
//    }
//
//    @Test
//    public void addEvent() {
//        Event e=new Event(12,"test", EventType.FOUL,"Avi");
//       boolean add=m.addEvent(e);
//       assertTrue(add);
//       boolean isExist=m.getGameEvents().contains(e);
//       assertTrue(isExist);
//       for( Integer fan: m.getMatchFollowers()){
//            Fan follower= DBManagerStub.getFan(fan);
//            int size=follower.getAlerts().size();
//            assertEquals(size,1);
//       }
//
//    }
//
//    @Test
//    public void addEventNull() {
//        boolean add=m.addEvent(null);
//        assertFalse(add);
//
//    }
//
//
//
//    @Test
//    public void setGameReport() {
//
//        GameReport gr=new GameReport(m.getHome(),m.getAway(),5,3);
//        boolean set=m.setGameReport(gr);
//        assertTrue(set);
//        assertEquals(gr.getWinnerTeam().getName(),"home");
//        assertEquals(gr.getLosingTeam().getName(),"away");
//
//        assertEquals(gr.getLoserGoals(),3);
//        assertEquals(gr.getWinnerGoals(),5);
//
//    }
//    @Test
//    public void setGameReportNull() {
//
//        boolean set=m.setGameReport(null);
//        assertFalse(set);
//
//
//    }
//
//
//    @Test
//    public void changeMatchDate() {
//        Date d=new Date();
//        m.changeMatchDate(d);
//        assertEquals(d,m.getDate());
//        for( Integer fan: m.getMatchFollowers()){
//            Fan follower= DBManagerStub.getFan(fan);
//            int size=follower.getAlerts().size();
//            assertEquals(size,1);
//        }
//        int mr=m.getMainReferee().getAlerts().size();
//        assertEquals(mr,1);
//
//
//
//    }
//
//    @Test
//    public void endMatch() {
//
//        int winG=5;
//        int loseG=2;
//        GameReport gr=new GameReport(m.getHome(),m.getAway(),3,1);
//        m.setMatchStatus(MatchStatus.IN_PROGRESS);
//        boolean end=m.endMatch(gr);
//        assertTrue(end);
//        assertEquals(m.getMatchStatus(), MatchStatus.FINISHED);
//        for( Integer fan: m.getMatchFollowers()){
//            Fan follower= DBManagerStub.getFan(fan);
//            int size=follower.getAlerts().size();
//            assertEquals(size,1);
//        }
//
//
//
//
//    }
//
//    @Test
//    public void notifyReferees() {
//        Event e=new Event(12,"test", EventType.FOUL,"Avi");
//
//        IAlert alert=new GameEventAlert(12,e);
//
//        m.notifyReferees(alert);
//
//       int sizeR1= r1.getMainReferee().getAlerts().size();
//       assertEquals(1,sizeR1);
//        int sizeR2= r2.getLineReferre().getAlerts().size();
//        assertEquals(1,sizeR2);
//
//        int sizeR3= r3.getLineReferre().getAlerts().size();
//        assertEquals(1,sizeR3);
//
//
//
//    }
//
//    @Test
//    public void notifyMatchFollowers() {
//        Event e=new Event(12,"test", EventType.FOUL,"Avi");
//
//        IAlert alert=new GameEventAlert(12,e);
//
//        m.notifyMatchFollowers(alert);
//
//        for( Integer fan: m.getMatchFollowers()){
//            Fan follower= DBManagerStub.getFan(fan);
//            int size=follower.getAlerts().size();
//            assertEquals(size,1);
//        }
//
//    }
//
//    @Test
//    public void addMatchFollower() {
//        Subscriber follower=new Subscriber("f","12","1");
//        follower.makeFanActive();
//        m.addMatchFollower(follower.getId());
//        boolean isExist=m.getMatchFollowers().contains(follower.getId());
//        assertTrue(isExist);
//
//    }
//
//    @Test
//    public void deleteMatchFollower() {
//        Subscriber follower=new Subscriber("f","12","1");
//        follower.makeFanActive();
//        m.addMatchFollower(follower.getId());
//        boolean isExist=m.getMatchFollowers().contains(follower.getId());
//        assertTrue(isExist);
//        m.deleteMatchFollower(follower.getId());
//        boolean notExist=m.getMatchFollowers().contains(follower.getId());
//        assertFalse(notExist);
//    }
//
//    @Test
//    public void getMatchStatus() {
//        assertEquals(m.getMatchStatus(),MatchStatus.YET_TO_COME);
//    }
//
//    @Test
//    public void setMatchStatus() {
//        m.setMatchStatus(MatchStatus.IN_PROGRESS);
//        assertEquals(m.getMatchStatus(),MatchStatus.IN_PROGRESS);
//
//    }
//
//
//
//    @Test
//    public void setDate() {
//        Date d=new Date();
//        m.setDate(d);
//        assertEquals(d,m.getDate());
//    }
//
//
//
//    @Test
//    public void setHour() {
//        LocalTime lc=LocalTime.now();
//        m.setHour(lc);
//        assertEquals(lc,m.getHour());
//    }
//
//
//
//
//    @Test
//    public void setField() {
//        Field field=new Field("TOTO");
//        m.setField(field.getFid());
//        Field field1=DBManagerStub.getField(m.getField());
//        assertEquals("TOTO",field1.getName());
//    }
//
//
//    @Test
//    public void setHome() {
//        Subscriber o=new Subscriber("Avi","12","1");
//        o.makeOwnerActive();
//        Team home=new Team("toto",o.getId());
//        DBManagerStub.addTeam(home.getTid(),home);
//        m.setHome(home.getTid());
//        assertEquals("toto",DBManagerStub.getTeam(m.getHome()).getName());
//    }
//
//
////
////    @Test
////    public void setAway() {
////    }
////
//
////
////    @Test
////    public void setMainReferee() {
////    }
////
////
//
////
////    @Test
////    public void setGameEvents() {
////    }
////
//
////
////
////    @Test
////    public void setMatchId() {
////    }
//}