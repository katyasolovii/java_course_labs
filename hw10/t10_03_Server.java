package hw10;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class t10_03_Server {
public static void main(String[] args) throws IOException {
        int port = 14110;

        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server running on " + server.getLocalSocketAddress());
            while (true) {
                Socket conn = server.accept();
                System.out.println("Client connected: " + conn.getRemoteSocketAddress());

                var reader = new BufferedReader(
                        new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
                var writer = new PrintStream(conn.getOutputStream(), true, StandardCharsets.UTF_8);

                String msg;
                while ((msg = reader.readLine()) != null) {
                    System.out.println("Received: " + msg);

                    StringBuilder digits = new StringBuilder();
                    for (int i = 0; i < msg.length(); i++) {
                        char c = msg.charAt(i);
                        if (Character.isDigit(c)) {
                            digits.append(c);
                        }
                    }

                    String response = digits.toString();
                    writer.println(response);
                    System.out.println("Sent: " + response);
                }

                conn.close();
                System.out.println("Client disconnected: " + conn.getRemoteSocketAddress());
            }
        }
    }
}
