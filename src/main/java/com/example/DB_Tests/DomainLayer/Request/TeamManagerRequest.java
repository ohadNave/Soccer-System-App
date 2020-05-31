package com.example.DB_Tests.DomainLayer.Request;

import javax.persistence.Entity;

@Entity
public class TeamManagerRequest extends RegistrationRequest {

    public void setAttributes(int subscriber_id) {
        setSubscriber_id(subscriber_id);
    }

}
