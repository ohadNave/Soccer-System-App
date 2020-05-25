package com.example.demo.DomainLayer.Request;

import com.example.demo.DomainLayer.Enums.PlayerRole;
import com.example.demo.DomainLayer.Users.Subscriber;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Entity
public class PlayerRequest extends RegistrationRequest {

    @Enumerated(EnumType.STRING)
    private PlayerRole role;
    private LocalDate dateOfBirth;


    public void setAttributes(int subscriber_id, PlayerRole role, LocalDate dateOfBirth) {
        setSubscriber_id(subscriber_id);
        this.role = role;
        this.dateOfBirth = dateOfBirth;
    }

    public PlayerRole getRole() {
        return role;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setRole(PlayerRole role) {
        this.role = role;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
