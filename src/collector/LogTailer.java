package src.collector;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class LogTailer {
    private File logFile;

    public LogTailer(String path) {
        this.logFile = new File(path);
    }

    public void startTailing() throws IOException {
        try (RandomAccessFile file = new RandomAccessFile(logFile, "r")) {
            System.out.println("🚀 Tailing started on: " + logFile.getAbsolutePath());
            file.seek(logFile.length()); // Start at the end of the file

            while (true) {
                String line = file.readLine();
                if (line != null) {
                    System.out.println("📥 New log: " + line);
                } else {
                    try {
                        Thread.sleep(1000); // wait for new logs
                    } catch (InterruptedException ignored) {}
                }
            }
        }
    }
}
