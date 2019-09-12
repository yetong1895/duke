import java.io.*;
import java.lang.*;
import java.util.*;
public class saveRead {
    private Scanner read;
    private String datas;

    /**
     * This method will read the saves.txt file that stored the save data
     */
    public void openFile() {
        try{
            read = new Scanner(new File("saves.txt"));
        } catch(Exception e) {
            System.out.println("Could not find any file");
        }
    }

    /**
     * This method will read the next line of the save data
     */
    public void readFile() {
        try {
            datas = read.nextLine();
        } catch (NoSuchElementException e) {
//            System.out.println("You have no task in your list.Try to add some new tasks with todo/event/deadline keywords.");
        }
    }

    /**
     * This method will return the data value
     * @return datas the data value
     */
    public String getData() {
        return datas;
    }

    /**
     * This method will close the scanner read.
     */
    public void closeFile() {
        read.close();
    }


}
