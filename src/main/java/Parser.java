package parser;

import commands.*;
import tasks.*;
import exceptions.DukeException;

import java.util.ArrayList;
import java.util.Collections;

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
                if (inputArr.length !=1) {
                    if (isNumber(inputArr[1])) {
                        int i = Integer.parseInt(inputArr[1]);
                        return new DoneCommand(i);
                    } else {
                        ArrayList<Integer> idxList = new ArrayList<>();
                        String[] idxArr = inputArr[1].split(" ");
                        for (String id : idxArr) {
                            int idx = Integer.parseInt(id);
                            idxList.add(idx);
                        }
                        return new DoneSomeCommand(idxList);
                    }
                } else {
                    throw new DukeException("Parker! Try: done {INDEX} or done {INDEX1 INDEX2 ...}");
                }

            case "delete":
                if (inputArr.length != 1) {
                    int j = Integer.parseInt(inputArr[1]);
                    return new DeleteCommand(j);
                } else {
                    throw new DukeException("Parker.. Try: delete {INDEX}");
                }

            case "todo":
                if (inputArr.length != 1) {
                    return new AddCommand(new Todo(inputArr[1]));
                } else {
                    throw new DukeException("Parker.. Try: todo {DESCRIPTION}");
                }

            case "deadline":
                if (inputArr.length != 1) {
                    String[] byArr = inputArr[1].split("/by ");
                    return new AddCommand(new Deadline(byArr[0], byArr[1]));
                } else {
                    throw new DukeException("Parker.. Try: deadline {DESCRIPTION} /by YYYY-MM-DD");
                }

            case "event":
                if (inputArr.length != 1) {
                    String[] atArr = inputArr[1].split("/at ");
                    return new AddCommand(new Event(atArr[0], atArr[1]));
                } else {
                    throw new DukeException("Parker.. Try: event {DESCRIPTION} /at YYYY-MM-DD");
                }

            case "find":
                if (inputArr.length != 1) {
                    String key = inputArr[1];
                    return new FindCommand(key);
                } else {
                    throw new DukeException("Parker.. Try: find {KEYWORD}");
                }

            default:
                throw new DukeException("You are not making sense, Parker!!! >:(");
        }
    }

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

