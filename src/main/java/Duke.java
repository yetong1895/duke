import jdk.jfr.Event;
import java.io.File;
import java.util.*;
public class Duke {
    public static void main(String[] args) {
        ArrayList<task> listOfTasks = new ArrayList<task>();

        //****************************************//storage
        storage storageObject = new storage();
        //****************************************//

        int counter = 0;
        int taskNum,position,i;
        String userDate;

        //*****************************storage
        storageObject.load();
        listOfTasks = storageObject.getListOfTasks();
        counter = storageObject.getCounter();
        //*****************************

        //*****************************TaskList
        TaskList TaskList = new TaskList();
        TaskList.setListOfTasks(listOfTasks);
        TaskList.setCounter(counter);
        TaskList.startTask();
        //*****************************

        //save
        //***************************************storage
        storageObject.setListOfTasks(listOfTasks);
        storageObject.setCounter(counter);
        storageObject.save();
        //***************************************
    }
}
