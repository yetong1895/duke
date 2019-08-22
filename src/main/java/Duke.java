import java.util.Scanner;
public class Duke {
    public static void main(String[] args) {
        echo echoObject = new echo();
        list listObject = new list();
        Scanner inputs = new Scanner(System.in);
        while(true) {
            String userInputs;
            userInputs = inputs.nextLine();
            if(userInputs.equals("bye")) {
                echoObject.exitMessage();
                break;
            } else if(userInputs.equals("list")) {
                listObject.display();
            } else {
//                echoObject.repeatInput(userInputs);
                listObject.add(userInputs);
          }
        }
    }
}
