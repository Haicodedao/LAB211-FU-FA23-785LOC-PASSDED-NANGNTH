package view;

import data.Doctor;
import mytoys_doctor.InputHelper;
import java.util.Scanner;

public class Doctormanagerment {

    public static void main(String[] args) {
        int choice;
        Scanner sc = new Scanner(System.in);
        InputHelper iph = new InputHelper();
        Shelfdoctor sdt = new Shelfdoctor();
        Doctor dt = new Doctor();
        do {
            sdt.menu();
            choice = iph.inputInt("Enter your choice: ");
            switch (choice) {
                case 1:
                    sdt.addDoctor();
                    break;
                case 2:
                    sdt.updateDoctor();
                    break;
                case 3:
                    sdt.deleteDoctor();
                    break;
                case 4:
                    sdt.search();
                    break;
                case 5:
                    System.out.println("See you again.");
                    break;
                default:
                    break;
            }
        } while (choice != 5);
    }


}
