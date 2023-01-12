package com.spring.security.bootapp.bootappsecurity.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userinfo")
public class UserInfo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;
    private String username;
    private String password;

    
    public UserInfo() {
    }


    public UserInfo(int uid, String username, String password) {
        this.uid = uid;
        this.username = username;
        this.password = password;
    }


    public int getUid() {
        return uid;
    }


    public void setUid(int uid) {
        this.uid = uid;
    }


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "UserInfo [uid=" + uid + ", username=" + username + ", password=" + password + "]";
    }

    
    


}
