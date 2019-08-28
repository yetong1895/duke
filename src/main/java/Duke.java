import jdk.jfr.Event;

import java.util.Scanner;
public class Duke {
    public static void main(String[] args) {
        echo echoObject = new echo();
        stringSplit checker = new stringSplit();
        task[] listOfTasks = new task[100];
        dukeException exception = new dukeException();
        Scanner inputs = new Scanner(System.in);

        int counter = 0;
        int taskNum;
        int position;

        while(true) {
            String userInputs;
            userInputs = inputs.nextLine();

            if (userInputs.equals("bye")) { //exit with the exit message
                echoObject.exitMessage();
                break;
            } else if (userInputs.equals("list")) { //print out the list of inputs
                if(counter == 0) {//check if the task list is empty
                    System.out.println("Your task list is empty.");
                } else {
                    for (int i = 1; i <= counter; i += 1) {
                        System.out.printf("%d.", i);
                        System.out.println(listOfTasks[i].toString());
                    }
                }
            } else if(checker.checkDone(userInputs) == true) { //check if the user command is a valid 'done' command
                taskNum = checker.getTaskNum();   //get the task number of the command to be done
                if(taskNum > counter) {
                    exception.NullPointerException(listOfTasks, taskNum, counter); //handle exception; I.E user enter an invalid task number
                } else {
                    listOfTasks[taskNum].markAsDone(); //mark the task as done
                    System.out.println("Nice! I've marked this task as done:");//print the task after marking as done
                    System.out.println(listOfTasks[taskNum].toString());
                }
            }else if(checker.checkTodo(userInputs) == true) { //check if the user command is a valid 'todo' command
                counter++;
                if(userInputs.length() < 6) { //handle exception; I.E. user have not enter the description of the task
                    exception.StringIndexOutOfBoundsException(listOfTasks,userInputs,counter,"todo");
                    counter --;
                } else {
                    listOfTasks[counter] = new todos(userInputs.substring(5));
                    System.out.printf("Got it. I've added this task:\n  %s\nNow you have %d tasks in the list.\n", listOfTasks[counter].toString(), counter);
                }
            } else if(checker.checkEvent(userInputs) == true) {//check if the user command is a valid 'event' command
                counter++;
                position = userInputs.indexOf("/"); //find the position of the separator '/'
                if(position == -1 || userInputs.length() <= position + 4) {
                    exception.StringIndexOutOfBoundsException(listOfTasks,userInputs,counter,"event");//call exception for invalid inputs
                    counter--;
                } else {//valid inputs
                    System.out.println(position);
                    System.out.println(userInputs.length());
                    listOfTasks[counter] = new events(userInputs.substring(6, position - 1), userInputs.substring(position + 4));
                    checker.setTotalTask(counter); //error checking
                    System.out.printf("Got it. I've added this task:\n  %s\nNow you have %d tasks in the list.\n", listOfTasks[counter].toString(), counter);
                }
            } else if(checker.checkDeadline(userInputs) == true) {//check if the user command is a valid 'deadline' command
                counter++;
                position = userInputs.indexOf("/"); //find the position of the separator '/'
                if(position == -1 || userInputs.length() <= position + 4) {
                    exception.StringIndexOutOfBoundsException(listOfTasks,userInputs,counter,"deadline");//call exception for invalid inputs
                    counter--;
                } else {
                    listOfTasks[counter] = new deadLines(userInputs.substring(9, position - 1), userInputs.substring(position + 4));
                    checker.setTotalTask(counter); //error checking
                    System.out.printf("Got it. I've added this task:\n  %s\nNow you have %d tasks in the list.\n", listOfTasks[counter].toString(), counter);
                }
            } else {//all other invalid inputs
                System.out.println("Sorry, the input is invalid");
            }
        }
    }
}
