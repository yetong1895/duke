public class todos extends task {
    public todos(String description) {
        super(description);
    }

    @Override
    public String toString() { //print out the status icon and the description
        return "[T]" + super.toString();
    }
    @Override
    public String saveFormat() {
        return String.format("%s|%s","T",super.saveFormat());
    }
}
