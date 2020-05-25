package com.example.demo.ServiceLayer;


import com.example.demo.DomainLayer.Users.sysMan;

public class SystemManagerController {

    private sysMan sysMan;

    /**
     * Close team for ever button.
     */
    public boolean closeTeamPermanently(int tid){
       return this.sysMan.closeTeamPermanently(tid);
    }


    /**
     *  Remove subscriber from system.
     */
    public boolean removeSubscriber(int sid){
       return this.sysMan.removeSubscriber(sid);
    }

    /**
     * Respond user complain button.
     */
    public boolean respondToUserComplain(int cid, String respond){
        return this.sysMan.respondToUserComplain(cid,respond);
    }


}
