package com.example.demo.ServiceLayer;


import com.example.demo.DomainLayer.Enums.RefereeRoll;
import com.example.demo.DomainLayer.Users.*;

public class GuestController {

    public String[] logIn(String userName, String password){
        String[] toReturn = new String[11];
        Guest guest = new Guest();
        Subscriber subscriber = guest.Login(userName,password);
        if(subscriber!=null){
            int id = subscriber.getId();
            String idString = ""+id;
            toReturn[0]=idString;
            toReturn[1] = subscriber.getName();
            Coach coach = subscriber.getCoach();
            if(coach!=null){
                toReturn[2]="1";
            }
            else{
                toReturn[2]="0";
            }
            Fan fan = subscriber.getFan();
            if(fan!=null){
                toReturn[3]="1";
            }
            else{
                toReturn[3]="0";
            }
            FAR far = subscriber.getFar();
            if(far!=null){
                toReturn[4]="1";
            }
            else{
                toReturn[4]="0";
            }
            Referee referee = subscriber.getReferee();
            if(referee != null){
                if (referee.getRoll() == RefereeRoll.LINE_REFEREE){
                    toReturn[5]="1";
                    toReturn[6]="0";
                }
                else{
                    toReturn[5]="0";
                    toReturn[6]="1";
                }
            }
            else{
                toReturn[5]="0";
                toReturn[6]="0";
            }
            Owner owner = subscriber.getOwner();
            if(owner!=null){
                toReturn[7]="1";
            }
            else{
                toReturn[7]="0";
            }
            Player player = subscriber.getPlayer();
            if(player!=null){
                toReturn[8]="1";
            }
            else{
                toReturn[8]="0";
            }
            TeamManager teamManager = subscriber.getTeamManager();
            if(teamManager!=null){
                toReturn[9]="1";
            }
            else{
                toReturn[9]="0";
            }
             sysMan systemManager = subscriber.getSysMan();
            if(systemManager!=null){
                toReturn[10]="1";
            }
            else{
                toReturn[10]="0";
            }
        }
        else{
            for(int i=0; i<11 ; i++){
                toReturn[i]="-1";
            }
        }
        return toReturn;
    }

}
