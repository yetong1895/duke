public class todos extends task {
    public todos(String description) {
        super(description);
    }

    /**
     * This method will return the status icon and the description of a todo task
     * @return the string containing the status icon and the description
     */
    @Override
    public String toString() { //print out the status icon and the description
        return "[T]" + super.toString();
    }

    /**
     * This method will return the user input in saving format.
     * @return the string containing the user inputs in saving format
     */
    @Override
    public String saveFormat() {
        return String.format("%s|%s","T",super.saveFormat());
    }
}
