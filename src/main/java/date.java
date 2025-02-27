import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class date {
    String[] listOfDate = new String[100]; //store the list of dates
    Date dueDate = new Date();
    private int counter = 1;
    private boolean checkDate = false;
    private int position;

    /**
     * Take in a counter and set the counter in this class as that counter.
     * @param counter
     */
    public void setCounter(int counter) {
        this.counter = counter;
    }

    /**
     * Take in the user input date and convert it to a system recognisable date
     * @param inputDate
     */
    public void dateConvert(String inputDate) {
        listOfDate[counter] = inputDate;
        position = inputDate.indexOf("-");
        try {
            if(position == -1) { //if there is only one input time
                Date dueDate = new SimpleDateFormat("dd.MM.yyyy HH mm").parse(inputDate);
//                System.out.println(dueDate);
                checkDate = true;
            } else { //if there is a time range
                Date dueDate1 = new SimpleDateFormat("dd.MM.yyyy HH mm").parse(inputDate.substring(0,position));
                Date dueDate2 = new SimpleDateFormat("dd.MM.yyyy HH mm").parse(inputDate.substring(0,position - 5)+inputDate.substring(position + 1));
//                System.out.println(dueDate1 +" to "+ dueDate2);
                checkDate = true;
            }
        } catch(ParseException e) {//if user input a invalid time format
            checkDate = false;
            System.out.println("Invalid date and time format. Please enter your date and time in the following format :\n" +
                    "dd.mm.yyyy hh mm  i.e. 05.12.2019 12 30  OR\n" +
                    "dd.mm.yyyy hh mm-hh mm  i.e. 05.12.2019 12 30-14 30\n");
        }
    }

    /**
     * check if the input date is a valid input date
     * @return checkDate the checker to see if the user input is a valid date.
     */
    public boolean getCheckDate () {
        return checkDate;
    }

//    public String toString() {
//        return String.format(dueDate.toString());
//    }

}
