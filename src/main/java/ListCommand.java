import java.io.IOException;

public class ListCommand extends Command {
    @Override
    public String action(TaskList taskList, Storage storage, Ui ui) throws IOException {
        return ui.printList(taskList);
    }
}

