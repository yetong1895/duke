public class list {
    private String userList[] = new String[100];
    private int counter = 0;
    public void add(String newContent) {
        userList[counter] = String.format("%d. %s",counter + 1, newContent);
        System.out.printf("Added: %s\n",newContent);
        counter++;
    }
    public void display() {
        for(int x = 0;x < counter;x++) {
            System.out.println(userList[x]);
        }
    }
}
