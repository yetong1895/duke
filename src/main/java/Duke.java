import jdk.jfr.Event;

import java.util.Scanner;
public class Duke {
    public static void main(String[] args) {
        echo echoObject = new echo();
        stringSplit checker = new stringSplit();
        task[] listOfTasks = new task[100];

        Scanner inputs = new Scanner(System.in);

        int counter = 1;
        int taskNum;
        int position;

        while(true) {
            String userInputs;
            userInputs = inputs.nextLine();

            if (userInputs.equals("bye")) { //exit with the exit message
                echoObject.exitMessage();
                break;
            } else if (userInputs.equals("list")) { //list out the stuff
                for (int i = 1; i < counter; i += 1) {
                    System.out.printf("%d.", i);
                    System.out.println(listOfTasks[i].toString());
                }
            } else if(checker.checkDone(userInputs) == true) { //check if the user command is a valid 'done' command
                taskNum = checker.getTaskNum();   //get the task number of the command to be done
                listOfTasks[taskNum].markAsDone(); //mark the task as done
                System.out.println("Nice! I've marked this task as done:");//print the task after marking as done
                System.out.println(listOfTasks[taskNum].toString());
            }else if(checker.checkTodo(userInputs) == true) { //check if the user command is a valid 'todo' command
                listOfTasks[counter] = new todos(userInputs.substring(5));
                checker.setTotalTask(counter); //error checking
                System.out.printf("Got it. I've added this task:\n  %s\nNow you have %d tasks in the list.\n", listOfTasks[counter].toString(), counter);
                counter++;
            } else if(checker.checkEvent(userInputs) == true) {//check if the user command is a valid 'event' command
                position = userInputs.indexOf("/"); //find the position of the separator '/'
                listOfTasks[counter] = new events(userInputs.substring(6, position - 1), userInputs.substring(position + 4));
                checker.setTotalTask(counter); //error checking
                System.out.printf("Got it. I've added this task:\n  %s\nNow you have %d tasks in the list.\n", listOfTasks[counter].toString(), counter);
                counter++;
            } else if(checker.checkDeadline(userInputs) == true) {//check if the user command is a valid 'deadline' command
                position = userInputs.indexOf("/"); //find the position of the separator '/'
                listOfTasks[counter] = new deadLines(userInputs.substring(9,position - 1),userInputs.substring(position + 4));
                checker.setTotalTask(counter); //error checking
                System.out.printf("Got it. I've added this task:\n  %s\nNow you have %d tasks in the list.\n", listOfTasks[counter].toString(), counter);
                counter++;
            } else {
                listOfTasks[counter] = new task(userInputs);
                counter ++;
                checker.setTotalTask(counter); //error checking
                System.out.printf("added: %s\n",userInputs);
            }
        }
    }
}
