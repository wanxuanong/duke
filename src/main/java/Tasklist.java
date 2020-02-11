import java.util.ArrayList;

// contains the task list e.g., it has operations to add/delete tasks in the list
public class TaskList {
    protected ArrayList<Task> list;

    public TaskList() {
        this.list = new ArrayList<Task>();
    }
    public TaskList(ArrayList<Task> list) {
        this.list = list;
    }

    public Task getTask(int idx) {
        return list.get(idx);
    }

    public int getListSize() {
        return list.size();
    }

    public void addTask(Task task) {
        list.add(task);
    }

    public void deleteTask(Task task) {
        list.remove(task);
    }
}

