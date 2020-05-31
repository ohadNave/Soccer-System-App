package domain.Domain_Tests.DomainLayer.Users;

import org.junit.jupiter.api.Test;

//package DomainLayer.Users;
//
//import DomainLayer.DBManagerStub;
//import DomainLayer.Enums.Certification;
//import DomainLayer.Enums.EventType;
//import DomainLayer.Enums.MatchStatus;
//import DomainLayer.LeagueManagment.Event;
//import DomainLayer.LeagueManagment.Field;
//import DomainLayer.LeagueManagment.Match;
//import DomainLayer.LeagueManagment.Team;
//import DomainLayer.Request.RegistrationRequest;
//import DomainLayer.Request.TeamRequest;
//import org.junit.Test;
//
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.util.Date;
//import java.util.HashSet;
//
//import static org.junit.Assert.*;
//
public class MainRefereeTest {
    @Test
    private void t(){

    }
}
//    String userName = "user";
//    String password = "1234";
//    String name = "Shlomi";
//    LocalDate d = LocalDate.of(99,2,22);
//    Subscriber subscriber = new Subscriber(userName,password,name);
//    MainReferee mainReferee;
//    @Test
//    public void editGameEvent() {
//        subscriber.makeMainRefereeActive(Certification.BASIC);
//        mainReferee=subscriber.getMainReferee();
//        Event event = new Event(2,"check", EventType.FOUL,"Shlomi");
//        int minuteInGame = 3;
//        String description = "another check";
//
//        //check if event is null
//        assertFalse(mainReferee.editGameEvent(null, minuteInGame,description, EventType.FOUL));
//
//        //check if minutes isn't logical
//        assertFalse(mainReferee.editGameEvent(event,130, description, EventType.FOUL));
//
//        //check if description is empty
//        assertFalse(mainReferee.editGameEvent(event, minuteInGame,"", EventType.FOUL));
//
//        //check if EventType is null
//        assertFalse(mainReferee.editGameEvent(event,minuteInGame,description, null));
//
//        //check if all the arguments are legal
//        assertTrue(mainReferee.editGameEvent(event,minuteInGame,description, EventType.Goal));
//        assertEquals(3, event.getMinuteInGame());
//        assertEquals("another check", event.getDescription());
//        assertEquals(EventType.Goal, event.getEventType());
//    }
//
//    @Test
//    public void createGameReport() {
//        subscriber.makeMainRefereeActive(Certification.BASIC);
//        mainReferee=subscriber.getMainReferee();
//        Subscriber subscriberOwner = new Subscriber(userName,password,name);
//        subscriberOwner.makeOwnerActive();
//        Owner owner=subscriberOwner.getOwner();
//        HashSet<Integer> matches = new HashSet<>();
//        LocalTime localTime = LocalTime.of(2,4);
//        Subscriber subscriberFAR = new Subscriber(userName,password,name);
//        subscriberFAR.makeFARActive();
//        FAR far = subscriberFAR.getFAR();
//        RegistrationRequest registrationRequest1 = new TeamRequest("check",owner.getSid());
//        far.handleRegistrationRequest(registrationRequest1,true);
//        RegistrationRequest registrationRequest2 = new TeamRequest("check2",owner.getSid());
//        far.handleRegistrationRequest(registrationRequest2,true);
//        // Team team1 = new Team("check", owner.getSid());
//        // Team team2 = new Team("check2", owner.getSid());
//        Team team1 =DBManagerStub.getTeam(1);
//        Team team2 = DBManagerStub.getTeam(2);
//        Field field = new Field("check");
//        Subscriber subscriberMainReferee = new Subscriber(userName,password,name);
//        MainReferee mainReferee = new MainReferee(Certification.BASIC, subscriberMainReferee.getId());
//        Subscriber subscriberLineReferee1 = new Subscriber(userName,password,name);
//        Subscriber subscriberLineReferee2 = new Subscriber(userName,password,name);
//        LineReferre lineReferre1 = new LineReferre(Certification.BASIC,subscriberLineReferee1.getId());
//        LineReferre lineReferre2 = new LineReferre(Certification.BASIC,subscriberLineReferee2.getId());
//        Match match = new Match(new Date(),localTime,field.getFid(),team1.getTid(),team2.getTid(),mainReferee.getSid(),lineReferre1.getSid(),lineReferre2.getSid());
//
//        //check when matches is null
//        assertFalse(mainReferee.createGameReport(130, team1, team2, 1, 0));
//
//        matches.add(match.getMatchId());
//        mainReferee.setMatches(matches);
//
//        //check if winnerTeam is null
//        assertFalse(mainReferee.createGameReport(match.getMatchId(), null, team2, 1, 0));
//
//        //check if losingTeam is null
//        assertFalse(mainReferee.createGameReport(match.getMatchId(), team1, null, 1, 0));
//
//        //check if num of goals is not logical
//        assertFalse(mainReferee.createGameReport(match.getMatchId(), team1, team2, -1, 0));
//        assertFalse(mainReferee.createGameReport(match.getMatchId(), team1, team2, 1, -1));
//
//        //check that teams are not equal
//        assertFalse(mainReferee.createGameReport(match.getMatchId(), team1, team1, 12, 1));
//
//       //check if everything is ok
//        assertTrue(mainReferee.createGameReport(match.getMatchId(), team1, team2, 12, 1));
//        assertEquals(team1, match.getGameReport().getWinnerTeam());
//        assertEquals(team2, match.getGameReport().getLosingTeam());
//        assertEquals(12, match.getGameReport().getWinnerGoals());
//        assertEquals(1, match.getGameReport().getLoserGoals());
//    }
//
//    @Test
//    public void deleteFromDB() {
//        subscriber.makeMainRefereeActive(Certification.BASIC);
//        mainReferee=subscriber.getMainReferee();
//        mainReferee.deleteFromDB(mainReferee.getSid());
//        MainReferee mainRefereeToCompare = DBManagerStub.getMainReferee(mainReferee.getSid());
//        assertNull(mainRefereeToCompare);
//    }
//
//    @Test
//    public void changeMatchStatus(){
//        subscriber.makeMainRefereeActive(Certification.BASIC);
//        mainReferee=subscriber.getMainReferee();
//        Subscriber subscriberOwner = new Subscriber(userName,password,name);
//        subscriberOwner.makeOwnerActive();
//        Owner owner=subscriberOwner.getOwner();
//        HashSet<Integer> matches = new HashSet<>();
//        LocalTime localTime = LocalTime.of(2,4);
//        Subscriber subscriberFAR = new Subscriber(userName,password,name);
//        subscriberFAR.makeFARActive();
//        FAR far = subscriberFAR.getFAR();
//        RegistrationRequest registrationRequest1 = new TeamRequest("check",owner.getSid());
//        far.handleRegistrationRequest(registrationRequest1,true);
//        RegistrationRequest registrationRequest2 = new TeamRequest("check2",owner.getSid());
//        far.handleRegistrationRequest(registrationRequest2,true);
//        // Team team1 = new Team("check", owner.getSid());
//        // Team team2 = new Team("check2", owner.getSid());
//        Team team1 =DBManagerStub.getTeam(1);
//        Team team2 = DBManagerStub.getTeam(2);
//        Field field = new Field("check");
//        Subscriber subscriberMainReferee = new Subscriber(userName,password,name);
//        MainReferee mainReferee = new MainReferee(Certification.BASIC, subscriberMainReferee.getId());
//        Subscriber subscriberLineReferee1 = new Subscriber(userName,password,name);
//        Subscriber subscriberLineReferee2 = new Subscriber(userName,password,name);
//        LineReferre lineReferre1 = new LineReferre(Certification.BASIC,subscriberLineReferee1.getId());
//        LineReferre lineReferre2 = new LineReferre(Certification.BASIC,subscriberLineReferee2.getId());
//        Match match = new Match(new Date(),localTime,field.getFid(),team1.getTid(),team2.getTid(),mainReferee.getSid(),lineReferre1.getSid(),lineReferre2.getSid());
//
//        //if matchStatus is null
//        mainReferee.changeMatchStatus(135,MatchStatus.IN_PROGRESS);
//        assertNotEquals(MatchStatus.IN_PROGRESS,match.getMatchStatus());
//
//        //if tempMatch is null
//        mainReferee.changeMatchStatus(match.getMatchId(),null);
//        assertNotEquals(null,match.getMatchStatus());
//
//        //if everything is OK
//        mainReferee.changeMatchStatus(match.getMatchId(),MatchStatus.IN_PROGRESS);
//        assertEquals(MatchStatus.IN_PROGRESS, match.getMatchStatus());
//    }
//}