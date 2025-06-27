# E-commerceAPI EASYSHOP

## Overview

**E-commerceAPI EASYSHOP** is a Java-based Spring Boot backend for a full-featured e-commerce platform. It supports user registration and login, shopping cart management, order checkout, product browsing, and admin-level product control. The backend connects to a SQL Server database and follows a layered architecture using DAO classes and models.

This capstone project demonstrates:

- RESTful API development
- Role-based access control 
- Secure authentication using JWT tokens
- SQL Server database integration using JDBC
- Structured controller-service-dao architecture

---

## Key Features

- User registration and login
- Secure JWT authentication
- Admin-only product creation, update, and deletion
- Product browsing for all users
- Add to cart, update quantity, remove from cart
- Checkout flow (creates order and order line items)
- View and update user profile

---

## How to Run the Project

To run the EasyShop backend locally:

1. Clone the repo and open it in your IDE  
2. Set up your database connection in `application.properties`  
3. Run the application using your IDE or `./mvnw spring-boot:run`  
4. Test endpoints at `http://localhost:8080/api` using Postman or a browser

That's it! 🎉 Your backend should now be running locally.

---

## Screenshots

Below are two screenshots from my postman test scrpits 

<img src="./Assets/">







---

## Interesting Code Snippet

This method inside the `` class 

```java

```
