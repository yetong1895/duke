public class deadLines extends task {
    protected String by;

    public deadLines(String description,String by) {
        super(description);
        this.by = by;
    }

    /**
     *  return the stored format of the user input.
     * @return the string that contain the information from the user input of a deadline
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }

    /**
     * This method return the save format of the user input
     * @return the string of the user input in saving format
     */
    @Override
    public String saveFormat() {
        return String.format("%s|%s|%s","D",super.saveFormat(),by);
    }
}
