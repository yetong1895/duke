import java.util.ArrayList;

public class storage {
    saveWrite write = new saveWrite();
    saveRead read = new saveRead();
    ArrayList<task> listOfTasks = new ArrayList<task>();
    Parser checker = new Parser();
    date dateObject = new date();

    private int counter = 0;
    private int taskNum,position,i;
    private String first,second,third,forth,temp;

    /**
     * This method will set the listOfTasks in this class
     * @param listOfTasks the list of class to be set in this class
     */
    public void setListOfTasks(ArrayList<task> listOfTasks) {
        this.listOfTasks = listOfTasks;
    }

    /**
     * This method will return the listOfTask
     * @return listOfTasks the list of task to be return.
     */
    public ArrayList<task> getListOfTasks() {
        return listOfTasks;
    }

    /**
     * This method set the counter in this class to the counter that is passed in.
     * @param counter
     */
    public void setCounter(int counter) {
        this.counter = counter;
    }

    /**
     * This method return the counter in this class.
     * @return counter the counter to be returned
     */
    public int getCounter() {
        return counter;
    }

    /**
     * This method will open the save file and read the data from the save file,the data will then be convert to display format
     * and stored into the ArrayList of object.
     */
    public void load() {
        //open save data
        read.openFile(); //open the save file
        read.readFile();//read the value of counter in the save file
        temp = read.getData();
        listOfTasks.add(new task("Dummy input to consume index 0"));
        if (temp != null) {
            if (temp.length() != 0) {
                counter = Integer.parseInt(temp);
            }
        }
        for (i = 1; i <= counter; i++) {
            read.readFile();
            temp = read.getData();
            checker.splitSaveData(temp); //split the string temp
            first = checker.saveData1(); //first part; I.E. the task type
            second = checker.saveData2(); //second part; I.E done or not done
            third = checker.saveData3(); //third part; I.E description
            if (first.equals("T")) { //if it is todo task
                listOfTasks.add(new todos(third));
                if (second.equals("1"))
                    listOfTasks.get(i).markAsDone();

            } else if (first.equals("E")) { //if it is event task
                forth = checker.saveData4();
                listOfTasks.add(new events(third, forth));

                dateObject.setCounter(counter);
                dateObject.dateConvert(forth);
                if (second.equals("1"))
                    listOfTasks.get(i).markAsDone();
//
            } else if (first.equals("D")) { //if it is deadline task
                forth = checker.saveData4();
                listOfTasks.add(new deadLines(third, forth));
                dateObject.setCounter(counter);
                dateObject.dateConvert(forth);
                if (second.equals("1"))
                    listOfTasks.get(i).markAsDone();
            }
        }
        read.closeFile(); // close the file

    }

    /**
     * This method will convert the contents in the listOfTasks into the save format and save into the save file
     */
    public void save() {
        write.openFile();
        String numOfTasks = Integer.toString(counter);
        write.addRecords(numOfTasks); //first save the value of counter into the save.txt file
        for(i = 1;i <= counter; i++) {//loop through the array of objects and save the information into save.txt file
            temp = listOfTasks.get(i).saveFormat();
            write.addRecords(temp);
        }
        write.closeFile();//close the file
    }
}
