import java.util.Calendar;

/**
 * This class implements the Comparable Interface and runs various methods on Date objects.
 * Some of these methods include getAge(), which returns an integer value of the current object's age in years.
 *
 * @author Christian Osma, Liam Smith
 **/
public class Date implements Comparable<Date>{
    private int year;
    private int month;
    private int day;

    private static final int QUADRENNIAL = 4;
    public static final int CENTENNIAL = 100;
    public static final int QUATERCENTENNIAL = 400;
    public static final int LONGER_DAYS_IN_MONTH = 31;
    public static final int SMALLER_DAYS_IN_MONTH = 30;
    public static final int NUM_MONTHS = 12;
    public static final int DAYS_IN_FEBRUARY_LEAPYEAR = 29;
    public static final int SMALLEST_MONTH_INDEX = 1;
    public static final int SMALLEST_DAY_INDEX = 1;
    public static final int LOWEST_VALID_YEAR = 1900;



    /**
    Default constructor, takes no arguments and instantiates a date object.
    */
    public Date(){
    }
    /**
     * Overloaded constructor.
    @param day - the day of the Date object as an int type
    @param month - the day of the Date object as an int type
    @param year - the year of the Date object as an int type
     */
    public Date(int day, int month, int year){
        this.year = year;
        this.month = month;
        this.day = day;
    }
    /**
    Overloaded constructor. Instantiates new Date object.
    @param date - String formatted like "2/24/2003", instantiates a Date object from this String.
     */
    public Date(String date){
        String [] array = date.split("/");
        this.month = Integer.parseInt(array[0]);
        this.day = Integer.parseInt(array[1]);
        this.year = Integer.parseInt(array[2]);
    }
    /**
    Copy constructor. Copies the information of the argument and stores its variables within
    the corresponding instance variables of the current Date object.
    @param d - Date object which contains the information we wish to copy to the current Date object.
    */
    public Date(Date d){
        this.year = d.year;
        this.month = d.month;
        this.day = d.day;
    }

    /**
    Getter method, returns the year of the current object as an int type.
    @return year of current Date object as an int
     */
    public int getYear(){
        return this.year;
    }

    /**
    Getter method, returns the month of the current object as an int, with January indexed as 0.
    @return month of current Date object as an int type
     */
    public int getMonth(){
        return this.month;
    }

    /**
    Getter method, returns the day of the current object as an int.
    @return day of current Date object as an int type
     */
    public int getDay(){
        return this.day;
    }
    /**
    Compares 2 dates
    @param obj - should be an instance of a Date object to be compared with current Date object.
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
    /**
    Checks whether the current Date object is a valid calendar date
    @return String to confirm/deny whether the Date is a valid calendar date.
     */
    public boolean isValid() {
        if ((this.getDay() > LONGER_DAYS_IN_MONTH) || this.getMonth() > NUM_MONTHS || this.getMonth() < SMALLEST_MONTH_INDEX || this.getDay() < SMALLEST_DAY_INDEX || this.getYear() < LOWEST_VALID_YEAR) {
            return false;
        }
        if ((this.getMonth() == (Calendar.APRIL +1)) || (this.getMonth() == (Calendar.JUNE +1)) ||
                (this.getMonth() == (Calendar.SEPTEMBER +1)) || (this.getMonth() == (Calendar.NOVEMBER +1))) {
            if (this.getDay() > SMALLER_DAYS_IN_MONTH) {
                return false;
            }
        }
        if (this.getMonth() == (Calendar.FEBRUARY+1)) {
            if (this.getDay() > DAYS_IN_FEBRUARY_LEAPYEAR) {
                return false;
            }
            if (this.getDay() == DAYS_IN_FEBRUARY_LEAPYEAR) {
                if (this.getYear() % QUADRENNIAL == 0) {
                    if (this.getYear() % CENTENNIAL == 0) {
                        if (this.getYear() % QUATERCENTENNIAL == 0) {
                            return true;
                        } else {
                            return false;
                        }
                    } else {
                        return true;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }
    /**
    Compares the current day (through Calendar import package) with whatever Date object is calling the method
    @return the Date object's age in years as an int type
     */
    public int getAge(){

        Calendar calendar = Calendar.getInstance();

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH + 1);
        int day = calendar.get(Calendar.DAY_OF_MONTH);


        int age = year - this.getYear();
        if ((this.getMonth() > month || this.getMonth() == month && this.getDay() > day))
        {
            age--;
        }
        return age;
    }
    /**
     * Compares the current Date object with another Date object passed as an argument
    @param d - Date object to be compared with current Date object
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
    /**
    Converts the current Date object to a String.
    @return String formatted as "1/20/2018" for January 20, 2018, for example.
     */
    @Override
    public String toString(){
        return this.getMonth() + "/" + this.getDay() + "/" + this.getYear();
    }
    public static void main (String [] args){
        Date d1 = new Date(29, 2, 2003);
        Date d2 = new Date(31, 4, 2003);
        Date d3 = new Date(31, 13, 2003);
        Date d4 = new Date(32, 3, 2003);
        Date d5 = new Date(31, -1, 2003);
        Date d6 = new Date(3, 4, 2003);
        Date d7 = new Date(20, 1, 2003);

        System.out.println(d1.isValid());
        System.out.println(d2.isValid());
        System.out.println(d3.isValid());
        System.out.println(d4.isValid());
        System.out.println(d5.isValid());
        System.out.println(d6.isValid());
        System.out.println(d7.isValid());

    }
}
