package domain.Domain_Tests.DomainLayer.Users;

import com.example.DB_Tests.DomainLayer.Enums.PlayerRole;
import com.example.DB_Tests.DomainLayer.MyFactory;
import com.example.DB_Tests.DomainLayer.Users.Player;
import com.example.DB_Tests.DomainLayer.Users.Subscriber;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.*;

public class PlayerTest {
    String name="Shlomi";
    String userName = "user";
    String password = "1234";
    Subscriber subscriber= MyFactory.createSubscriber(name,userName,password);
    LocalDate d = LocalDate.of(99,2,22);



    @Test
    public void updatePrivatePage() {
        subscriber.makePlayerActive(PlayerRole.ATTACKER, LocalDate.of(99,2,22));
        Player p = subscriber.getPlayer();
        assertFalse(p.updatePrivatePage(""));
        String s1 = "check my page";
        String s2= "another check";
        Queue<String> content = new LinkedList<>();
        content.add(s1);
        content.add(s2);
        assertTrue(p.updatePrivatePage(s1));
        assertTrue(p.updatePrivatePage(s2));
        assertEquals(content, p.getPrivate_page().getContent());

    }

    @Test
    public void setRole() {
        subscriber.makePlayerActive(PlayerRole.ATTACKER, LocalDate.of(99,2,22));
        Player p = subscriber.getPlayer();
        assertFalse(p.setRole(null));
        assertTrue(p.setRole(PlayerRole.ATTACKER));
        assertEquals(p.getRole(),PlayerRole.ATTACKER);
    }

    @Test
    public void setDateOfBirth() {
        subscriber.makePlayerActive(PlayerRole.ATTACKER, LocalDate.of(99,2,22));
        Player p = subscriber.getPlayer();
        assertFalse(p.setDateOfBirth(null));
        assertTrue(p.setDateOfBirth(d));
        assertEquals(p.getDate_of_birth(),d);
    }

    @Test
    public void getPrivatePage() {
        subscriber.makePlayerActive(PlayerRole.ATTACKER, LocalDate.of(99,2,22));
        Player p = subscriber.getPlayer();
        Queue<String> check = new LinkedList<>();
        check.add("check my page");
        check.add("another check");
        String s1 = "check my page";
        String s2= "another check";
        assertTrue(p.updatePrivatePage(s1));
        assertTrue(p.updatePrivatePage(s2));
        assertEquals(check,p.getPrivate_page().getContent());
    }

    @Test
    public void getRole() {
        subscriber.makePlayerActive(PlayerRole.ATTACKER, LocalDate.of(99,2,22));
        Player p = subscriber.getPlayer();
        assertEquals(p.getRole(),PlayerRole.ATTACKER);
    }

    @Test
    public void getDateOfBirth() {
        subscriber.makePlayerActive(PlayerRole.ATTACKER, LocalDate.of(99,2,22));
        Player p = subscriber.getPlayer();
        assertEquals(p.getDate_of_birth(),d);
    }

    @Test
    public void deleteFromDB() {
        subscriber.makePlayerActive(PlayerRole.ATTACKER, LocalDate.of(99,2,22));
        Player p = subscriber.getPlayer();

    }
}