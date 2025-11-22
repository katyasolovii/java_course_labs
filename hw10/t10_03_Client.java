package hw10;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class t10_03_Client {
    public static void main(String[] args) throws IOException {
        int port = 14110;
        String host = "localhost";

        String fileInp = "hw10/input.txt";
        String fileOut = "hw10/output.txt";

        Socket sock = new Socket(host, port);
        System.out.println("Connected to: " + sock.getRemoteSocketAddress());

        var reader = new BufferedReader(
                new InputStreamReader(sock.getInputStream(), StandardCharsets.UTF_8));
        var writer = new PrintStream(sock.getOutputStream(), true, StandardCharsets.UTF_8);

        var fInp = new BufferedReader(new FileReader(fileInp, StandardCharsets.UTF_8));
        var fOut = new BufferedWriter(new FileWriter(fileOut, StandardCharsets.UTF_8));

        String msg;
        while ((msg = fInp.readLine()) != null) {
            writer.println(msg);
            System.out.println("Sent: " + msg);

            String response = reader.readLine();
            System.out.println("Received: " + response);
            fOut.write(response + "\n");
        }

        fInp.close();
        fOut.close();
        sock.close();
        System.out.println("Disconnected from: " + sock.getRemoteSocketAddress());
    }
}