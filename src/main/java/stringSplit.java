public class stringSplit {
    private String split[] = new String[100];
    private int taskNum;
    private int totalTask;

    public void setTotalTask(int x) { //find the total number of task in the current list
        totalTask = x;
    }

    public void breakString(String command) { //split the string into individual words
        split = command.split(" ");
    }

    public void convertToInt() { //convert the string number to int number
        taskNum = Integer.valueOf(split[1]);
    }

    public static boolean isNumeric(final String s) { //check if a string passed in is a numeric number
        return s.chars().allMatch(Character::isDigit);
    }

    public boolean checkDone(String command) { //check if there is a "done" command
        breakString(command);
        if(split[0].equals("done") && isNumeric(split[1]) == true) { //check if the first string is "done" and the second string is a number.
                convertToInt();
                if(taskNum <= totalTask) {//check if the task number to be done is involve in the total number.
                    return true;
                }
        }
        return false;
    }

    public boolean checkTodo(String command) {//check if it is a todo command
        if(split[0].equals("todo")) {
            return true;
        }
        return false;
    }

    public boolean checkEvent(String command) {//check if it is a event command
        if(split[0].equals("event")) {
            return true;
        }
        return false;
    }

    public boolean checkDeadline(String command) {//check if it is a deadline command
        if(split[0].equals("deadline")) {
            return true;
        }
        return false;
    }


    public int getTaskNum () { //return the task number to be mark as done

        return taskNum;
    }
}
