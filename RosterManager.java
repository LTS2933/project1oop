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
                System.out.println("invalid command!");
                // continue to next iteration
                continue;
            }

            String firstOperating = st.nextToken();
            switch(firstOperating){
                case "A":
                    // call add student function
                    break;
                case "R": 
                    // call remove student function
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
                    break;
                case "C":
                    // call change student major function
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
}