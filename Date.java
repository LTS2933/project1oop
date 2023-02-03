import java.util.Calendar;
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
        return compare.getDay() == this.getDay() && compare.getMonth() == this.getMonth() && compare.getYear() == this.getYear();
    }
    public boolean isValid() {
        if ((this.getDay() > 31) || this.getMonth() > 12 || this.getMonth() < 0 || this.getDay() < 1) {
            return false;
        }
        if ((this.getMonth() == Calendar.APRIL) || (this.getMonth() == Calendar.JUNE ||
                (this.getMonth() == Calendar.SEPTEMBER) || (this.getMonth() == Calendar.NOVEMBER))) {
            if (this.getDay() > 30) {
                return false;
            }
        }
        if (this.getMonth() == Calendar.FEBRUARY) {
            if (this.getDay() > 29) {
                return false;
            }
            if (this.getDay() == 29) {
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
