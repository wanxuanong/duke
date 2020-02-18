package tasks;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * TaskList contains the list of tasks.
 */
public class TaskList {
    public ArrayList<Task> list;

    public TaskList() {
        this.list = new ArrayList<Task>();
    }
    public TaskList(ArrayList<Task> list) {
        this.list = list;
    }

    /**
     * Returns specific task required.
     * @param idx Index of task.
     * @return Required task.
     */
    public Task getTask(int idx) {
        return list.get(idx);
    }

    /**
     * Returns number of tasks in list.
     * @return size of list.
     */
    public int getListSize() {
        return list.size();
    }

    public void addTask(Task task) {
        list.add(task);
    }

    public void deleteTask(Task task) {
        list.remove(task);
    }

    /**
     * Marks a few specified tasks as done.
     * @param idxList List of indices of the tasks.
     * @return TaskList consisting of the tasks marked done.
     */
    public TaskList doneSpecificTasks(ArrayList<Integer> idxList) {
        ArrayList<Task> doneList = new ArrayList<>();
        for (int i = 0; i < idxList.size(); i++) {
            getTask(idxList.get(i) - 1).markDone();
            doneList.add(getTask(idxList.get(i) - 1));
        }
        return new TaskList(doneList);
    }

    /**
     * Finds tasks consisting of keyword.
     * @param key Keyword.
     * @return TaskList consisting of tasks that has the keyword.
     */
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

