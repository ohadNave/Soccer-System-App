package domain.Domain_Tests.DomainLayer.Users;

import org.junit.jupiter.api.Test;

//package DomainLayer.Users;
//
//import DomainLayer.Alerts.MatchDateChangedAlert;
//import DomainLayer.Enums.Certification;
//import DomainLayer.Enums.EventType;
//import DomainLayer.Enums.playerRole;
//import DomainLayer.LeagueManagment.*;
//import org.junit.Test;
//
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.util.Date;
//import java.util.HashSet;
//
//import static org.junit.Assert.*;
//
public class RefereeTest {

    @Test
    private void v(){

    }
}
//    String userName = "user";
//    String password = "1234";
//    String name = "Shlomi";
//    LocalDate d = LocalDate.of(99,2,22);
//    public class referee extends Referee{
//        public referee(Certification certification,int id) {
//            super(certification,id);
//        }
//    }
//    Subscriber subscriber=new Subscriber(userName,password,name);
//    referee r = new referee(Certification.BASIC,subscriber.getId());
//    @Test
//    public void showFutureGames() {
//        Subscriber subscriberOwner = new Subscriber(userName,password,name);
//        subscriberOwner.makeOwnerActive();
//        Owner owner=subscriberOwner.getOwner();
//        //check when match is null
//        assertNull(r.showFutureGames());
//
//        //check when match isn't null
//        HashSet<Integer> matches = new HashSet<>();
//        LocalTime localTime = LocalTime.of(2,4);
//        Team team1 = new Team("check", owner.getSid());
//        Team team2 = new Team("check2", owner.getSid());
//        Field field = new Field("check");
//        Subscriber subscriberMainReferee = new Subscriber(userName,password,name);
//        MainReferee mainReferee = new MainReferee(Certification.BASIC, subscriberMainReferee.getId());
//        Subscriber subscriberLineReferee1 = new Subscriber(userName,password,name);
//        Subscriber subscriberLineReferee2 = new Subscriber(userName,password,name);
//        LineReferre lineReferre1 = new LineReferre(Certification.BASIC,subscriberLineReferee1.getId());
//        LineReferre lineReferre2 = new LineReferre(Certification.BASIC,subscriberLineReferee2.getId());
//        Match match = new Match(new Date(),localTime,field.getFid(),team1.getTid(),team2.getTid(),mainReferee.getSid(),lineReferre1.getSid(),lineReferre2.getSid());
//        matches.add(match.getMatchId());
//        r.setMatches(matches);
//        HashSet<String> matchesToCompare = new HashSet<>();
//        matchesToCompare.add(match.toString());
//        assertEquals(matchesToCompare,r.showFutureGames());
//    }
//
//    @Test
//    public void addEventToMatch() {
//        //check a case that match is null
//        assertFalse(r.addEventToMatch(10,2,"check", EventType.FOUL,"Shlomi"));
//
//        //initialize parameters
//        LocalTime localTime = LocalTime.of(2,4);
//        Subscriber subscriberOwner = new Subscriber(userName,password,name);
//        subscriberOwner.makeOwnerActive();
//        Owner owner=subscriberOwner.getOwner();
//        Team team1 = new Team("check", owner.getSid());
//        HashSet<Integer> players = new HashSet<>();
//        Subscriber subscriberPlayer= new Subscriber(userName,password,name);
//        Player p =new Player(playerRole.ATTACKER,LocalDate.of(2,2,2),subscriberPlayer.getId());
//        players.add(p.getSid());
//        team1.addPlayers(players);
//        Team team2 = new Team("check2", owner.getSid());
//        Field field = new Field("check");
//        Subscriber subscriberMainReferee = new Subscriber(userName,password,name);
//        MainReferee mainReferee = new MainReferee(Certification.BASIC, subscriberMainReferee.getId());
//        Subscriber subscriberLineReferee1 = new Subscriber(userName,password,name);
//        Subscriber subscriberLineReferee2 = new Subscriber(userName,password,name);
//        LineReferre lineReferre1 = new LineReferre(Certification.BASIC,subscriberLineReferee1.getId());
//        LineReferre lineReferre2 = new LineReferre(Certification.BASIC,subscriberLineReferee2.getId());
//        Match match = new Match(new Date(),localTime,field.getFid(),team1.getTid(),team2.getTid(),mainReferee.getSid(),lineReferre1.getSid(),lineReferre2.getSid());
//
//        //check if matches is null
//        HashSet<Integer> matches = new HashSet<>();
//        assertFalse(r.addEventToMatch(match.getMatchId(),2,"check", EventType.FOUL,"Shlomi"));
//
//
//        //check if match is not null but doesn't exist
//        r.setMatches(matches);
//        assertFalse(r.addEventToMatch(match.getMatchId(),2,"check", EventType.FOUL,"Shlomi"));
//
//        //check is minutesInGame logical
//        matches.add(match.getMatchId());
//        r.setMatches(matches);
//        assertFalse(r.addEventToMatch(match.getMatchId(),-1,"check", EventType.FOUL,"Shlomi"));
//        assertFalse(r.addEventToMatch(match.getMatchId(),126,"check", EventType.FOUL,"Shlomi"));
//
//        //check if there is no description
//        assertFalse(r.addEventToMatch(match.getMatchId(),2,"", EventType.FOUL,"Shlomi"));
//
//        //check if eventType is null
//        assertFalse(r.addEventToMatch(match.getMatchId(),2,"check", null,"Shlomi"));
//
//        //check if player name doesn't exist in match
//
//
//        //check if everything is OK
//        assertTrue(r.addEventToMatch(match.getMatchId(),2,"check", EventType.FOUL,"Shlomi"));
//
//        Event newEvent = new Event(2, "check", EventType.FOUL,"Shlomi");
//        HashSet<Event> gameEvents = new HashSet<>();
//        gameEvents.add(newEvent);
//        Event eventFromMatch = match.getGameEvents().iterator().next();
//        assertEquals(newEvent.getDescription(),eventFromMatch.getDescription());
//        assertEquals(newEvent.getMinuteInGame(),eventFromMatch.getMinuteInGame());
//        assertEquals(newEvent.getEventType(),eventFromMatch.getEventType());
//    }
//
//    @Test
//    public void update() {
//        LocalTime localTime = LocalTime.of(2,4);
//        Subscriber subscriberOwner = new Subscriber(userName,password,name);
//        subscriberOwner.makeOwnerActive();
//        Owner owner=subscriberOwner.getOwner();
//        Team team1 = new Team("check", owner.getSid());
//        Team team2 = new Team("check2", owner.getSid());
//        Field field = new Field("check");
//        Subscriber subscriberMainReferee = new Subscriber(userName,password,name);
//        MainReferee mainReferee = new MainReferee(Certification.BASIC, subscriberMainReferee.getId());
//        Subscriber subscriberLineReferee1 = new Subscriber(userName,password,name);
//        Subscriber subscriberLineReferee2 = new Subscriber(userName,password,name);
//        LineReferre lineReferre1 = new LineReferre(Certification.BASIC,subscriberLineReferee1.getId());
//        LineReferre lineReferre2 = new LineReferre(Certification.BASIC,subscriberLineReferee2.getId());
//        Match match = new Match(new Date(),localTime,field.getFid(),team1.getTid(),team2.getTid(),mainReferee.getSid(),lineReferre1.getSid(),lineReferre2.getSid());
//        MatchDateChangedAlert matchDateChangedAlert= new MatchDateChangedAlert(new Date());
//
//        //check is matches is null
//        r.update(match, matchDateChangedAlert);
//        assertFalse(r.getAlerts().contains(matchDateChangedAlert));
//
//        //check if matches doesn't contains match
//        HashSet<Integer> matches = new HashSet<>();
//        r.update(match, matchDateChangedAlert);
//        assertFalse(r.getAlerts().contains(matchDateChangedAlert));
//
//        //check if o is not instance of match
//        r.setMatches(matches);
//        matches.add(match.getMatchId());
//        PrivatePage p= new PrivatePage();
//        r.update(p, matchDateChangedAlert);
//        assertFalse(r.getAlerts().contains(matchDateChangedAlert));
//
//        //check if one of arguments is null
//        r.update(null,matchDateChangedAlert);
//        assertFalse(r.getAlerts().contains(matchDateChangedAlert));
//        r.update(match, null);
//        assertFalse(r.getAlerts().contains(matchDateChangedAlert));
//
//
//        //check if everything is ok
//        match.setMainReferee(mainReferee.getSid());
//        match.setLineReferee1(lineReferre1.getSid());
//        match.setMainReferee(lineReferre2.getSid());
//
//        //check if it's mainReferee
//        subscriber.makeMainRefereeActive(Certification.BASIC);
//        r.update(match,matchDateChangedAlert);
//        MainReferee mainReferee1 = subscriber.getMainReferee();
//        assertTrue(mainReferee1.getAlerts().contains(matchDateChangedAlert));
//
//        //check if it's lineReferee
//        subscriber.makeMainRefereeNotActive();
//        subscriber.makeLineRefereeActive(Certification.BASIC);
//        LineReferre lineReferre = subscriber.getLineReferre();
//        r.update(match,matchDateChangedAlert);
//        assertTrue(lineReferre
//                .getAlerts().contains(matchDateChangedAlert));
//    }
//
//    @Test
//    public void handleAlert() {
//        LocalTime localTime = LocalTime.of(2,4);
//        Subscriber subscriberOwner = new Subscriber(userName,password,name);
//        subscriberOwner.makeOwnerActive();
//        Owner owner=subscriberOwner.getOwner();
//        Team team1 = new Team("check", owner.getSid());
//        Team team2 = new Team("check2", owner.getSid());
//        Field field = new Field("check");
//        Subscriber subscriberMainReferee = new Subscriber(userName,password,name);
//        MainReferee mainReferee = new MainReferee(Certification.BASIC, subscriberMainReferee.getId());
//        Subscriber subscriberLineReferee1 = new Subscriber(userName,password,name);
//        Subscriber subscriberLineReferee2 = new Subscriber(userName,password,name);
//        LineReferre lineReferre1 = new LineReferre(Certification.BASIC,subscriberLineReferee1.getId());
//        LineReferre lineReferre2 = new LineReferre(Certification.BASIC,subscriberLineReferee2.getId());
//        Match match = new Match(new Date(),localTime,field.getFid(),team1.getTid(),team2.getTid(),mainReferee.getSid(),lineReferre1.getSid(),lineReferre2.getSid());
//        MatchDateChangedAlert matchDateChangedAlert= new MatchDateChangedAlert(new Date());
//
//        HashSet<Integer> matches = new HashSet<>();
//        r.setMatches(matches);
//        matches.add(match.getMatchId());
//        subscriber.makeMainRefereeActive(Certification.BASIC);
//        MainReferee mainReferee1 = subscriber.getMainReferee();
//        r.handleAlert(matchDateChangedAlert);
//        assertTrue(mainReferee1.getAlerts().contains(matchDateChangedAlert));
//
//    }
//
//    @Test
//    public void getMatches() {
//        //check without matches
//        HashSet<Integer> matches = new HashSet<>();
//        r.setMatches(matches);
//        assertEquals(matches, r.getMatches());
//
//
//        //check with matches
//        LocalTime localTime = LocalTime.of(2,4);
//        Subscriber subscriberOwner = new Subscriber(userName,password,name);
//        subscriberOwner.makeOwnerActive();
//        Owner owner=subscriberOwner.getOwner();
//        Team team1 = new Team("check", owner.getSid());
//        Team team2 = new Team("check2", owner.getSid());
//        Field field = new Field("check");
//        Subscriber subscriberMainReferee = new Subscriber(userName,password,name);
//        MainReferee mainReferee = new MainReferee(Certification.BASIC, subscriberMainReferee.getId());
//        Subscriber subscriberLineReferee1 = new Subscriber(userName,password,name);
//        Subscriber subscriberLineReferee2 = new Subscriber(userName,password,name);
//        LineReferre lineReferre1 = new LineReferre(Certification.BASIC,subscriberLineReferee1.getId());
//        LineReferre lineReferre2 = new LineReferre(Certification.BASIC,subscriberLineReferee2.getId());
//        Match match = new Match(new Date(),localTime,field.getFid(),team1.getTid(),team2.getTid(),mainReferee.getSid(),lineReferre1.getSid(),lineReferre2.getSid());
//        matches.add(match.getMatchId());
//        r.setMatches(matches);
//        assertEquals(matches, r.getMatches());
//    }
//
//    @Test
//    public void setMatches() {
//        //check null argument
//        r.setMatches(null);
//        assertNull(r.getMatches());
//
//        //check without matches
//        HashSet<Integer> matches = new HashSet<>();
//        r.setMatches(matches);
//        assertEquals(matches, r.getMatches());
//
//
//        //check with matches
//        LocalTime localTime = LocalTime.of(2,4);
//        Subscriber subscriberOwner = new Subscriber(userName,password,name);
//        subscriberOwner.makeOwnerActive();
//        Owner owner=subscriberOwner.getOwner();
//        Team team1 = new Team("check", owner.getSid());
//        Team team2 = new Team("check2", owner.getSid());
//        Field field = new Field("check");
//        Subscriber subscriberMainReferee = new Subscriber(userName,password,name);
//        MainReferee mainReferee = new MainReferee(Certification.BASIC, subscriberMainReferee.getId());
//        Subscriber subscriberLineReferee1 = new Subscriber(userName,password,name);
//        Subscriber subscriberLineReferee2 = new Subscriber(userName,password,name);
//        LineReferre lineReferre1 = new LineReferre(Certification.BASIC,subscriberLineReferee1.getId());
//        LineReferre lineReferre2 = new LineReferre(Certification.BASIC,subscriberLineReferee2.getId());
//        Match match = new Match(new Date(),localTime,field.getFid(),team1.getTid(),team2.getTid(),mainReferee.getSid(),lineReferre1.getSid(),lineReferre2.getSid());
//        matches.add(match.getMatchId());
//        r.setMatches(matches);
//        assertEquals(matches, r.getMatches());
//    }
//
//    @Test
//    public void getCertification() {
//        assertEquals(Certification.BASIC, r.getCertification());
//    }
//
//    @Test
//    public void setCertification() {
//        //check regular case
//        r.setCertification(Certification.INTERMIDATE);
//        assertEquals(Certification.INTERMIDATE, r.getCertification());
//
//        //check null argument
//        r.setCertification(null);
//        assertEquals(Certification.INTERMIDATE, r.getCertification());
//    }
//
//    @Test
//    public void getAlerts() {
//        //check an empty alerts queue
//        assertEquals(0, r.getAlerts().size());
//
//        //check alerts with arguments
//        LocalTime localTime = LocalTime.of(2,4);
//        Subscriber subscriberOwner = new Subscriber(userName,password,name);
//        subscriberOwner.makeOwnerActive();
//        Owner owner=subscriberOwner.getOwner();
//        Team team1 = new Team("check", owner.getSid());
//        Team team2 = new Team("check2", owner.getSid());
//        Field field = new Field("check");
//        Subscriber subscriberMainReferee = new Subscriber(userName,password,name);
//        MainReferee mainReferee = new MainReferee(Certification.BASIC, subscriberMainReferee.getId());
//        Subscriber subscriberLineReferee1 = new Subscriber(userName,password,name);
//        Subscriber subscriberLineReferee2 = new Subscriber(userName,password,name);
//        LineReferre lineReferre1 = new LineReferre(Certification.BASIC,subscriberLineReferee1.getId());
//        LineReferre lineReferre2 = new LineReferre(Certification.BASIC,subscriberLineReferee2.getId());
//        Match match = new Match(new Date(),localTime,field.getFid(),team1.getTid(),team2.getTid(),mainReferee.getSid(),lineReferre1.getSid(),lineReferre2.getSid());
//        MatchDateChangedAlert matchDateChangedAlert= new MatchDateChangedAlert(new Date());
//        HashSet<Integer> matches = new HashSet<>();
//        r.setMatches(matches);
//        matches.add(match.getMatchId());
//        subscriber.makeMainRefereeActive(Certification.BASIC);
//        MainReferee mainReferee1 = subscriber.getMainReferee();
//        r.handleAlert(matchDateChangedAlert);
//        assertTrue(mainReferee1.getAlerts().contains(matchDateChangedAlert));
//    }
//}