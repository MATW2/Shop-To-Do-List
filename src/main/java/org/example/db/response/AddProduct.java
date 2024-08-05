package org.example.db.response;

import org.example.db.DB;
import org.example.db.response.abstractResponse.AbstractAddProduct;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.*;

public class AddProduct extends AbstractAddProduct {

    public AddProduct(Socket socket) {
        super(socket);
    }

    @Override
    public void add(String text) {
        try (PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {
                    String[] parts = text.split(";");
                    String query = "INSERT INTO product (`Name`, `Quantity`, `Price`) VALUES (?, ?, ?)";
                    try (Connection connection = DB.getConnection();
                         PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                        preparedStatement.setString(1, parts[1]);
                        preparedStatement.setInt(2, Integer.parseInt(parts[2]));
                        preparedStatement.setDouble(3, Double.parseDouble(parts[3].replace(",", ".")));
                        preparedStatement.executeUpdate();
                    }
                    writer.println("Dodano: " + parts[1] + " " + parts[2] + " " + parts[3]);
            } catch (SQLException e) {
            System.out.println("Brak połączenia z bazą danych.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
