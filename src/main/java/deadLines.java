public class deadLines extends task {
    protected String by;

    public deadLines(String description,String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }

    @Override
    public String saveFormat() {
        return String.format("%s|%s|%s","D",super.saveFormat(),by);
    }
}
