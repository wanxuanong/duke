package tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalTime;
import java.time.LocalDate;

/**
 * An Event Task that takes in date and time.
 */
public class Event extends Task {
    protected LocalDate localDate;
    protected LocalTime localTime;

    public Event(String description, String localDate, String localTime) {
        super(description);
        this.localDate = LocalDate.parse(localDate);
        this.localTime = LocalTime.parse(localTime);
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + "(at: " +
                        localDate.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ", " +
                        localTime.format(DateTimeFormatter.ofPattern("h:mma")) + ")";
    }

    public String formatText() {
        return "E | " + (this.isDone ? "1" : "0") + " | " + description + " | " +
                        localDate + ", " + localTime + "\n";
    }
}

