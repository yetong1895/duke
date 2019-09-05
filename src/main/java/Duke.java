import jdk.jfr.Event;
import java.io.File;
import java.util.*;
public class Duke {
    private storage storageObject;
    private ArrayList<task> listOfTasts;
    private TaskList TaskList;
    private int counter = 0;

    public Duke() {
        storageObject = new storage();
        listOfTasts = new ArrayList<task>();
        storageObject.load();
        listOfTasts = storageObject.getListOfTasks();
        counter = storageObject.getCounter();
    }

    public void run() {
        TaskList = new TaskList();
        TaskList.setListOfTasks(listOfTasts);
        TaskList.setCounter(counter);
        TaskList.startTask();
        counter = TaskList.getCounter();
        listOfTasts = TaskList.getListOfTasks();
    }

    public void close() {
        storageObject.setListOfTasks(listOfTasts);
        storageObject.setCounter(counter);
        storageObject.save();
    }

    public static void main(String[] args) {
        Duke Duke = new Duke();
        Duke.run();
        Duke.close();

    }
}
