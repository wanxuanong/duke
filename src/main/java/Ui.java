import java.util.Scanner;

// deals with interactions with the user
public class Ui {
    public Ui() {
    }

    public String input() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public String intro() {
        String intro = "Hello Squarepants! What can I do for you? xD";
        return intro;
    }

    public String exit() {
        String exit = "Bye Squarepants! See ya again soon xD";
        return exit;
    }

    public String printList(TaskList taskList) {
        String msg = "Here are the tasks in your list: \n";
        for (int i = 0; i < taskList.getListSize(); i++) {
            msg += (i + 1) + "." + taskList.getTask(i).toString() + "\n";
        }
        return msg;
    }

    public String printMatchList(TaskList taskList) {
        String msg = "Here are the search results: \n";
        for (int i = 0; i < taskList.getListSize(); i++) {
            msg += (i + 1) + "." + taskList.getTask(i).toString() + "\n";
        }
        return msg;
    }

    public String printDoneTask(Task task) {
        return "Nice! I've marked this as done:" + "\n  " + task.toString();
    }

    public String printDeletedTask(Task task, TaskList taskList) {
        return "Noted. I've removed this task:\n  " + task.toString() + "\n" +
                "Now you have " + taskList.getListSize() + " tasks in the list.";
    }

    public String printAddedTask(Task task, TaskList taskList) {
        return "Got it. I've added this task:\n  " + task.toString() + "\n" +
                "Now you have " + taskList.getListSize() + " tasks in the list.";
    }

    public String printFileNotFoundError() {
        return "File not found under the sea...";
    }

    public String printError(String msg) {
        return msg;
    }
}

