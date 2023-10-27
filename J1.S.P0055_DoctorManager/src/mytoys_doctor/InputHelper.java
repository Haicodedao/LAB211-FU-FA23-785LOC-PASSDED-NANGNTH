package mytoys_doctor;

import java.util.Scanner;

public class InputHelper {

    public Scanner sc = new Scanner(System.in);

     public String inputStringAvai() {
        String input = "";
        while (true) {
            try {
                input = sc.nextLine().trim();
                return input;
            } catch (Exception e) {
                System.out.println("Please enter a pos number");
            }
        }
    }
    public String inputString() {
        String input = "";
        while (true) {
            try {
                input = sc.nextLine().trim().toUpperCase();
                if (!input.matches("^[a-zA-Z\\s]*$")) {
                    System.out.print("Please input a string type!!!\nEnter again: ");
                }
                return input;
            } catch (Exception e) {
                System.out.println("Please enter a type String");
            }
        }
    }

    public String inputStringCodeAdd(String msg) {
        String input = "";
        do {
            System.out.print(msg);
            input = sc.nextLine().trim().toUpperCase();

            if (input.length() == 0) {
                System.out.println("Don't see value.");
            }
        } while (input.length() == 0);
        return input;
    }

    public String inputStringAdd(String msg) {
        String input = "";
        do {
            System.out.print(msg);
            input = sc.nextLine().trim().toUpperCase();

            if (input.length() == 0) {
                System.out.println("Don't see value.");
            } else if (!input.matches("^[a-zA-Z\\s]*$")) {
                System.out.println("Please input a string type!!!");
            }
        } while (input.length() == 0 || !input.matches("^[a-zA-Z\\s]*$"));
        return input;
    }

    public int inputAvailabiUpdate(String s) {
    int input;
    while (true) {
        try {
            input = Integer.parseInt(s);
            return input;
        } catch (NumberFormatException e) {
            System.out.print("Data must be an integer!\nEnter again: ");
            s = inputStringAvai();
        }
    }
}

    public int inputAvailabi() {
        int input;
        do {
            try {
                input = Integer.parseInt(sc.nextLine().trim());
                if (input < 0) {
                    System.out.print("Invalid, Availability must be greater than 0\nEnter again: ");
                } else {
                    return input;
                }
            } catch (Exception e) {
                System.out.print("Data must be an integer!\nEnter again: ");
            }
        } while (true);
    }

    public int inputInt(String msg) {
        int input;
        while (true) {
            try {
                System.out.print(msg);
                input = Integer.parseInt(sc.nextLine().trim());
                if (input < 1 || input > 5) {
                    System.out.println("Please enter an number between 1 and 5");
                }
                return input;
            } catch (Exception e) {
                System.out.println("Data must be int!");
            }
        }
    }

}
