import java.util.ArrayList;

public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false; //default not done
    }

    /**
     * Returns the status of the task. Depends on whether task isDone = true.
     * @return tick or cross
     */
    public String getStatus() { return (isDone ? "✓" : "✗");
    }

    public void markDone() {
        this.isDone = true;
    }

    @Override
    public String toString() {
        return "[" + getStatus() + "] " + description;
    }

    public String formatText() {
        return "X | " + (this.isDone ? "1" : "0") + " | " + description;
    }
}

