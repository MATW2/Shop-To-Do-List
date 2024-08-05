package org.example.db.dbCreate;

import org.example.config.DBConfig;

import java.sql.*;

public class CreateDataBase {
    public static void createDataBase(Connection connection) {
        String query = "SHOW DATABASES LIKE '" + DBConfig.getName()+ "'";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            if (!resultSet.next()) {
                String sql = "CREATE DATABASE " + DBConfig.getName();
                statement.executeUpdate(sql);
            }
        } catch (SQLException ex) {
            System.out.println("Brak połączenia z bazą danych.");
        }
    }
}

