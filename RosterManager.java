import java.util.Scanner;
import java.util.StringTokenizer;

public class RosterManager { 
    
    private Scanner sc;
    private Roster roster;

    public RosterManager(){
        this.sc = new Scanner(System.in);
        this.roster = new Roster();
    }

    public void run(){
        System.out.println("Roster manager running ...");
        System.out.println();
        boolean running = true;
        while (running){
            String line = sc.nextLine();
            StringTokenizer st = new StringTokenizer(line);
            if (st.countTokens() == 0) {
                // continue to next iteration
                continue;
            }

            String firstOperating = st.nextToken();
            switch(firstOperating){
                case "A":
                    handleAddStudent(st);
                    break;
                case "R": 
                    // call remove student function
                    handleRemoveStudent(st);
                    break;
                case "P":
                    // call display student function
                    roster.print();
                    break;
                case "PS":
                    // call display student function sort by standing
                    roster.printByStanding();
                    break;
                case "PC":
                    // call display student function sort by school and major
                    roster.printBySchoolMajor();
                    break;
                case "L":
                    // call list student function depending on school
                    handleListStudent(st.nextToken());
                    break;
                case "C":
                    // call change student major function
                    handleChangeMajor(st);
                    break;
                case "Q":
                    System.out.println("Roster manager terminated.");
                    running = false;
                    break;
                default: 
                    System.out.println(firstOperating + " is an invalid command!");
            } 
        }
    }

    private void handleChangeMajor(StringTokenizer st){
        String firstName = st.nextToken();
        String lastName = st.nextToken();

        String stringDate = st.nextToken();
        Date date = new Date(stringDate);

        String stringMajor = st.nextToken();
        Major major = getMajor(stringMajor);

        // valid date

        if (major == null){
            System.out.println("Major code invalid: " + stringMajor);
            return;
        }

        Student student = new Student(new Profile(firstName, lastName, date), Major.CS, 100);
        if (this.roster.contains(student) == false){
            System.out.println(firstName + " " + lastName + " " + stringDate + " is not in the roster.");
            return;
        }

        System.out.println(firstName + " " + lastName + " " + stringDate + " major changed to " + stringMajor);
        this.roster.changeMajor(student, major);
    }

    private void handleAddStudent(StringTokenizer st){
       String firstName = st.nextToken();
       String lastName = st.nextToken();
       String stringDate = st.nextToken();
       Date date = new Date(stringDate);

       String requestedMajor = st.nextToken();
       Major major = getMajor(requestedMajor.toUpperCase());

       if (date.isValid() == false){
            System.out.println("DOB invalid: " + stringDate + " not a valid calendar date!");
            return;
       }

       // check if dob is today or in the future

       // check if student is less than 16 

       if (major == null){
            System.out.println("Major code invalid: " + requestedMajor);
            return;
       }

       int credits = 0;
       try { 
            credits = Integer.parseInt(st.nextToken());
       } catch (Exception e){
            System.out.println("Credits completed invalid: not an integer!");
            return;
       }
       if (credits < 0) { 
            System.out.println("Credits completed invalid: cannot be negative!");
            return;
       }

        Student student = new Student(new Profile(firstName, lastName, date), major, credits);
        if (this.roster.contains(student) == true){
            System.out.println(firstName + " " + lastName + " " + stringDate + " is already in the roster");
            return;
        }

        this.roster.add(student);
        System.out.println(firstName + " " + lastName + " " + stringDate + " added to the roster");

    }

    private void handleRemoveStudent(StringTokenizer st){
        String firstName = st.nextToken();
        String lastName = st.nextToken();
        String stringDate = st.nextToken();
        Date date = new Date(stringDate);

        Student student = new Student(new Profile(firstName, lastName, date), Major.CS, 106);
        if (this.roster.contains(student) == false){
            System.out.println(firstName + " " + lastName + " " + stringDate + " is not in the roster");
            return;
        }

        this.roster.remove(student);
        System.out.println(firstName + " " + lastName + " " + stringDate + " removed from the roster");

    }

    private void handleListStudent(String string){
        if (string.equals("")){
            System.out.println("Please enter a school name: ");
            return;
        }
        boolean isSchool = false;
        String school = string.toUpperCase();
        for (Major major : Major.values()){
            if (school.equals(major.getSchoolName())) isSchool = true;
        }
        if (isSchool == false){
            System.out.println("School doesn't exist: " + string);
            return;
        }
        this.roster.printBySchool(string);
    }

    public static Major getMajor(String major){
        switch(major){
            case "BAIT":
                return Major.BAIT;
            case "CS":
                return Major.CS;
            case "MATH":
                return Major.MATH;
            case "ITI":
                return Major.ITI;
            case "EE":
                return Major.EE;
            default:
                return null;
        }
    }

    public static void main (String [] args){
        
    }
}