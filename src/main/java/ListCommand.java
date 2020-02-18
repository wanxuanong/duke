package commands;

import tasks.Task;
import storage.Storage;
import ui.Ui;
import tasks.TaskList;
import java.io.IOException;

/**
 * Command that lists all the tasks.
 */
public class ListCommand extends Command {
    @Override
    public String action(TaskList taskList, Storage storage, Ui ui) throws IOException {
        return ui.printList(taskList);
    }
}

