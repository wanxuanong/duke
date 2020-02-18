package commands;

import tasks.Task;
import storage.Storage;
import ui.Ui;
import tasks.TaskList;
import java.io.IOException;

/**
 * Command that marks a task as done with a tick.
 */
public class DoneCommand extends Command {
    protected int idx;
    public DoneCommand(int idx) {
        this.idx = idx;
    }

    @Override
    public String action(TaskList taskList, Storage storage, Ui ui) throws IOException {
        Task task = taskList.getTask(idx - 1);
        task.markDone();
        storage.writeNew(taskList);
        return ui.printDoneTask(task);
    }
}

