import java.util.ArrayList;

public class TaskList {
    protected ArrayList<Task> list;

    public TaskList(ArrayList<Task> list) {
        this.list = list;
    }

    public Task getTask(int idx) {
        return list.get(idx);
    }

    public int getListSize() {
        return list.size();
    }

    public
}

