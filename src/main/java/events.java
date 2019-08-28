public class events extends task{
    protected String at;
    public events(String description,String at) {
        super(description);
        this.at = at;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + at + ")";
    }

    @Override
    public String saveFormat() {
        return String.format("%s|%s|%s","E",super.saveFormat(),at);
    }
}
