package src.network;


import java.io.*;
import java.net.*;

public class LogClient {
    private Socket socket;
    private PrintWriter writer;

    public LogClient(String host, int port) throws IOException {
        this.socket = new Socket(host, port);
        this.writer = new PrintWriter(socket.getOutputStream(), true);
    }

    public void send(String logJson) {
        writer.println(logJson);
    }

    public void close() throws IOException {
        writer.close();
        socket.close();
    }
}
