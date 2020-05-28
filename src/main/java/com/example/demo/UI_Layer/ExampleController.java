package com.example.demo.UI_Layer;




import com.example.demo.DomainLayer.LeagueManagment.Game;
import com.example.demo.DomainLayer.LeagueManagment.League;
import com.example.demo.ServiceLayer.FARController;
import com.example.demo.ServiceLayer.GuestController;
import com.example.demo.ServiceLayer.OwnerController;
import com.example.demo.ServiceLayer.RefereeController;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**-
 * ExampleController
 *
 * @author danielpadua
 *
 */
@RestController
public class ExampleController {
//    ******ADD SCORE POLICY*******
    RefereeController refereeController = new RefereeController();
    @RequestMapping("/addScorePolicy/getLeagueNames")
    public String[] getLeaguesNames_scorePolicy(){
     //   System.out.println("i'm in java function");
        FARController farController = new FARController();
        return farController.getLeagues();
    }

//    @RequestMapping("/addScorePolicy/getPossibleYears/{leagueID}")
//    public HashSet<Integer> getPossibleYears_scorePolicy(@PathVariable String leagueID){
//        System.out.println("the name i get is "+leagueID);
//        FarGetLeaguesController farGetLeaguesController=new FarGetLeaguesController();
//        return farGetLeaguesController.getPossibleYears(leagueID);
//    }

    @RequestMapping(method = RequestMethod.POST, value = "/addScorePolicy")
    public boolean setScorePolicy(@RequestBody setScoreParameters param){
        FARController farController = new FARController();
        return farController.setLeagueScorePolicy(param.getSid(),param.getLeagueID(),param.getScorePolicy());
    }


//    ******ADD PLACEMENT POLICY*******
    @RequestMapping("/addPlacementPolicy/getLeagueNames")
    public String[] getLeaguesNames_placementPolicy(){
        //   System.out.println("i'm in java function");
        FARController farController = new FARController();
        return farController.getLeagues();
    }

//    @RequestMapping("/addPlacementPolicy/getPossibleYears/{leagueName}")
//    public HashSet<Integer> getPossibleYears_placementPolicy(@PathVariable String leagueName){
////        System.out.println("the name i get is "+leagueName);
//        FarGetLeaguesController farGetLeaguesController=new FarGetLeaguesController();
//        return farGetLeaguesController.getPossibleYears(leagueName);
//    }

    @RequestMapping(method = RequestMethod.POST, value = "/addPlacementPolicy")
    public boolean setPlacementPolicy(@RequestBody setPlacementParameters param){
        FARController farController = new FARController();
        return farController.setLeagueGameSchedulerPolicy(param.getSid(),param.getLeagueID(),param.getPlacementPolicy());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/applyPlacementPolicy")
    public boolean applyPlacementPolicy(@RequestBody setPlacementParameters param){
        FARController farController = new FARController();
        return farController.activeGameSchedulerPolicy(param.getSid(),param.getLeagueID());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public String[] login(@RequestBody loginParameters param){
//        System.out.println("my name is" + param.getUsername());
//        System.out.println("my pass is" + param.getPassword());
       GuestController login= new GuestController();
        return login.logIn(param.getUsername(),param.getPassword());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/owner/openNewTeam")
    public boolean openTeamRequest(@RequestBody openNewTeanParameters param){
       OwnerController teamRequestController = new OwnerController();
        System.out.println(param.getTeamName()+" "+param.getSid());
        return teamRequestController.sendTeamRequest(param.getTeamName(),param.getSid());
    }


//    *****ALERTS******
    @RequestMapping("owner/getAlerts/{sid}")
    public Queue<String> getOwnerAlerts(@PathVariable String sid){
//        System.out.println(sid);
       OwnerController getOwnerAlertsController=new OwnerController ();
        return getOwnerAlertsController.getAlerts(sid);
    }
    @RequestMapping("mainReferee/getAlerts/{sid}")
    public Queue<String>  getMainRefereeAlerts(@PathVariable String sid){
        return refereeController.getAlerts(sid);
    }

    @RequestMapping("lineReferee/getAlerts/{sid}")
    public Queue<String>  getLineRefereeAlerts(@PathVariable String sid){
        return refereeController.getAlerts(sid);
    }


//    *****ADD EVENT******
    @RequestMapping("/getListOfGames/{subscriberID}")
    public String []  getPossibleGames(@PathVariable String subscriberID){
//     System.out.println("the name i get is "+leagueName);
//       RefereeController refereeController = new RefereeController();
        return refereeController.getListOfGames(subscriberID);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addEvent")
    public boolean addEvent(@RequestBody addEventParameters param){
     //   RefereeController refereeController = new RefereeController();
        return refereeController.addEvent(param.getSid(),param.getMatchId(), param.getMinuteInGame(),param.getDescription(),param.getEventType());
    }


//    *****MAKE REPORT****
    @RequestMapping("/getTeamsInGame/{matchID}")
    public String[] getTeamsInGame(@PathVariable String matchID){
    //     System.out.println("the name i get is "+leagueName);
      //  RefereeController refereeController = new RefereeController();
        return refereeController.getTeamsNames(matchID);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/makeReport")
    public boolean makeReport(@RequestBody makeReportParameters param){
       // RefereeController refereeController = new RefereeController();
        return refereeController.makeReport(param.getSid(),param.getMid(),param.getWinnerTeamID(),param.getLoosingTeamID(),param.getScoreWinnerTeam(),param.getScoreLoosingTeam());
    }

//    ****CHECK TEAM REQUEST*****
    @RequestMapping("/nextTeamRequest")
    public String[] getNextTeamRequest(){
        //   System.out.println("i'm in java function");
        FARController farController = new FARController();
        return farController.getTeamRequest();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/approveRequest")
    public boolean approveTeamRequest(@RequestBody teamRequestParameters param){
        FARController farController = new FARController();
        return farController.handleRegistrationRequest(param.getSid(),param.getRegID(),param.getBooleanVar());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/rejectRequest")
    public boolean rejectTeamRequest(@RequestBody teamRequestParameters param){
        FARController farController = new FARController();
        return farController.handleRegistrationRequest(param.getSid(),param.getRegID(),param.getBooleanVar());
    }

}
