package com.mycompany.gestionetudiant.service;

import com.mycompany.gestionetudiant.dao.IAdministrator;
import com.mycompany.gestionetudiant.database.Database;
import com.mycompany.gestionetudiant.model.Administrator;

import java.sql.*;

public class AdministratorService implements IAdministrator {
    private final Connection connection = Database.getConnexion();
    private String request;

    public AdministratorService() throws SQLException {
    }

    @Override
    public Administrator login(Administrator administrator) {
        if (administrator == null) {
            return null;
        }

        this.request = "SELECT * FROM administrator WHERE username='" + administrator.getUsername() + "' AND password=MD5('" + administrator.getPassword() + "')";

        try {
            Statement statement = this.connection.createStatement();
            ResultSet result = statement.executeQuery(this.request);

            if (result.next()) {
                Administrator logedAdministrator = new Administrator();

                logedAdministrator.setName(result.getString("name"));
                logedAdministrator.setUsername(result.getString("username"));
                logedAdministrator.setPassword(result.getString("password"));

                return logedAdministrator;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public boolean signup(Administrator administrator) {
        if (administrator == null) {
            return false;
        }

        this.request = "INSERT INTO administrator (name, username, password) VALUES (?, ?, MD5(?))";

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(this.request);
            preparedStatement.setString(1, administrator.getName());
            preparedStatement.setString(2, administrator.getUsername());
            preparedStatement.setString(3, administrator.getPassword());

            preparedStatement.execute();
            preparedStatement.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }
}
