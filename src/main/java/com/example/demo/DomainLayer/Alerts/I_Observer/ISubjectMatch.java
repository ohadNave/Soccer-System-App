package com.example.demo.DomainLayer.Alerts.I_Observer;

import com.example.demo.DomainLayer.Alerts.Alert;

/**
 * Defines methods for alert managing in cases of match events(new event,new match date etc'...)
 */
public interface ISubjectMatch {

    public void notifyReferees(Alert newAlert);
    public void notifyMatchFollowers(Alert newAlert);

}
