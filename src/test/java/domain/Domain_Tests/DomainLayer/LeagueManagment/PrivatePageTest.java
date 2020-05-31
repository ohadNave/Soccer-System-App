package domain.Domain_Tests.DomainLayer.LeagueManagment;

import com.example.DB_Tests.DomainLayer.LeagueManagment.PrivatePage;
import com.example.DB_Tests.DomainLayer.MyFactory;
import org.junit.Test;

//
//import static org.junit.Assert.*;
//
public class PrivatePageTest {
    PrivatePage p = MyFactory.createPrivatePage();
    @Test
    public void addContentToPage() {

    }
}
//
//    @Test
//    public void notifyPageFollowers() {
//        //new alert
//        NewPostOnPageAlert a = new NewPostOnPageAlert(p, "check");
//        NewPostOnPageAlert nullAlert=null;
//
//        //new followers
//        String name = "checkkkkkk";
//        Subscriber subscriberPlayer = new Subscriber(name,name,name);
//        subscriberPlayer.makePlayerActive(playerRole.ATTACKER, LocalDate.of(99,2,22));
//
//        HashSet<Integer> followers = new HashSet<>();
//        Subscriber subscriberFan = new Subscriber("user","1234", "Shlomi");
//        subscriberFan.makeFanActive();
//        Fan f1 = subscriberFan.getFan();
//        PrivatePage p1 = DBManagerStub.getPrivatePage(2);
//        f1.followPage(p1.getPageId());
////        HashSet<Integer> FollowingPrivatePages  = new HashSet<>();
////        FollowingPrivatePages.add(1);
////        FollowingPrivatePages.add(2);
////        f1.setFollowingPrivatePages(FollowingPrivatePages);
//
////        followers.add(1);
////        p.setFollowers(followers);
//
//        //list of alerts to compare with
//        Queue<IAlert> alerts = new LinkedList<>();
//        alerts.add(a);
//
//        //check the method
//
//        p1.notifyPageFollowers(a);
//        assertTrue(f1.getAlerts().contains(a));
//
//        //add null alert
//        p1.notifyPageFollowers((nullAlert));
//        assertFalse(f1.getAlerts().contains(nullAlert));
//    }
//
//    @Test
//    public void getPageId() {
//        PrivatePage p1=new PrivatePage();
//        assertEquals(p.getPageId()+1, p1.getPageId());
//    }
//
//    @Test
//    public void getFollowers() {
//        //new followers
//        HashSet<Integer> followers = new HashSet<>();
//        Subscriber subscriber = new Subscriber("user","1234", "Shlomi");
//        subscriber.makeFanActive();
//        Fan f1 = subscriber.getFan();
//        HashSet<Integer> FollowingPrivatePages  = new HashSet<>();
//        FollowingPrivatePages.add(1);
//        f1.setFollowingPrivatePages(FollowingPrivatePages);
//
//        followers.add(1);
//        p.setFollowers(followers);
//
//        assertEquals(followers,p.getFollowers());
//    }
//
//    @Test
//    public void setFollowers() {
//        //new followers
//        HashSet<Integer> followers = new HashSet<>();
//        Subscriber subscriber = new Subscriber("user","1234", "Shlomi");
//        subscriber.makeFanActive();
//        Fan f1 = subscriber.getFan();
//        HashSet<Integer> FollowingPrivatePages  = new HashSet<>();
//        FollowingPrivatePages.add(1);
//        f1.setFollowingPrivatePages(FollowingPrivatePages);
//
//        followers.add(1);
//        p.setFollowers(followers);
//        assertEquals(followers,p.getFollowers());
//
//        //check null setting
//        p.setFollowers(null);
//        assertNotNull(p.getFollowers());
//
//        //check empty follower
//        HashSet<Integer> emptyFollowers = new HashSet<>();
//        p.setFollowers(emptyFollowers);
//        assertNotNull(p.getFollowers());
//    }
//
//    @Test
//    public void deletePrivatePageFromDb() {
//        String name="Shlomi";
//        String userName = "user";
//        String password = "1234";
//        Subscriber subscriber= new Subscriber(name,userName,password);
//        LocalDate d = LocalDate.of(99,2,22);
//        subscriber.makePlayerActive(playerRole.ATTACKER, LocalDate.of(99,2,22));
//        Player p1 = subscriber.getPlayer();
//        PrivatePage p2= p1.getPrivatePage();
//        assertTrue(p2.deletePrivatePageFromDb());
//        assertNull(DBManagerStub.getPrivatePage(p2.getPageId()));
//    }
//
//    @Test
//    public void getContent() {
//        assertTrue(p.addContentToPage("check"));
//        assertTrue(p.addContentToPage("me"));
//        Queue check = new LinkedList();
//        check.add("check");
//        check.add("me");
//        assertEquals(check,p.getContent());
//    }
//}