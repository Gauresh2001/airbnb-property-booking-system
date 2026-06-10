# 🏡 Airbnb Property Booking System

<div align="center">

### 🚀 Full Stack Property Rental & Booking Platform

Built with **Spring Boot**, **Spring Data JPA**, **MySQL**, **React.js**, **REST APIs**, **Swagger OpenAPI**, and **Hibernate**

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-brightgreen)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue)
![React](https://img.shields.io/badge/React-Frontend-61DAFB)
![Swagger](https://img.shields.io/badge/Swagger-OpenAPI-green)
![Status](https://img.shields.io/badge/Project-Completed-success)

</div>

---

## 📖 Project Overview

The Airbnb Property Booking System is a full-stack web application inspired by Airbnb's booking workflow. The platform allows property owners (Hosts) to list rental properties, manage availability, and monitor bookings while Guests can search properties, create bookings, manage reservations, and submit reviews.

The system is designed with a scalable architecture using Spring Boot, RESTful APIs, MySQL Database, and React.js Frontend.

---

## ✨ Key Features

### 👤 User Management

* Host Registration
* Guest Registration
* User Role Management
* User Listing API

### 🏠 Property Management

* Create Property Listings
* Update Property Details
* View Property Information
* Search Properties by Location
* Filter Properties by Price Range

### 📅 Availability Management

* Set Property Availability
* Manage Available Dates
* Validate Availability Before Booking

### 🎟️ Booking Management

* Create Booking Requests
* Booking Confirmation
* Booking Cancellation
* Booking Completion
* View Booking History
* Host Booking Dashboard

### ⭐ Review System

* Add Property Reviews
* Property Ratings
* Average Rating Calculation
* Guest Feedback System

### 🔒 Booking Validation

* Prevent Double Booking
* Date Conflict Validation
* Transaction Management
* Availability Verification

### 📊 API Documentation

* Swagger UI Integration
* Interactive API Testing
* OpenAPI Documentation

---

# 🏗️ System Architecture

```text
Guest / Host
      │
      ▼
 React Frontend
      │
      ▼
 Spring Boot REST APIs
      │
      ▼
 Service Layer
      │
      ▼
 Repository Layer
      │
      ▼
 MySQL Database
```

---

# 🛠️ Tech Stack

## Backend

* Java 21
* Spring Boot
* Spring Data JPA
* Hibernate ORM
* MySQL Database
* Lombok
* Spring Validation
* Spring Security
* Swagger OpenAPI
* SLF4J Logging

## Frontend

* React.js
* Axios
* React Router DOM
* CSS3

## Tools

* Postman
* MySQL Workbench
* IntelliJ IDEA / Eclipse
* Git & GitHub

---

# 🗄️ Database Design

## User

```text
id
name
email
password
role
created_at
```

## Property

```text
id
title
description
location
price_per_night
rating
host_id
```

## Property Availability

```text
id
property_id
available_from
available_to
```

## Booking

```text
id
property_id
guest_id
start_date
end_date
total_price
status
created_at
```

## Review

```text
id
property_id
guest_id
rating
comment
created_at
```

---

# 🔄 Booking Workflow

```text
Host Registration
      ↓
Property Creation
      ↓
Set Availability
      ↓
Guest Registration
      ↓
Property Search
      ↓
Booking Request
      ↓
Availability Validation
      ↓
Booking Confirmation
      ↓
Stay Completion
      ↓
Review Submission
```

---

# 🚀 REST API Endpoints

## User APIs

```http
POST   /users
GET    /users
```

## Property APIs

```http
POST   /properties
PUT    /properties/{id}
GET    /properties
GET    /properties/{id}
GET    /properties/filter/price
```

## Availability APIs

```http
POST   /properties/availability
```

## Booking APIs

```http
POST   /bookings
GET    /bookings
GET    /bookings/user/{userId}
GET    /bookings/property/{propertyId}
PUT    /bookings/{id}/cancel
PUT    /bookings/{id}/complete
```

## Review APIs

```http
POST   /reviews
GET    /reviews/property/{propertyId}
```

---

# 🔥 Advanced Functionalities

✅ Role Based User Management

✅ Property Availability Tracking

✅ Booking Lifecycle Management

✅ Review & Rating System

✅ Price Range Filtering

✅ Transaction Handling

✅ Global Exception Handling

✅ Input Validation

✅ Swagger Documentation

✅ Double Booking Prevention

✅ Scalable Layered Architecture

---

# 📸 Project Screens

```text
✔ User Registration
✔ Property Listing
✔ Availability Management
✔ Booking Creation
✔ Booking Dashboard
✔ Review Submission
✔ Swagger API Documentation
```

---

# 📚 Learning Outcomes

* Spring Boot Development
* REST API Design
* Hibernate ORM
* JPA Relationships
* DTO Pattern
* Validation Handling
* Exception Handling
* Swagger Integration
* React API Integration
* Full Stack Application Development

---

# 👨‍💻 Developer

### Gauresh Badgujar

Java Full Stack Developer

**Skills**

* Java
* Spring Boot
* Hibernate
* MySQL
* React.js
* REST APIs
* HTML
* CSS
* JavaScript

---

# ⭐ Project Status

```text
Project Status : COMPLETED ✅
Backend APIs   : COMPLETED ✅
Database       : COMPLETED ✅
Swagger Docs   : COMPLETED ✅
Frontend UI    : COMPLETED ✅
Testing        : COMPLETED ✅
```

---

<div align="center">

### ⭐ If you like this project, don't forget to Star the Repository ⭐

🚀 Happy Coding 🚀

</div>
