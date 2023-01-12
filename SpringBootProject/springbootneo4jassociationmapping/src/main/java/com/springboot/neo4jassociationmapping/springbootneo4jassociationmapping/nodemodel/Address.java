package com.springboot.neo4jassociationmapping.springbootneo4jassociationmapping.nodemodel;

import org.springframework.data.annotation.Id;

import org.springframework.data.neo4j.core.schema.Node;

@Node(labels = "Address")
public class Address {

    @Id
    private int id;

    private String city;

    private String pin;

    private String state;

    public Address() {
    }

    public Address(int id, String city, String pin, String state) {
        this.id = id;
        this.city = city;
        this.pin = pin;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    
}
