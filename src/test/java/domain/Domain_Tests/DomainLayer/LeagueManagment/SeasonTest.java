package domain.Domain_Tests.DomainLayer.LeagueManagment;

import org.junit.Test;

import java.util.HashSet;

//package DomainLayer.LeagueManagment;
//
//import DomainLayer.Enums.Certification;
//import DomainLayer.Users.*;
//import org.junit.Test;
//
//import java.time.LocalTime;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.HashSet;
//
//import static org.junit.Assert.*;
//
public class SeasonTest {
    String userName = "user";
    String password = "1234";
    String name = "Shlomi";
    int year = 2020;
    HashSet<Integer> referees = new HashSet<>();
    HashSet<Integer> matches = new HashSet<>();
    @Test
    public void initializeTeams() {

    }
}
//        Subscriber subscriberOwner = new Subscriber(userName,password,name);
//        subscriberOwner.makeOwnerActive();
//        Owner owner=subscriberOwner.getOwner();
//        Team team1 = new Team("check", owner.getSid());
//        Team team2 = new Team("check2", owner.getSid());
//        TeamBySeason teamBySeason=new TeamBySeason(team1.getTid(),year);
//        ScorePolicy scorePolicy = new ScorePolicyA();
//        Subscriber subscriberReferee = new Subscriber(userName,password,name);
//        Referee referee=subscriberReferee.getLineReferre();
//        GameSchedulerPolicy gameSchedulerPolicy = new GameSchedulerPolicy() {
//            @Override
//            public HashSet<Integer> activate(HashMap<Integer, Integer> teamStatsHashMap) {
//                return new HashSet<>();
//            }
//        };
//        Season season = new Season(year,gameSchedulerPolicy,scorePolicy);
//        assertFalse(season.initializeTeams(null));
//
//        //check if everything is OK
//        int [] teams2 = {team1.getTid(), team2.getTid()};
//        assertTrue(season.initializeTeams(teams2));
//    }
//
//    @Test
//    public void activateGameSchedulePolicy() {
//        ScorePolicy scorePolicy = new ScorePolicyA();
//        GameSchedulerPolicy gameSchedulerPolicy = new GameSchedulerPolicy() {
//            @Override
//            public HashSet<Integer> activate(HashMap<Integer, Integer> teamStatsHashMap) {
//                return new HashSet<>();
//            }
//        };
//        Season season = new Season(year,gameSchedulerPolicy,scorePolicy);
//        //check when teamLeague is null
//        season.setTeamsLeague(null);
//        assertFalse(season.activateGameSchedulePolicy());
//
//        //check when gameSchedulerPolicy is null
//        HashMap<Integer, Integer> teamsLeague = new HashMap<>();
//        season.setTeamsLeague(teamsLeague);
//        Season seasonNull = new Season(2,null, scorePolicy);
//        assertFalse(seasonNull.activateGameSchedulePolicy());
//
//
//        //check if everything is ok
//        assertTrue(season.activateGameSchedulePolicy());
//        assertTrue(season.getMatches().isEmpty());
//
//    }
//
//    @Test
//    public void getGameSchedulerPolicy() {
//        ScorePolicy scorePolicy = new ScorePolicyA();
//        GameSchedulerPolicy gameSchedulerPolicy = new GameSchedulerPolicy() {
//            @Override
//            public HashSet<Integer> activate(HashMap<Integer, Integer> teamStatsHashMap) {
//                return new HashSet<>();
//            }
//        };
//        Season season = new Season(year,gameSchedulerPolicy,scorePolicy);
//        assertEquals(gameSchedulerPolicy,season.getGameSchedulerPolicy());
//
//    }
//
//    @Test
//    public void getMainReferees() {
//        ScorePolicy scorePolicy = new ScorePolicyA();
//        Subscriber subscriberMainReferee = new Subscriber(userName,password,name);
//        subscriberMainReferee.makeMainRefereeActive(Certification.BASIC);
//        Referee mainReferee=subscriberMainReferee.getMainReferee();
//        referees.add(mainReferee.getSid());
//        GameSchedulerPolicy gameSchedulerPolicy = new GameSchedulerPolicy() {
//            @Override
//            public HashSet<Integer> activate(HashMap<Integer, Integer> teamStatsHashMap) {
//                return new HashSet<>();
//            }
//        };
//        Season season = new Season(year,gameSchedulerPolicy,scorePolicy);
//        HashSet<Integer> mainReferees = new HashSet<>();
//        mainReferees.add(mainReferee.getSid());
//        season.setMainReferees(mainReferees);
//        assertEquals(referees,season.getMainReferees());
//    }
//
//    @Test
//    public void setMainReferees() {
//        ScorePolicy scorePolicy = new ScorePolicyA();
//        Subscriber subscriberMainReferee = new Subscriber(userName,password,name);
//        subscriberMainReferee.makeMainRefereeActive(Certification.BASIC);
//        Referee mainReferee=subscriberMainReferee.getMainReferee();
//        GameSchedulerPolicy gameSchedulerPolicy = new GameSchedulerPolicy() {
//            @Override
//            public HashSet<Integer> activate(HashMap<Integer, Integer> teamStatsHashMap) {
//                return new HashSet<>();
//            }
//        };
//        Season season = new Season(year,gameSchedulerPolicy,scorePolicy);
//        HashSet<Integer> mainReferees = new HashSet<>();
//        referees.add(mainReferee.getSid());
//        mainReferees.add(mainReferee.getSid());
//        season.setMainReferees(mainReferees);
//        assertEquals(referees,season.getMainReferees());
//    }
//
//    @Test
//    public void getLineReferees() {
//        ScorePolicy scorePolicy = new ScorePolicyA();
//        Subscriber subscriberLineReferee = new Subscriber(userName,password,name);
//        subscriberLineReferee.makeLineRefereeActive(Certification.BASIC);
//        Referee lineReferee=subscriberLineReferee.getLineReferre();
//        GameSchedulerPolicy gameSchedulerPolicy = new GameSchedulerPolicy() {
//            @Override
//            public HashSet<Integer> activate(HashMap<Integer, Integer> teamStatsHashMap) {
//                return new HashSet<>();
//            }
//        };
//        Season season = new Season(year,gameSchedulerPolicy,scorePolicy);
//        HashSet<Integer> lineReferees = new HashSet<>();
//        lineReferees.add(lineReferee.getSid());
//        referees.add(lineReferee.getSid());
//        season.setLineReferees(lineReferees);
//        assertEquals(referees,season.getLineReferees());
//    }
//
//    @Test
//    public void setLineReferees() {
//        ScorePolicy scorePolicy = new ScorePolicyA();
//        Subscriber subscriberLineReferee = new Subscriber(userName,password,name);
//        subscriberLineReferee.makeLineRefereeActive(Certification.BASIC);
//        Referee lineReferee=subscriberLineReferee.getLineReferre();
//        GameSchedulerPolicy gameSchedulerPolicy = new GameSchedulerPolicy() {
//            @Override
//            public HashSet<Integer> activate(HashMap<Integer, Integer> teamStatsHashMap) {
//                return new HashSet<>();
//            }
//        };
//        Season season = new Season(year,gameSchedulerPolicy,scorePolicy);
//        HashSet<Integer> lineReferees = new HashSet<>();
//        lineReferees.add(lineReferee.getSid());
//        referees.add(lineReferee.getSid());
//        season.setLineReferees(lineReferees);
//        assertEquals(referees,season.getLineReferees());
//    }
//
//    @Test
//    public void setGameSchedulerPolicy() {
//        ScorePolicy scorePolicy = new ScorePolicyA();
//        GameSchedulerPolicy gameSchedulerPolicy = new GameSchedulerPolicy() {
//            @Override
//            public HashSet<Integer> activate(HashMap<Integer, Integer> teamStatsHashMap) {
//                return new HashSet<>();
//            }
//        };
//        Season season = new Season(year,gameSchedulerPolicy,scorePolicy);
//        GameSchedulerPolicy gameSchedulerPolicy1 = new GameSchedulerPolicy() {
//            @Override
//            public HashSet<Integer> activate(HashMap<Integer, Integer> teamStatsHashMap) {
//                return null;
//            }
//        };
//        season.setGameSchedulerPolicy(gameSchedulerPolicy1);
//        assertEquals(gameSchedulerPolicy1,season.getGameSchedulerPolicy());
//
//    }
//
//    @Test
//    public void getScorePolicy() {
//        ScorePolicy scorePolicy = new ScorePolicyA();
//        GameSchedulerPolicy gameSchedulerPolicy = new GameSchedulerPolicy() {
//            @Override
//            public HashSet<Integer> activate(HashMap<Integer, Integer> teamStatsHashMap) {
//                return new HashSet<>();
//            }
//        };
//        Season season = new Season(year,gameSchedulerPolicy,scorePolicy);
//        assertEquals(scorePolicy,season.getScorePolicy());
//
//    }
//
//    @Test
//    public void setScorePolicy() {
//        ScorePolicy scorePolicy = new ScorePolicyA();
//        GameSchedulerPolicy gameSchedulerPolicy = new GameSchedulerPolicy() {
//            @Override
//            public HashSet<Integer> activate(HashMap<Integer, Integer> teamStatsHashMap) {
//                return new HashSet<>();
//            }
//        };
//        Season season = new Season(year,gameSchedulerPolicy,scorePolicy);
//        ScorePolicy scorePolicy1=new ScorePolicyB();
//        season.setScorePolicy(scorePolicy1);
//        assertEquals(scorePolicy1,season.getScorePolicy());
//
//    }
//
//    @Test
//    public void getYear() {
//        ScorePolicy scorePolicy = new ScorePolicyA();
//        GameSchedulerPolicy gameSchedulerPolicy = new GameSchedulerPolicy() {
//            @Override
//            public HashSet<Integer> activate(HashMap<Integer, Integer> teamStatsHashMap) {
//                return new HashSet<>();
//            }
//        };
//        Season season = new Season(year,gameSchedulerPolicy,scorePolicy);
//        assertEquals(year,season.getYear());
//
//    }
//
//    @Test
//    public void setYear() {
//        ScorePolicy scorePolicy = new ScorePolicyA();
//        GameSchedulerPolicy gameSchedulerPolicy = new GameSchedulerPolicy() {
//            @Override
//            public HashSet<Integer> activate(HashMap<Integer, Integer> teamStatsHashMap) {
//                return new HashSet<>();
//            }
//        };
//        Season season = new Season(year,gameSchedulerPolicy,scorePolicy);
//        int newYear= 4;
//        season.setYear(newYear);
//        assertEquals(newYear,season.getYear());
//
//    }
//
//    @Test
//    public void setTeamsLeague() {
//        ScorePolicy scorePolicy = new ScorePolicyA();
//        GameSchedulerPolicy gameSchedulerPolicy = new GameSchedulerPolicy() {
//            @Override
//            public HashSet<Integer> activate(HashMap<Integer, Integer> teamStatsHashMap) {
//                return new HashSet<>();
//            }
//        };
//        Season season = new Season(year,gameSchedulerPolicy,scorePolicy);
//        HashMap<Integer,Integer> teamsLeague = new HashMap<>();
//        season.setTeamsLeague(teamsLeague);
//        assertEquals(teamsLeague,season.getTeamsLeague());
//    }
//
//    @Test
//    public void setMatches() {
//        Subscriber subscriberOwner = new Subscriber(userName,password,name);
//        subscriberOwner.makeOwnerActive();
//        Owner owner=subscriberOwner.getOwner();
//        Team team1 = new Team("check", owner.getSid());
//        Team team2 = new Team("check2", owner.getSid());
//        ScorePolicy scorePolicy = new ScorePolicyA();
//        Subscriber subscriberLineReferee = new Subscriber(userName,password,name);
//        subscriberLineReferee.makeLineRefereeActive(Certification.BASIC);
//        Referee lineReferee=subscriberLineReferee.getLineReferre();
//        Subscriber subscriberMainReferee = new Subscriber(userName,password,name);
//        subscriberMainReferee.makeMainRefereeActive(Certification.BASIC);
//        Referee mainReferee=subscriberMainReferee.getMainReferee();
//        GameSchedulerPolicy gameSchedulerPolicy = new GameSchedulerPolicy() {
//            @Override
//            public HashSet<Integer> activate(HashMap<Integer, Integer> teamStatsHashMap) {
//                return new HashSet<>();
//            }
//        };
//        Season season = new Season(year,gameSchedulerPolicy,scorePolicy);
//        LocalTime localTime = LocalTime.of(2,4);
//        Field field = new Field("check");
//        Match match = new Match(new Date(),localTime,field.getFid(),team1.getTid(),team2.getTid(),mainReferee.getSid(),lineReferee.getSid(),lineReferee.getSid());
//        matches.add(match.getMatchId());
//        season.setMatches(matches);
//        assertEquals(matches, season.getMatches());
//
//    }
//
//    @Test
//    public void getMatches() {
//        ScorePolicy scorePolicy = new ScorePolicyA();
//        GameSchedulerPolicy gameSchedulerPolicy = new GameSchedulerPolicy() {
//            @Override
//            public HashSet<Integer> activate(HashMap<Integer, Integer> teamStatsHashMap) {
//                return new HashSet<>();
//            }
//        };
//        Season season = new Season(year,gameSchedulerPolicy,scorePolicy);
//        assertEquals(matches,season.getMatches());
//
//    }
//}