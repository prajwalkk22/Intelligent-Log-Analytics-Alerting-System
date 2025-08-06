package src.processor;

import java.util.HashMap;
import java.util.Map;

public class LogParser {
    public static Map<String, String> parse(String line) {
        Map<String, String> logEntry = new HashMap<>();
        if (line.contains(":")) {
            String[] parts = line.split(":", 2);
            logEntry.put("level", parts[0].trim());
            logEntry.put("message", parts[1].trim());
        } else {
            logEntry.put("level", "Unknown");
            logEntry.put("message", line);
        }
        return logEntry;
    }
}
