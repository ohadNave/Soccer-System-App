package domain.Domain_Tests.DomainLayer.Users;

import com.example.DB_Tests.DomainLayer.Enums.Certification;
import com.example.DB_Tests.DomainLayer.Enums.CoachRole;
import com.example.DB_Tests.DomainLayer.LeagueManagment.PrivatePage;
import com.example.DB_Tests.DomainLayer.MyFactory;
import com.example.DB_Tests.DomainLayer.Users.Coach;
import com.example.DB_Tests.DomainLayer.Users.Subscriber;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CoachTest {

    Subscriber c;


    @Before
    public void reset(){
        c= MyFactory.createSubscriber("Avi","12","avi");
        boolean active=c.makeCoachActive(CoachRole.DefenderCoach, Certification.PROFFESIONAL);
        assertTrue(active);
    }

    @Test
    public void updatePrivatePage() {
        String addContent="test";
        boolean add=c.getCoach().updatePrivatePage(addContent);
        assertTrue(add);
        boolean isExist=c.getCoach().getPrivate_page().getContent().contains(addContent);
        assertTrue(isExist);
    }

    @Test
    public void updatePrivatePageNull() {
        String addContent="test";
        boolean add=c.getCoach().updatePrivatePage(null);
        assertFalse(add);
//        PrivatePage p= DBManagerStub.getPrivatePage(c.getCoach().getPrivatePage().getPageId());
//        boolean isExist=p.getContent().contains(addContent);
//        assertTrue(isExist);
    }

    @Test
    public void deleteCoachFromDB() {
        Subscriber c1=MyFactory.createSubscriber("tal","12","avi");
        boolean active=c1.makeCoachActive(CoachRole.DefenderCoach,Certification.PROFFESIONAL);
        assertTrue(active);
        Coach c3=c1.getCoach();
        assertNull(c3);
    }

    @Test
    public void getPrivatePage() {
        PrivatePage p=c.getCoach().getPrivate_page();
        int i=p.getPageId();
        int o=c.getCoach().getPrivate_page().getPageId();
        assertEquals(i,o);

    }

    @Test
    public void setCertification() {
        boolean set=c.getCoach().setCertification(Certification.INTERMIDATE);
        assertEquals(Certification.INTERMIDATE,c.getCoach().getCertification());
    }


    @Test
    public void setRole() {
        boolean set=c.getCoach().setRole(CoachRole.AttackerCoach);
        assertEquals(CoachRole.AttackerCoach,c.getCoach().getRole());
    }


}