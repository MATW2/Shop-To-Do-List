package org.example.db;

import org.example.config.DBConfig;
import org.example.db.dbCreate.CreateDataBase;
import org.example.db.dbCreateTable.CreateTableProduct;

import java.sql.*;

public class DB {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DBConfig.getURL(), DBConfig.getUser(), DBConfig.getPassword());
            CreateDataBase.createDataBase(connection);
            connection = DriverManager.getConnection(DBConfig.getFullURL(), DBConfig.getUser(), DBConfig.getPassword());
            CreateTableProduct.createTableProduct(connection);
        } catch (SQLException ex) {
            System.out.println("Brak połączenia z bazą danych.");
        }
        return connection;
    }

    public static void connection() {
        Connection connection = getConnection();
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}

