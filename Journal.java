import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Journal implements Serializable {
    private List<JournalEntry> entries;

    public Journal() {
        this.entries = new ArrayList<>();
    }

    public void logOperation(String operation, String details) {
        entries.add(new JournalEntry(operation, details));
    }

    public void printJournal() {
        System.out.println("Journal:");
        for (JournalEntry entry : entries) {
            System.out.println(entry);
        }
    }
}

class JournalEntry implements Serializable {
    private String operation;
    private String details;
    private long timestamp;

    public JournalEntry(String operation, String details) {
        this.operation = operation;
        this.details = details;
        this.timestamp = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return "Operation: " + operation + ", Details: " + details + ", Timestamp: " + new Date(timestamp);
    }
}
