# Food Order API

  The Food Order API is a web application that provides a RESTful API for managing food orders. It is built using Spring Boot, MySQL, Swagger, MVC, and supports CRUD operations for creating food items, adding orders, and adding users.


## Features
    * CRUD operations for managing food items, orders, and users.
    * Swagger UI for easy API documentation.
    * Supports authentication for admin users.
## Technologies Used
   * Spring Boot
   * MySQL
   * Swagger
   * MVC
   * Spring Data JPA
   * JUnit
## Getting Started
To run this application locally, you will need to have Java 8 or higher installed on your machine. Follow these steps:

      * Clone the repository: git clone 
      * Navigate to the project directory
      * Run the application: ./mvnw spring-boot:run
      * The application will be running at http://localhost:8080.

## API Endpoints
The following endpoints are available:

     * GET /foods: Returns a list of all food items.
     * GET /foods/{id}: Returns the food item with the specified ID.
     * POST /foods: Adds a new food item.
     * PUT /foods/{id}: Updates the food item with the specified ID.
     * DELETE /foods/{id}: Deletes the food item with the specified ID.

Swagger Link : http://35.154.150.244:8080/swagger-ui/index.html

  ## controller
   * Food controller
   ![Screenshot 2023-03-16 003959](https://user-images.githubusercontent.com/110538655/225418304-db8d1a30-7bf1-48c8-aed9-64e0a05da706.png)
   * User controller
   ![Screenshot 2023-03-16 004413](https://user-images.githubusercontent.com/110538655/225418664-74c6363e-5364-4390-bfd9-74a6410b961b.png)
   * Order Controller
   ![Screenshot 2023-03-16 004423](https://user-images.githubusercontent.com/110538655/225418747-f75d797f-ceaf-409c-88d0-3498c8cc8898.png)

used Database MySQL , Deployed Using AWS Ec2 , used various other tools like Terminus , Intellij IDEA , git bash etc.
