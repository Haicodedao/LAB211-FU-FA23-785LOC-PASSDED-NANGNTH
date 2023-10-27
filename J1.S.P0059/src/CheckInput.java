
import java.util.Scanner;

public class CheckInput {

    private Scanner sc = new Scanner(System.in);

    public int checkInput(String msg) {
        int input;

        while (true) {
            try {
                System.out.print(msg);
                input = Integer.parseInt(sc.nextLine());
                if (input < 1 || input > 3) {
                    System.out.println("Enter a number from 1 - 3.");
                }
                return input;
            } catch (Exception e) {
                System.out.println("Please enter a number.");
            }
        }
    }

    public double checkDouble(String msg) {
        double input;
        while (true) {
            try {
                System.out.print(msg);
                input = Double.parseDouble(sc.nextLine());
                if (input < 0) {
                    throw new Exception();
                }
                return input;
            } catch (Exception e) {
                System.out.println("Enter a number more than 0.");
            }
        }
    }

    public String Checkstring(String msg) {
        String input = "";
        do {
            System.out.print(msg);
            input = sc.nextLine();
            if (!input.matches("[a-zA-Z]:\\\\.+\\.txt")) {
                System.out.println("Incorrect format. Format should be [a-zA-Z]:\\____.txt");
            } else {
                break;
            }
        } while (true);
        return input;
    }

    public String Checkstringinfo(String msg) {
        String input = "";
        do {
            System.out.print(msg);
            input = sc.nextLine();
            if (input.length() == 0 || !input.endsWith(".txt")) {
                System.out.println("Incorrect format. Format should be _____.txt");
            } else {
                break;
            }
        } while (input.length() != 0);
        return input;
    }
}
