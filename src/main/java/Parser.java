public class Parser {
        private String split[] = new String[100];
        private int taskNum;

    /**
     * This method will split the string of user command into individual words
     * @param command the string of user input
     */
    public void breakString(String command) {
            split = command.split(" ");
        }

    /**
     * This method will convert the string number to int number
      */
    public void convertToInt() {
        taskNum = Integer.valueOf(split[1]);
    }

    /**
     * This method will check if a string passed in is a numeric number
     * @param s the string to be checked.
     * @return true if the input string is a numeric number, false if it is not.
     */
    public static boolean isNumeric(final String s) {
        return s.chars().allMatch(Character::isDigit);
    }

    /**
     * This method check if the command is a valid "done" command
     * @param command the user input String
     * @return true if the first word is a "done" keyword and second word is a numeric number or false otherwise
     */
    public boolean checkDone(String command) {
        breakString(command);
        if(split[0].equals("done") && isNumeric(split[1]) == true) {
            convertToInt();
            return true;
        }
        return false;
    }

    /**
     * This method check if the command is a valid "delete" command
     * @param command the user input string
     * @return true if the first word is a "delete" keyword and second word is a numeric number or false otherwise
     */
    public boolean checkDelete(String command) {
        breakString(command);
        if(split[0].equals("delete") && isNumeric(split[1]) == true) {
            convertToInt();
            return true;
        }
        return false;
    }

    /**
     *This method check if the command is a valid "todo" command
     * @param command the user input string
     * @return true if the first word is a "todo" keyword or false otherwise
     */
    public boolean checkTodo(String command) {
        if(split[0].equals("todo")) {
            return true;
        }
        return false;
    }

    /**
     * This method check if the command is a valid "event" command
     * @param command the user input string
     * @return true if the first word is a "event" keyword or false otherwise
     */
    public boolean checkEvent(String command) {//check if it is a event command
        if(split[0].equals("event")) {
            return true;
        }
        return false;
    }

    /**
     * This method check if the command is a valid "deadline" command
     * @param command the user input string
     * @return true if the first word is a "deadline" keyword or false otherwise
     */
    public boolean checkDeadline(String command) {
        if(split[0].equals("deadline")) {
            return true;
        }
        return false;
    }

    /**
     * This method check if the command is a valid "find" command
     * @param command the user input string
     * @return true if the first word is a "find" keyword or false otherwise
     */
    public boolean checkFind(String  command) {
        if(split[0].equals("find")) {
            return true;
        }
        return false;
    }

    /**
     * This method return the task number to be marked as done
     * @return taskNum the task number to be marked as done
     */
    public int getTaskNum () {
        return taskNum;
    }

    /**
     * This method split the string in the save data
     * @param data the string from the save date
     */
    public void splitSaveData (String data) {
        split = data.split("\\|");
    }

    /**
     * This method return the first word from the split save date
     * @return the first word of the split save data
     */
    public String saveData1 () {
        return split[0];
    }

    /**
     * This method return the first word from the split save date
     * @return the first word of the split save data
     */
    public String saveData2() {
        return split[1];
    }

    /**
     * This method return the first word from the split save date
     * @return the first word of the split save data
     */
    public String saveData3() {
        return split[2];
    }

    /**
     * This method return the first word from the split save date
     * @return the first word of the split save data
     */
    public String saveData4() {
        return split[3];
    }
}
