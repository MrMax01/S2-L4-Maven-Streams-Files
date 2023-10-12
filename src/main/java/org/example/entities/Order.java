package org.example.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class Order {
    private final long id;
    private String status;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private List<Product> products;
    private  Customer customer;

    public Order( List<Product> products, Customer customer) {
        Random rdm = new Random();
        setStatus();
        this.id = rdm.nextLong();
        setOrderDate();
        setDeliveryDate();
        this.products = products;
        this.customer = customer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus() {
        LocalDate today = LocalDate.now();
        if (today.equals(this.orderDate)) {
            this.status="we are taking charge of delivery";
        } else if (today.equals(this.deliveryDate)) {
            this.status="delivery Today";
        }else{
            //this.status= "mancano"+(today.until(this.deliveryDate))+ "alla consegna";
            this.status= "da fare";
        }
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate() {
        this.orderDate = LocalDate.now();
    }

    public LocalDate getDeliveryDate() {

        return deliveryDate;
    }

    public void setDeliveryDate() {
        Random rnd= new Random();
        this.deliveryDate = this.orderDate.plusDays(rnd.nextInt(0,10));
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products)  {
        if(products.isEmpty()) throw new RuntimeException("Ordine vuoto!");
        else this.products = products;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDate +
                ", products=" + products +
                ", customer=" + customer +
                '}';
    }


}
