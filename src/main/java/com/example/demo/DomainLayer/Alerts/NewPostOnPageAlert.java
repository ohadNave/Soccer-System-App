package com.example.demo.DomainLayer.Alerts;

import com.example.demo.DomainLayer.LeagueManagment.PrivatePage;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class NewPostOnPageAlert extends Alert{

    @OneToOne
    private PrivatePage privatePage;

    private String newContent;


    public NewPostOnPageAlert() { }

    public void setAttributes(PrivatePage privatePage, String newContent) {
        this.privatePage = privatePage;
        this.newContent = newContent;
    }

    /*
    getters and setters.
     */
    public PrivatePage getPrivatePage() {
        return privatePage;
    }

    public void setPrivatePage(PrivatePage privatePage) {
        this.privatePage = privatePage;
    }

    public String getNewContent() {
        return newContent;
    }

    public void setNewContent(String newContent) {
        this.newContent = newContent;
    }

    @Override
    public String toString() {
        return "New post on page";
    }
}