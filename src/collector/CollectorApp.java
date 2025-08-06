package src.collector;

public class CollectorApp {
    public static void main(String[] args) {
        String logFilePath = "logs/sample.log";  // Or "/var/log/syslog" in future

        LogTailer tailer = new LogTailer(logFilePath);
        try {
            tailer.startTailing();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
