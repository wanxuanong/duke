package ui;

import tasks.Task;
import tasks.TaskList;

import java.util.Scanner;

/**
 * Ui deals with interactions with the user.
 */
public class Ui {
    public Ui() {
    }

    public String input() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public String intro() {
        String intro = "Nice to see you, Parker! What do you need?";
        return intro;
    }

    public String exit() {
        String exit = "Bye Parker... I love you 3000 <3";
        return exit;
    }

    public String printList(TaskList taskList) {
        String msg = "Here are your tasks in the Spiderverse: \n";
        for (int i = 0; i < taskList.getListSize(); i++) {
            msg += (i + 1) + "." + taskList.getTask(i).toString() + "\n";
        }
        return msg;
    }

    /**
     * Displays list of tasks that contains keyword.
     * @param taskList resulting TaskList
     * @return resulting TaskList in string
     */
    public String printMatchList(TaskList taskList) {
        String msg = "Here are the search results: \n";
        for (int i = 0; i < taskList.getListSize(); i++) {
            msg += (i + 1) + "." + taskList.getTask(i).toString() + "\n";
        }
        return msg;
    }

    public String printDoneTask(Task task) {
        return "Well done! I've marked this as done:" + "\n" + task.toString();
    }

    public String printSpecificDoneTasks(TaskList taskList) {
        String msg = "Well done! I've marked these tasks as done:\n";
        for (int i = 0; i < taskList.getListSize(); i++) {
            msg += (i + 1) + "." + taskList.getTask(i).toString() + "\n";
        }
        return msg;
    }

    public String printDeletedTask(Task task, TaskList taskList) {
        return "Noted! I've removed this task:\n  " + task.toString() + "\n" +
                "Now you have " + taskList.getListSize() + " tasks in the Spiderverse.";
    }

    public String printAddedTask(Task task, TaskList taskList) {
        return "Got it. I've added this task:\n  " + task.toString() + "\n" +
                "Now you have " + taskList.getListSize() + " tasks in the Spiderverse.";
    }

    public String printFileNotFoundError() {
        return "File not found in this Spiderverse...";
    }

    /**
     * Displays message when an error is encountered.
     * @param msg Error message.
     * @return Error message.
     */
    public String printError(String msg) {
        return msg;
    }
}

