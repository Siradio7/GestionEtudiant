package com.mycompany.gestionetudiant.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Database {
    private static final String url = "jdbc:mysql://localhost:3306/student_management";
    private static final String userName = "root";
    private static final String password = "eclipse23";
    private static Connection connexion;

    public static Connection getConnexion() throws SQLException {
        connexion = DriverManager.getConnection(url, userName, password);

        return connexion;
    }

    public static void close() throws SQLException {
        connexion.close();
    }
}

