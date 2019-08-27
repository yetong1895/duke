public class dukeException {
    task[] listOfTask = new task[100];
    String temp;
    public void NullPointerException(task[] listOfTask,int a,int counter) {
        this.listOfTask = listOfTask;
        try {
            listOfTask[a].markAsDone();
        } catch (NullPointerException e) {
            if(counter == 0) {
                System.out.printf("Sorry, there is not task in the list.\n");
            } else if(counter == 1) {
                System.out.printf("Sorry, there is only 1 task in the list.\n");
            } else {
                System.out.printf("Sorry, there are only %d tasks in the list.\n", counter);
            }
        }

    }

    public void StringIndexOutOfBoundsException(task[] listOfTask,String inputs,int a) {
        this.listOfTask = listOfTask;
        if (inputs.length() == 5) {
            System.out.println("Sorry, the description of a todo cannot be empty.");
        } else {
            try {
                listOfTask[a] = new todos(inputs.substring(5));
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Sorry, the description of a todo cannot be empty.");
            }
        }
    }
}
