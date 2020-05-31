package com.example.DB_Tests.DomainLayer.Alerts.I_Observer;

import com.example.DB_Tests.DomainLayer.Alerts.Alert;

/**
 * Defines methods for alert managing in cases of match events(new event,new match date etc'...)
 */
public interface ISubjectMatch {

    public void notifyReferees(Alert newAlert);
    public void notifyMatchFollowers(Alert newAlert);

}
