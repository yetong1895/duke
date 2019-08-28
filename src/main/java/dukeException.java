public class dukeException {
    task[] listOfTask = new task[100];
    String temp;

    public void NullPointerException(task[] listOfTask, int a, int counter) {
        this.listOfTask = listOfTask;
        try {
            listOfTask[a].markAsDone();
        } catch (NullPointerException e) {
            if (counter == 0) {
                System.out.printf("Sorry, there is not task in the list.\n");
            } else if (counter == 1) {
                System.out.printf("Sorry, there is only 1 task in the list.\n");
            } else {
                System.out.printf("Sorry, there are only %d tasks in the list.\n", counter);
            }
        }

    }

    public void StringIndexOutOfBoundsException(task[] listOfTask, String inputs, int a, String taskType) {
        this.listOfTask = listOfTask;
        if (inputs.length() == 5 && taskType.equals("todo")) { //hand the exception from 'todo'
            System.out.println("Sorry, the description of a todo cannot be empty.");
        } else if(inputs.length() != 5 && taskType.equals("todo")){
            try {
                listOfTask[a] = new todos(inputs.substring(5));
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Sorry, the description of a todo cannot be empty.");
            }
        }

        int position = inputs.indexOf("/"); //find the position of the separator '/'
        if(taskType.equals("event")) {
            try {
                listOfTask[a] = new events(inputs.substring(6, position - 1), inputs.substring(position + 4));
            } catch (StringIndexOutOfBoundsException e) {
                if (inputs.length() <= 7) {
                    System.out.println("Sorry, the description of an event cannot be empty.");
                } else if (position == -1 || inputs.length() <= position + 4) {
                    System.out.println(("Sorry, please enter a valid date and time"));
                }
            }
        } else if(taskType.equals("deadline")) {
            try {
                listOfTask[a] = new deadLines(inputs.substring(9, position - 1), inputs.substring(position + 4));
            } catch (StringIndexOutOfBoundsException e) {
                if (inputs.length() <= 9) {
                    System.out.println("Sorry, the description of an event cannot be empty.");
                } else if (position == -1 || inputs.length() <= position + 4) {
                    System.out.println(("Sorry, please enter a valid date and time"));
                }
            }
        }

    }
}
