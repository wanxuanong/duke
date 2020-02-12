import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Duke extends Application {
    private TaskList taskList;
    private Storage storage;
    private Ui ui;
    static String path = "data/tasks.txt";

    public Duke() {}

    public Duke(String path) throws IOException {
        this.ui = new Ui();
        this.storage = new Storage(path);
        try {
            this.taskList = new TaskList(storage.loadFile());
        } catch (IOException e) {
            ui.printFileNotFoundError();
            taskList = new TaskList();
        }
    }

    public void run() {
        ui.intro();
        boolean isExit = false; //default
        while (!isExit) {
            try {
                String input = ui.input();
                Command command = Parser.parse(input);
                command.action(taskList, storage, ui);
                isExit = command.isExit();
            } catch (DukeException m) {
                ui.printError(m.getMessage());
            } catch (IOException e) {
                ui.printFileNotFoundError();
            }
        }
    }

    public static void main(String[] args) throws IOException, DukeException {
        new Duke(path).run();
    }

    @Override
    public void start(Stage stage) {
        Label helloWorld = new Label("Hello World!"); // Creating a new Label control
        Scene scene = new Scene(helloWorld); // Setting the scene to be our Label

        stage.setScene(scene); // Setting the stage to show our screen
        stage.show(); // Render the stage.
    }

}