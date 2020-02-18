import java.io.IOException;
import java.util.ArrayList;

public class DoneSomeCommand extends Command {
    private ArrayList<Integer> idxList;

    public DoneSomeCommand(ArrayList<Integer> idxList) {
        this.idxList = idxList;
    }

    @Override
    public String action(TaskList taskList, Storage storage, Ui ui) throws IOException {
        taskList.doneSpecificTasks(idxList);
        storage.writeNew(taskList);
        return ui.printSpecificDoneTasks(taskList.doneSpecificTasks(idxList));
    }
}

