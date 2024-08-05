package org.example.db.dbCreateTable;

import org.example.config.DBConfig;

import java.sql.*;

public class CreateTableProduct {

    private static final String TABLE_NAME = "product";

    public static String getTableName() {
        return TABLE_NAME;
    }

    public static void createTableProduct(Connection connection) {
        String query = "SHOW TABLES LIKE '" + TABLE_NAME + "'";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            if (!resultSet.next()) {
                String sql = "CREATE TABLE " + TABLE_NAME + " ("
                        + "ID INT PRIMARY KEY AUTO_INCREMENT, "
                        + "Name VARCHAR(255) NOT NULL, "
                        + "Quantity INT NOT NULL, "
                        + "Price DOUBLE NOT NULL"
                        + ")";
                statement.executeUpdate(sql);
            }
        } catch (SQLException ex) {
            System.out.println("Brak połączenia z bazą danych.");
        }
    }
}
