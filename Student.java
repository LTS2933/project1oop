public class Student implements Comparable<Student>{
    private Profile profile;
    private Major major;
    private int creditsCompleted;

    public Student(){
        this.profile = new Profile();
        this.major = null;
        this.creditsCompleted = 0;
    }
    public Student(Profile profile, Major major, int creditsCompleted){
        this.profile = profile;
        this.major = major;
        this.creditsCompleted = creditsCompleted;
    }
    public Student(Student st){
        this.profile = st.profile;
        this.major = st.major;
        this.creditsCompleted = st.creditsCompleted;
    }

    public Profile getProfile(){
        return this.profile;
    }

    public Major getMajor(){
        return this.major;
    }

    public void setMajor(Major major){
        this.major = major;
    }

    public int getCredits(){
        return this.creditsCompleted;
    }

    @Override
    public String toString(){
        String str = profile.toString();
        str =  str + " (" + major.getMajorCode() + " " + major + " " + major.getSchoolName() + ") ";
        str = str + "credits completed : " + creditsCompleted;
        String year = "Senior";
        if (this.creditsCompleted < 30) year = "Freshman";
        else if (this.creditsCompleted < 60) year = "Sophomore";
        else if (this.creditsCompleted < 90) year = "Junior";
        str += " (" + year + ")";
        return str;
    }
    @Override
    public boolean equals(Object obj) {
        Student st = null;
        if (obj instanceof Student) {
            st = (Student) obj;
        }
        return (this.profile.equals(st.getProfile()));
    }
    @Override
    public int compareTo(Student st) {
        return this.profile.compareTo(st.profile);
    }

    public static void main (String [] args){

    }
}
