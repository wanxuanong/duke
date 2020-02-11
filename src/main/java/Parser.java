// deals with making sense of the user command
public class Parser {
    public static Command parse(String input) throws DukeException {
        String[] inputArr = input.split(" ", 2);
        String type = inputArr[0];
        switch(type) {
            case "bye":
                return new ExitCommand();

            case "list":
                return new ListCommand();

            case "done":
                int i = Integer.parseInt(inputArr[1]);
                return new DoneCommand(i);

            case "delete":
                int j = Integer.parseInt(inputArr[1]);
                return new DeleteCommand(j);

            case "todo":
                if (inputArr.length != 1) {
                    return new AddCommand(new Todo(inputArr[1]));
                } else {
                    throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.");
                }

            case "deadline":
                if (inputArr.length != 1) {
                    String[] byArr = inputArr[1].split("/by ");
                    return new AddCommand(new Deadline(byArr[0], byArr[1]));
                } else {
                    throw new DukeException("☹ OOPS!!! The description of a deadline cannot be empty.");
                }

            case "event":
                if (inputArr.length != 1) {
                    String[] atArr = inputArr[1].split("/at ");
                    return new AddCommand(new Event(atArr[0], atArr[1]));
                } else {
                    throw new DukeException("☹ OOPS!!! The description of an event cannot be empty.");
                }

            case "find":
                if (inputArr.length != 1) {
                    String key = inputArr[1];
                    return new FindCommand(key);
                } else {
                    throw new DukeException("☹ OOPS!!! The description of a find cannot be empty.");
                }

            default:
                throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
        }
    }
}

