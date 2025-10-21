package com.orders.repository;

import com.orders.model.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    @DisplayName("Save an order successfully")
    void testSaveOrder() {
        Order order = new Order();
        order.setProduct("Laptop");
        order.setQuantity(2);
        order.setPrice(1200.0);

        Order savedOrder = orderRepository.save(order);

        assertThat(savedOrder.getId()).isNotNull();
        assertThat(savedOrder.getProduct()).isEqualTo("Laptop");
    }

    @Test
    @DisplayName("Retrieve all orders")
    void testFindAllOrders() {
        Order order1 = new Order();
        order1.setProduct("Laptop");
        order1.setQuantity(2);
        order1.setPrice(1200.0);
        orderRepository.save(order1);

        Order order2 = new Order();
        order2.setProduct("Mouse");
        order2.setQuantity(5);
        order2.setPrice(50.0);
        orderRepository.save(order2);

        List<Order> orders = orderRepository.findAll();
        assertThat(orders).hasSize(2);
    }

    @Test
    @DisplayName("Find order by ID")
    void testFindById() {
        Order order = new Order();
        order.setProduct("Keyboard");
        order.setQuantity(1);
        order.setPrice(80.0);
        Order saved = orderRepository.save(order);

        Optional<Order> retrieved = orderRepository.findById(saved.getId());
        assertThat(retrieved).isPresent();
        assertThat(retrieved.get().getProduct()).isEqualTo("Keyboard");
    }

    @Test
    @DisplayName("Delete order successfully")
    void testDeleteOrder() {
        Order order = new Order();
        order.setProduct("Monitor");
        order.setQuantity(1);
        order.setPrice(300.0);
        Order saved = orderRepository.save(order);

        orderRepository.delete(saved);
        Optional<Order> deleted = orderRepository.findById(saved.getId());
        assertThat(deleted).isNotPresent();
    }

    @Test
    @DisplayName("Edge case: find by non-existent ID")
    void testFindNonExistentOrder() {
        Optional<Order> retrieved = orderRepository.findById(999L);
        assertThat(retrieved).isNotPresent();
    }
}
