package domain.Domain_Tests.DomainLayer.LeagueManagment;

import org.junit.Test;

import static org.junit.Assert.*;

public class LeagueTest {


    //    String userName = "user";
//    String password = "1234";
//    String name = "Shlomi";
//    int year = 2020;
//    League league = MyFactory.createLeague(LeagueLevel.PremierLeague, name);
    @Test
    public void setScorePolicyForSeason() {

    }
//        //check is season doesn't contains key
//        assertFalse(league.setScorePolicyForSeason(1,new ScorePolicyA()));
//
//        //check id scorePolicy is null
//        Subscriber subscriberOwner = MyFactory.createSubscriber(userName,password,name);
//        subscriberOwner.makeOwnerActive();
//        Owner owner=subscriberOwner.getOwner();
//        Team team1 = MyFactory.createTeam(owner,"team1");
//        Team team2 = MyFactory.createTeam(owner,"team2");
//        List<Team> teams = new ArrayList<>();
//        teams.add(team1);
//        teams.add(team2);
//        league.startNewSeason(5,teams);
//        assertFalse(league.setScorePolicyForSeason(5,null));
//
//        //check if everything is OK
//        assertTrue(league.setScorePolicyForSeason(5,new ScorePolicyA()));
//        Season season = league.getSeasons().iterator().next();
//        assertEquals(new ScorePolicyA(),season.getIScorePolicy());
//    }
//
//    @Test
//    public void setSeasonSchedulerPolicy() {
//        //check if season doesn't contains key
//        assertFalse(league.setSeasonSchedulerPolicy(1,gameSchedulerPolicy));
//
//        //check id gameSchedularPolicy is null
//        Subscriber subscriberOwner = new Subscriber(userName,password,name);
//        subscriberOwner.makeOwnerActive();
//        Owner owner=subscriberOwner.getOwner();
//        Team team1 = new Team("team1",owner.getSid());
//        Team team2 = new Team("team2", owner.getSid());
//        int [] teams = {team1.getTid(),team2.getTid()};
//        league.startNewSeason(5,teams,gameSchedulerPolicy,scorePolicy);
//        assertFalse(league.setSeasonSchedulerPolicy(5,null));
//
//        //check if everything is OK
//        assertTrue(league.setScorePolicyForSeason(5,scorePolicy));
//        Season season = DBManagerStub.getSeason(league.getLid(),5);
//        assertEquals(scorePolicy,season.getScorePolicy());
//    }
//
//    @Test
//    public void activateGameSchedulePolicyForSeason() {
//        //check is season doesn't contains key
//        assertFalse(league.activateGameSchedulePolicyForSeason(1));
//
//        //check if everything is OK
//        Subscriber subscriberOwner = new Subscriber(userName,password,name);
//        subscriberOwner.makeOwnerActive();
//        Owner owner=subscriberOwner.getOwner();
//        Team team1 = new Team("team1",owner.getSid());
//        Team team2 = new Team("team2", owner.getSid());
//        int [] teams = {team1.getTid(),team2.getTid()};
//        league.startNewSeason(5,teams,gameSchedulerPolicy,scorePolicy);
//        assertTrue(league.activateGameSchedulePolicyForSeason(5));
//        Season season = DBManagerStub.getSeason(league.getLid(),5);
//        assertNull(season.getMatches());
//    }
//
//    @Test
//    public void setMainRefereesForSeason() {
//        //check if season doesn't contains year
//        HashSet<Integer> referees = new HashSet<>();
//        Subscriber subscriberMainReferee = new Subscriber(userName, password, name);
//        subscriberMainReferee.makeMainRefereeActive(Certification.BASIC);
//        Referee referee= subscriberMainReferee.getMainReferee();
//        referees.add(referee.getSid());
//        assertFalse(league.setMainRefereesForSeason(5,referees));
//
//        //check if referee is mull is null
//        Subscriber subscriberOwner = new Subscriber(userName,password,name);
//        subscriberOwner.makeOwnerActive();
//        Owner owner=subscriberOwner.getOwner();
//        Team team1 = new Team("team1",owner.getSid());
//        Team team2 = new Team("team2", owner.getSid());
//        int [] teams = {team1.getTid(),team2.getTid()};
//        league.startNewSeason(5,teams,gameSchedulerPolicy,scorePolicy);
//        assertFalse(league.setMainRefereesForSeason(5,null));
//
//        //check if everything is OK
//        assertTrue(league.setMainRefereesForSeason(5,referees));
//        Season season = DBManagerStub.getSeason(league.getLid(),5);
//        assertEquals(referees, season.getMainReferees());
//    }
//
//    @Test
//    public void setLineRefereesForSeason() {
//        //check if season doesn't contains year
//        HashSet<Integer> referees = new HashSet<>();
//        Subscriber subscriberLineReferee = new Subscriber(userName, password, name);
//        subscriberLineReferee.makeLineRefereeActive(Certification.BASIC);
//        Referee referee= subscriberLineReferee.getLineReferre();
//        referees.add(referee.getSid());
//        assertFalse(league.setLineRefereesForSeason(5,referees));
//
//        //check if referee is mull is null
//        Subscriber subscriberOwner = new Subscriber(userName,password,name);
//        subscriberOwner.makeOwnerActive();
//        Owner owner=subscriberOwner.getOwner();
//        Team team1 = new Team("team1",owner.getSid());
//        Team team2 = new Team("team2", owner.getSid());
//        int [] teams = {team1.getTid(),team2.getTid()};
//        league.startNewSeason(5,teams,gameSchedulerPolicy,scorePolicy);
//        assertFalse(league.setMainRefereesForSeason(5,null));
//
//        //check if everything is OK
//        assertTrue(league.setLineRefereesForSeason(5,referees));
//        Season season = DBManagerStub.getSeason(league.getLid(),5);
//        assertEquals(referees, season.getLineReferees());
//    }
//
//    @Test
//    public void startNewSeason() {
//        //check non logical year
//        Subscriber subscriberOwner = new Subscriber(userName,password,name);
//        subscriberOwner.makeOwnerActive();
//        Owner owner=subscriberOwner.getOwner();
//        Team team1 = new Team("team1",owner.getSid());
//        Team team2 = new Team("team2", owner.getSid());
//        int [] teams = {team1.getTid(),team2.getTid()};
//        assertFalse(league.startNewSeason(-1,teams,gameSchedulerPolicy,scorePolicy));
//
//        //check if team is null
//        assertFalse(league.startNewSeason(5,null,gameSchedulerPolicy,scorePolicy));
//
//        //check if everything OK
//        assertTrue(league.startNewSeason(5,teams,gameSchedulerPolicy,scorePolicy));
//    }
//
//    @Test
//    public void getLeagueLevel() {
//        assertEquals(LeagueLevel.NationalLeague, league.getLeagueLevel());
//    }
//
//    @Test
//    public void setLeagueLevel() {
//        //check if leagueLevel is null
//        League league1 = new League(LeagueLevel.PremierLeague,name,gameSchedulerPolicy,scorePolicy);
//        league1.setLeagueLevel(null);
//        assertEquals(LeagueLevel.PremierLeague, league1.getLeagueLevel());
//
//        //check if everything is OK
//        league1.setLeagueLevel(LeagueLevel.NationalLeague);
//        assertEquals(LeagueLevel.NationalLeague, league1.getLeagueLevel());
//    }
//
//    @Test
//    public void getName() {
//        assertEquals(name, league.getName());
//    }
//
//    @Test
//    public void setName() {
//        //check if name is empty
//        league.setName("");
//        assertEquals(name, league.getName());
//
//        //check if name is null
//        league.setName(null);
//        assertEquals(name, league.getName());
//
//        //check if everything is OK
//        String anotherName="another name";
//        league.setName(anotherName);
//        assertEquals(anotherName,league.getName());
//    }
//
//    @Test
//    public void getLid() {
//        League leagueToCompare = new League(LeagueLevel.NationalLeague,name,gameSchedulerPolicy,scorePolicy);
//        assertEquals(league.getLid()+1,leagueToCompare.getLid());
//    }
//
//    @Test
//    public void getSeasons() {
//        Subscriber subscriberOwner = new Subscriber(userName,password,name);
//        subscriberOwner.makeOwnerActive();
//        Owner owner=subscriberOwner.getOwner();
//        Team team1 = new Team("team1",owner.getSid());
//        Team team2 = new Team("team2", owner.getSid());
//        int [] teams = {team1.getTid(),team2.getTid()};
//        league.startNewSeason(5,teams,gameSchedulerPolicy,scorePolicy);
//        assertTrue(league.getSeasons().contains(5));
//
//    }
//}
}