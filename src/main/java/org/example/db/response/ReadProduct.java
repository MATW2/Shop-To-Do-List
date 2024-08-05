package org.example.db.response;

import org.example.db.DB;
import org.example.db.response.abstractResponse.AbstractReadProduct;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.*;

public class ReadProduct extends AbstractReadProduct {

    public ReadProduct(Socket socket) {
        super(socket);
    }

    @Override
    public void read(String text) {
        try (PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {
                try {
                        String query = "SELECT * FROM product";
                        StringBuilder response = new StringBuilder();
                        try (Connection connection = DB.getConnection();
                             Statement statement = connection.createStatement();
                             ResultSet resultSet = statement.executeQuery(query)) {
                            while (resultSet.next()) {
                                int id = resultSet.getInt("id");
                                String name = resultSet.getString("Name");
                                Integer quantity = resultSet.getInt("Quantity");
                                Double price = resultSet.getDouble("Price");
                                response.append(id).append(",").append(name).append(",").append(quantity).append(",").append(price).append(";");
                            }
                        }
                        writer.println(response);
                } catch (SQLException e) {
                    System.out.println("Brak połączenia z bazą danych.");
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
