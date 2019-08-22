import java.util.Scanner;
public class Duke {
    public static void main(String[] args) {
        echo echoObject = new echo();
        Scanner inputs = new Scanner(System.in);
        while(true) {
            String userInputs;
            userInputs = inputs.nextLine();
            if(userInputs.equals("bye")) {
                echoObject.exitMessage();
                break;
            } else {
                echoObject.repeatInput(userInputs);
            }
        }
    }
}
