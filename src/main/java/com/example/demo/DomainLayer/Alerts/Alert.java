package com.example.demo.DomainLayer.Alerts;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public abstract class Alert  {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int aid;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }
}
