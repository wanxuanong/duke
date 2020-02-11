import java.io.IOException;

public class FindCommand extends Command {
    protected String key;

    public FindCommand(String key) {
        this.key = key;
    }

    @Override
    public void action(TaskList taskList, Storage storage, Ui ui) throws IOException {
        ui.printMatchList(taskList.findMatching(key));
    }
}

