public class Parser {
        private String split[] = new String[100];
        private int taskNum;

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
                return true;
            }
            return false;
        }

        public boolean checkDelete(String command) {
            breakString(command);
            if(split[0].equals("delete") && isNumeric(split[1]) == true) {
                convertToInt();
                return true;
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

        public boolean checkFind(String  command) {
            if(split[0].equals("find")) {
                return true;
            }
            return false;
        }


        public int getTaskNum () { //return the task number to be mark as done
            return taskNum;
        }
        public void splitSaveData (String data) {
            split = data.split("\\|");
        }
        public String saveData1 () {
            return split[0];
        }

        public String saveData2() {
            return split[1];
        }

        public String saveData3() {
            return split[2];
        }

        public String saveData4() {
            return split[3];
        }
}
