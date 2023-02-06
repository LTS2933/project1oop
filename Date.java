/**
 * This class implements the Comparable Interface and runs various methods on Date objects.
 * Some of these methods include getAge(), which returns an integer value of the current object's age in years.
 *
 * @author Christian Osma, Liam Smith
 **/

import java.util.Calendar;
public class Date implements Comparable<Date>{
    private int year;
    private int month;
    private int day;

    private static final int QUADRENNIAL = 4;
    public static final int CENTENNIAL = 100;
    public static final int QUATERCENTENNIAL = 400;


    /* Default constructor, takes no arguments and instantiates a date object.
    */
    public Date(){
    }
    /*Overloaded constructor.
    @param day - the day of the Date object as an int type, month - the day of the Date object as an int type, year - the year of the Date object as an int type
    * */
    public Date(int day, int month, int year){
        this.year = year;
        this.month = month;
        this.day = day;
    }
    /*
    Overloaded constructor. Instantiates new Date object.
    @param dateParse - String formatted like "2/24/2003", instantiates a Date object from this String.
     */
    public Date(String dateParse){
        String [] array = dateParse.split("/");
        this.month = Integer.parseInt(array[0])-1;
        this.day = Integer.parseInt(array[1]);
        this.year = Integer.parseInt(array[2]);
    }

    /*
    Getter method, returns the year of the current object as an int type.
    @return year of current Date object
     */
    public int getYear(){
        return this.year;
    }

    /*
    Getter method, returns the month of the current object as an int, with January indexed as 0.
    @return month of current Date object as an int type
     */
    public int getMonth(){
        return this.month;
    }

    /*
    Getter method, returns the day of the current object as an int.
    @return day of current Date object as an int type.
     */
    public int getDay(){
        return this.day;
    }
    /*
    Compares 2 dates
    @param Object to be compared with current Date object.
    @return true if the 2 dates are exactly the same (day, month, year), false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        Date compare = null;
        if (obj instanceof Date) {
            compare = (Date) obj;
        }
        return compare.getDay() == this.getDay() && compare.getMonth() == this.getMonth() && compare.getYear() == this.getYear();
    }
    /*
    Checks whether the current Date object is a valid calendar date
    @return String to confirm/deny whether the Date is a valid calendar date.
     */
    public String isValid() {
        if ((this.getDay() > 31) || this.getMonth() > 12 || this.getMonth() < 0 || this.getDay() < 1) {
            return this.toString() + " is not a valid calendar date.";
        }
        if ((this.getMonth() == Calendar.APRIL) || (this.getMonth() == Calendar.JUNE ||
                (this.getMonth() == Calendar.SEPTEMBER) || (this.getMonth() == Calendar.NOVEMBER))) {
            if (this.getDay() > 30) {
                return this.toString() + " is not a valid calendar date.";
            }
        }
        if (this.getMonth() == Calendar.FEBRUARY) {
            if (this.getDay() > 29) {
                return this.toString() + " is not a valid calendar date.";
            }
            if (this.getDay() == 29) {
                if (this.getYear() % QUADRENNIAL == 0) {
                    if (this.getYear() % CENTENNIAL == 0) {
                        if (this.getYear() % QUATERCENTENNIAL == 0) {
                            return this.toString() + " is a valid calendar date.";
                        } else {
                            return this.toString() + " is not a valid calendar date.";
                        }
                    } else {
                        return this.toString() + " is a valid calendar date.";
                    }
                } else {
                    return this.toString() + " is not a valid calendar date.";
                }
            }
        }
        return this.toString() + " is a valid calendar date.";
    }
    /*
    Compares the current day (through Calendar import package) with whatever Date object is calling the method
    @return int corresponding to the Date object's age in years.
     */
    public int getAge(){

        Calendar calendar = Calendar.getInstance();

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);


        int age = year - this.getYear();
        if ((this.getMonth() > month || this.getMonth() == month && this.getDay() > day))
        {
            age--;
        }
        return age;
    }
    /*Compares the current Date object with another Date object passed as an argument
    @param Date object to be compared with current Date object
    @return 1 if the current Date object occurs later in time than the Date object parameter,
    -1 if the parameters Date object occurs later in time than this Date object,
    and 0 if the 2 Date objects are the same date.
    */

    @Override
    public int compareTo(Date d) {
        if (this.getYear() > d.getYear()) {
            return 1;
        }
        else if (this.getYear() < d.getYear()){
            return -1;
        } else {
            if (this.getMonth() > d.getMonth()) {
                return 1;
            }
            else if (this.getMonth() < d.getMonth()){
                return -1;
            }
            else {
                if (this.getDay() > d.getDay()) {
                    return 1;
                }
                else if (this.getDay() < d.getDay()){
                    return -1;
                }
                else {
                    return 0;
                }
            }
        }
    }
    /*
    Converts the current Date object to a String.
    @return String, formatted as "1/20/2018" for January 20, 2018, for example.
     */
    @Override
    public String toString(){
        return this.getMonth()+1 + "/" + this.getDay() + "/" + this.getYear();
    }
    public static void main (String [] args){
        Date d1 = new Date(29, 1, 2003);
        Date d2 = new Date(31, -2, 2003);
        Date d3 = new Date(31, 12, 2003);
        Date d4 = new Date(32, 2, 2007);
        Date d5 = new Date(31, 3, 2005);
        Date d6 = new Date(5, 6, 2001);
        Date d7 = new Date(8, 2, 2003);

        System.out.println(d1.isValid());
        System.out.println(d2.isValid());
        System.out.println(d3.isValid());
        System.out.println(d4.isValid());
        System.out.println(d5.isValid());
        System.out.println(d6.isValid());
        System.out.println(d7.isValid());

    }
}
