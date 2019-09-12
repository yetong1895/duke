import java.util.ArrayList;

public class Ui{

    private int i;

    public Ui() {
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
    }

    /**
     * This method will repeat the user input
     * @param input the string that the user have input.
     */
    public void repeatInput(String input) {
        System.out.printf("%s\n",input);
    }

    /**
     * This method will print the string that says the user task list is empty
     */
    public void emptyMessage() {
        System.out.println("Your task list is empty.");
    }

    /**
     * This method will print the list of tasks in the listOfTasks.
     * @param counter the number of task in the listOfTasks.
     * @param listOfTasks the list that containing all the tasks.
     */
    public void listPrinting(int counter,ArrayList<task> listOfTasks) {
        for (i = 1; i <= counter; i += 1) {
            System.out.printf("%d.", i);
            System.out.println(listOfTasks.get(i).toString());
        }
    }

    /**
     * This method will print which task is getting deleted.
     * @param taskNum the task number to be removed
     * @param counter the number of task in the list of task
     * @param listOfTasks the list containing all the tasks
     */
    public void deleteMessage(int taskNum,int counter,ArrayList<task> listOfTasks) {
        System.out.println("Noted. I've removed this task:");
        System.out.println(listOfTasks.get(taskNum).toString());
        System.out.printf("Now you have %d tasks in the list.\n", counter);
    }

    /**
     * This method will print which task is marking as done
     * @param taskNum the task number to be mark as done
     * @param listOfTasks the list containg all the tasks
     */
    public void MarkAsDoneMessage(int taskNum,ArrayList<task> listOfTasks) {
        System.out.println("Nice! I've marked this task as done:");//print the task after marking as done
        System.out.println(listOfTasks.get(taskNum).toString());
    }

    /**
     * This method will print the message that the task is already marked as done.
     */
    public void checkDoneMessage() {
            System.out.println("This task is already marked as done.");
    }

    /**
     * This method will print the item that are found by the find command
     * @param counter the number of tasks in the list
     * @param userInputs the keyword that the user want to find
     * @param listOfTasks the list containing all of the task
     */
    public void checkFindMessage(int counter,String userInputs, ArrayList<task> listOfTasks) {
        System.out.println("Here are the matching tasks in your list:");
        for (i = 1; i <= counter; i++) {
            if (listOfTasks.get(i).getDescription().contains(userInputs.substring(5))) { //find the keyword
                System.out.println(listOfTasks.get(i).toString());
            }
        }
    }

    /**
     * This method will print the task that is being added to the list of tasks
     * @param counter the task number that is going to be printed
     * @param listOfTasks the list containing all the task
     */
    public void checkAddMessage(int counter,ArrayList<task> listOfTasks) {
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + listOfTasks.get(counter).toString());
        System.out.println("Now you have " + counter + " tasks in the list.");
    }

    /**
     * This method will print the invalid message when the user key in an invalid message
     */
    public void invalidMessage() {
        System.out.println("Sorry, the input is invalid");
    }

    /**
     * This method will print the exit message when the user is leaving the app.
     */
    public void exitMessage() {
        System.out.print("Bye. Hope to see you again soon!");
    }
}
