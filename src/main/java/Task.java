import java.util.ArrayList;

public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false; //default not done
    }

    public String getStatus() {
        return (isDone ? "✓" : "✗");
    }

    public void markDone() {
        this.isDone = true;
    }

    @Override
    public String toString() {
        return this.description;
    }
}

