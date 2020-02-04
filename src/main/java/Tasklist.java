import java.util.ArrayList;

public class Tasklist {
    public Tasklist(ArrayList<Task> list) {
        this.list = list;
    }

    public int getListSize() {
        return list.size();
    }
}

