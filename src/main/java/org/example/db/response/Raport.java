package org.example.db.response;

import org.example.db.response.abstractResponse.AbstractRaport;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Raport extends AbstractRaport {

    public Raport(Socket socket) {
        super(socket);
    }

    @Override
    public void raport(String text) {
        try (PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {
                    String[] parts = text.split(":");
                    System.out.println("Message: " + parts[1]);
                    writer.println("Dziękujemy za przesłanie wiadmości o błędzie.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
