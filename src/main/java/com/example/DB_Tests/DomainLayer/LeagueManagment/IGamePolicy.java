package com.example.DB_Tests.DomainLayer.LeagueManagment;

public interface IGamePolicy {

    boolean activate(Season season);
    String getDescription();
}
