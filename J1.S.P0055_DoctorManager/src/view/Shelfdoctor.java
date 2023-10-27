package view;

import data.Bodoctor;
import data.Doctor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import mytoys_doctor.InputHelper;

public class Shelfdoctor {

    private Bodoctor bodoctor = new Bodoctor();
    InputHelper iph = new InputHelper();

    public Shelfdoctor() {
        bodoctor = new Bodoctor();
    }
    public void menu() {
        System.out.println("======= Doctor Management =======");
        System.out.println("1. Add Doctor");
        System.out.println("2. Update Doctor");
        System.out.println("3. Delete Doctor");
        System.out.println("4. Search Doctor");
        System.out.println("5. Exit");
        System.out.println("=================================");
    }

    public void addDoctor() {
        try {

            System.out.println("-------- ADD Doctor ---------");
            String code, name, specialization;
            int availability;
            do {
                code = iph.inputStringCodeAdd("Enter Code: ").toUpperCase();
                if (bodoctor.checkCodeDup(code)) {
                    System.out.println("Code exist");
                }
            } while (bodoctor.checkCodeDup(code));
            name = iph.inputStringAdd("Enter Name: ");
            specialization = iph.inputStringAdd("Enter Specialization: ");
            System.out.print("Enter Availability: ");
            availability = iph.inputAvailabi();

            Doctor doctor = new Doctor(code, name, specialization, availability);
            if (bodoctor.addDoctor(doctor)) {
                bodoctor.addDoctor(doctor);
                System.out.println("Doctor added successfully.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateDoctor() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("-------- Update Doctor ---------");
            String code, name, specialization;
            int availability;

            code = iph.inputStringCodeAdd("Enter Code: ").toUpperCase();

            Map<String, List<Doctor>> existDoc = bodoctor.searchToUpdate(code);
            List<Doctor> doctors = existDoc.get(code);

            if (doctors == null || doctors.isEmpty()) {
                System.out.println("Doctor with code ' " + code + " ' does not exist.");
                return;
            }
            Doctor existingDoctor = doctors.get(0);
            System.out.print("Enter Name (Leave blank to keep the old value '" + existingDoctor.getName() + "'): ");
            name = iph.inputString();
            if (name.trim().isEmpty()) {
                name = existingDoctor.getName();
            }
            System.out.print("Enter Specialization (Leave blank to keep the old value '" + existingDoctor.getSpecialization() + "'): ");
            specialization = iph.inputString();

            if (specialization.trim().isEmpty()) {
                specialization = existingDoctor.getSpecialization();
            }
            while (true) {
                System.out.print("Enter Availability (Leave blank to keep the old value '" + existingDoctor.getAvailability() + "'): ");
                String availabilityString = iph.inputStringAvai();
                if (availabilityString.trim().isEmpty()) {
                    availability = existingDoctor.getAvailability();
                    break;
                } else {
                    availability = iph.inputAvailabiUpdate(availabilityString.trim());
                    if (availability < 0) {
                        System.out.println("Availability must be a pos number or leave blank. Please try again.");
                    } else {
                        break;
                    }
                }
            }
            Doctor updatedDoctor = new Doctor(code, name, specialization, availability);
            bodoctor.updateDoctor(updatedDoctor);
            System.out.println("Doctor updated successfully.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteDoctor() {
        try {
            System.out.println("-------- Delete Doctor ---------");
            String code = iph.inputStringCodeAdd("Enter Code: ");
            boolean success = bodoctor.deleteDoctor(code);
            if (success) {
                System.out.println("Doctor deleted successfully.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void search() {
        System.out.println("--------- Search Doctor ---------");
        System.out.print("Enter text (Press Enter to display all doctors): ");
        String searchText = iph.inputStringAvai().toUpperCase();
        Map<String, List<Doctor>> searchResult = bodoctor.searchDoctor(searchText);

        if (searchResult.containsKey(searchText)) {
            List<Doctor> doctors = searchResult.get(searchText);
            System.out.println("--------- Results --------");
            System.out.printf("%-25s %-25s %-25s %-25s\n", "Code", "Name", "Specialization", "Availabiity");
            for (Doctor doctor : doctors) {
                doctor.display();

            }
        } else if (searchResult.containsKey("")) {
            List<Doctor> doctors = searchResult.get("");
            System.out.println("--------- Results --------");
            System.out.printf("%-25s %-25s %-25s %-25s\n", "Code", "Name", "Specialization", "Availabiity");
            for (Doctor doctor : doctors) {
                doctor.display();

            }
        } else {
            System.out.println("No doctors found.");
        }
    }
}
