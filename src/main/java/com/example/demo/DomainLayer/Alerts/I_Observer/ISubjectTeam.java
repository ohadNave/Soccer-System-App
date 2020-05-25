package com.example.demo.DomainLayer.Alerts.I_Observer;

import com.example.demo.DomainLayer.Alerts.Alert;

public interface ISubjectTeam {

    /**
     * Defines methods for alert managing in cases of team closing by its owner or team's private page has been updated.
     */
    public void notifyTeamPrivatePageFollowers(Alert alert);
    public void notifySystemManager(Alert alert);
    public void notifyOwner(Alert alert);
    public void notifyTeamManagers(Alert alert);

}
