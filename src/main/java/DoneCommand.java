import java.io.IOException;

public class DoneCommand extends Command {
    protected int idx;
    public DoneCommand(int idx) {
        this.idx = idx;
    }

    @Override
    public void action(TaskList taskList, Storage storage, Ui ui) throws IOException {
        Task task = taskList.getTask(idx - 1);
        task.markDone();
        storage.writeNew(taskList);
        ui.printDoneTask(task);
    }
}

