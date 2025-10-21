package com.orders.repository;

import com.orders.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Order entity.
 * Extends JpaRepository, allowing to provide CRUD operations (Create, Read, Update, Delete).
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // Spring Data JPA Dependency provides basic CRUD methods automatically.
}
