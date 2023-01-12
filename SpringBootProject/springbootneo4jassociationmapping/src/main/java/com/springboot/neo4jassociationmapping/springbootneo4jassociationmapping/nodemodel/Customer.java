package com.springboot.neo4jassociationmapping.springbootneo4jassociationmapping.nodemodel;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.Relationship.Direction;

@Node(labels = "Customer")
public class Customer {
    
    @Id
    private int id;

    private String name;

    @Relationship(type = "Leav_IN",direction = Direction.OUTGOING)
    private List<Address> address;

    @Relationship(type = "Purchase",direction = Direction.OUTGOING)
    private List<Product> products;



    

    public Customer(int id, String name,List<Address>address, List<Product> products) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.products = products;
    }

    public Customer() {
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

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    

}
