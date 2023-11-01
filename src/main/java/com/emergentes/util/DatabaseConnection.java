/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emergentes.util;

/**
 *
 * @author ALEX
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/bd_biblioteca"; // Cambia la URL por la de tu base de datos
    private static final String USER = "postgres"; // Cambia por tu nombre de usuario
    private static final String PASSWORD = "123"; // Cambia por tu contraseña

    public Connection connection;

    public DatabaseConnection() {
        try {
            // Registra el controlador JDBC de PostgreSQL (asegúrate de tener el archivo JAR)
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        if (connection == null) {
            try {
                // Establece la conexión a la base de datos
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
