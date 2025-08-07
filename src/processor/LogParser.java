package src.processor;

import java.util.regex.*;

public class LogParser {

    public static ParsedLog parse(String logLine) {
        // Example format: "2025-08-07 18:00:01 INFO Starting service"
        Pattern pattern = Pattern.compile("^(\\S+\\s+\\S+)\\s+(INFO|ERROR|WARN|DEBUG)\\s+(.*)$");
        Matcher matcher = pattern.matcher(logLine);

        if (matcher.find()) {
            return new ParsedLog(
                matcher.group(1),
                matcher.group(2),
                matcher.group(3)
            );
        }

        return null;
    }
}
