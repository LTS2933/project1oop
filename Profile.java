public class Profile implements Comparable<Profile>{
    private String fname;
    private String lname;
    private Date dob;

    public Profile(){
        fname = "Jane";
        lname = "Doe";
        dob = new Date();
    }
    public Profile(String fname, String lname, Date dob){
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
    }
    public Profile(Profile pr){
        this.fname = pr.fname;
        this.lname = pr.lname;
        this.dob = pr.dob;
    }
    @Override
    public String toString(){
        String str = fname + " " + lname + " " + dob.toString();
        return str;
    }


    /*@Override
    public boolean equals(Object obj){
        if (obj instanceof Profile) {
            Profile pr = (Profile) obj;
            if (this.fname.length() != pr.fname.length() || this.lname.length() != pr.lname.length()){
                return false;
            }
            for (int i = 0; i < this.fname.length(); i++) {
                if (this.fname.charAt(i) == pr.fname.charAt(i)) {
                    for (int j = 0; j < this.lname.length(); j++) {
                        if (this.lname.charAt(j) == pr.lname.charAt(j)) {
                            if (this.dob.compareTo(pr.dob) == 0) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }/* */

    @Override
    public boolean equals(Object obj){
        Profile compare = null;
        if (obj instanceof Profile){
            compare = (Profile) obj;
        }
        boolean firstNameEquals = this.fname.toLowerCase().equals(compare.fname.toLowerCase());
        boolean lastNameEquals = this.lname.toLowerCase().equals(compare.lname.toLowerCase());
        boolean dateEquals = this.dob.equals(compare.dob);

        return (firstNameEquals & lastNameEquals & dateEquals);
    }


    @Override
    public int compareTo(Profile pr) {
        int lastNameCompare = this.lname.compareTo(pr.lname);
        if (lastNameCompare < 0) return -1;
        
        int firstNameCompare = this.fname.compareTo(pr.fname);
        if (lastNameCompare == 0 && firstNameCompare < 0 ) return -1;

        int dateCompare = this.dob.compareTo(pr.dob);
        if (lastNameCompare == 0 && firstNameCompare == 0 && dateCompare < 0) return -1;

        if (lastNameCompare + firstNameCompare + dateCompare == 0) return 0;

        return 1;
    }

    public static void main (String [] args){
        
    }
}
