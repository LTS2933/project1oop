public class Date implements Comparable<Date>{
    private int year;
    private int month;
    private int day;

    public Date(){

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

    public boolean isValid(){
        return true;
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
        return 0;
    }
}
