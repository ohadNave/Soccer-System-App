package com.example.demo.DomainLayer.Request;

import com.example.demo.DomainLayer.Enums.Certification;
import com.example.demo.DomainLayer.Enums.CoachRole;
import com.example.demo.DomainLayer.Users.Subscriber;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class CoachRequest extends RegistrationRequest {

    @Enumerated(EnumType.STRING)
    private CoachRole role;

    @Enumerated(EnumType.STRING)
    private Certification certification;

    public CoachRequest() { }

    public void setAttributes(int subscriber_id, CoachRole role, Certification certification){
        setSubscriber_id(subscriber_id);
        this.role = role;
        this.certification = certification;
    }

    public CoachRole getRole() {
        return role;
    }

    public Certification getCertification() {
        return certification;
    }

    public void setRole(CoachRole role) {
        this.role = role;
    }

    public void setCertification(Certification certification) {
        this.certification = certification;
    }
}
