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
        System.out.println("Hello from\n" + logo + "What can I do for you? xD\n");

        Scanner sc = new Scanner(System.in);
        ArrayList<Task> list = new ArrayList<Task>(100);

        while (true) {
            try {
                String command = sc.nextLine();
                String[] arr = command.split(" ", 2);

                if (command.equals("bye")) {
                    System.out.println("Bye!!! See ya again soon xD");
                    break;
                } else if (command.equals("list")) {
                    System.out.println("Here are the tasks in your list:");
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println((i + 1) + "." + list.get(i).toString());
                    }
                } else if (command.equals("todo") || command.equals("deadline") || command.equals("event")) {
                    throw new DukeException("☹ OOPS!!! The description of a " + command + " cannot be empty.");

                } else {
                    Task t = new Task(command);
                    if ((arr[0]).equals("done")) {
                        int i = Integer.parseInt(arr[1]);
                        list.get(i - 1).markDone();
                        System.out.println("Nice! I've marked this as done:");
                        System.out.println("  " + list.get(i - 1).toString());

                    } else if ((arr[0]).equals("delete")) {
                        int i = Integer.parseInt(arr[1]);
                        Task d = list.get(i - 1);
                        list.remove(d);
                        System.out.println("Noted. I've removed this task:\n" + "  " + d.toString() + "\n" + "Now you have "
                                        + list.size() + " tasks in the list.");

                    } else if ((arr[0]).equals("todo")) {
                        Task t1 = new Todo(arr[1]);
                        list.add(t1);
                        System.out.println("Got it. I've added this task:\n" + "  " + t1.toString());
                        System.out.println("Now you have " + list.size() + " tasks in the list.");

                    } else if ((arr[0].equals("deadline"))) {
                        String[] byArr = arr[1].split("/by ");
                        Task t2 = new Deadline(byArr[0], byArr[1]);
                        list.add(t2);
                        System.out.println("Got it. I've added this task:\n" + "  " + t2.toString());
                        System.out.println("Now you have " + list.size() + " tasks in the list.");

                    } else if ((arr[0].equals("event"))) {
                        String[] atArr = arr[1].split("/at");
                        Task t3 = new Event(atArr[0], atArr[1]);
                        list.add(t3);
                        System.out.println("Got it. I've added this task:\n" + "  " + t3.toString());
                        System.out.println("Now you have " + list.size() + " tasks in the list.");
                    } else {
                        throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                    }
                }
            }
            catch(DukeException m) {
                System.out.println(m.getMessage());
            }
        }
    }
}