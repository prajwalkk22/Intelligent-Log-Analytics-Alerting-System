package src;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        String logFile = "logs/sample.log";

        Thread logTailThread = new Thread(() -> {
            try (BufferedReader br = new BufferedReader(new FileReader(logFile))) {
                String line;
                while (true) {
                    if ((line = br.readLine()) != null) {
                        System.out.println("[LOG] " + line);
                    } else {
                        Thread.sleep(1000); // wait if no new line
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        logTailThread.start();
    }
}
