package domain.Domain_Tests.DomainLayer.Users;

import org.junit.Test;

//package DomainLayer.Users;
//
//import DomainLayer.Alerts.GameEventAlert;
//import DomainLayer.Alerts.IAlert;
//import DomainLayer.Alerts.TeamIsNowNotActiveAlert;
//import DomainLayer.DBManagerStub;
//import DomainLayer.Enums.Certification;
//import DomainLayer.Enums.CoachRole;
//import DomainLayer.Enums.EventType;
//import DomainLayer.Enums.playerRole;
//import DomainLayer.LeagueManagment.Complain;
//import DomainLayer.LeagueManagment.Event;
//import DomainLayer.LeagueManagment.Team;
//import DomainLayer.Request.CoachRequest;
//import DomainLayer.Request.OwnerRequest;
//import DomainLayer.Request.PlayerRequest;
//import DomainLayer.Request.TeamManagerRequest;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.time.LocalDate;
//import java.util.Date;
//import java.util.LinkedList;
//import java.util.Queue;
//
//import static org.junit.Assert.*;
//
public class SystemManagerTest {

    @Test
    private void v(){

    }
}
//
//    Subscriber s;
//
//    @Before
//    public void reset(){
//        s=new Subscriber("AVI","123","Avi");
//        boolean add=s.makeSystemManagerActive();
//        assertTrue(add);
//    }
//
//    @Test
//    public void createNewSystemManager() {
//        Subscriber s2=s.getSystemManager().createNewSystemManager("Gadi","gadi","123");
//        assertEquals(s2.getName(),"Gadi");
//        assertEquals(s2.getPassword(),"123");
//        assertEquals(s2.getUserName(),"gadi");
//
//    }
//
//    @Test
//    public void createNewSystemManagerWrongUserName() {
//        Subscriber s2=s.getSystemManager().createNewSystemManager("Gadi","gad","123");
//        assertNull(s2);
//
//    }
//
//    @Test
//    public void closeTeamPermanently() {
//        Subscriber o=new Subscriber("ss","ss","ss");
//        o.makeOwnerActive();
//        Team t=new Team("winners",o.getId());
//        t.setActive(true);
//        DBManagerStub.addTeam(t.getTid(),t);
//        s.getSystemManager().closeTeamPermanently(t.getTid());
//        assertTrue(t.isClosedPermanently());
//        int i=t.getTid();
//        Team temp=DBManagerStub.getTeam(i);
//
//        assertNull(temp);
//    }
//
//    @Test
//    public void removeSubscriber() {
//        Subscriber s1=new Subscriber("12","12","1");
//        s.makeCoachActive(CoachRole.AttackerCoach, Certification.INTERMIDATE);
//        boolean remove=s.getSystemManager().removeSubscriber(s1.getId());
//        assertTrue(remove);
//        Subscriber isExist= DBManagerStub.getSubscriberById(s1.getId());
//        assertNull(isExist);
//        Coach coachExist=DBManagerStub.getCoach(s1.getId());
//        assertNull(coachExist);
//
//
//
//    }
//
//    @Test
//    public void respondToUserComplain() {
//        Date d=new Date();
//        String str="test";
//        Complain c=new Complain(d,str);
//        boolean respond=s.getSystemManager().respondToUserComplain(c.getCid(),"done");
//        assertTrue(respond);
//        assertEquals(c.getSystemManagerRespond(),"done");
//
//    }
//
//    @Test
//    public void respondToUserComplainNull() {
//        Date d=new Date();
//        String str="test";
//        Complain c=new Complain(d,str);
//        boolean respond=s.getSystemManager().respondToUserComplain(c.getCid(),null);
//        assertFalse(respond);
//
//    }
//
//    @Test
//    public void update() {
//        Subscriber o=new Subscriber("ss","ss","ss");
//        o.makeOwnerActive();
//        Team t=new Team("winners",o.getId());
//        t.setActive(true);
//        DBManagerStub.addTeam(t.getTid(),t);
//        IAlert alert=new TeamIsNowNotActiveAlert(t);
//        s.getSystemManager().update(t,alert);
//         SystemManager sm=DBManagerStub.getSystemManager(s.getId());
//         int size=sm.getAlerts().size();
//         assertEquals(size,1);
//
//    }
//
//
//
//    @Test
//    public void setAlerts() {
//        Subscriber o=new Subscriber("ss","ss","ss");
//        o.makeOwnerActive();
//        Team t=new Team("winners",o.getId());
//        t.setActive(true);
//        DBManagerStub.addTeam(t.getTid(),t);
//        Queue<IAlert>q=new LinkedList<>();
//        IAlert a=new TeamIsNowNotActiveAlert(t);
//        IAlert a2=new GameEventAlert(12,new Event(12,"2", EventType.FOUL,"avi"));
//        q.add(a);
//        q.add(a2);
//        s.getSystemManager().setAlerts(q);
//
//        assertEquals(s.getSystemManager().getAlerts().size(),q.size());
//
//
//    }
//
//
//    @Test
//    public void setActive() {
//        s.getSystemManager().setActive(false);
//        assertFalse(s.getSystemManager().isActive());
//    }
//
//    @Test
//    public void addFar() {
//        boolean far=s.getSystemManager().addFar("test","12","1");
//        assertTrue(far);
//        Subscriber s2=DBManagerStub.getSubscriberByUserNameAndPassword("test","12");
//
//        assertEquals(s2.getName(),"1");
//        assertEquals(s2.getPassword(),"12");
//        assertEquals(s2.getUserName(),"test");
//
//    }
//
//    @Test
//    public void addFarNull() {
//        boolean far=s.getSystemManager().addFar(null,"12","1");
//        assertFalse(far);
////        Subscriber s2=DBManagerStub.getSubscriberByUserNameAndPassword("test","12");
////
////        assertEquals(s2.getName(),"1");
////        assertEquals(s2.getPassword(),"12");
////        assertEquals(s2.getUserName(),"test");
//
//    }
//
//    @Test
//    public void handleRegistretionRequestOwner() {
//        Subscriber o=new Subscriber("123","12","12");
//        OwnerRequest or=new OwnerRequest(o);
//        boolean a=s.getSystemManager().handleRegistretionRequest(or,true);
//        assertTrue(a);
//
//        assertEquals(o.getId(),DBManagerStub.getOwner(o.getId()).getSid());
//
//
//    }
//    @Test
//    public void handleRegistretionRequestCoach() {
//        Subscriber o=new Subscriber("123","12","12");
//        CoachRequest or=new CoachRequest(o,CoachRole.AttackerCoach,Certification.INTERMIDATE);
//        boolean a=s.getSystemManager().handleRegistretionRequest(or,true);
//        assertTrue(a);
//
//        assertEquals(o.getId(),DBManagerStub.getCoach(o.getId()).getSid());
//        assertEquals(o.getCoach().getRole(),DBManagerStub.getCoach(o.getId()).getRole());
//
//
//
//    }
//
//    @Test
//    public void handleRegistretionRequestPlayer() {
//        Subscriber o=new Subscriber("123","12","12");
//        LocalDate localDate=LocalDate.of(2000,12,12);
//        PlayerRequest or=new PlayerRequest(o, playerRole.ATTACKER,localDate);
//        boolean a=s.getSystemManager().handleRegistretionRequest(or,true);
//        assertTrue(a);
//
//        assertEquals(o.getId(),DBManagerStub.getPlayer(o.getId()).getSid());
//        assertEquals(o.getPlayer().getRole(),DBManagerStub.getPlayer(o.getId()).getRole());
//    }
//
//    @Test
//    public void handleRegistretionRequestTeamManager() {
//        Subscriber o=new Subscriber("123","12","12");
//        LocalDate localDate=LocalDate.of(2000,12,12);
//        TeamManagerRequest or=new TeamManagerRequest(o);
//        boolean a=s.getSystemManager().handleRegistretionRequest(or,true);
//        assertTrue(a);
//
//        assertEquals(o.getId(),DBManagerStub.getTeamManager(o.getId()).getSid());
//    }
//
//    @Test
//    public void handleRegistretionRequestNull() {
////        Subscriber o=new Subscriber("123","12","12");
////        LocalDate localDate=LocalDate.of(2000,12,12);
////        TeamManagerRequest or=new TeamManagerRequest(o);
//        boolean a=s.getSystemManager().handleRegistretionRequest(null,true);
//        assertFalse(a);
//    }
//
//
//    @Test
//    public void deleteSystemManagerFromDB() {
//        boolean a=s.getSystemManager().deleteSystemManagerFromDB(s.getId());
//        assertTrue(a);
//        SystemManager isExist=DBManagerStub.getSystemManager(s.getId());
//        assertNull(isExist);
//    }
//}