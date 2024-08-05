package org.example.db.response;

import org.example.db.DB;
import org.example.db.response.abstractResponse.AbstractEditProduct;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.*;

public class EditProduct extends AbstractEditProduct {

    public EditProduct(Socket socket) {
        super(socket);
    }

    @Override
    public void edit(String text) {
        try (PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {
            try {
                    String[] parts = text.split(";");
                    String query = "UPDATE product SET Name = ?, Quantity = ?, Price = ? WHERE ID = ?";
                    try (Connection connection = DB.getConnection();
                         PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                        preparedStatement.setString(1, parts[2]);
                        preparedStatement.setInt(2, Integer.parseInt(parts[3]));
                        preparedStatement.setDouble(3, Double.parseDouble(parts[4].replace(",", ".")));
                        preparedStatement.setInt(4, Integer.parseInt(parts[1]));
                        preparedStatement.executeUpdate();
                    }
                    writer.println("Zmodyfikowano na: " + parts[2] + " " + parts[3] + " " + parts[4]);
            } catch (SQLException e) {
                System.out.println("Brak połączenia z bazą danych.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
