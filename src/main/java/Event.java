package tasks;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class Event extends Task {
    protected LocalDate localDate;
    public Event(String description, String localDate) {
        super(description);
        this.localDate = LocalDate.parse(localDate);
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + "(at: " + localDate.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ")";
    }

    public String formatText() {
        return "E | " + (this.isDone ? "1" : "0") + " | " + description + " | " +
                        localDate + "\n";
    }
}

