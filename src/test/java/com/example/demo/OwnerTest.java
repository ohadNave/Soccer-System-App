package com.example.demo;

import com.example.demo.DomainLayer.DBManager;
import com.example.demo.DomainLayer.Enums.Certification;
import com.example.demo.DomainLayer.Enums.LeagueLevel;
import com.example.demo.DomainLayer.Enums.PlayerRole;
import com.example.demo.DomainLayer.Enums.RefereeRoll;
import com.example.demo.DomainLayer.LeagueManagment.*;
import com.example.demo.DomainLayer.MyFactory;
import com.example.demo.DomainLayer.Users.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest

public class OwnerTest {

    public static Subscriber subscriber;
    public static Subscriber subscriber2;


    @Test
    void removeOwnerTest() {
        Subscriber s1 = MyFactory.createSubscriber("a","s","d");
        Subscriber s2 = MyFactory.createSubscriber("2","2","2");
        Subscriber s3 = MyFactory.createSubscriber("3","3","3");
        Subscriber s4 = MyFactory.createSubscriber("4","4","4");

        s2.setId(1);
        s3.setId(2);
        s4.setId(3);

        s1.makeOwnerActive();
        s2.makeOwnerActive();
        s3.makeOwnerActive();
        s4.makeOwnerActive();

        Owner o1 = s1.getOwner();
        Owner o2 = s2.getOwner();
        Owner o3 = s3.getOwner();
        Owner o4 = s4.getOwner();

        Team t = MyFactory.createTeam(o1,"HBS");

        Set<Owner> f1 = new HashSet<>();
        f1.add(o2);
        o1.setOwners(f1);

        Set<Owner> f2 = new HashSet<>();
        f2.add(o3);
        o2.setOwners(f2);

        Set<Owner> f3 = new HashSet<>();
        f3.add(o4);
        o3.setOwners(f3);
        o1.removeOwner(o2.getSid());
    }

    @Test
    public void addPlayersTest(){
        subscriber = MyFactory.createSubscriber("ohad-far2","s","ohad");
        subscriber.makeFARActive();
        FAR far = subscriber.getFar();
        far.initializeLeague(LeagueLevel.PremierLeague,"La-Liga");

        subscriber2  = MyFactory.createSubscriber("owner","none","none");
        subscriber2.makeOwnerActive();


        Team team2 = MyFactory.createTeam(subscriber2.getOwner(),"RMA");
        List<Team> teams = new ArrayList<>();
        teams.add(team2);
        int[] team_ids = new int[3];
        team_ids[0] = team2.getTid();

        Subscriber s3 = MyFactory.createSubscriber("player1","none","none");
        Subscriber s4 = MyFactory.createSubscriber("player2","none","none");
        Subscriber s5 = MyFactory.createSubscriber("player3","none","none");


        s3.makePlayerActive(PlayerRole.ATTACKER, LocalDate.now());
        s4.makePlayerActive(PlayerRole.MIDFIELDER,LocalDate.now());
        s5.makePlayerActive(PlayerRole.DEFENDER,LocalDate.now());
        Player player = s3.getPlayer();
        Player player1 = s4.getPlayer();
        Player player2 = s5.getPlayer();
        Set<Integer> players = new HashSet<>();
        players.add(player.getSid());
        players.add(player1.getSid());
        players.add(player2.getSid());


        Owner owner = subscriber2.getOwner();
        owner.addPlayers(players);
    }

    @Test
        void removePlayerTest(){
        Owner owner = (Owner) DBManager.getObject(Owner.class,2);
        Team team = (Team) DBManager.getObject(Team.class,1);
        Set<Player> players = team.getPlayers();
        owner.removePlayer(3);
        System.out.println("player removed");
    }

    @Test
    public void test(){
        Subscriber owner1 = MyFactory.createSubscriber("owner1","1234","a");
        owner1.makeOwnerActive();
        Subscriber owner2 = MyFactory.createSubscriber("owner2","1234","a");
        owner2.makeOwnerActive();
//        Subscriber far = MyFactory.createSubscriber("far","1234","a");
//        far.makeFARActive();
        Subscriber mainReferee = MyFactory.createSubscriber("main referee","1234","a");
        mainReferee.makeRefereeActive(Certification.BASIC,RefereeRoll.MAIN_REFEREE);
        Subscriber lineReferee1 = MyFactory.createSubscriber("line referee1","1234","a");
        lineReferee1.makeRefereeActive(Certification.BASIC,RefereeRoll.LINE_REFEREE);
        Subscriber lineReferee2 = MyFactory.createSubscriber("line referee2","1234","a");
        lineReferee2.makeRefereeActive(Certification.BASIC,RefereeRoll.LINE_REFEREE);

        Set<Referee> referees = new HashSet<>();
        referees.add(mainReferee.getReferee());
        referees.add(lineReferee1.getReferee());
        referees.add(lineReferee2.getReferee());

        Team team1 = MyFactory.createTeam(owner1.getOwner(),"team1");
        Team team2 = MyFactory.createTeam(owner2.getOwner(),"team2");
        List<Team> teams = new ArrayList<>();
        teams.add(team1);
        teams.add(team2);

        Game game1 = MyFactory.createGame(null, null, null,team1,team2,referees);
        Game game2 = MyFactory.createGame(null, null, null,team2,team1,referees);

        League league1 = MyFactory.createLeague(LeagueLevel.PremierLeague,"league1");
        league1.startNewSeason(2019,teams);
        league1.startNewSeason(2020,teams);
        league1.startNewSeason(2021,teams);
        League league2 = MyFactory.createLeague(LeagueLevel.PremierLeague,"league2");
        league2.startNewSeason(2019,teams);
        league2.startNewSeason(2020,teams);
        league2.startNewSeason(2021,teams);







//        subscriber.makeRefereeActive(Certification.BASIC, RefereeRoll.MAIN_REFEREE);
    }
}
