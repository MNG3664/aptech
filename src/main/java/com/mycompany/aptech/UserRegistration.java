/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aptech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
/**
 *
 * @author USER
 */
public class UserRegistration {
    
     // Database URL, username, and password
    private static final String DB_URL = "jdbc:mysql://localhost:3306/user_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "nazeer3664";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("=== User Registration ===");

            System.out.print("Enter username: ");
            String username = scanner.nextLine();

            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            System.out.print("Enter email: ");
            String email = scanner.nextLine();

            // Register the user
            registerUser(username, password, email);
        }
    }

    public static void registerUser(String username, String password, String email) {
        String insertUserSQL = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(insertUserSQL)) {

            // Set parameters for the SQL statement
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, email);

            // Execute the SQL statement
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("User registered successfully!");
            } else {
                System.out.println("Failed to register user.");
            }

        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
        }
    }
}
