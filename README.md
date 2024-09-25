# User Registration System

A simple Java-based user registration system that allows users to sign up by entering their username, password, and email. The user information is stored in a MySQL database.

## Features
+ Register users with a username, password, and email.
+ Store user data in a MySQL database.
+ Prevent SQL injection with parameterized queries using `PreparedStatement`.

## Requirements
+ **Java Development Kit (JDK)**: Version 8 or higher
+ **MySQL Database**: Version 5.7 or higher
+ **Maven**: For dependency management
+ **MySQL Connector/J**: Java library for MySQL database connectivity

## Database Setup

1. Start by creating a MySQL database and a `users` table:
   ```sql
   CREATE DATABASE user_db;

   USE user_db;

   CREATE TABLE users (
       id INT AUTO_INCREMENT PRIMARY KEY,
       username VARCHAR(50) NOT NULL UNIQUE,
       password VARCHAR(100) NOT NULL,
       email VARCHAR(100) NOT NULL UNIQUE
   );
