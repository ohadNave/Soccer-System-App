package com.example.demo.DataLayer;
import org.springframework.stereotype.Repository;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@Repository
public interface Dao <T> extends Serializable {


    Object get(Class entityClass, int id);

    List<Object> getAll(Class classType, String table);

    void save(T t) throws SQLException;

    void update(T t);

    void detach(Object o);

    void delete(T t);




    }

