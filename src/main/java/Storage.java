package storage;

import tasks.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Storage deals with loading tasks from the file and saving tasks in the file.
 */

public class Storage {
    protected String path;

    public Storage(String path) {
        this.path = path;
    }

    /**
     * Loads contents in text file into TaskList.
     * @return TaskList for Duke.
     * @throws IOException thrown when error encountered.
     */
    public ArrayList<Task> loadFile() throws IOException {
        File f = new File(path); //create a file for the given file path
        ArrayList<Task> list = new ArrayList<Task>();
        Scanner sc = new Scanner(f);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            String[] arr = s.split(" [|] ");
            String type = arr[0];
            switch(type) {
                case "T":
                    Todo t1 = new Todo(arr[2]);
                    if (arr[1].equals("1")) {
                        t1.markDone();
                    }
                    list.add(t1);
                    break;

                case "D":
                    Deadline d1 = new Deadline(arr[2], arr[3]);
                    if (arr[1].equals("1")) {
                        d1.markDone();
                    }
                    list.add(d1);
                    break;

                case "E":
                    Event e1 = new Event(arr[2], arr[3]);
                    if (arr[1].equals("1")) {
                        e1.markDone();
                    }
                    list.add(e1);
                    break;

                default:
                    break;
            }
        }
        return list;
    }

    /**
     * Writes a new ArrayList of tasks.
     * @param taskList List of tasks for Duke.
     * @throws IOException thrown when error is encountered.
     */
    public void writeNew(TaskList taskList) throws IOException {
        FileWriter fw = new FileWriter(path);
        for (Task task : taskList.list) {
            fw.write(task.formatText());
        }
        fw.close();
    }

    /**
     * Writes to the old ArrayList of tasks.
     * @param newText New task added.
     * @throws IOException thrown when error is encountered.
     */
    public void writeToOld(String newText) throws IOException {
        FileWriter fw = new FileWriter(path, true);
        fw.write(newText);
        fw.close();
    }
}

