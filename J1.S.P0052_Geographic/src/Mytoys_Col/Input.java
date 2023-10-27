package Mytoys_Col;

import java.util.Scanner;

public class Input {
        
    // yêu cầu người dùng nhập vào kiểu int, nếu nhập sai 
    // dưa ra thông báo yêu cầu nhập lại 
    public int inputNumber(String msg) {
        Scanner sc = new Scanner(System.in);
        int input;
        while (true) {
            try {
                System.out.print(msg);
                input = Integer.parseInt(sc.nextLine().trim());
                if (input < 1 || input > 5) {
                    System.out.println("Please enter a number between 1 and 5");
                }
                return input;
            } catch (Exception e) {
                System.out.println("Please enter an pos number!!!");
                System.out.println("Please enter again");
            }
        }
    }

    // nhập vào kiểu String và kiểm tra nếu rỗng hoặc chứa digit , kí tự đặc biệt
    // đưa ra thông báo và bắt người dùng nhập lại
    public String inputStr(String msg) {
        Scanner sc = new Scanner(System.in);
        String input = "";
        do {
            System.out.print(msg);
            input = sc.nextLine().trim();

            if (input.length() == 0) {
                System.out.println("Don't see the value!");
            } else if (!input.matches("^[a-zA-Z\\s]*$")) {
                System.out.println("Please input a string type");
            }

        } while (input.length() == 0 || !input.matches("^[a-zA-Z\\s]*$"));

        return input;
    }

    // yêu cầu người dùng nhập vào kiểu float , kiểm tra xem người dùng nhập sai 
    // đưa ra thông báo yêu cầu nhập lại 
    public float inputFloat(String msg) {
        Scanner sc = new Scanner(System.in);
        float input;
        while (true) {

            try {
                System.out.print(msg);
                input = Float.parseFloat(sc.nextLine().trim());
                if (input < 0) {
                    System.out.println("Please enter a number more than 0");
                    continue;
                }
                return input;
            } catch (NumberFormatException e) {
                System.out.println("Please enter an pos number!!!");
                System.out.println("Please enter again");
            }
        }

    }

}
