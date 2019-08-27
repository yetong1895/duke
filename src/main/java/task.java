import jdk.jfr.Description;

public class task {
    protected String description;
    protected boolean isDone;

    public task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public void markAsDone() { //set the task as done
        isDone = true;
//        getStatusIcon();
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public String toString() { //print out the status icon and the description
        return"["+ getStatusIcon()+"]"+" "+description;
    }
}
