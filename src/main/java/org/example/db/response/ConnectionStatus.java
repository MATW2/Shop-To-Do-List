package org.example.db.response;

import org.example.db.DB;
import org.example.db.response.abstractResponse.AbstractConnectionStatus;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionStatus extends AbstractConnectionStatus {

    public ConnectionStatus(Socket socket) {
        super(socket);
    }

    @Override
    public void status() {
        try (PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {
            try (Connection connection = DB.getConnection();
                 Statement ignored = connection.createStatement()){
                writer.println("Active:Active");
            } catch (SQLException e) {
                System.out.println("Brak połączenia z bazą danych.");
            }catch (NullPointerException e) {
                writer.println("Active:Disable");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


