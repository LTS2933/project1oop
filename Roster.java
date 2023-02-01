
public class Roster {
    private final static int NOT_FOUND = -1;

    private Student [] roster;
    private int size;

    public Roster(){
        this.roster = new Student[4];
        this.size = 0;
    }

    private int find(Student student){
        for (int i = 0; i<this.size; i++){
            if (student.equals(roster[i])) return i;
        }
        return NOT_FOUND;
    }

    private void grow(){
        Student [] newRoster = new Student[roster.length+4];
        for (int i = 0; i<this.size; i++){
            newRoster[i] = roster[i];
        }
        this.roster = newRoster;
    }

    public boolean add (Student student){
        if (this.size == roster.length) grow();
        this.roster[this.size] = student;
        this.size++;
        return true;
    }

    public boolean remove (Student student){
        int indexOfStudent = find(student);
        if (indexOfStudent == -1) return false;

        roster[indexOfStudent] = null;
        for (int i = indexOfStudent; i<this.size-1; i++){
            roster[i] = roster[i+1];
        }
        this.size--;
        return true;
    }

    public boolean contains (Student student){
        int index = find(student);
        if (index == -1) return false;
        return true;
    }

    public void print(){
        
    }

    public void printBySchoolMajor(){

    }

    public void printByStanding(){

    }

    public static void main (String [] args){
        

    }
}
