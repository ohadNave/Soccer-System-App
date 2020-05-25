package com.example.demo.DomainLayer.LeagueManagment;

import javax.persistence.*;

@Entity
public class TeamManagerPremissions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int perm_id;

    @Column(columnDefinition = "boolean default false")
    private boolean addPlayerPermission;
    @Column(columnDefinition = "boolean default false")
    private boolean removePlayerPermission;
    @Column(columnDefinition = "boolean default false")
    private boolean editPlayerRolePermission;
    @Column(columnDefinition = "boolean default false")
    private boolean addCoachPermission;
    @Column(columnDefinition = "boolean default false")
    private boolean removeCoachPermission;
    @Column(columnDefinition = "boolean default false")
    private boolean editCoachRolePermission;
    @Column(columnDefinition = "boolean default false")
    private boolean addFieldPermission;
    @Column(columnDefinition = "boolean default false")
    private boolean removeFieldPermission;
    @Column(columnDefinition = "boolean default false")
    private boolean editFieldNamePermission;


    public TeamManagerPremissions(){
        this.addPlayerPermission = false;
        this.removePlayerPermission = false;
        this.editPlayerRolePermission = false;
        this.addCoachPermission = false;
        this.removeCoachPermission = false;
        this.editCoachRolePermission = false;
        this.addFieldPermission = false;
        this.removeFieldPermission = false;
        this.editFieldNamePermission = false;
    }

    public void setTeamManagerPremissions(boolean addPlayerPermission, boolean removePlayerPermission, boolean editPlayerRolePermission, boolean addCoachPermission, boolean removeCoachPermission, boolean editCoachRolePermission, boolean addFieldPermission, boolean removeFieldPermission, boolean editFieldNamePermission) {
        this.addPlayerPermission = addPlayerPermission;
        this.removePlayerPermission = removePlayerPermission;
        this.editPlayerRolePermission = editPlayerRolePermission;
        this.addCoachPermission = addCoachPermission;
        this.removeCoachPermission = removeCoachPermission;
        this.editCoachRolePermission = editCoachRolePermission;
        this.addFieldPermission = addFieldPermission;
        this.removeFieldPermission = removeFieldPermission;
        this.editFieldNamePermission = editFieldNamePermission;
    }

    public void setAddPlayerPermission(boolean addPlayerPermission) {
        this.addPlayerPermission = addPlayerPermission;
    }

    public void setRemovePlayerPermission(boolean removePlayerPermission) {
        this.removePlayerPermission = removePlayerPermission;
    }

    public void setEditPlayerRolePermission(boolean editPlayerRolePermission) {
        this.editPlayerRolePermission = editPlayerRolePermission;
    }

    public void setAddCoachPermission(boolean addCoachPermission) {
        this.addCoachPermission = addCoachPermission;
    }

    public void setRemoveCoachPermission(boolean removeCoachPermission) {
        this.removeCoachPermission = removeCoachPermission;
    }

    public void setEditCoachRolePermission(boolean editCoachRolePermission) {
        this.editCoachRolePermission = editCoachRolePermission;
    }

    public void setAddFieldPermission(boolean addFieldPermission) {
        this.addFieldPermission = addFieldPermission;
    }

    public void setRemoveFieldPermission(boolean removeFieldPermission) {
        this.removeFieldPermission = removeFieldPermission;
    }

    public void setEditFieldNamePermission(boolean editFieldNamePermission) {
        this.editFieldNamePermission = editFieldNamePermission;
    }

    public boolean AddPlayerPermission() {
        return addPlayerPermission;
    }

    public boolean RemovePlayerPermission() {
        return removePlayerPermission;
    }

    public boolean EditPlayerRolePermission() {
        return editPlayerRolePermission;
    }

    public boolean AddCoachPermission() {
        return addCoachPermission;
    }

    public boolean RemoveCoachPermission() {
        return removeCoachPermission;
    }

    public boolean EditCoachRolePermission() {
        return editCoachRolePermission;
    }

    public boolean AddFieldPermission() {
        return addFieldPermission;
    }

    public boolean RemoveFieldPermission() {
        return removeFieldPermission;
    }

    public boolean EditFieldNamePermission() {
        return editFieldNamePermission;
    }

    public int getPerm_id() {
        return perm_id;
    }

    public void setPerm_id(int perm_id) {
        this.perm_id = perm_id;
    }

    public boolean isAddPlayerPermission() {
        return addPlayerPermission;
    }

    public boolean isRemovePlayerPermission() {
        return removePlayerPermission;
    }

    public boolean isEditPlayerRolePermission() {
        return editPlayerRolePermission;
    }

    public boolean isAddCoachPermission() {
        return addCoachPermission;
    }

    public boolean isRemoveCoachPermission() {
        return removeCoachPermission;
    }

    public boolean isEditCoachRolePermission() {
        return editCoachRolePermission;
    }

    public boolean isAddFieldPermission() {
        return addFieldPermission;
    }

    public boolean isRemoveFieldPermission() {
        return removeFieldPermission;
    }

    public boolean isEditFieldNamePermission() {
        return editFieldNamePermission;
    }
}
