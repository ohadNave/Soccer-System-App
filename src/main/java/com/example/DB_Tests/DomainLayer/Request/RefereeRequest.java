package com.example.DB_Tests.DomainLayer.Request;

import com.example.DB_Tests.DomainLayer.Enums.Certification;
import com.example.DB_Tests.DomainLayer.Enums.RefereeRoll;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class RefereeRequest extends RegistrationRequest {

    @Enumerated(EnumType.STRING)
    private Certification certification;

    @Enumerated(EnumType.STRING)
    private RefereeRoll refereeRoll;

    public RefereeRequest() { }

    public void setAttributes(int subscriber_id, Certification certification , RefereeRoll refereeRoll) {
        setSubscriber_id(subscriber_id);
        this.certification = certification;
        this.refereeRoll = refereeRoll;
    }

    public Certification getCertification() {
        return certification;
    }

    public void setCertification(Certification certification) {
        this.certification = certification;
    }

    public RefereeRoll getRefereeRoll() {
        return refereeRoll;
    }

    public void setRefereeRoll(RefereeRoll refereeRoll) {
        this.refereeRoll = refereeRoll;
    }


}
