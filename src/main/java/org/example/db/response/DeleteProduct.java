package org.example.db.response;

import org.example.db.DB;
import org.example.db.response.abstractResponse.AbstractDeleteProduct;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.*;

public class DeleteProduct extends AbstractDeleteProduct {

    public DeleteProduct(Socket socket) {
        super(socket);
    }

    @Override
    public void delete(String text) {
        try (PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {
            String[] parts = text.split(";");
            String query = "  DELETE FROM product WHERE ID = ?";
            try (Connection connection = DB.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, Integer.parseInt(parts[1]));
                preparedStatement.executeUpdate();
            }
            writer.println("Usunięto: ");
        } catch (SQLException e) {
            System.out.println("Brak połączenia z bazą danych.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
