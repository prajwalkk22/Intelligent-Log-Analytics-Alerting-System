package src.processor;

public class LogFilter {

    public boolean isCritical(ParsedLog log) {
        return log.getLevel().equals("ERROR") || log.getLevel().equals("WARN");
    }
}
