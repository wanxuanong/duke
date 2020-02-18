package commands;

import tasks.Task;
import storage.Storage;
import ui.Ui;
import tasks.TaskList;
import java.io.IOException;

/**
 * Command that closes Duke with a message.
 */
public class ExitCommand extends Command {
    @Override
    public boolean isExit() {
        return true;
    }

    @Override
    public String action(TaskList taskList, Storage storage, Ui ui) throws IOException {
        return ui.exit();
    }
}
