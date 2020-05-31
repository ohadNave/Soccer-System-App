package domain.Domain_Tests.DomainLayer.LeagueManagment;

import com.example.DB_Tests.DomainLayer.LeagueManagment.Field;
import com.example.DB_Tests.DomainLayer.MyFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FieldTest {

    Field f;

    @Before
    public void reset(){
        f= MyFactory.createField("test");
    }

    @Test
    public void getName() {
        assertEquals("test",f.getName());
    }

    @Test
    public void setName() {
       boolean set= f.setName("test2");
       assertTrue(set);
       assertEquals("test2",f.getName());
    }

    @Test
    public void setNameNull() {
        boolean set= f.setName(null);
        assertFalse(set);
        assertEquals("test",f.getName());
    }
}