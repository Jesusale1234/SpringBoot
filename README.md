# REST API for MELI Order Management Problem

## Project Description
This project is a simple **RESTful API** built with **Spring Boot**, **Maven**, and **Java 17**, designed to manage orders to face the MELI E-commerce company problem.  
It allows users to **create, read, update, and delete orders** stored in a database.  
The application includes environment-specific configurations, Swagger documentation, and automated testing to ensure functionality and reliability.

---

## Features
- Create a new order
- Retrieve all orders
- Retrieve an order by ID
- Update an order by ID
- Delete an order by ID
- Fully documented using **Javadoc**
- Ready for GitHub deployment
- Environment-specific profiles (dev, test, prod)
- Dynamic configuration via system environment variables
- Unit and integration tests with JUnit 5, MockMvc, and Spring Boot Test
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

| Method | URL               | Request Body Example                                      | Description                       |
| ------ | ----------------- | --------------------------------------------------------- | --------------------------------- |
| POST   | `/orders`         | `{ "product": "Laptop", "quantity": 2, "price": 1200.0 }` | Create a new order                |
| GET    | `/orders`         | —                                                         | Retrieve all orders               |
| GET    | `/orders/{id}`    | —                                                         | Retrieve an order by ID           |
| PATCH  | `/orders/{id}`    | `{ "quantity": 3 }`                                       | Update an existing order          |
| DELETE | `/orders/{id}`    | —                                                         | Delete an order by ID             |
| GET    | `/orders/profile` | —                                                         | Check current environment profile |


## Structure of the project

```
orders-api/
├── src/
│   ├── main/
│   │   ├── java/com/orders/
│   │   │   ├── OrdersApplication.java       # Main application class
│   │   │   ├── controller/OrderController.java
│   │   │   ├── model/Order.java
│   │   │   └── repository/OrderRepository.java
│   │   └── resources/
│   │       ├── application.yml              # Default configuration
│   │       ├── application-dev.yml          # Development profile
│   │       ├── application-test.yml         # Testing profile
│   │       └── application-prod.yml         # Production profile
│   └── test/
│       └── java/com/orders/
│           ├── controller/OrderControllerTest.java
│           └── repository/OrderRepositoryTest.java
├── pom.xml                                  # Maven project file
└── README.md                                # Project documentation

```

## Environment Profiles
The application uses Spring Profiles to separate environment-specific configurations and regulate the permissions for each person involved in the project.
Each environment is defined in a dedicated .yml file.


**Available Profiles**

| Profile | File                   | Description                                                                                 |
| ------- | ---------------------- | ------------------------------------------------------------------------------------------- |
| `dev`   | `application-dev.yml`  | Used for local development. Runs with an in-memory H2 database.                             |
| `test`  | `application-test.yml` | Used for automated or manual testing. Creates a fresh in-memory database for isolation.     |
| `prod`  | `application-prod.yml` | Used for production deployment. Persists H2 data in a local file and can log system events. |

## Running with a Specific Profile
You can activate a specific profile using:
```
mvn spring-boot:run -Dspring-boot.run.profiles=dev
mvn spring-boot:run -Dspring-boot.run.profiles=test
mvn spring-boot:run -Dspring-boot.run.profiles=prod
```
Or modifying the default "dev" value in the application.yml file.

## Verify Active Profile

You can test which profile is currently active through the /orders/profile endpoint on Postman:
```
GET http://localhost:8080/orders/profile
```

**Response example:**
<img width="2014" height="419" alt="image" src="https://github.com/user-attachments/assets/daeca68c-8d35-4c8e-a5c5-7399d9d0c7c6" />

## Swagger / OpenAPI Documentation
The API is fully documented using Springdoc OpenAPI (Swagger UI).
Once the app is running, access:
```
http://localhost:8080/swagger-ui.html
```
Once it is accessed, you can interact with and test each endpoint directly from your browser.

## Testing
This project includes unit and integration tests using JUnit 5, MockMvc, and AssertJ.

**Run all tests**
```
./mvnw test
```
**Test coverage**

| Test Class            | Purpose                                                        |
| --------------------- | -------------------------------------------------------------- |
| `OrderRepositoryTest` | Validates CRUD operations of the OrderRepository class.        |
| `OrderControllerTest` | Validates REST endpoints for success, failure, and edge cases. |

All tests are designed to prove that the endpoints are working correctly.

## License
This project is open-source and free to use.
