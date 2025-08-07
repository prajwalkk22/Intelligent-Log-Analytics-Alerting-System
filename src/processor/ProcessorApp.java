package src.processor;

import java.io.*;

public class ProcessorApp {
    public static void main(String[] args) throws Exception {
        String filePath = "logs/sample.log";

        LogFilter filter = new LogFilter();
        AlertService alertService = new AlertService();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(">> Reading: " + line);
                ParsedLog parsed = ParsedLog.parse(line);

                if (parsed != null) {
                    System.out.println(">> Parsed: " + parsed);

                    if (filter.isCritical(parsed)) {
                        alertService.raiseAlert(parsed);
                    }
                }
            }
        }
    }
}
