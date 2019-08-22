import java.util.Scanner;
public class Duke {
    public static void main(String[] args) {
        echo echoObject = new echo();
        stringSplit stringSplitObject = new stringSplit();
        task[] listOfTasks = new task[100];

        Scanner inputs = new Scanner(System.in);

        int counter = 1;
        int taskNum;

        while(true) {
            String userInputs;
            userInputs = inputs.nextLine();

            if (userInputs.equals("bye")) { //exit with the exit message
                echoObject.exitMessage();
                break;
            } else if (userInputs.equals("list")) { //list out the stuff
                for (int i = 1; i < counter; i += 1) {
                    System.out.printf("%d.", i);
                    listOfTasks[i].printTask();
                }
            } else if(stringSplitObject.checkCommand(userInputs) == true) { //check if the user command is a valid done command
                taskNum = stringSplitObject.getTaskNum();   //get the task number of the command to be done
                listOfTasks[taskNum].markAsDone(); //mark the task as done
                System.out.println("Nice! I've marked this task as done:");
                listOfTasks[taskNum].printTask(); //print the task after marking as done
            } else {
                listOfTasks[counter] = new task(userInputs);
                counter ++;
                stringSplitObject.setTotalTask(counter);
                System.out.printf("added: %s\n",userInputs);
            }
        }
    }
}
