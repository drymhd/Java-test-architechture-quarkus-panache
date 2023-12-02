package com.drymhd.rest.dtos;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class User extends PanacheEntity {
    public String name;
    public static User findByName(String name){
        return find("name", name).firstResult();
    }

    public static void deleteStefs(){
        delete("name", "Stef");
    }
}