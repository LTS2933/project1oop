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
    @Override
    public String toString(){
        String str = "";
        str += profile.toString();
        str += major.toString();
        str += " Number of credits completed: " + creditsCompleted;
        return str;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            Student st = (Student) obj;
        }
        return (this.profile == st.profile);
    }
    @Override
    public int compareTo(Student st) {
        return 0;
    }
}
