import java.io.*;
import java.lang.*;
import java.util.*;
public class saveWrite {
    private Formatter write;
    public void openFile() {
        try{
            write = new Formatter("saves.txt"); //create a new file call saves
        } catch (Exception e) {
            System.out.println("You have an error.");
        }
    }

    //insert the elements into the file.
    public void addRecords(String temp) {
        write.format("%s\n",temp);
    }

    //close the file
    public void closeFile() {
        write.close();
    }
}
