package com.example.demo.DomainLayer.Users;

import com.example.demo.DomainLayer.DBManager;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;

//import com.example.demo.DomainLayer.Enums.SearchFilterCategory;
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class SystemUser implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int sid;

    /**
     * after sub name edit,we need to update database with new sub name.
     */
    public boolean setName(int sid, String name) {
        if ( name != null && !name.isEmpty() && DBManager.checkUserName(name)  ){
            Subscriber tempSub = ((Subscriber) DBManager.getObject(Subscriber.class, sid));
            tempSub.setName(name);
            DBManager.updateObject(tempSub);
            return true;
        }
        return false;
    }

    /**
     * part of UC 2.5
     */
    public HashSet<Object> searchByName(String searchWord){
//        if (!searchWord.isEmpty()){
//            return DBManagerStub.searchByName(searchWord);
//        }
        return null;
    }

    /**
     * part of UC 2.5
     */
//    public HashSet<Object> searchByCategory(SearchFilterCategory category){
//            return DBManagerStub.searchByCategory(category); }

    /**
     * part of UC 2.5
     */
    public HashSet<Object> searchByKeyWords(String keyWord){
//        if (!keyWord.isEmpty()){
//            return DBManagerStub.searchByKeywords(keyWord);
//        }
        return null;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getSid() {
        return sid;
    }


    public boolean deleteDB(int sid){
//        if ( sid != -1 ){
//            DBManagerStub.deleteSub(sid);
//            return true;
//        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SystemUser)) return false;
        SystemUser that = (SystemUser) o;
        return sid == that.sid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid);
    }


}
