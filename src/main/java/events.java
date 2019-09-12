public class events extends task{
    protected String at;
//    private int rank;
    public events(String description,String at) {
        super(description);
        this.at = at;
    }
//    public void setRank(int rank) {
//        this.rank = rank;
//    }

    /**
     * return the stored format of the user input.
     * @return the string that contain the information from the user input of a event
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + at + ")";
    }

    /**
     * This method return the save format of the user input
     * @return the string of the user input in saving format
     */
    @Override
    public String saveFormat() {
        return String.format("%s|%s|%s","E",super.saveFormat(),at);
    }
}
