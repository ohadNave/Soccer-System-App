package com.example.demo.DataLayer;
import com.example.demo.DomainLayer.LeagueManagment.Season;
import com.example.demo.DomainLayer.Request.RegistrationRequest;
import com.example.demo.DomainLayer.Users.Subscriber;
import org.hibernate.type.ClassType;

import javax.persistence.*;
import java.sql.SQLException;
import java.util.List;


public class DaoMySQL implements Dao<Object> {

    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my_persistence_unit") ;

    @PersistenceContext
    private static EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public synchronized Object get(Class classType, int id) {
        return entityManager.find(classType, id);
    }

    @Override
    public List<Object> getAll(Class classType,String table) {
        TypedQuery<Object> query = entityManager.createQuery("SELECT C FROM " + table + " C" , classType);
        List<Object> list = query.getResultList();
        return list;
    }




    @Override
    public synchronized void save(Object o) throws SQLException {


        try {
            entityManager.getTransaction().begin();
            entityManager.persist(o);
            entityManager.getTransaction().commit();
        }
        catch (RuntimeException e) {
            entityManager.getTransaction().rollback();
            throw e;
        }

//
////        if(!entityManager.getTransaction().isActive()) {
//            entityManager.getTransaction().begin();
////        }
////        else {
//            entityManager.getTransaction().rollback();
////        }
//        entityManager.persist(o);
//        entityManager.getTransaction().commit();
    }

    @Override
    public synchronized void update(Object o) {

        try {
            entityManager.getTransaction().begin();

            entityManager.merge(o);

            entityManager.getTransaction().commit();
        }
        catch (RuntimeException e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
//
////        if(!entityManager.getTransaction().isActive()) {
//            entityManager.getTransaction().begin();
//        entityManager.merge(o);
//        entityManager.getTransaction().commit();

    }


    @Override
    public void detach(Object o) {
        try{
            entityManager.getTransaction().begin();
            entityManager.detach(o);
            entityManager.getTransaction().commit();
        }
               catch (RuntimeException e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public void delete(Object o) {
        entityManager.getTransaction().begin();
        entityManager.remove(o);
        entityManager.getTransaction().commit();
    }


    public Subscriber getSubscriber(String typed_username, String typed_pass) {
        Object subscriber = entityManager.createQuery(
                "SELECT C FROM Subscriber C WHERE C.userName LIKE : userName AND C.password LIKE : password " )
                .setParameter("userName",typed_username)
                .setParameter("password",typed_pass)
                .getSingleResult();
        return ((Subscriber) subscriber);

    }

    public Subscriber getByUserName(String existingUserName) {
        Object subscriber = entityManager.createQuery(
                "SELECT C FROM Subscriber C WHERE C.userName LIKE : userName" )
                .setParameter("userName",existingUserName)
                .getSingleResult();
        return ((Subscriber) subscriber);

    }

    public boolean checkUserName(String potentialUserName){
        boolean valid = false;
        try{
            Object subscriber = entityManager.createQuery(
                    "SELECT C FROM Subscriber C WHERE C.userName LIKE : userName" )
                    .setParameter("userName",potentialUserName)
                    .getSingleResult();
            if (subscriber != null){
                valid = false;
            }
        }
        catch (NoResultException e){
            valid = true;
        }
        return valid;
    }

    public boolean checkTeamName(String potentialTeamName){
        boolean name_is_valid = false;
        try{
            Object Team = entityManager.createQuery(
                    "SELECT C FROM Team C WHERE C.name LIKE : name" )
                    .setParameter("name",potentialTeamName)
                    .getSingleResult();
            if (Team != null){
                name_is_valid = false;
            }
        }
        catch (NoResultException e){
            name_is_valid = true;
        }
        return name_is_valid;
    }


    public Season getSeasonByYear(int league_id, int year){
        return null;
    }
}