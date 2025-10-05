# 🛍️ E-Commerce Product Management System

## 📖 Overview
The **E-Commerce Product Management System** is a full-stack web application that enables efficient product management and display for an online store.  
It provides both **Admin features** (like product CRUD operations) and **User features** (like browsing and adding products to cart).  

This project integrates a **React-based frontend** with a **Spring Boot REST API backend**, offering real-time communication via RESTful endpoints.

---

## ⚙️ Backend - Spring Boot (Java)

### 🚀 Overview
A RESTful API built using **Spring Boot 3.5.6 (Java 21)** that manages product data, including CRUD operations, product search, and image storage.

### 🧠 Features
- Create, Read, Update, and Delete (CRUD) products  
- Search products by keyword (name, brand, category, description)  
- Upload and retrieve product images  
- Manage stock quantity and availability  
- Pre-loaded sample data with automatic schema creation (via Hibernate)  

### 🧩 Tech Stack
- **Framework:** Spring Boot 3.5.6  
- **Language:** Java 21  
- **Database:** H2 (In-Memory)  
- **ORM:** JPA / Hibernate  
- **Build Tool:** Maven  
- **Libraries:** Lombok  

### 🏗️ Architecture
- **Model:** Product entity defining all product attributes  
- **Repository:** `ProductRepo` (extends JpaRepository)  
- **Service:** `ProductService` (business logic & validation)  
- **Controller:** `ProductController` (REST endpoints)  

### 📡 API Endpoints
| Method | Endpoint | Description |
|---------|-----------|-------------|
| `GET` | `/api/products` | Get all products |
| `GET` | `/api/product/{id}` | Get product by ID |
| `POST` | `/api/product` | Add new product (supports image upload) |
| `PUT` | `/api/product/{id}` | Update product details |
| `DELETE` | `/api/product/{id}` | Delete product |
| `GET` | `/api/products/search?keyword=...` | Search products |
| `GET` | `/api/product/{productId}/image` | Get product image |

### 🧾 Recent Fixes & Improvements
- Fixed JPQL query syntax issues  
- Added null and error handling  
- Optimized service and repository layers  
- Improved entity-to-table mapping  

---

## 💻 Frontend - React (Vite)

### 🚀 Overview
A **React 18** application designed with **Vite** for fast development.  
It provides a responsive UI for users to browse products, manage a shopping cart, and perform product administration.

### 🧠 Features
- Product catalog with filtering and category-based navigation  
- Dynamic product images fetched from backend API  
- Add/update product functionality (admin side)  
- Shopping cart with add/remove, quantity control, and total calculation  
- Persistent cart data using `localStorage`  
- Checkout modal for preview before purchase  

### 🧩 Tech Stack
- **Framework:** React 18.2.0  
- **Build Tool:** Vite  
- **Routing:** React Router DOM v6  
- **Styling:** Bootstrap 5.3.3 + Custom CSS  
- **HTTP Client:** Axios  
- **State Management:** React Context API  
- **Icons:** Bootstrap Icons, React Icons  

### 🏗️ Key Components
| Component | Description |
|------------|-------------|
| `Home.jsx` | Displays all products with filters |
| `Cart.jsx` | Shopping cart with total and quantity management |
| `Navbar.jsx` | Navigation bar with category selection |
| `AddProduct.jsx` / `UpdateProduct.jsx` | Forms for product management |
| `Context.js` | Global state management (cart & product data) |

### 🔗 Backend Integration
- Communicates with Spring Boot APIs hosted at `http://localhost:8080`  
- Uses Axios for API calls (CRUD + image upload/retrieval)  
- Synchronizes data dynamically with backend database  

---

