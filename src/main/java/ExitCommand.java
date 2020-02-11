import java.io.IOException;

public class ExitCommand extends Command {
    @Override
    public boolean isExit() {
        return true;
    }

    @Override
    public void action(TaskList taskList, Storage storage, Ui ui) throws IOException {
        ui.exit();
    }
}
