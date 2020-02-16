import java.io.IOException;

public class AddCommand extends Command {
    protected Task task;
    public AddCommand(Task task) {
        this.task = task;
    }

    @Override
    public String action(TaskList taskList, Storage storage, Ui ui) throws IOException {
        taskList.addTask(task);
        storage.writeToOld(task.formatText());
        return ui.printAddedTask(task, taskList);
    }
}

