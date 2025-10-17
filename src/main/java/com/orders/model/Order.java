package com.orders.model;

import jakarta.persistence.*;

/**
 * Represents an order in the system.
 * Contains basic information such as product name, quantity, and price.
 */
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String product;

    @Column(nullable = false)
    private Integer quantity;

    private Double price;

    /**
     * Default constructor required by JPA (SQL Dependency).
     */
    public Order() {}

    /**
     * Constructor with the parameters that will be added into the database.
     *
     * @param product  Name of the product.
     * @param quantity Quantity ordered.
     * @param price    Price of the product.
     */
    public Order(String product, Integer quantity, Double price) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and setters
    public Long getId() { return id; }

    public String getProduct() { return product; }
    public void setProduct(String product) { this.product = product; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
}
