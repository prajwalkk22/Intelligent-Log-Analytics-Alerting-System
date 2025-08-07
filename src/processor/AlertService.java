package src.processor;

public class AlertService {

    public void raiseAlert(ParsedLog log) {
        System.out.println("🚨 ALERT: " + log.getLevel() + " - " + log.getMessage());
        // You can later expand this to send emails, Slack, SMS, etc.
    }
}
