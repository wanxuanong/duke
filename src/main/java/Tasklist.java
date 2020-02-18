package tasks;

import java.lang.reflect.Array;
import java.util.ArrayList;

// contains the task list e.g., it has operations to add/delete tasks in the list
public class TaskList {
    public ArrayList<Task> list;

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

    public TaskList doneSpecificTasks(ArrayList<Integer> idxList) {
        ArrayList<Task> doneList = new ArrayList<>();
        for (int i = 0; i < idxList.size(); i++) {
            getTask(idxList.get(i) - 1).markDone();
            doneList.add(getTask(idxList.get(i) - 1));
        }
        return new TaskList(doneList);
    }

    public TaskList findMatching(String key) {
        ArrayList<Task> results = new ArrayList<Task>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains(key)) {
                results.add(list.get(i));
            }
        }
        return new TaskList(results);
    }
}

