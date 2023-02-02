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
        String str = "";
        str += profile.toString();
        str += major.toString();
        str += " Number of credits completed: " + creditsCompleted;
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
        return 0;
    }

    public static void main (String [] args){
        Profile first = new Profile("Chritian", "Osma", new Date("9/24/2002"));
        Profile second = new Profile("Christian", "Osma", new Date("9/24/2005"));

        Student test1 = new Student(first, Major.CS, 32);
        Student test2 = new Student(second, Major.BAIT, 100);
    
        System.out.println(test1.equals(test2));

    }
}
