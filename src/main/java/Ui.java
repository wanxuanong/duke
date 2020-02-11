import java.util.Scanner;

// deals with interactions with the user
public class Ui {
    public Ui() {
    }

    public String input() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public void intro() {
        String intro = "Hello friend. What can I do for you? xD";
        System.out.println(intro);
    }

    public void exit() {
        String exit = "Bye!!! See ya again soon xD";
        System.out.println(exit);
    }

    public void printList(TaskList taskList) {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < taskList.getListSize(); i++) {
            System.out.println((i + 1) + "." + taskList.getTask(i).toString());
        }
    }

    public void printMatchList(TaskList taskList) {
        System.out.println("Here are the search results:");
        for (int i = 0; i < taskList.getListSize(); i++) {
            System.out.println((i + 1) + "." + taskList.getTask(i).toString());
        }
    }

    public void printDoneTask(Task task) {
        System.out.println("Nice! I've marked this as done:" + "\n  " + task.toString());
    }

    public void printDeletedTask(Task task, TaskList taskList) {
        System.out.println("Noted. I've removed this task:\n  " + task.toString() + "\n" +
                "Now you have " + taskList.getListSize() + " tasks in the list.");
    }

    public void printAddedTask(Task task, TaskList taskList) {
        System.out.println("Got it. I've added this task:\n  " + task.toString() + "\n" +
                "Now you have " + taskList.getListSize() + " tasks in the list.");
    }

    public void printFileNotFoundError() {
        System.out.println("File not found...");
    }

    public void printError(String msg) {
        System.out.println(msg);
    }
}

