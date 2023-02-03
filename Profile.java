import java.util.Date;

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
    public String getLname(){
        return this.lname;
    }
    public String getFname(){
        return this.fname;
    }
    public Date getDOB(){
        return this.dob;
    }
    @Override
    public String toString(){
        String str = "";
        str += "First name: " + this.fname;
        str += " | Last name: " + this.lname;
        str += " | DOB: " + this.dob;
        return str;
    }
    @Override
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
    }


    @Override
    public int compareTo(Profile pr) {

        if (this.getLname().compareTo(pr.getLname()) < 0){
            return 1;
        }
        else if (this.getLname().compareTo(pr.getLname()) > 0){
            return -1;
        }
        else {
            if (this.getFname().compareTo(pr.getFname()) < 0){
                return 1;
            } else if (this.getFname().compareTo(pr.getFname()) > 0) {
                return -1;
            }
            else {
                if (this.getDOB().compareTo(pr.getDOB()) > 0) {
                    return -1;
                }
                else if (this.getDOB().compareTo(pr.getDOB()) < 0){
                    return 1;
                }
                else {
                    return 0;
                }
            }
        }
    }
}
