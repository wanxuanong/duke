import java.io.IOException;

public class DeleteCommand extends Command {
    protected int idx;
    public DeleteCommand(int idx) {
        this.idx = idx;
    }

    @Override
    public void action(TaskList taskList, Storage storage, Ui ui) throws IOException {
        Task task = taskList.getTask(idx - 1);
        taskList.deleteTask(task);
        storage.writeNew(taskList);
        ui.printDeletedTask(task, taskList);
    }
}

