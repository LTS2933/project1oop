
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
        if (this.size == 0){
            System.out.println("Student roster is empty!");
            return;
        }
        for (int i = 0; i<this.size-1; i++){
            Profile minProfile = this.roster[i].getProfile();
            int minIndex = i;
            for (int j = i+1; j<this.size; j++){
                Profile currProfile = this.roster[i].getProfile();
                if (currProfile.compareTo(minProfile) < 0){
                    minProfile = currProfile;
                    minIndex = j;
                }
            }
            Student minStudent = this.roster[minIndex];

            Student temp = minStudent;
            this.roster[minIndex] = this.roster[i];
            this.roster[i] = temp;
        }
        System.out.println("* Student roster sorted by last name, first name, and DOB **");
        for (int i = 0; i<this.size; i++){
            System.out.println(this.roster[i].toString());
        }
        System.out.println("* end of roster **");
        
    }

    public void printBySchoolMajor(){
        if (this.size == 0){
            System.out.println("Student roster is empty!");
            return;
        }
        int minIndex = 0;
        for (Major major: Major.values()){
            for (int i = minIndex; i<this.size; i++){
                Student currStudent = this.roster[i];
                Major studentMajor = currStudent.getMajor();
                if (studentMajor == major){
                    Student temp = this.roster[minIndex];
                    this.roster[minIndex] = currStudent;
                    this.roster[i] = temp;
                    minIndex++;
                }
            }
        }
        System.out.println("* Student roster sorted by school, major **");
        for (int i = 0; i<this.size; i++){
            System.out.println(roster[i].toString());
        }
        System.out.println("* end of roster **");
    }

    public void printByStanding(){
        if (this.size == 0){
            System.out.println("Student roster is empty!");
            return;
        }
        for (int i = 0; i<this.size-1; i++){
            int minCredits = this.roster[i].getCredits();
            int minIndex = i;
            for (int j = i+1; j<this.size; j++){
                Student currStudent = this.roster[j];
                if (currStudent.getCredits() < minCredits){
                    minCredits = currStudent.getCredits();
                    minIndex = j;
                }
            }
            Student newMinimum = this.roster[minIndex];

            Student temp = newMinimum;
            this.roster[minIndex] = this.roster[i];
            this.roster[i] = temp;
        }
        System.out.println("* Student roster sorted by standing **");
        for (int i = 0; i<this.size; i++){
            System.out.println(this.roster[i].toString());
        }
        System.out.println("* end of roster **");
    }

    public void printBySchool(String string){
        if (this.size == 0){
            System.out.println("Student roster is empty!");
            return;
        }
        System.out.println("* Students in " + string + " **");
        String school = string.toUpperCase();
        for (int i = 0; i<this.size; i++){
            Student currStudent = this.roster[i];
            Major currMajor = currStudent.getMajor();
            if (school.equals(currMajor.getSchoolName())) System.out.println(currStudent.toString());
        }
        System.out.println("* end of roster **");
    }
    
    public void changeMajor(Student student, Major major){
        int indexOfStudent = find(student);
        this.roster[indexOfStudent].setMajor(major);
    }

    public static void main (String [] args){

        

    }
}
