package src.processor;

public class ParsedLog {
    private String timestamp;
    private String level;
    private String message;

    public ParsedLog(String timestamp, String level, String message) {
        this.timestamp = timestamp;
        this.level = level;
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }

    // Static method to parse a raw log line into ParsedLog object
    public static ParsedLog parse(String line) {
        // Example line: "2025-08-07 18:01:02 ERROR Unable to connect to database"
        String[] parts = line.split(" ", 4); // Split into 4 parts

        if (parts.length < 4) return null;

        String timestamp = parts[0] + " " + parts[1];
        String level = parts[2];
        String message = parts[3];

        return new ParsedLog(timestamp, level, message);
    }

    @Override
    public String toString() {
        return "[" + timestamp + "] " + level + " - " + message;
    }
}
