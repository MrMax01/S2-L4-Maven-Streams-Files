package org.example.entities;

import java.util.Random;

public class Product {
    private long id;
    private String name;
    private String category;
    private double price;


    public Product( String name, String category, double price) {
        Random rdm = new Random();
        this.id = rdm.nextLong();
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.length()<3) throw new RuntimeException("nome troppo corto");
        else this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}
