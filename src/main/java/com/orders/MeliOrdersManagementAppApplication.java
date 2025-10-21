package com.orders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the Orders Spring Boot application.
 * Starts the embedded server and initializes the context.
 */
@SpringBootApplication
public class MeliOrdersManagementAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MeliOrdersManagementAppApplication.class, args);
    }
}
