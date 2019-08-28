import java.io.*;
import java.lang.*;
import java.util.*;
public class saveRead {
    private Scanner read;
    private String datas;
    public void openFile() {
        try{
            read = new Scanner(new File("saves.txt"));
        } catch(Exception e) {
            System.out.println("Could not find any file");
        }
    }
    //read the next line of data
    public void readFile() {
            datas = read.nextLine();
    }

    //return the data value
    public String getData() {
        return datas;
    }

    //close the file
    public void closeFile() {
        read.close();
    }


}
