package parser;

import commands.*;
import tasks.*;
import exceptions.DukeException;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Parser deals with making sense of the user inputs.
 */
public class Parser {
    /**
     * Parses the user input and tag it to the respective command.
     * @param  input User input.
     * @return Appropriate command that executes the input.
     * @throws DukeException thrown when input is unknown to Duke.
     */
    public static Command parse(String input) throws DukeException {
        assert input.length() != 0 : "Error: User input not found.";
        String[] inputArray = input.split(" ", 2);
        String type = inputArray[0];
        switch(type) {
            case "bye":
                return new ExitCommand();

            case "list":
                return new ListCommand();

            case "done":
                if (inputArray.length !=1) {
                    if (isNumber(inputArray[1])) {
                        int i = Integer.parseInt(inputArray[1]);
                        return new DoneCommand(i);
                    } else {
                        ArrayList<Integer> idxList = new ArrayList<>();
                        String[] idxArray = inputArray[1].split(" ");
                        for (String id : idxArray) {
                            int idx = Integer.parseInt(id);
                            idxList.add(idx);
                        }
                        return new DoneSomeCommand(idxList);
                    }
                } else {
                    throw new DukeException("Parker! Try: done {INDEX} or done {INDEX1 INDEX2 ...}");
                }

            case "delete":
                if (inputArray.length != 1) {
                    int j = Integer.parseInt(inputArray[1]);
                    return new DeleteCommand(j);
                } else {
                    throw new DukeException("Parker.. Try: delete {INDEX}");
                }

            case "todo":
                if (inputArray.length != 1) {
                    return new AddCommand(new Todo(inputArray[1]));
                } else {
                    throw new DukeException("Parker.. Try: todo {DESCRIPTION}");
                }

            case "deadline":
                if (inputArray.length != 1) {
                    String[] byArray = inputArray[1].split("/by ");
                    return new AddCommand(new Deadline(byArray[0], byArray[1]));
                } else {
                    throw new DukeException("Parker.. Try: deadline {DESCRIPTION} /by YYYY-MM-DD");
                }

            case "event":
                if (inputArray.length != 1) {
                    String[] atArray = inputArray[1].split("/at ");
                    String[] dateTimeArray = atArray[1].split(" ");
                    return new AddCommand(new Event(atArray[0], dateTimeArray[0], dateTimeArray[1]));
                } else {
                    throw new DukeException("Parker.. Try: event {DESCRIPTION} /at YYYY-MM-DD HHmm");
                }

            case "find":
                if (inputArray.length != 1) {
                    String key = inputArray[1];
                    return new FindCommand(key);
                } else {
                    throw new DukeException("Parker.. Try: find {KEYWORD}");
                }

            default:
                throw new DukeException("You are not making sense, Parker!!! >:(");
        }
    }

    /**
     * Returns whether the String is an Integer.
     * @param s Input string.
     * @return true if Integer, false if not.
     */
    public static boolean isNumber(String s) {
        if (s == null) {
            return false;
        }
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

