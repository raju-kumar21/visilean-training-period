package com.spring.mongodb.embadded.springmongodbembadded.model;

public class Product {

    private String name;
    private int quantity;
    private int price;
    public Product() {
    }
    public Product(String name, int quantity, int price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "Product [name=" + name + ", quantity=" + quantity + ", price=" + price + "]";
    }

        

}
