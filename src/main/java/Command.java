package commands;

import tasks.Task;
import storage.Storage;
import ui.Ui;
import tasks.TaskList;
import java.io.IOException;

import java.io.IOException;

public class Command {

    public boolean isExit() {
        return false;
    }

    public String action(TaskList taskList, Storage storage, Ui ui) throws IOException {
        return "";
    }
}

