package src.collector;

public class CollectorApp {
    public static void main(String[] args) {
        String logFilePath = "logs/sample.log";

        LogTailer tailer = new LogTailer(logFilePath);
        try {
            System.out.println("Starting log collector daemon...");
            while (true) {
                tailer.startTailing();  // Tail in intervals or as a thread
                Thread.sleep(10000);    // Sleep to simulate continuous background operation
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
