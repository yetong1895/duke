import java.util.ArrayList;

public class Ui{

    private int i;

    public Ui() {
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
    }

    public void repeatInput(String input) {
        System.out.printf("%s\n",input);
    }

    public void emptyMessage() {
        System.out.println("Your task list is empty.");
    }

    public void listPrinting(int counter,ArrayList<task> listOfTasks) {
        for (i = 1; i <= counter; i += 1) {
            System.out.printf("%d.", i);
            System.out.println(listOfTasks.get(i).toString());
        }
    }

    public void deleteMessage(int taskNum,int counter,ArrayList<task> listOfTasks) {
        System.out.println("Noted. I've removed this task:");
        System.out.println(listOfTasks.get(taskNum).toString());
        System.out.printf("Now you have %d tasks in the list.\n", counter);
    }

    public void checkDoneMessage(boolean done,int taskNum,ArrayList<task> listOfTasks) {
        if(done == true) {
            System.out.println("This task is already marked as done.");
        } else {
            System.out.println("Nice! I've marked this task as done:");//print the task after marking as done
            System.out.println(listOfTasks.get(taskNum).toString());
        }
    }

    public void checkFindMessage(int counter,String userInputs, ArrayList<task> listOfTasks) {
        System.out.println("Here are the matching tasks in your list:");
        for (i = 1; i <= counter; i++) {
            if (listOfTasks.get(i).getDescription().contains(userInputs.substring(5))) { //find the keyword
                System.out.println(listOfTasks.get(i).toString());
            }
        }
    }

    public void checkAddMessage(int counter,ArrayList<task> listOfTasks) {
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + listOfTasks.get(counter).toString());
        System.out.println("Now you have " + counter + " tasks in the list.");
    }

    public void invalidMessage() {
        System.out.println("Sorry, the input is invalid");
    }

    public void exitMessage() {
        System.out.print("Bye. Hope to see you again soon!");
    }
}
