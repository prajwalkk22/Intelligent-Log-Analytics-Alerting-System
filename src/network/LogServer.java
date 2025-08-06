package src.network;



import java.io.*;
import java.net.*;

public class LogServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(9090);
        System.out.println("Server listening on port 9090...");

        Socket clientSocket = serverSocket.accept();
        BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println("Received: " + line);
        }

        reader.close();
        clientSocket.close();
        serverSocket.close();
    }
}
