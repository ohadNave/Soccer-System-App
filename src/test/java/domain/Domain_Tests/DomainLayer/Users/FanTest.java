package domain.Domain_Tests.DomainLayer.Users;


import com.example.DB_Tests.DomainLayer.Enums.PlayerRole;
import com.example.DB_Tests.DomainLayer.LeagueManagment.Complain;
import com.example.DB_Tests.DomainLayer.LeagueManagment.Game;
import com.example.DB_Tests.DomainLayer.MyFactory;
import com.example.DB_Tests.DomainLayer.Users.Subscriber;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashSet;

import static org.junit.Assert.*;

public class FanTest {

    Subscriber fun;
//    PrivatePage pp1;
//    PrivatePage pp2;
    Subscriber player1;
    Game m;

    @Before
    public void reset(){
        LocalDate lc=LocalDate.of(1990,12,12);
        player1= MyFactory.createSubscriber("123","12","12");
        player1.makePlayerActive(PlayerRole.ATTACKER,lc);
        fun=MyFactory.createSubscriber("12","12","12");
        fun.makeFanActive();
//         pp1=new PrivatePage();
//         pp2=new PrivatePage();
        Date d=new Date(12,12,12);
        LocalTime hour=LocalTime.now();
        m=MyFactory.createGame(null,hour,null,null,null,null);
    }


//    Fan funTest;
//    DBManagerStub data= new DBManagerStub();
//    PrivatePage pp1=new PrivatePage("test1");
//    PrivatePage pp2=new PrivatePage("test2");
//    Match m;



    //uc 3.2



    @Test
    public void followPage() {
     boolean follow= fun.getFan().followPage(player1.getPlayer().getPrivate_page());
      assertTrue(follow);
      boolean isExist=fun.getFan().getFollowingPrivatePages().contains(player1.getPlayer().getPrivate_page().getPageId());
      assertTrue(isExist);

    }

    @Test
    public void followPageNull() {
        boolean follow= fun.getFan().followPage(null);
        assertFalse(follow);
//        boolean isExist=fun.getFan().getFollowingPrivatePages().contains(player1.getPlayer().getPrivate_page().getPageId());
//        assertTrue(isExist);
//        boolean isExist2=DBManagerStub.getPrivate_page(player1.getPlayer().getPrivate_page().getPageId()).getFollowers().contains(fun.getId());
//        assertTrue(isExist2);

    }




//
    @Test
    public void signForMatchAlerts() {

        boolean add=fun.getFan().signForMatchAlerts(m);
        assertTrue(add);
        boolean isExist=fun.getFan().getFollowingMatches().contains(m);
        assertTrue(isExist);

        boolean isExist2= m.getMatch_followers().contains(fun.getId());
        assertTrue(isExist2);


    }
    @Test
    public void signForMatchAlertsNull() {

        boolean add=fun.getFan().signForMatchAlerts(null);
        assertFalse(add);



    }


    @Test
    public void unsignForMatchAlerts() {
        boolean add=fun.getFan().signForMatchAlerts(m);
        assertTrue(add);
        boolean isExist=fun.getFan().getFollowingMatches().contains(m);
        assertTrue(isExist);

            boolean isExist2= m.getMatch_followers().contains(fun);
        assertTrue(isExist2);

        boolean add2=fun.getFan().unsignForMatchAlerts(m.getId());
        assertTrue(add2);
        boolean isExist4= m.getMatch_followers().contains(fun.getId());
        assertFalse(isExist4);
        boolean isExist3=fun.getFan().getFollowingMatches().contains(m);
        assertFalse(isExist3);


    }

    @Test
    public void unsignForMatchAlertsNull() {
//

        boolean add2=fun.getFan().unsignForMatchAlerts(0);
        assertFalse(add2);


    }


    @Test
    public void sendComplain() {
        String complaint="complaint";
        Date date=new Date();
        fun.getFan().sendComplain(date,complaint);
        boolean isExist=false;
        for (Complain temp : fun.getFan().getMyComplains()) {
                isExist=true;
            }


    }



    @Test
    public void sendComplainNull() {
        String complaint="complaint";
        Date date=new Date();
       boolean isExist= fun.getFan().sendComplain(date,null);

        assertFalse(isExist);

    }


    @Test
    public void searchByName() {

        String str="macabi haifa";
        HashSet<Object> list=fun.getFan().searchByName(str);
        boolean isExist=fun.getFan().getSearchHistory().contains(str);
        assertTrue(isExist);



    }

    @Test
    public void searchByNameNull() {

        String str="macabi haifa";
        HashSet<Object> list=fun.getFan().searchByName(null);
        boolean isExist=fun.getFan().getSearchHistory().contains(str);
        assertFalse(isExist);



    }


    @Test
    public void update() {
        fun.getFan().signForMatchAlerts(m);
    }
//    @Test
//    public void updateNull() {
//        fun.getFan().signForMatchAlerts(m.getMatchId());
//        IAlert alert=new GameEventAlert(12,new Event(12,"test", EventType.FOUL,"avi"));
//        fun.getFan().update(null,alert);
//        Subscriber s=DBManagerStub.getSubscriberById(fun.getId());
//        assertEquals(s.getFan().getAlerts().size(),0);
//    }
//
//
//    @Test
//    public void setMyComplains() {
//        HashSet<Integer> complains=new HashSet<>();
//        complains.add(1);
//        complains.add(2);
//        complains.add(3);
//        fun.getFan().setMyComplains(complains);
//       boolean isExist= fun.getFan().getMyComplains().contains(2);
//       assertTrue(isExist);
//    }
//
//
//    @Test
//    public void setFollowingPrivatePages() {
//        HashSet<Integer> privatePgae=new HashSet<>();
//        privatePgae.add(1);
//        privatePgae.add(2);
//        privatePgae.add(3);
//        fun.getFan().setFollowingPrivatePages(privatePgae);
//        boolean isExist= fun.getFan().getFollowingPrivatePages().contains(2);
//        assertTrue(isExist);
//
//    }
//
//
//
//    @Test
//    public void setSearchHistory() {
//        HashSet<String> history=new HashSet<>();
//        history.add("?");
//        history.add("E");
//        history.add("f");
//        fun.getFan().setSearchHistory(history);
//        boolean isExist= fun.getFan().getSearchHistory().contains("?");
//        assertTrue(isExist);
//    }
//
//
//
//    @Test
//    public void setAlerts() {
//        IAlert alert=new GameEventAlert(12,new Event(12,"test", EventType.FOUL,"avi"));
//        IAlert alert2=new GameEventAlert(12,new Event(12,"test", EventType.FOUL,"avi"));
//        IAlert alert3=new GameEventAlert(12,new Event(12,"test", EventType.FOUL,"avi"));
//        Queue<IAlert> alerts=new LinkedList<>();
//        alerts.add(alert);
//        alerts.add(alert2);
//        alerts.add(alert3);
//
//        fun.getFan().setAlerts(alerts);
//        Queue<IAlert> temp= fun.getFan().getAlerts();
//        assertEquals(temp,alerts);
//
//
//
//
//    }
//
//
//    @Test
//    public  void deleteFanFromDB(){
//        boolean rem=fun.getFan().deleteFanFromDB(fun.getId());
//        assertTrue(rem);
//        Fan temp=DBManagerStub.getFan(fun.getId());
//        assertNull(temp);
//    }
//    @Test
//    public  void deleteFanFromDBNull(){
//        boolean rem=fun.getFan().deleteFanFromDB(0);
//        assertFalse(rem);
//
//    }
}