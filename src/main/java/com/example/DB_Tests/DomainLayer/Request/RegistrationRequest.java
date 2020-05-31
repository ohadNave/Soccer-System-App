package com.example.DB_Tests.DomainLayer.Request;

import javax.persistence.*;

@Entity
@DiscriminatorColumn(name="REQ_TYPE")
@Table(name = "registration_request")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class RegistrationRequest {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int req_id;

    private int subscriber_id;


    public RegistrationRequest() { }

    public int getSubscriber_id() {
        return subscriber_id;
    }

    public void setSubscriber_id(int subscriber_id) {
        this.subscriber_id = subscriber_id;
    }

    public int getReq_id() {
        return req_id;
    }

    public void setReq_id(int req_id) {
        this.req_id = req_id;
    }
}
