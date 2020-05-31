package com.example.DB_Tests.DomainLayer.Alerts.I_Observer;


import com.example.DB_Tests.DomainLayer.Alerts.Alert;

/**
 * Defines methods for alert managing in cases of private page new content.
 */
public interface ISubjectPrivatePage {

    public void notifyPageFollowers(Alert alert);
}
