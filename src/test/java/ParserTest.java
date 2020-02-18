import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {
    @Test
    public void parserTest() throws DukeException {
        Command c = new ExitCommand();
        //String output = "Bye Parker... I love you 3000 <3";
        assertEquals(c, Parser.parse("bye"));
    }
}
