package domain.Domain_Tests.DomainLayer.Users;

import com.example.DB_Tests.DomainLayer.MyFactory;
import com.example.DB_Tests.DomainLayer.Users.Guest;
import com.example.DB_Tests.DomainLayer.Users.Subscriber;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GuestTest {

    Guest g= MyFactory.createGuest();



    @Test
    public void registerUserNameLess3letters() throws Exception {

        Subscriber s=g.Register("Avi","123","123","avi");
        assertNull(s);


    }

    @Test
    public void register() throws Exception {

        Subscriber s=g.Register("tomi","123","123","tom");
        assertEquals(s.getName(),"tom");
        assertEquals(s.getPassword(),"123");
        assertEquals(s.getUserName(),"tomi");


    }

    @Test
    public void registerNull() throws Exception {
        Subscriber s=g.Register(null,"123","123","david");
        assertNull(s);
    }


    @Test
    public void login() throws Exception {
        Subscriber s=g.Register("Chen","123","123","chen");
        assertEquals(s.getName(),"chen");
        assertEquals(s.getPassword(),"123");
        assertEquals(s.getUserName(),"Chen");
        Subscriber s2=g.Login("Chen","123");
        assertEquals(s2.getName(),"chen");
        assertEquals(s2.getPassword(),"123");
        assertEquals(s2.getUserName(),"Chen");


    }

    @Test
    public void loginNull() throws Exception {
        Subscriber s=g.Register("Aviiii","123","123","tom");
        assertEquals(s.getName(),"tom");
        assertEquals(s.getPassword(),"123");
        assertEquals(s.getUserName(),"Aviiii");
        Subscriber s2=g.Login(null,"123");
        assertNull(s2);
//        assertEquals(s2.getName(),"tom");
//        assertEquals(s2.getPassword(),"123");
//        assertEquals(s2.getUserName(),"Aviiii");


    }
}