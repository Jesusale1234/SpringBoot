package com.orders.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.orders.model.Order;
import com.orders.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        orderRepository.deleteAll();
    }

    @Test
    @DisplayName("POST /orders - create order")
    void testCreateOrder() throws Exception {
        Order order = new Order();
        order.setProduct("Laptop");
        order.setQuantity(2);
        order.setPrice(1200.0);

        mockMvc.perform(post("/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(order)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.product").value("Laptop"));
    }

    @Test
    @DisplayName("GET /orders - retrieve all orders")
    void testGetAllOrders() throws Exception {
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

        mockMvc.perform(get("/orders"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    @DisplayName("GET /orders/{id} - retrieve single order")
    void testGetOrderById() throws Exception {
        Order order = new Order();
        order.setProduct("Keyboard");
        order.setQuantity(1);
        order.setPrice(80.0);
        Order saved = orderRepository.save(order);

        mockMvc.perform(get("/orders/{id}", saved.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.product").value("Keyboard"));
    }

    @Test
    @DisplayName("PATCH /orders/{id} - update order")
    void testUpdateOrder() throws Exception {
        Order order = new Order();
        order.setProduct("Monitor");
        order.setQuantity(1);
        order.setPrice(300.0);
        Order saved = orderRepository.save(order);

        saved.setQuantity(3);

        mockMvc.perform(patch("/orders/{id}", saved.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(saved)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.quantity").value(3));
    }

    @Test
    @DisplayName("DELETE /orders/{id} - delete order")
    void testDeleteOrder() throws Exception {
        Order order = new Order();
        order.setProduct("Tablet");
        order.setQuantity(1);
        order.setPrice(204.0);
        Order saved = orderRepository.save(order);

        mockMvc.perform(delete("/orders/{id}", saved.getId()))
                .andExpect(status().isNoContent());
    }
}
