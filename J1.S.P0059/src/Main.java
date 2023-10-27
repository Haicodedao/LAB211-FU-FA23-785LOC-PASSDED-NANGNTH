
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Manager mn = new Manager();
        CheckInput ci = new CheckInput();
        int choice;
        do {
            mn.Menu();
            choice = ci.checkInput("Enter your choice: ");
            switch (choice) {
                case 1:
                    // Find person info
                    mn.findPersonInfo();
                    break;
                case 2:
                    mn.copyTextToFile();
                    break;
                case 3:
                    System.out.println("See you again.");
                    break;
            }
        } while (choice != 3);
    }

    
}
