import java.time.Month;
import java.time.LocalDate;
import java.util.Calendar;
import java.lang.Integer;
import java.util.GregorianCalendar;
public class Date implements Comparable<Date>{
    private int year;
    private int month;
    private int day;

    private static final int QUADRENNIAL = 4;
    public static final int CENTENNIAL = 100;
    public static final int QUATERCENTENNIAL = 400;

    public Date(){
    }
    public Date(int day, int month, int year){
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public Date(String dateParse){
        String [] array = dateParse.split("/");
        this.month = Integer.parseInt(array[0]);
        this.day = Integer.parseInt(array[1]);
        this.year = Integer.parseInt(array[2]);
    }

    public int getYear(){
        return this.year;
    }

    public int getMonth(){
        return this.month;
    }

    public int getDay(){
        return this.day;
    }
    @Override
    public boolean equals(Object obj) {
        Date compare = null;
        if (obj instanceof Date) {
            compare = (Date) obj;
        }
        return compare.getDay() == this.day && compare.getMonth() == this.month && compare.getYear() == this.year;
    }
    public boolean isValid() {
        boolean isValid = false;
        if ((this.day > 31) || this.month > 12 || this.month < 0 ) {
            return false;
        }
        if ((this.month == Calendar.FEBRUARY) || (this.month == Calendar.APRIL) || (this.month == Calendar.JUNE ||
                (this.month == Calendar.SEPTEMBER) || (this.month == Calendar.NOVEMBER))) {
                    if (this.day > 30) {
                        return false;
                    }
        if (this.month == Calendar.FEBRUARY) {
            if (this.day == 29){
                if (this.year % 4 ==0){
                    if (this.year % 100 == 0){
                        if (this.year % 400 == 0){
                            return true;
                        }
                        else {
                            return false;
                        }
                    }
                    else {
                        return true;
                    }
                }
                return false;
            }
        }
        }
        return true;
    }
    public int getAge(){
        Calendar dob = new GregorianCalendar(this.year, this.month, this.day);
        Calendar currentDate = new GregorianCalendar();
        int age = currentDate.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
        if ((dob.get(Calendar.MONTH) > currentDate.get(Calendar.MONTH)) || (dob.get(Calendar.MONTH) == currentDate.get(Calendar.MONTH) && dob.get(Calendar.DAY_OF_MONTH) > currentDate.get(Calendar.DAY_OF_MONTH)))
        {
            age--;
        }
        return age;
    }
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
}
