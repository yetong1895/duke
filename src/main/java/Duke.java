import jdk.jfr.Event;
import java.io.File;
import java.util.*;
public class Duke {
    private storage storageObject;
    private ArrayList<task> listOfTasts;
    private TaskList TaskList;
    private int counter = 0;

    /**
     * This method will initialise the objects and load the data from the save file.
     */
    public Duke() {
        storageObject = new storage();
        listOfTasts = new ArrayList<task>();
        storageObject.load();
        listOfTasts = storageObject.getListOfTasks();
        counter = storageObject.getCounter();
    }

    /**
     * This method will initialise the tasklist and run the program
     * it will pass in the information that was obtained from the save data and pass to
     * the TaskList object.
     */
    public void run() {
        TaskList = new TaskList();
        TaskList.setListOfTasks(listOfTasts);
        TaskList.setCounter(counter);
        TaskList.startTask();
        counter = TaskList.getCounter();
        listOfTasts = TaskList.getListOfTasks();
    }

    /**
     * This method will save the userinputs into the save file and terminate the program.
     */
    public void close() {
        storageObject.setListOfTasks(listOfTasts);
        storageObject.setCounter(counter);
        storageObject.save();
    }

    /**
     * This method will start the program and close the program when the user is done.
     * @param args
     */
    public static void main(String[] args) {
        Duke Duke = new Duke();
        Duke.run();
        Duke.close();

    }
}
