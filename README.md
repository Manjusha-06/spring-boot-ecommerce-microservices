# spring-boot-ecommerce-microservices
A Spring Boot-based e-commerce microservices application featuring User, Product, and Order services, with Spring Cloud API Gateway, Eureka Service Discovery, OpenFeign for inter-service communication, and JUnit &amp; Mockito for unit testing.
##  Technologies Used

- **Java & Spring Boot** – Backend application development
- **Spring Cloud Gateway** – Centralized API routing
- **Netflix Eureka Server** – Service registration and discovery
- **Spring Cloud OpenFeign** – Declarative inter-service communication
- **PostgreSQL** – Relational database with separate databases for each microservice
- **Spring Security & JWT** – Authentication and authorization
- **JUnit & Mockito** – Unit testing and dependency mocking
- **Maven** – Dependency management and build automation

##  Authentication and Security

- Implemented JWT-based authentication for protected API endpoints.
- Used Spring Security to configure endpoint access and authorization rules.
- Configured OpenFeign for service-to-service HTTP communication, including calls that do not require JWT authentication, according to the application's security configuration.

##  Database

The application follows the **Database-per-Service** pattern, with each microservice maintaining its own PostgreSQL database.

- **User Service:** Stores user-related data.
- **Product Service:** Stores product-related data.
- **Order Service:** Stores order-related data.

Configure the database URL, username, and password for each service in its application configuration. Use environment variables or another secure configuration method for sensitive credentials.

##  Testing

JUnit and Mockito are used to test application logic and mock dependencies.

Run tests from an individual service's project directory:

```bash
mvn test
```

##  Architecture

The application consists of five main components:

1. **User Service** – Manages user-related operations and data.
2. **Product Service** – Manages product-related operations and data.
3. **Order Service** – Manages order-related operations and data.
4. **Eureka Server** – Supports service registration and discovery.
5. **API Gateway** – Routes incoming client requests to the appropriate services.

OpenFeign facilitates communication between services, while each business microservice manages its own PostgreSQL database.
