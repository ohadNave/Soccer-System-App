package com.example.demo;

import com.example.demo.DomainLayer.DBManager;
import com.example.demo.DomainLayer.Enums.Certification;
import com.example.demo.DomainLayer.Enums.CoachRole;
import com.example.demo.DomainLayer.Enums.PlayerRole;
import com.example.demo.DomainLayer.Enums.RefereeRoll;
import com.example.demo.DomainLayer.LeagueManagment.*;
import com.example.demo.DomainLayer.MyFactory;
import com.example.demo.DomainLayer.Users.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//
public class DBtest {



//
//    public void saveTeamTest() throws Exception {
//
//        Subscriber subscriber = MyFactory.createSubscriber("Ohadony", "pass", "ohad");
//
//        subscriber.makeOwnerActive();
//        Owner owner = subscriber.getOwner();
//        Team team = MyFactory.createTeam(subscriber.getOwner(), "HBS");
//        save(subscriber);
//
//        Subscriber subscriber2= MyFactory.createSubscriber("Azariag","pass","gal");
//        subscriber2.makeCoachActive(CoachRole.AttackerCoach, Certification.BASIC);
//        Coach coach = subscriber2.getCoach();
//        owner.addCoach(coach);
//        save(subscriber2);
//
//        entityManager.close();
//    }
//
//
//    public void savePrivatePage() throws Exception {
//        Subscriber subscriber = MyFactory.createSubscriber("PPtest", "pass", "ohad");
//        subscriber.makeOwnerActive();
//        Owner owner = subscriber.getOwner();
//        Team team = MyFactory.createTeam(subscriber.getOwner(), "HBS");
//        PrivatePage privatePage = MyFactory.createPrivatePage();
//        privatePage.addContentToPage("new content");
//        team.setPrivatePage(privatePage);
//        save(subscriber);
//        entityManager.close();
//    }
//
//
//    public  void saveTeamBySeason() throws Exception {
//        Subscriber subscriber = MyFactory.createSubscriber("PPtest", "pass", "ohad");
//        subscriber.makeOwnerActive();
//        Owner owner = subscriber.getOwner();
//        Team team = MyFactory.createTeam(subscriber.getOwner(), "HBS");
//        TeamBySeason teamBySeason = MyFactory.createTeamBySeason(team,2020);
//        team.addTeamBySeason(teamBySeason);
//        save(subscriber);
//        entityManager.close();
//    }
//
//    public  void saveTeamManagerTest() throws Exception {
//
//        Subscriber subscriber = MyFactory.createSubscriber("Ohadony-owner", "pass", "ohad");
//        Subscriber subscriber2= MyFactory.createSubscriber("Azariag-teaManager","pass","gal");
//
//        subscriber.makeOwnerActive();
//        subscriber2.makeTeamManagerActive();
//
//        Owner owner = subscriber.getOwner();
//        TeamManager teamManager = subscriber2.getTeamManager();
//
//        Team team = MyFactory.createTeam(subscriber.getOwner(), "HBS");
//        owner.addTeamManager(teamManager.getSid());
//
//        save(subscriber);
//        save(subscriber2);
//        entityManager.close();
//    }
//
//    public  void saveTeam2() throws Exception {
//        Subscriber subscriber = MyFactory.createSubscriber("ohad2-owner", "pass", "ohad");
//        subscriber.makeOwnerActive();
//        Owner owner = subscriber.getOwner();
//        Team team = MyFactory.createTeam(subscriber.getOwner(), "HAIFA");
//        save(subscriber);
//    }
//
//    public  void saveTest() throws Exception {
//        Subscriber subscriber = MyFactory.createSubscriber("Ohadony", "pass", "ohad");
//        subscriber.makeOwnerActive();
//        Team team = MyFactory.createTeam(subscriber.getOwner(), "HBS");
//        subscriber.getOwner().setTeam(team);
//        save(subscriber);
//    }
//
//
////    public  void updateTest() throws Exception {
////        Object object = get(Subscriber.class,1);
////        Subscriber subscriber =((Subscriber)object);
////        Team team1 = MyFactory.createTeam(subscriber.getOwner(), "BAR");
////        Team team2 = MyFactory.createTeam(subscriber.getOwner(), "RMA");
////        subscriber.getOwner().setTeam(team2);
////        update(subscriber);
////    }
//
//    public  void deleteTest() throws Exception {
//        Team team2 = entityManager.find(Team.class, 2);
//        delete(team2);
//    }
//
//    public  void getAllTest() throws Exception {
//        Team team2 = entityManager.find(Team.class, 2);
//        delete(team2);
//    }
//
////    public static void Test2() throws Exception {
////        Subscriber subscriber = MyFactory.createSubscriber("Ohadony-owner", "pass", "ohad");
////        subscriber.makeOwnerActive();
////        Owner owner = subscriber.getOwner();
////        Field field = MyFactory.createField("Vasermil");
////        DBManagerStub.saveObject(field);
////        Team team = MyFactory.createTeam(subscriber.getOwner(), "HBS");
////        owner.addField(field.getFid());
////        DBManagerStub.saveObject(subscriber);
////        DBManagerStub.updateObject(field);
////    }
//
//
////    public void Test2() throws Exception {
////        Subscriber subscriber = MyFactory.createSubscriber("Ohadony-owner", "pass", "ohad");
////        subscriber.makeOwnerActive();
////        Owner owner = subscriber.getOwner();
////        Field field = MyFactory.createField("Vasermil");
////        save(field);
////        Team team = MyFactory.createTeam(subscriber.getOwner(), "HBS");
////        entityManager.detach(field);
////        owner.addField(field.getFid());
////        DBManagerStub.saveObject(subscriber);
////        daoMySQL.update(field);
////    }
//
////    public static void Test3() throws Exception {
////        Subscriber subscriber = MyFactory.createSubscriber("Ohadony-owner", "pass", "ohad");
////        subscriber.makeOwnerActive();
////        Owner owner = subscriber.getOwner();
////        Team team = MyFactory.createTeam(subscriber.getOwner(), "HBS");
////
////
////        Subscriber subscriberPlayer = MyFactory.createSubscriber("Gal-player", "pass", "ohad");
////        subscriberPlayer.makePlayerActive(playerRole.ATTACKER , LocalDate.now());
////        Set<Player> players = new HashSet<>();
////        players.add(subscriberPlayer.getPlayer());
////
////
////        owner.addPlayers(players);
////
////        DBManagerStub.saveObject(subscriber);
////        DBManagerStub.saveObject(subscriberPlayer);
////    }
//



    public static void test1() throws Exception {

        Subscriber subscriber = MyFactory.createSubscriber("UserName1", "pass", "ohad");
        Subscriber subscriber1 = MyFactory.createSubscriber("UserName2", "pass", "gal");
        Subscriber subscriber2 = MyFactory.createSubscriber("UserName3", "pass", "referee name");
        Subscriber subscriber3 = MyFactory.createSubscriber("UserName4", "pass", "referee name");

        subscriber.makeOwnerActive();
        subscriber1.makeOwnerActive();


        Team team1 = MyFactory.createTeam(subscriber.getOwner(), "HBS");
        Team team2 = MyFactory.createTeam(subscriber1.getOwner(), "RMA");


        subscriber2.makeRefereeActive(Certification.BASIC, RefereeRoll.MAIN_REFEREE);
        subscriber3.makeRefereeActive(Certification.BASIC,RefereeRoll.LINE_REFEREE);

        Referee referee1 = subscriber2.getReferee();
        Referee referee2 = subscriber3.getReferee();

        Set<Referee> referees = new HashSet<>();
        referees.add(referee1);
        referees.add(referee2);

        Field field = MyFactory.createField("Terner");
        DBManager.saveObject(field);

        DBManager.saveObject(subscriber);
        DBManager.saveObject(subscriber1);
        DBManager.saveObject(subscriber2);
        DBManager.saveObject(subscriber3);

        subscriber.getOwner().addField(field.getFid());
        DBManager.updateObject(subscriber);

        Game match = MyFactory.createMatch(LocalDate.now(),LocalTime.now(),field,team1,team2,referees);
        DBManager.saveObject(match);

    }

    public static void test2(){
        List<Object> subs = DBManager.getListOfObjects(Subscriber.class, "Subscriber");
        List<Subscriber> sub2 = new ArrayList<>();
        for (Object o:subs){
            sub2.add(((Subscriber) o));
        }
    }

    public static void test3(){
        Subscriber subscriber = MyFactory.createSubscriber("UserName1", "pass", "ohad");
        Subscriber subscriber1 = MyFactory.createSubscriber("UserName2", "pass", "gal");

        subscriber.makeCoachActive( CoachRole.AttackerCoach, Certification.BASIC );

        DBManager.getInstance().saveObject(subscriber);
        DBManager.getInstance().saveObject(subscriber1);
    }

    /**
     * edit Player role/date test
     */
    public static void test4(){
        Subscriber subscriber = MyFactory.createSubscriber("UserName1", "pass", "ohad");
        subscriber.makePlayerActive(PlayerRole.ATTACKER,LocalDate.now());
        DBManager.saveObject(subscriber);
        Player player = subscriber.getPlayer();
        player.setRole(PlayerRole.DEFENDER);
        player.setDateOfBirth(LocalDate.of(1992,05,03));
        DBManager.updateObject(subscriber);
    }

    /**
     * edit Coach role/date test
     */
    public static void test5(){
        Subscriber subscriber = MyFactory.createSubscriber("UserName1", "pass", "ohad");
        subscriber.makeCoachActive(CoachRole.AttackerCoach,Certification.BASIC);
        DBManager.saveObject(subscriber);
        Coach coach = subscriber.getCoach();
        coach.setRole(CoachRole.DefenderCoach);
        coach.setCertification( Certification.PROFFESIONAL );
        DBManager.updateObject(subscriber);
    }

    /**
     * open a game report by
     */


    public static void test6(){
       // Subscriber subscriberNew = MyFactory.createSubscriber("UserName1", "12345", "ohad");
        Subscriber subscriberFromDB = DBManager.validateLogin("UserName1","pass");
        System.out.println(subscriberFromDB.getUserName());
        System.out.println(subscriberFromDB.getPassword());

    }

    /**
     * Same user_name in register test.
     */
    public static void test7(){
        Guest guest = MyFactory.createGuest();
        Subscriber subscriber = guest.Register("ohadnav","pass","pass","ohad");
        Subscriber subscriber1 = guest.Register("ohadnav","pass","pass","ohad");
    }
}
