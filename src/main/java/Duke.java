import jdk.jfr.Event;
import java.io.File;
import java.util.*;
public class Duke {
    public static void main(String[] args) {
        echo echoObject = new echo();
        stringSplit checker = new stringSplit();
        ArrayList<task> listOfTasks = new ArrayList<task>();
        dukeException exception = new dukeException();
        Scanner inputs = new Scanner(System.in);
        saveWrite write = new saveWrite();
        date dateObject = new date();
        saveRead read = new saveRead();

        int counter = 0;
        int taskNum,position,i;
        String first,second,third,forth,temp;
        String userDate;
        //open save data
        read.openFile(); //open the save file
        read.readFile();//read the value of counter in the save file
        temp = read.getData();
        listOfTasks.add(new task("Dummy input to consume index 0"));
        if(temp != null) {
            if (temp.length() != 0) {
                counter = Integer.valueOf(temp);
            }
        }
        for(i = 1;i <= counter;i ++) {
            read.readFile();
            temp = read.getData();
            checker.splitSaveData(temp); //split the string temp
            first = checker.saveData1(); //first part; I.E. the task type
            second = checker.saveData2(); //second part; I.E done or not done
            third = checker.saveData3(); //third part; I.E description
            if(first.equals("T")) { //if it is todo task
//                listOfTasks[i] = new todos(third);
                listOfTasks.add(new todos(third));
                if(second.equals("1"))
                    listOfTasks.get(i).markAsDone();
//                    listOfTasks[i].markAsDone();

            } else if(first.equals("E")) { //if it is event task
                forth = checker.saveData4();
                listOfTasks.add(new events(third,forth));
//                listOfTasks[i] = new events(third,forth);

                dateObject.setCounter(counter);
                dateObject.dateConvert(forth);
                if(second.equals("1"))
                    listOfTasks.get(i).markAsDone();
//                    listOfTasks[i].markAsDone();
//
            } else if(first.equals("D")) { //if it is deadline task
                forth = checker.saveData4();
//                listOfTasks[i] = new deadLines(third,forth);
                listOfTasks.add(new deadLines(third,forth));
                dateObject.setCounter(counter);
                dateObject.dateConvert(forth);
                if(second.equals("1"))
//                    listOfTasks[i].markAsDone();
                     listOfTasks.get(i).markAsDone();
            }
        }
        read.closeFile(); // close the file

        //interface start here
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
                    for (i = 1; i <= counter; i += 1) {
                        System.out.printf("%d.", i);
                        System.out.println(listOfTasks.get(i).toString());
//                        System.out.println(listOfTasks[i].toString());
                    }
                }
            } else if(checker.checkDelete(userInputs) == true) {
                taskNum = checker.getTaskNum();
                if (taskNum > counter) {
                    exception.IndexOutOfBoundsException(listOfTasks, taskNum, counter);
                } else {
                    counter --;
                    System.out.println("Noted. I've removed this task:");
                    System.out.println(listOfTasks.get(taskNum).toString());
                    System.out.printf("Now you have %d tasks in the list.\n", counter);
                    listOfTasks.remove(taskNum);
                }
            } else if(checker.checkDone(userInputs) == true) { //check if the user command is a valid 'done' command
                taskNum = checker.getTaskNum();   //get the task number of the command to be done
                if(taskNum > counter) {
                    exception.IndexOutOfBoundsException(listOfTasks, taskNum, counter); //handle exception; I.E user enter an invalid task number
                } else {
                    if(listOfTasks.get(taskNum).checkDone() == true) {//check if the task is already done
                        System.out.println("This task is already marked  as done.");
                    } else {
                        listOfTasks.get(taskNum).markAsDone(); //mark the task as done
                        System.out.println("Nice! I've marked this task as done:");//print the task after marking as done
                        System.out.println(listOfTasks.get(taskNum).toString());
                    }
                }
            }else if(checker.checkTodo(userInputs) == true) { //check if the user command is a valid 'todo' command
                counter++;
                if(userInputs.length() < 6) { //handle exception; I.E. user have not enter the description of the task
                    exception.StringIndexOutOfBoundsException(listOfTasks,userInputs,counter,"todo");
                    counter --;
                } else {
//                    listOfTasks[counter] = new todos(userInputs.substring(5));
                    listOfTasks.add(new todos(userInputs.substring(5)));
                    System.out.printf("Got it. I've added this task:\n  %s\nNow you have %d tasks in the list.\n", listOfTasks.get(counter).toString(), counter);
                }
            } else if(checker.checkEvent(userInputs) == true) {//check if the user command is a valid 'event' command
                counter++;
                position = userInputs.indexOf("/"); //find the position of the separator '/'

                if(position == -1 || userInputs.length() <= position + 4) {
                    exception.StringIndexOutOfBoundsException(listOfTasks,userInputs,counter,"event");//call exception for invalid inputs
                    counter--;
                } else {//valid inputs
                    userDate = userInputs.substring(position + 4);
                    dateObject.setCounter(counter);
                    dateObject.dateConvert(userDate);

                    if(dateObject.getCheckDate() == true) {//check if the date input is valid
//                        listOfTasks[counter] = new events(userInputs.substring(6, position - 1), userInputs.substring(position + 4));
                        listOfTasks.add(new events(userInputs.substring(6, position - 1), userInputs.substring(position + 4)));
                        System.out.printf("Got it. I've added this task:\n  %s\nNow you have %d tasks in the list.\n", listOfTasks.get(counter).toString(), counter);
                    } else {
                        counter--;
                    }
                }
            } else if(checker.checkDeadline(userInputs) == true) {//check if the user command is a valid 'deadline' command
                counter++;
                position = userInputs.indexOf("/"); //find the position of the separator '/'

                if(position == -1 || userInputs.length() <= position + 4) {
                    exception.StringIndexOutOfBoundsException(listOfTasks,userInputs,counter,"deadline");//call exception for invalid inputs
                    counter--;
                } else {
                    userDate = userInputs.substring(position + 4);
                    dateObject.setCounter(counter);
                    dateObject.dateConvert(userDate);
                    if(dateObject.getCheckDate() == true) {//check if the date input is valid
//                        listOfTasks[counter] = new deadLines(userInputs.substring(9, position - 1), userInputs.substring(position + 4));
                        listOfTasks.add(new deadLines(userInputs.substring(9, position - 1), userInputs.substring(position + 4)));
                        System.out.printf("Got it. I've added this task:\n  %s\nNow you have %d tasks in the list.\n", listOfTasks.get(counter).toString(), counter);
                    } else {
                        counter--;
                    }
                }
            } else {//all other invalid inputs
                System.out.println("Sorry, the input is invalid");
            }

            dateObject.setCounter(counter);
        }
        //convert the date and time
//        date dateObject = new date();
//        dateObject.dateConvert();

        //save
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
