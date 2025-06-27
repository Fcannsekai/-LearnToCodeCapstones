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

<img src="./Assets/Postman1.png">

<img src="./Assets/Postman2.png">

---

## Interesting Code Snippet

This method inside the `ShoppingCartController` class, This method handles adding a product to the logged-in user's shopping cart. It uses the product's ID from the URL and the authenticated user's information to ensure the correct cart is updated. After adding the product, the updated cart is returned to keep the front-end in sync.

```java

 @PostMapping("/products/{productId}")
    public ShoppingCart addProduct(@PathVariable int productId, Principal principal)
    {
        try
        {
            String userName = principal.getName();
            User user = userDao.getByUserName(userName);
            int userId = user.getId();

            shoppingCartDao.addProduct(userId, productId);
            return shoppingCartDao.getByUserId(user.getId());

        }
        catch (Exception e)
        {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unable to add product to cart.");
        }
    }


```

# EasyShop Frontend

## Running the Project

This project is not deployed. To run the frontend locally:

1. Clone or download this repository  
2. Open the project folder in your code editor  
3. Open `index.html` directly in your browser or use a simple live server extension  
4. Ensure the EasyShop backend is running at `http://localhost:8080`  
5. Begin exploring the site  

---

## Features

- Modern, responsive user interface  
- Product catalog with images, descriptions, and pricing  
- Product filtering by category, price range, and color  
- Add, view, and remove items from the shopping cart  
- Real-time cart item count updates  
- One-click clear cart functionality  
- Secure login with JWT authentication  
- View and update user profile information  
- Checkout functionality that creates orders through the backend  
- Fully integrated with the EasyShop Spring Boot API  

---

## Connected API Endpoints

| Endpoint               | Method | Description                |
|------------------------|--------|----------------------------|
| `/products`            | GET    | Fetch all products         |
| `/cart`                | GET    | Retrieve user's cart       |
| `/cart/products/{id}`  | POST   | Add item to cart           |
| `/cart`                | DELETE | Clear entire cart          |
| `/profile`             | GET    | View user profile          |
| `/profile`             | PUT    | Update user profile        |
| `/login`               | POST   | Authenticate and receive token |
| `/register`            | POST   | Register a new user        |

---

## Screenshots

### Home Page  
<img src="./Assets/HomePage.png">

### Cart Page  
<img src="./Assets/ShoppingCart.png">

### Profile Page  
<img src="./Assets/Profile.png">

