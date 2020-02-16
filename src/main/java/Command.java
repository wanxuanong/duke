import java.io.IOException;

public class Command {

    public boolean isExit() {
        return false;
    }

    public String action(TaskList taskList, Storage storage, Ui ui) throws IOException {
        return "";
    }
}

