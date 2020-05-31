package domain.Domain_Tests.DomainLayer.Users;

import org.junit.jupiter.api.Test;

//package DomainLayer.Users;
//
//import DomainLayer.DBManagerStub;
//import DomainLayer.Enums.Certification;
//import DomainLayer.Enums.LeagueLevel;
//import DomainLayer.LeagueManagment.*;
//import DomainLayer.Request.LineRefereeRequest;
//import DomainLayer.Request.MainRefereeRequest;
//import DomainLayer.Request.RegistrationRequest;
//import DomainLayer.Request.TeamRequest;
//import org.junit.Test;
//
//import java.util.HashMap;
//import java.util.HashSet;
//
//import static org.junit.Assert.*;
//
public class FARTest {
    @Test
    private void r(){

    }

}
//    GameSchedulerPolicy gameSchedulerPolicy=new GameSchedulerPolicy() {
//        @Override
//        public HashSet<Integer> activate(HashMap<Integer, Integer> teamStatsHashMap) {
//            return new HashSet<>();
//        }
//    };
//    ScorePolicy scorePolicy=new ScorePolicyA();
//    String name="check";
//  //  League league= new League(LeagueLevel.NationalLeague,name,gameSchedulerPolicy,scorePolicy);
//    HashSet<League> leagues = new HashSet<>();
//    Subscriber subscriberMainReferee = new Subscriber(name,name,name);
////    subscriberMainReferee.makeMainRefereeActive(Certification.BASIC);
////    Referee referee = subscriberMainReferee.getMainReferee();
//    HashSet<Integer> referees = new HashSet<>();
//    Subscriber subscriberFAR = new Subscriber(name, name,name);
//    FAR far = new FAR(subscriberFAR.getId());
//    @Test
//    public void initializeLeague() {
//        //check if leagueLevel is null
//        assertFalse(far.initializeLeague(null,name,gameSchedulerPolicy,scorePolicy));
//
//        //check if name is null
//        assertFalse(far.initializeLeague(LeagueLevel.NationalLeague,null,gameSchedulerPolicy,scorePolicy));
//
//        //check if name is empty
//        assertFalse(far.initializeLeague(LeagueLevel.NationalLeague,"",gameSchedulerPolicy,scorePolicy));
//
//        //check if gameSchedularPolicy is null
//        assertFalse(far.initializeLeague(LeagueLevel.NationalLeague,name,null,scorePolicy));
//
//        //check if scorePolicy is null
//        assertFalse(far.initializeLeague(LeagueLevel.NationalLeague,name,gameSchedulerPolicy,null));
//
//        //check if everything is OK
//        assertTrue(far.initializeLeague(LeagueLevel.NationalLeague,name,gameSchedulerPolicy,scorePolicy));
//    }
//
//    @Test
//    public void initializeSeasonForLeague() {
//        int year =4;
//        Subscriber subscriberOwner = new Subscriber(name,name,name);
//        subscriberOwner.makeOwnerActive();
//        Owner owner=subscriberOwner.getOwner();
//        Team team1 = new Team("team1",owner.getSid());
//        Team team2 = new Team("team2",owner.getSid());
//        int [] teams ={team1.getTid(),team2.getTid()};
//        far.initializeLeague(LeagueLevel.NationalLeague,name,gameSchedulerPolicy,scorePolicy);
//        League league = DBManagerStub.getLeague(1);
//        //check if DB doesn't contains
//        assertFalse(far.initializeSeasonForLeague(10000,year,teams,gameSchedulerPolicy,scorePolicy));
//        leagues.add(league);
//
//
//        //check if year is not logical
//        assertFalse(far.initializeSeasonForLeague(league.getLid(),-1,teams,gameSchedulerPolicy,scorePolicy));
//
//        //check if teams is null
//        assertFalse(far.initializeSeasonForLeague(league.getLid(),year,null,gameSchedulerPolicy,scorePolicy));
//
//        //check if gameSchedularPolicy is null
//        assertFalse(far.initializeSeasonForLeague(league.getLid(),year,teams,null,scorePolicy));
//
//        //check if scorePoicy is null
//        assertFalse(far.initializeSeasonForLeague(league.getLid(),year,teams,gameSchedulerPolicy,null));
//
////        //check if team is close
////        team1.setClosedPermanently(true);
////        assertFalse(far.initializeSeasonForLeague(league,year,teams,gameSchedulerPolicy,scorePolicy));
//
//
//        //check if everything is OK
//        assertTrue(far.initializeSeasonForLeague(league.getLid(),year,teams,gameSchedulerPolicy,scorePolicy));
//        assertTrue(DBManagerStub.getBudgetControl().getTeams().containsKey(team1.getTid()));
//        //
//    }
//
//    @Test
//    public void createMainReferee() {
//        //check if userName is empty or null
//        assertFalse(far.createMainReferee("",name,name,Certification.BASIC));
//        assertFalse(far.createMainReferee(null,name,name,Certification.BASIC));
//
//        //check if password is empty or null
//        assertFalse(far.createMainReferee(name,"",name,Certification.BASIC));
//        assertFalse(far.createMainReferee(name,null,name,Certification.BASIC));
//
//        //check if name is empty or null
//        assertFalse(far.createMainReferee(name,name,"",Certification.BASIC));
//        assertFalse(far.createMainReferee(name,name,null,Certification.BASIC));
//
//        //check if certification is empty or null
//        assertFalse(far.createMainReferee(name,name,name,null));
//
//        //check if userName is not OK
//        assertFalse(far.createMainReferee("ch",name,name,Certification.BASIC));
//
//        //check if everything is OK
//        String newUserNameAndPassword = "check1";
//        assertTrue(far.createMainReferee(newUserNameAndPassword,newUserNameAndPassword,name,Certification.BASIC));
//        Subscriber subscriber= DBManagerStub.getSubscriberByUserNameAndPassword(newUserNameAndPassword,newUserNameAndPassword);
//        assertNotNull(subscriber);
//        assertNotNull(DBManagerStub.getMainReferee(subscriber.getId()));
//
//    }
//
//    @Test
//    public void createLineReferee() {
//        //check if userName is empty or null
//        assertFalse(far.createLineReferee("",name,name,Certification.BASIC));
//        assertFalse(far.createLineReferee(null,name,name,Certification.BASIC));
//
//        //check if password is empty or null
//        assertFalse(far.createLineReferee(name,"",name,Certification.BASIC));
//        assertFalse(far.createLineReferee(name,null,name,Certification.BASIC));
//
//        //check if name is empty or null
//        assertFalse(far.createLineReferee(name,name,"",Certification.BASIC));
//        assertFalse(far.createLineReferee(name,name,null,Certification.BASIC));
//
//        //check if certification is empty or null
//        assertFalse(far.createLineReferee(name,name,name,null));
//
//        //check if userName is not OK
//        assertFalse(far.createLineReferee("ch",name,name,Certification.BASIC));
//
//        //check if everything is OK
//        String newUserNameAndPassword = "check123";
//        assertTrue(far.createLineReferee(newUserNameAndPassword,newUserNameAndPassword,name,Certification.BASIC));
//        Subscriber subscriber= DBManagerStub.getSubscriberByUserNameAndPassword(newUserNameAndPassword,newUserNameAndPassword);
//        assertNotNull(subscriber);
//        assertNotNull(DBManagerStub.getLineReferee(subscriber.getId()));
//    }
//
//    @Test
//    public void removeMainReferee() {
//        //check if referee is null
//        assertFalse(far.removeMainReferee(220));
//
//
//        //check if everything is ok
//        String newUserNameAndPassword = "check2";
//        assertTrue(far.createMainReferee(newUserNameAndPassword,newUserNameAndPassword,name,Certification.BASIC));
//        Subscriber subscriber= DBManagerStub.getSubscriberByUserNameAndPassword(newUserNameAndPassword,newUserNameAndPassword);
//        assertNotNull(subscriber);
//        assertNotNull(DBManagerStub.getMainReferee(subscriber.getId()));
//        assertTrue(far.removeMainReferee(subscriber.getId()));
//        assertFalse(DBManagerStub.getSubscriberById(subscriber.getId()).isActive());
//        assertNull(DBManagerStub.getMainReferee(subscriber.getId()));
//    }
//
//    @Test
//    public void removeLineReferee() {
//        //check if referee is null
//        assertFalse(far.removeLineReferee(220));
//
//
//        //check if everything is ok
//        String newUserNameAndPassword = "check3";
//        assertTrue(far.createLineReferee(newUserNameAndPassword,newUserNameAndPassword,name,Certification.BASIC));
//        Subscriber subscriber= DBManagerStub.getSubscriberByUserNameAndPassword(newUserNameAndPassword,newUserNameAndPassword);
//        assertNotNull(subscriber);
//        assertNotNull(DBManagerStub.getLineReferee(subscriber.getId()));
//       // subscriber.makeLineRefereeActive(Certification.BASIC);
//        assertTrue(far.removeLineReferee(subscriber.getId()));
//        assertFalse(DBManagerStub.getSubscriberById(subscriber.getId()).isActive());
//        assertNull(DBManagerStub.getLineReferee(subscriber.getId()));
//    }
//
//    @Test
//    public void setLeagueMainReferees() {
//       // far.initializeLeague(LeagueLevel.NationalLeague,name,gameSchedulerPolicy,scorePolicy);
//       // League league = DBManagerStub.getLeague(1);
//        League league = new League(LeagueLevel.NationalLeague, name, gameSchedulerPolicy,scorePolicy);
//        //check if league is null
//        assertFalse(far.setLeagueMainReferees(200,5,referees));
//
//        //check if year is logical
//        assertFalse(far.setLeagueMainReferees(league.getLid(),-1,referees));
//
//        //check if referees is null
//        assertFalse(far.setLeagueMainReferees(league.getLid(),5,null));
//
//        //check if everything is OK
//        String anotherName="Tony";
//        Subscriber subscriberMainReferee = new Subscriber(anotherName,anotherName,anotherName);
//        subscriberMainReferee.makeMainRefereeActive(Certification.BASIC);
//        Referee mainReferee = subscriberMainReferee.getMainReferee();
//        referees.add(mainReferee.getSid());
//        Subscriber subscriberOwner = new Subscriber(name,name,name);
//        subscriberOwner.makeOwnerActive();
//        Owner owner=subscriberOwner.getOwner();
//        Team team1 = new Team("team1",owner.getSid());
//        Team team2 = new Team("team2", owner.getSid());
//        int [] teams = {team1.getTid(),team2.getTid()};
//        league.startNewSeason(5,teams,gameSchedulerPolicy,scorePolicy);
//        assertTrue(far.setLeagueMainReferees(league.getLid(),5,referees));
//        Season season= DBManagerStub.getSeason(league.getLid(),5);
//        assertEquals(referees, season.getMainReferees());
//    }
//
//    @Test
//    public void setLeagueLineReferees() {
//        League league = new League(LeagueLevel.NationalLeague, name, gameSchedulerPolicy,scorePolicy);
//        //far.initializeLeague(LeagueLevel.NationalLeague,name,gameSchedulerPolicy,scorePolicy);
//       // League league = DBManagerStub.getLeague(1);
//        //check if league is null
//        assertFalse(far.setLeagueLineReferees(200,5,referees));
//
//        //check if year is logical
//        assertFalse(far.setLeagueLineReferees(league.getLid(),-1,referees));
//
//        //check if referees is null
//        assertFalse(far.setLeagueLineReferees(league.getLid(),5,null));
//
//        //check if everything is OK
//        String anotherName="Tony";
//        Subscriber subscriberLineReferee = new Subscriber(anotherName,anotherName,anotherName);
//        subscriberLineReferee.makeMainRefereeActive(Certification.BASIC);
//        Referee lineReferee = subscriberLineReferee.getMainReferee();
//        referees.add(lineReferee.getSid());
//        Subscriber subscriberOwner = new Subscriber(name,name,name);
//        subscriberOwner.makeOwnerActive();
//        Owner owner=subscriberOwner.getOwner();
//        Team team1 = new Team("team1",owner.getSid());
//        Team team2 = new Team("team2", owner.getSid());
//        int [] teams = {team1.getTid(),team2.getTid()};
//        league.startNewSeason(5,teams,gameSchedulerPolicy,scorePolicy);
//        assertTrue(far.setLeagueLineReferees(league.getLid(),5,referees));
//        Season season= DBManagerStub.getSeason(league.getLid(),5);
//        assertEquals(referees, season.getLineReferees());
//    }
//
//
//    @Test
//    public void setScorePolicyForSeason() {
//        League league = new League(LeagueLevel.NationalLeague, name, gameSchedulerPolicy,scorePolicy);
//        Subscriber subscriberOwner = new Subscriber(name,name,name);
//        subscriberOwner.makeOwnerActive();
//        Owner owner=subscriberOwner.getOwner();
//        Team team1 = new Team("team1",owner.getSid());
//        Team team2 = new Team("team2", owner.getSid());
//        int [] teams = {team1.getTid(),team2.getTid()};
//        league.startNewSeason(5,teams,gameSchedulerPolicy,scorePolicy);
//        // far.initializeLeague(LeagueLevel.NationalLeague,name,gameSchedulerPolicy,scorePolicy);
//       // League league = DBManagerStub.getLeague(1);
//        int year=5;
//        ScorePolicy scorePolicy = new ScorePolicyA();
//
//        //check if league is null
//        assertFalse(far.setScorePolicyForSeason(220,year,scorePolicy));
//
//        //check if year is not logical
//        assertFalse(far.setScorePolicyForSeason(league.getLid(),-1,scorePolicy));
//
//        //check if scorePolicy is null
//        assertFalse(far.setScorePolicyForSeason(league.getLid(),year,null));
//
//        //check if everything is OK
//        assertTrue(far.setScorePolicyForSeason(league.getLid(),year,scorePolicy));
//        Season season= DBManagerStub.getSeason(league.getLid(),year);
//        assertEquals(scorePolicy, season.getScorePolicy());
//    }
//
//    @Test
//    public void setLeagueGameSchedulerPolicy() {
//        League league = new League(LeagueLevel.NationalLeague, name, gameSchedulerPolicy,scorePolicy);
//        Subscriber subscriberOwner = new Subscriber(name,name,name);
//        subscriberOwner.makeOwnerActive();
//        Owner owner=subscriberOwner.getOwner();
//        Team team1 = new Team("team1",owner.getSid());
//        Team team2 = new Team("team2", owner.getSid());
//        int [] teams = {team1.getTid(),team2.getTid()};
//        league.startNewSeason(5,teams,gameSchedulerPolicy,scorePolicy);
//        //far.initializeLeague(LeagueLevel.NationalLeague,name,gameSchedulerPolicy,scorePolicy);
//        //League league = DBManagerStub.getLeague(1);
//        int year=5;
//        ScorePolicy scorePolicy = new ScorePolicyA();
//
//        //check if league is null
//        assertFalse(far.setLeagueGameSchedulerPolicy(225,year,gameSchedulerPolicy));
//
//        //check if year is not logical
//        assertFalse(far.setLeagueGameSchedulerPolicy(league.getLid(),-1,gameSchedulerPolicy));
//
//        //check if gameSchedulerPolicy is null
//        assertFalse(far.setLeagueGameSchedulerPolicy(league.getLid(),year,null));
//
//        //check if everything is OK
//        assertTrue(far.setLeagueGameSchedulerPolicy(league.getLid(), year,gameSchedulerPolicy));
//        Season season= DBManagerStub.getSeason(league.getLid(),year);
//        assertEquals(gameSchedulerPolicy, season.getGameSchedulerPolicy());
//    }
//
//    @Test
//    public void activateGameSchedulePolicyForLeague() {
//        League league = new League(LeagueLevel.NationalLeague, name, gameSchedulerPolicy,scorePolicy);
//        Subscriber subscriberOwner = new Subscriber(name,name,name);
//        subscriberOwner.makeOwnerActive();
//        Owner owner=subscriberOwner.getOwner();
//        Team team1 = new Team("team1",owner.getSid());
//        Team team2 = new Team("team2", owner.getSid());
//        int [] teams = {team1.getTid(),team2.getTid()};
//        league.startNewSeason(5,teams,gameSchedulerPolicy,scorePolicy);
//        //far.initializeLeague(LeagueLevel.NationalLeague,name,gameSchedulerPolicy,scorePolicy);
//        //League league = DBManagerStub.getLeague(1);
//        int year=5;
//        ScorePolicy scorePolicy = new ScorePolicyA();
//
//        //check if league is null
//        assertFalse(far.activateGameSchedulePolicyForLeague(year,230));
//
//        //check if year is not logical
//        assertFalse(far.activateGameSchedulePolicyForLeague(-1,league.getLid()));
//
//        //check if everything is OK
//        assertTrue(far.activateGameSchedulePolicyForLeague(year,league.getLid()));
//        Season season= DBManagerStub.getSeason(league.getLid(),year);
//        assertTrue(season.getMatches().isEmpty());
//    }
//
//    @Test
//    public void getNegativeBalanceTeams() {
//        int year=5;
//
//        //in case budgetControl is empty
//        assertTrue(far.getNegativeBalanceTeams().isEmpty());
//
//        //in case budgetControl is not empty
//        Subscriber subscriberOwner = new Subscriber(name,name,name);
//        subscriberOwner.makeOwnerActive();
//        Owner owner=subscriberOwner.getOwner();
//        Team team = new Team("check",owner.getSid());
//        TeamBySeason teamBySeason = new TeamBySeason(team.getTid(),year);
//        teamBySeason.incrementMatchesIncome(1,100);
//        teamBySeason.incrementMatchesOutcome(1,200);
//        DBManagerStub.getBudgetControl().updateTeamFinance(team.getTid(),year);
//        assertEquals(new Integer(team.getTid()),far.getNegativeBalanceTeams().iterator().next());
//    }
//
//    @Test
//    public void checkTeamsStatus() {
//        Subscriber subscriberOwner = new Subscriber(name,name,name);
//        subscriberOwner.makeOwnerActive();
//        Owner owner=subscriberOwner.getOwner();
//        Team team1=new Team("team1",owner.getSid());
//        Team team2=new Team("team2",owner.getSid());
//        Team[] teams = {team1,team2};
//
//        //in case that one of the teams is close
//        team1.setClosedPermanently(true);
//        assertFalse(far.checkTeamsStatus(teams));
//
//        //in case both of teams are open
//        team1.setClosedPermanently(false);
//        assertTrue(far.checkTeamsStatus(teams));
//    }
//
//    @Test
//    public void handleRegistrationRequest() {
//        //check if registrationRequest is null
//        assertFalse(far.handleRegistrationRequest(null, true));
//
//        //check if approved is false
//        Subscriber subscriberLineReferee = new Subscriber(name,name,name);
//        RegistrationRequest registrationRequestLineReferee = new LineRefereeRequest(subscriberLineReferee, Certification.BASIC);
//
//        assertFalse(far.handleRegistrationRequest(registrationRequestLineReferee,false));
//
//        //check if it's TeamRequest
//        Subscriber subscriberOwner = new Subscriber(name,name,name);
//        subscriberOwner.makeOwnerActive();
//        Owner owner=subscriberOwner.getOwner();
//        Subscriber subscriber1 = new Subscriber(name,name,name);
//        RegistrationRequest registrationRequestTeam = new TeamRequest("MacabiTelAviv",owner.getSid());
//        assertTrue(far.handleRegistrationRequest(registrationRequestTeam,true));
//
//        //check if it's MainRefereeRequest
//        assertTrue(far.handleRegistrationRequest(registrationRequestLineReferee,true));
//
//        //check if it's LineRefereeRequest
//        Subscriber subscriberMainReferee = new Subscriber(name, name, name);
//        RegistrationRequest registrationRequestMainReferee = new MainRefereeRequest(subscriberMainReferee,Certification.BASIC);
//        assertTrue(far.handleRegistrationRequest(registrationRequestMainReferee,true));
//    }
//
//    @Test
//    public void deleteFarFromDB() {
//        Subscriber subscriber = new Subscriber(name, name,name);
//        SystemManager systemManager= new SystemManager(subscriber.getId());
//        String newName = "new name";
//        systemManager.addFar(newName,newName,newName);
//        assertTrue(far.deleteFarFromDB(subscriber.getId()+1));
//        FAR far1 = DBManagerStub.getFAR(far.getSid());
//        assertNull(far1);
//    }
//}