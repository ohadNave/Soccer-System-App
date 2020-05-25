package com.example.demo.DomainLayer.LeagueManagment;

import java.util.HashMap;
import java.util.HashSet;

public interface IGamePolicy {

    boolean activate(Season season);
    String getDescription();
}
