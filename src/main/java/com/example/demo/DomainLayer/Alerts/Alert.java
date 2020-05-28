package com.example.demo.DomainLayer.Alerts;

import com.example.demo.DomainLayer.Users.Referee;

import javax.persistence.*;
import java.util.Set;

@Entity
@DiscriminatorColumn(name="A_TYPE")
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
