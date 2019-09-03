import java.util.ArrayList;

public class dukeException {
    ArrayList<task> listOfTasks = new ArrayList<task>();
    String temp;

    public void IndexOutOfBoundsException(ArrayList<task> listOfTasks, int a, int counter) {
        this.listOfTasks = listOfTasks;
        try {
            listOfTasks.get(a).markAsDone();
        } catch (IndexOutOfBoundsException e) {
            if (counter == 0) {
                System.out.printf("Sorry, there is not task in the list.\n");
            } else if (counter == 1) {
                System.out.printf("Sorry, there is only 1 task in the list.\n");
            } else {
                System.out.printf("Sorry, there are only %d tasks in the list.\n", counter);
            }
        }

    }

    public void StringIndexOutOfBoundsException(ArrayList<task> listOfTasks, String inputs, int a, String taskType) {
        this.listOfTasks = listOfTasks;
        if (inputs.length() == 5 && taskType.equals("todo")) { //hand the exception from 'todo'
            System.out.println("Sorry, the description of a todo cannot be empty.");
        } else if(inputs.length() != 5 && taskType.equals("todo")){
            try {
                listOfTasks.add(new todos(inputs.substring(5)));
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Sorry, the description of a todo cannot be empty.");
            }
        }

        int position = inputs.indexOf("/"); //find the position of the separator '/'
        if(taskType.equals("event")) {
            try {
                listOfTasks.add(new events(inputs.substring(6, position - 1), inputs.substring(position + 4)));
            } catch (StringIndexOutOfBoundsException e) {
                if (inputs.length() <= 7) {
                    System.out.println("Sorry, the description of an event cannot be empty.");
                } else if (position == -1 || inputs.length() <= position + 4) {
                    System.out.println(("Sorry, please enter a valid date and time"));
                }
            }
        } else if(taskType.equals("deadline")) {
            try {
                listOfTasks.add(new deadLines(inputs.substring(9, position - 1), inputs.substring(position + 4)));
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
