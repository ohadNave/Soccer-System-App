package com.example.demo.DomainLayer.LeagueManagment;

import com.example.demo.DomainLayer.DBManager;
import com.example.demo.DomainLayer.Enums.ComplainStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Complain implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public int cid ;

    private Date date;

    @Enumerated(EnumType.ORDINAL)
    private ComplainStatus complainStatus;
    private String content;
    private String systemManagerRespond;

    public void setAttributes(Date date , String  content){
        this.date = date;
        this.content = content;
        this.complainStatus = ComplainStatus.WAITING;
    }

    /*
    getters and setters.
     */
    public int getCid() { return cid; }

    public void setCid(int cid) {
        this.cid = cid;
        DBManager.updateObject(this);
    }

    public Date getDate() { return date; }

    public void setDate(Date date) {
        this.date = date;
        DBManager.updateObject(this);
    }

    public ComplainStatus getComplainStatus() { return complainStatus; }

    public void setComplainStatus(ComplainStatus complainStatus) {
        this.complainStatus = complainStatus;
        DBManager.updateObject(this);
    }

    public String getContent() { return content; }

    public void setContent(String content) {
        this.content = content;
        DBManager.updateObject(this);

    }

    public String getSystemManagerRespond() { return systemManagerRespond; }

    public void setSystemManagerRespond(String systemManagerRespond) {
        this.systemManagerRespond = systemManagerRespond;
        DBManager.updateObject(this);
    }
}
