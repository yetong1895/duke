import jdk.jfr.Description;

public class task {
    protected String description;
    protected boolean isDone;
    protected int isDoneInt;

    public task(String description) {
        this.description = description;
        this.isDone = false;
        isDoneInt = 0;
    }

    public void markAsDone() { //set the task as done
        isDone = true;
        isDoneInt = 1;
    }

    public boolean checkDone() {
        return isDone;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public String toString() { //print out the status icon and the description
        return"["+ getStatusIcon()+"]"+" "+description;
    }

    public String saveFormat() {
        return String.format("%d|%s",isDoneInt,description);
    }
}
