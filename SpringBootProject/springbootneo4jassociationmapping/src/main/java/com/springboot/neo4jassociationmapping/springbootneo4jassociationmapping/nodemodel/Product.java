package com.springboot.neo4jassociationmapping.springbootneo4jassociationmapping.nodemodel;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;


@Node(labels = "Product")
public class Product {
    
    @Id
    private int id;

    private String name;

    private int qty;

    private double price;


    public Product() {
    }

    public Product(int id, String name, int qty, double price) {
        this.id = id;
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    
}
