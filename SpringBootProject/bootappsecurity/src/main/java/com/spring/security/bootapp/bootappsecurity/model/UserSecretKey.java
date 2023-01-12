package com.spring.security.bootapp.bootappsecurity.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "secretkey")
public class UserSecretKey {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String keys;

    



    public UserSecretKey(int id, String username, String keys) {
        this.id = id;
        this.username = username;
        this.keys = keys;
    }
    public UserSecretKey() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getKeys() {
        return keys;
    }
    public void setKeys(String keys) {
        this.keys = keys;
    }
    @Override
    public String toString() {
        return "UserSecretKey [id=" + id + ", username=" + username + ", key=" + keys + "]";
    }


    

}
