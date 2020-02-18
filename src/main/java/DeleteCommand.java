package commands;

import tasks.Task;
import storage.Storage;
import ui.Ui;
import tasks.TaskList;
import java.io.IOException;

/**
 * Command that deletes a task from TaskList.
 */
public class DeleteCommand extends Command {
    protected int idx;
    public DeleteCommand(int idx) {
        this.idx = idx;
    }

    @Override
    public String action(TaskList taskList, Storage storage, Ui ui) throws IOException {
        Task task = taskList.getTask(idx - 1);
        taskList.deleteTask(task);
        storage.writeNew(taskList);
        return ui.printDeletedTask(task, taskList);
    }
}

