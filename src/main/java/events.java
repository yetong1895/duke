public class events extends task{
    protected String at;
    private int rank;
    public events(String description,String at) {
        super(description);
        this.at = at;
    }
//    public void setRank(int rank) {
//        this.rank = rank;
//    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + at + ")";
    }

    @Override
    public String saveFormat() {
        return String.format("%s|%s|%s","E",super.saveFormat(),at);
    }
}
