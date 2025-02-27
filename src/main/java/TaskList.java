import java.util.ArrayList;
import java.util.Scanner;

public class    TaskList {
    Ui UiObject = new Ui();
    Parser checker = new Parser();
    ArrayList<task> listOfTasks = new ArrayList<task>();
    dukeException exception = new dukeException();
    Scanner inputs = new Scanner(System.in);
    date dateObject = new date();


    private int counter = 0;
    private int i;
    private int taskNum;
    private int position;
    private String userDate;

    /**
     * This method will set the counter in this class equals to the counter that passed in.
     * @param counter the counter to be set in this method
     */
    public void setCounter(int counter) {
        this.counter = counter;
    }

    /**
     * This method will set the listOfTasks in this class equals to the listOfTask equals to the listOfTasks that passed in.
     * @param listOfTasks the array list to be passed in.
     */
    public void setListOfTasks(ArrayList<task> listOfTasks) {
        this.listOfTasks = listOfTasks;
    }

    /**
     * This method return the counter
     * @return counter the number of task.
     */
    public int getCounter() {
        return counter;
    }

    /**
     * This method return the array list listOfTasks;
     * @return listOfTasks the list of task in this class
     */
    public ArrayList<task> getListOfTasks() {
        return listOfTasks;
    }

    /**
     * This method will check for all of the user inputs and call the required method according to the keyword used.
     * @throws IndexOutOfBoundsException the exception when accessing an index that is out of bound of the array list
     * @throws StringIndexOutOfBoundsException the exception when accessing a string that is out of the bound of the input string.
     */
    public void startTask() {
        while (true) {
            String userInputs;
            userInputs = inputs.nextLine();

            if (userInputs.equals("bye")) { //exit with the exit message
                UiObject.exitMessage();
                break;
            } else if (userInputs.equals("list")) { //print out the list of inputs
                if (counter == 0) {//check if the task list is empty
                    UiObject.emptyMessage();
                } else {
                    UiObject.listPrinting(counter,listOfTasks);
                }
            } else if (checker.checkDelete(userInputs) == true) {//check if the user command is a valid 'delete' command
                taskNum = checker.getTaskNum();
                if (taskNum > counter) {
                    exception.IndexOutOfBoundsException(listOfTasks, taskNum, counter);
                } else {
                    counter--;
                    UiObject.deleteMessage(taskNum,counter,listOfTasks);
                    listOfTasks.remove(taskNum);
                }
            } else if (checker.checkDone(userInputs) == true) { //check if the user command is a valid 'done' command
                taskNum = checker.getTaskNum();   //get the task number of the command to be done
                if (taskNum > counter) {
                    exception.IndexOutOfBoundsException(listOfTasks, taskNum, counter); //handle exception; I.E user enter an invalid task number
                } else {
                    if (listOfTasks.get(taskNum).checkDone() == true) {//check if the task is already done
                        UiObject.checkDoneMessage();
                    } else {
                        listOfTasks.get(taskNum).markAsDone(); //mark the task as done
                        UiObject.MarkAsDoneMessage(taskNum,listOfTasks);
                    }
                }
            } else if (checker.checkFind(userInputs) == true) { //check if it is a valid 'find' command
                UiObject.checkFindMessage(counter,userInputs,listOfTasks);
            } else if (checker.checkTodo(userInputs) == true) { //check if the user command is a valid 'todo' command
                counter++;
                if (userInputs.length() < 6) { //handle exception; I.E. user have not enter the description of the task
                    exception.StringIndexOutOfBoundsException(listOfTasks, userInputs, counter, "todo");
                    counter--;
                } else {
                    listOfTasks.add(new todos(userInputs.substring(5)));
                    UiObject.checkAddMessage(counter,listOfTasks);
                }
            } else if (checker.checkEvent(userInputs) == true) {//check if the user command is a valid 'event' command
                counter++;
                position = userInputs.indexOf("/"); //find the position of the separator '/'

                if (position == -1 || userInputs.length() <= position + 4) {
                    exception.StringIndexOutOfBoundsException(listOfTasks, userInputs, counter, "event");//call exception for invalid inputs
                    counter--;
                } else {//valid inputs
                    userDate = userInputs.substring(position + 4);
                    dateObject.setCounter(counter);
                    dateObject.dateConvert(userDate);

                    if (dateObject.getCheckDate() == true) {//check if the date input is valid
                        listOfTasks.add(new events(userInputs.substring(6, position - 1), userInputs.substring(position + 4)));
                        UiObject.checkAddMessage(counter,listOfTasks);
                    } else {
                        counter--;
                    }
                }
            } else if (checker.checkDeadline(userInputs) == true) {//check if the user command is a valid 'deadline' command
                counter++;
                position = userInputs.indexOf("/"); //find the position of the separator '/'

                if (position == -1 || userInputs.length() <= position + 4) {
                    exception.StringIndexOutOfBoundsException(listOfTasks, userInputs, counter, "deadline");//call exception for invalid inputs
                    counter--;
                } else {
                    userDate = userInputs.substring(position + 4);
                    dateObject.setCounter(counter);
                    dateObject.dateConvert(userDate);
                    if (dateObject.getCheckDate() == true) {//check if the date input is valid
                        listOfTasks.add(new deadLines(userInputs.substring(9, position - 1), userInputs.substring(position + 4)));
                        UiObject.checkAddMessage(counter,listOfTasks);
                    } else {
                        counter--;
                    }
                }
            } else {//all other invalid inputs
                UiObject.invalidMessage();
            }

            dateObject.setCounter(counter);
        }
    }
}
