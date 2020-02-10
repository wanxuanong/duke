import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Integer.*;

public class Duke {
    static ArrayList<Task> list = new ArrayList<Task>(100);

    public static void main(String[] args) throws IOException {
        System.out.println("Hello friend. What can I do for you? xD\n");
        Scanner sc = new Scanner(System.in);
        String path = "/Users/ongwanxuan/duke/src/main/java/tasks.txt";
        File file = new File("/Users/ongwanxuan/duke/src/main/java/tasks.txt");
        boolean exists = file.exists();

        if (!exists) {
            PrintWriter pw = new PrintWriter("tasks.txt", "UTF-8");
            pw.println("");
        } else {
            try {
                fileContents(path, list);
            } catch (IOException e) {
                System.out.println("File not found!!!");
            }
        }
        while (sc.hasNextLine()) {
            try {
                String command = sc.nextLine();
                String[] commandArr = command.split(" ", 2);

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
                    if ((commandArr[0]).equals("done")) {
                        int i = Integer.parseInt(commandArr[1]);
                        list.get(i - 1).markDone();
                        System.out.println("Nice! I've marked this as done:" + "\n  " + list.get(i - 1).toString());
                        writeNew(path, list);

                    } else if ((commandArr[0]).equals("delete")) {
                        int i = Integer.parseInt(commandArr[1]);
                        Task d = list.get(i - 1);
                        list.remove(d);
                        System.out.println("Noted. I've removed this task:\n  " + d.toString() + "\n" +
                                "Now you have " + list.size() + " tasks in the list.");
                        writeNew(path, list);

                    } else if ((commandArr[0]).equals("todo")) {
                        Task t1 = new Todo(commandArr[1]);
                        list.add(t1);
                        System.out.println("Got it. I've added this task:\n  " + t1.toString() + "\n" +
                                "Now you have " + list.size() + " tasks in the list.");
                        writeToOld(path, t1.formatText());

                    } else if ((commandArr[0].equals("deadline"))) {
                        String[] byArr = commandArr[1].split("/by ");
                        Task t2 = new Deadline(byArr[0], byArr[1]);
                        list.add(t2);
                        System.out.println("Got it. I've added this task:\n" + "  " + t2.toString() + "\n" +
                                "Now you have " + list.size() + " tasks in the list.");
                        writeToOld(path, t2.formatText());

                    } else if ((commandArr[0].equals("event"))) {
                        String[] atArr = commandArr[1].split("/at");
                        Task t3 = new Event(atArr[0], atArr[1]);
                        list.add(t3);
                        System.out.println("Got it. I've added this task:\n" + "  " + t3.toString() + "\n" +
                                "Now you have " + list.size() + " tasks in the list.");
                        writeToOld(path, t3.formatText());
                    } else {
                        throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                    }
                }
            } catch (DukeException m) {
                System.out.println(m.getMessage());
            } catch (IOException e) {
                System.out.println("File not found...");
            }
        }

    }
    public static void fileContents(String path, ArrayList<Task> list) throws IOException {
        File f = new File(path); //create a file for the given file path
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
    }

    public static void writeNew(String path, ArrayList<Task> list) throws IOException {
        FileWriter fw = new FileWriter(path);
        for (Task task : list) {
            fw.write(task.formatText());
        }
        fw.close();
    }

    public static void writeToOld(String path, String newText) throws IOException {
        FileWriter fw = new FileWriter(path, true);
        fw.write(newText);
        fw.close();
    }
}
