import java.io.*;
import java.lang.*;
import java.util.*;
public class saveWrite {
    private Formatter write;

    /**
     * This method will create a new file call saves
     * @throws Exception if create file fail
     */
    public void openFile() {
        try{
            write = new Formatter("saves.txt");
        } catch (Exception e) {
            System.out.println("You have an error.");
        }
    }

    /**
     * This method will insert the string temp into the save file
     * @param temp the string to be insert into the save file
     */
    public void addRecords(String temp) {
        write.format("%s\n",temp);
    }

    /**
     * This method will close the save file
     */
    public void closeFile() {
        write.close();
    }
}
