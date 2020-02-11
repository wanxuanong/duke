import java.io.IOException;

public class ListCommand extends Command {
    @Override
    public void action(TaskList taskList, Storage storage, Ui ui) throws IOException {
        ui.printList(taskList);
    }
}

