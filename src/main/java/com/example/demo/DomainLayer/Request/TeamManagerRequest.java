package com.example.demo.DomainLayer.Request;

import com.example.demo.DomainLayer.Users.Subscriber;

import javax.persistence.Entity;

@Entity
public class TeamManagerRequest extends RegistrationRequest {

    public void setAttributes(int subscriber_id) {
        setSubscriber_id(subscriber_id);
    }

}
