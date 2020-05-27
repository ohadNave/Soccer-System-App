package com.example.demo.DomainLayer.Alerts;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

public abstract class Alert  {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int aid;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }
}
