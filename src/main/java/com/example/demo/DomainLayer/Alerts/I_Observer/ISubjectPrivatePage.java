package com.example.demo.DomainLayer.Alerts.I_Observer;


import com.example.demo.DomainLayer.Alerts.Alert;

/**
 * Defines methods for alert managing in cases of private page new content.
 */
public interface ISubjectPrivatePage {

    public void notifyPageFollowers(Alert alert);
}
