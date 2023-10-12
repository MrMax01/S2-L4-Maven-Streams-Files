package org.example;

import com.github.javafaker.Faker;
import org.example.entities.Customer;
import org.example.entities.Order;
import org.example.entities.Product;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {
        //-------------------------------------MAGAZZINO-------------------
        List<Product> warehouse = new ArrayList<>();
        warehouse.add(new Product("Lord od Rings", "Books", 150));
        warehouse.add(new Product("Ten Little Indians", "Books", 30));
        warehouse.add(new Product("Word of Warcraft", "Games", 30));
        warehouse.add(new Product("White T-Shirt", "Clothes", 20));
        warehouse.add(new Product("Old Jeans", "Clothes", 15));
        warehouse.add(new Product("One Plus", "Tech", 400));
        warehouse.add(new Product("Auto Vacuum Cleaner", "Tech", 350));
        warehouse.add(new Product("Star Wars Lego", "Baby", 100));
        warehouse.add(new Product("stroller", "Baby", 99));



        //Creo i/un Customer
        //Faker faker= new Faker();
        Customer client = new Customer("Massimo", 2);
        Customer client1 = new Customer("Riccardo", 1);
        Customer client2 = new Customer("Andrea", 2);
        Customer client3 = new Customer("Pippo", 1);
        Customer client4 = new Customer("Pippo", 1);


        //Creo qualche list di Prodotti
        List<Product> cart = randomListOfProducts(warehouse);
        List<Product> cart2 = randomListOfProducts(warehouse);
        List<Product> cart3 = randomListOfProducts(warehouse);
        List<Product> cart4 = randomListOfProducts(warehouse);
        List<Product> cart5 = randomListOfProducts(warehouse);

        //creo una lista di ordini
        List<Order> orderList = new ArrayList<>();
        orderList.add(new Order(cart, client));
        orderList.add(new Order(cart2, client1));
        orderList.add(new Order(cart3, client2));
        orderList.add(new Order(cart4, client3));
        orderList.add(new Order(cart5, client4));

        /*--------------------------------------ESERCIZIO 1-------------------------------------------------------*/

        Map<Customer, List<Order>> clientOrder = orderList.stream()
                .collect(Collectors.groupingBy(Order::getCustomer));
        /*
        clientOrder.forEach((key, value) -> {
            System.out.println("-------"+key+"----------");
            System.out.println("-------"+value+"----------");

        });
        */

        /*---------------------------------ESERCIZIO 2--------------------------------*/
        Map<Customer, Double> totalSellsCustomer = orderList.stream()
                .collect(Collectors.groupingBy(Order::getCustomer, Collectors.summingDouble(order->
                        order.getProducts().stream().mapToDouble(Product::getPrice).sum()
                )));
        totalSellsCustomer.forEach((key, value) -> {
            System.out.println("-------"+key+"----------");
            System.out.println("-------"+value+"----------");

        });

    }


    public static List<Product> randomListOfProducts(List<Product> catalog){

        Random rnd= new Random();
        List<Product> output= new ArrayList<>();
        for (int i = 0; i < rnd.nextInt(1, catalog.size()); i++) {
            output.add(catalog.get(rnd.nextInt(0, catalog.size()-1)));
        }

        return output;
    }
}
