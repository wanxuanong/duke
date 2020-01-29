import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Integer.*;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo + "What can I do for you?\n");

        Scanner sc = new Scanner(System.in);
        ArrayList<Task> list = new ArrayList<Task>();

        while (true) {
            String command = sc.nextLine();
            String[] arr = command.split(" ");

            if (command.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            } else if (command.equals("list")) {
                System.out.println("Here are the tasks in your list:");
                for (int i = 0; i < list.size(); i++) {
                    System.out.println((i + 1) + ".[" + list.get(i).getStatus() + "] " + list.get(i));
                }
            } else {
                Task t = new Task(command);
                if ((arr[0]).equals("done")) {
                    int i = Integer.parseInt(arr[1]);
                    list.get(i-1).markDone();
                    System.out.println("Nice! I've marked this as done:");
                    System.out.println("  [" + list.get(i - 1).getStatus() + "] " + list.get(i - 1));
                } else {
                    list.add(t);
                    System.out.println("added: " + command);
                }
            }
        }
    }
}