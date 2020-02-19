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

    String inputTimePattern = "HH:mm";
    DateTimeFormatter inputTimeFormatter = DateTimeFormatter.ofPattern(inputTimePattern);

    public Event(String description, String localDate, String localTime) {
        super(description);
        this.localDate = LocalDate.parse(localDate);
        this.localTime = LocalTime.parse(localTime, inputTimeFormatter);
    }


    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " +
                        localDate.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ", " +
                        LocalTime.parse(localTime.toString(), inputTimeFormatter) + ")";
    }

    public String formatText() {
        return "E | " + (this.isDone ? "1" : "0") + " | " + description + " | " +
                        localDate + " | " + localTime + "\n";
    }
}

