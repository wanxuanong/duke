import java.io.IOException;

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
