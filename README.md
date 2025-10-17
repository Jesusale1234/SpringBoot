# REST API for MELI Order Management Problem

## Project Description
This project is a simple **RESTful API** built with **Spring Boot**, **Maven**, and **Java 17**, designed to manage orders to face the MELI E-commerce company problem.  
It allows users to **create, read, update, and delete orders** stored in a database.  
The application uses **Spring Data JPA** for database interactions and **H2** for development purposes.

---

## Features
- Create a new order
- Retrieve all orders
- Retrieve an order by ID
- Update an order by ID
- Delete an order by ID
- Fully documented using **Javadoc**
- Ready for GitHub deployment

---

## Installation

### Prerequisites
- Java 17 installed
- Maven installed
- Git (optional, for cloning)
- IDE like IntelliJ IDEA, Eclipse, or VS Code

### Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/Jesusale1234/SpringBoot/
   cd SpringBoot
2. Build the project with Maven:
   ```
   mvn clean install
3. Run the application (or run the MeliOrdersManagementAppApplication.java class in VS Code):
   ```
   mvn spring-boot:run
4. The server will start on:
   ```
   http://localhost:8080
6. Access H2 console (development database):
   ```
   http://localhost:8080/h2-console
   JDBC URL: jdbc:h2:mem:testdb
   Username: sa
   Password: <empty>


## API Endpoints

| Method | URL            | Request Body Example                                      | Description              |
| ------ | -------------- | --------------------------------------------------------- | ------------------------ |
| POST   | `/orders`      | `{ "product": "Laptop", "quantity": 2, "price": 1200.0 }` | Create a new order       |
| GET    | `/orders`      | —                                                         | Retrieve all orders      |
| GET    | `/orders/{id}` | —                                                         | Retrieve an order by ID  |
| PATCH  | `/orders/{id}` | `{ "quantity": 3 }`                                       | Update an existing order |
| DELETE | `/orders/{id}` | —                                                         | Delete an order by ID    |

## Structure of the project

```
orders-api/
├── src/
│   ├── main/
│   │   ├── java/com/orders/
│   │   │   ├── OrdersApplication.java       # Main application that works as an executable class
│   │   │   ├── controller/                  # REST controllers
│   │   │   │   └── OrderController.java
│   │   │   ├── model/                       # Entity models to define the database parameters
│   │   │   │   └── Order.java
│   │   │   └── repository/                  # JPA dependency repositories
│   │   │       └── OrderRepository.java
│   │   └── resources/
│   │       └── application.properties       # Configuration
├── pom.xml                                  # Maven project file
└── README.md                                # Project documentation
```

 ## Future Improvements
 - Define environment roles within the project.
 - Switch to a production-grade database (PostgreSQL or MySQL).
 - Add unit and integration tests for API endpoints.
 - Include Swagger/OpenAPI documentation.

## License
This project is open-source and free to use.
