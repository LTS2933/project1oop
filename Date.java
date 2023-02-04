import java.util.Calendar;

public class Date implements Comparable<Date>{
    private int year;
    private int month;
    private int day;

    public Date(){

    }

    public Date (int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Date(String string){
        String [] array = string.split("/");
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
    public boolean equals(Object obj){
        Date compare = null;
        if (obj instanceof Date){
            compare = (Date) obj;
        }
        return compare.getDay() == this.day && compare.getMonth() == this.month && compare.getYear() == this.year;
    }

    @Override
    public int compareTo(Date obj){
        if (this.year == obj.year && this.day == obj.day && this.month == obj.month) return 0;
        if (this.year < obj.year) return -1;
        if (this.year <= obj.year && this.month < obj.month) return -1;
        if (this.year <= obj.year && this.month <= obj.month && this.day < obj.day ) return -1;
        
        return 1;
    }

    @Override
    public String toString(){
        return this.month + "/" + this.day + "/" + this.year;
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

    public boolean isValid() {
        if ((this.day > 31) || this.month > 12 || this.month < 0 ) {
            return false;
        }
        if ((this.month == 2) || (this.month == 4) || (this.month == 6 ||
                (this.month == 9) || (this.month == 11))) {
                    if (this.day > 30) {
                        return false;
                    }
        if (this.month == 2) {
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

    public static void main (String [] args){
        
    }
}
