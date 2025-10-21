package com.orders.controller;

import com.orders.model.Order;
import com.orders.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * REST controller for managing orders.
 * Provides endpoints for CRUD operations.
 */
@RestController

// To define the route that the program will use.
// In this case is localhost:8080/orders.
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository repository;

    /**
     * Retrieve all orders.
     *
     * @return List of all orders.
     */
    @GetMapping
    public List<Order> getAllOrders() {
        return repository.findAll();
    }

    /**
     * Retrieve an order by its ID.
     *
     * @param id ID of the order.
     * @return Order object or null if not found.
     */
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    /**
     * Create a new order.
     *
     * @param order Order object from request body.
     * @return Saved order.
     */
    @PostMapping
public ResponseEntity<Order> createOrder(@RequestBody Order order) {
    Order savedOrder = repository.save(order);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedOrder);
}

    /**
     * Update an existing order by ID.
     * Only non-null fields in the request are updated.
     *
     * @param id           ID of the order to update.
     * @param updatedOrder Order object with new values.
     * @return Updated order or null if not found.
     */
    @PatchMapping("/{id}")
    public Order updateOrder(@PathVariable Long id, @RequestBody Order updatedOrder) {
        return repository.findById(id).map(order -> {
            if (updatedOrder.getProduct() != null) order.setProduct(updatedOrder.getProduct());
            if (updatedOrder.getQuantity() != null) order.setQuantity(updatedOrder.getQuantity());
            if (updatedOrder.getPrice() != null) order.setPrice(updatedOrder.getPrice());
            return repository.save(order);
        }).orElse(null);
    }

    /**
     * Delete an order by ID.
     *
     * @param id ID of the order to delete.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Value("${spring.profiles.active:default}")
    private String activeProfile;
    
    @GetMapping("/profile")
    public String getActiveProfile() {
    return "Active profile: " + activeProfile;
    }
    }
    