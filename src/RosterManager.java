package src;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 This class reads standard input from the user and executes, processes
 the commands, and then displays results to user in standard output
 @author Christian Osma, Liam Smith
 */
public class RosterManager {

    private Scanner sc;
    private Roster roster;

    /**
     Initializes sc to a new Scanner that takes standard input from user.
     Initializes roster to a new Roster object with an initla capacity of 4.
     */
    public RosterManager(){
        this.sc = new Scanner(System.in);
        this.roster = new Roster();
    }

    /**
     Starts roster manager and calls the method loop() which
     takes user input.
     */
    public void run(){
        System.out.println("Roster Manager running...");
        System.out.println();
        loop();
    }

    /**
     Creates a loop that continues to take user commands and
     execute them until the user exits the program.
     */
    private void loop(){
        boolean running = true;
        while (running){
            String line = sc.nextLine();
            StringTokenizer st = new StringTokenizer(line);
            if (st.countTokens() == 0)  continue;
            String firstOperation = st.nextToken();
            switch(firstOperation){
                case "A":
                    handleAddStudent(st);
                    break;
                case "R":
                    handleRemoveStudent(st);
                    break;
                case "P":
                    roster.print();
                    break;
                case "PS":
                    roster.printByStanding();
                    break;
                case "PC":
                    roster.printBySchoolMajor();
                    break;
                case "L":
                    handleListStudent(st.nextToken());
                    break;
                case "C":
                    handleChangeMajor(st);
                    break;
                case "Q":
                    System.out.println("Roster Manager terminated.");
                    running = false;
                    break;
                default:
                    System.out.println(firstOperation + " is an invalid command!");
            }
        }
    }

    /**
     Changes student major given the rest of the command from the user.
     Prints out error if major is invalid or if the student is not in the roster
     and success message if major was successfully changed
     @param st : StringTokenizer that contains the rest of the user command
     */
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

    /**
     Adds student to the Roster given the rest of the user input. Returns
     error if date is invalid, student is less than 16 years old, credits is
     invalid, major is invalid, or the student is already in the roster.
     @param st : StringTokenizer that contains the rest of user input
     */
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
        if (isBeforeCurrent(date) == false){
            System.out.println("DOB invalid: " + stringDate + " is today or in the future!");
            return;
        }

        // check if student is less than 16
        if (date.getAge() < 16){
            System.out.println("DOB invalid: " + stringDate + " younger than 16 years old.");
            return;
        }

        if (major == null){
            System.out.println("Major code invalid: " + requestedMajor);
            return;
        }

        int credits = 0;
        try {
            credits = Integer.parseInt(st.nextToken());
        } catch (Exception e) {
            System.out.println("Credits completed invalid: not an integer!");
            return;
        }
        if (credits < 0) {
            System.out.println("Credits completed invalid: cannot be negative!");
            return;
        }

        Student student = new Student(new Profile(firstName, lastName, date), major, credits);
        if (this.roster.contains(student) == true){
            System.out.println(firstName + " " + lastName + " " + stringDate + " is already in the roster.");
            return;
        }

        this.roster.add(student);
        System.out.println(firstName + " " + lastName + " " + stringDate + " added to the roster.");

    }

    /**
     Removes student from the Roster unless they are not in the roster.
     Prints out error or success message.
     @param st : StringTokenizer that contains the rest of the user input
     */
    private void handleRemoveStudent(StringTokenizer st){
        String firstName = st.nextToken();
        String lastName = st.nextToken();
        String stringDate = st.nextToken();
        Date date = new Date(stringDate);

        Student student = new Student(new Profile(firstName, lastName, date), Major.CS, 106);
        if (this.roster.contains(student) == false){
            System.out.println(firstName + " " + lastName + " " + stringDate + " is not in the roster.");
            return;
        }

        this.roster.remove(student);
        System.out.println(firstName + " " + lastName + " " + stringDate + " removed from the roster.");

    }

    /**
     Method takes string representation of a school and calls
     roster method that returns lists of students belonging
     to that school, then prints it out to Standard Output.
     @param string : a string representation of the school
     */
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
        Student [] array = this.roster.getBySchool(school);
        if (array == null){
            System.out.println("Student roster is empty!");
            return;
        }
        System.out.println("* Students in " + string + " *");
        for (int i = 0; i<array.length; i++){
            System.out.println(array[i].toString());
        }
        System.out.println("* end of list **");
    }

    /**
     Takes String input and returns its equivalent value in the
     enum Major class.
     @param major : String representation of the inputed major
     @return returns object from Major class depending on input
     */
    private Major getMajor(String major){
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

    /**
     Takes in a student's date of birth and returns true if the student
     was born before present and false otherwise
     @param dob : student's date of birth
     @return true if student was born before present day
     */
    private boolean isBeforeCurrent(Date dob){
        Date currentDate = new Date();
        int compare = dob.compareTo(currentDate);

        if (compare < 0) return true;
        return false;
    }

}