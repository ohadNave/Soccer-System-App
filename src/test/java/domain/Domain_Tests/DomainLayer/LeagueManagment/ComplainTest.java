package domain.Domain_Tests.DomainLayer.LeagueManagment;

import com.example.DB_Tests.DomainLayer.Enums.ComplainStatus;
import com.example.DB_Tests.DomainLayer.LeagueManagment.Complain;
import com.example.DB_Tests.DomainLayer.MyFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class ComplainTest {
    Complain c;

    @Before
    public void reset(){
        Date d=new Date();
        String content="test";
        c= MyFactory.createComplain(d,content);
    }

    @Test
    public void getCid() {
        int ic=c.getCid();
        assertNotNull(c);
    }

    @Test
    public void setCid() {
        c.setCid(4);
        assertEquals(4,c.getCid());


    }

    @Test
    public void getDate() {
        Date d1=c.getDate();
        assertEquals(d1,c.getDate());
    }

    @Test
    public void setDate() {
        Date d1=new Date();
        c.setDate(d1);
        assertEquals(d1,c.getDate());



    }

    @Test
    public void getComplainStatus() {
        assertEquals(c.getComplainStatus(), ComplainStatus.WAITING);
    }

    @Test
    public void setComplainStatus() {
        c.setComplainStatus(ComplainStatus.DONE);
        assertEquals(c.getComplainStatus(),ComplainStatus.DONE);

    }


    @Test
    public void setContent() {
        c.setContent("testest");
        assertEquals("testest",c.getContent());
    }


    @Test
    public void setContentNull() {
        c.setContent(null);
        assertEquals(null,c.getContent());
    }



    @Test
    public void setSystemManagerRespond() {

        c.setSystemManagerRespond("done");
        assertEquals("done",c.getSystemManagerRespond());


    }
    @Test
    public void setSystemManagerRespondNull() {

        c.setSystemManagerRespond(null);
        assertEquals(null,c.getSystemManagerRespond());


    }
}