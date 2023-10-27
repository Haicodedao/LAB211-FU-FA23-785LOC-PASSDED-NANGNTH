
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manager {

    BoFile bf = new BoFile();
    CheckInput ci = new CheckInput();

    public void Menu() {
        System.out.println("========= File Processing =========");
        System.out.println("1. Find person info");
        System.out.println("2. Copy Text to new file");
        System.out.println("3. Exit");
    }

    public void findPersonInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---------- Person info ----------");
        String filePath = ci.Checkstringinfo("Enter Path: ");
        double minimumSalary = ci.checkDouble("Enter Money: ");

        try {
            List<Person> personList = bf.getPerson(filePath, minimumSalary);
            displayPeople(personList);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void copyTextToFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---------- Copy text ----------");
        String sourcePath = ci.Checkstring("Enter source: ");
        String destinationPath = ci.Checkstringinfo("Enter new file name: ");

        try {
            boolean success = bf.copyWordOneTimes(sourcePath, destinationPath);
            if (success) {
                System.out.println("Copy done...");
            } else {
                System.out.println("Failed to copy text.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void displayPeople(List<Person> personList) {
        System.out.println("---------- Results ----------");
        System.out.printf("%-20s %-20s %-20s%n", "Name", "Address", "Money");
        System.out.println("----------------------------------------------");
        for (Person person : personList) {
            System.out.printf("%-20s %-20s %-20.2f%n", person.getName(), person.getAddress(), person.getSalary());
        }
        System.out.println("----------------------------------------------");
        if (!personList.isEmpty()) {
            double minSalary = personList.get(0).getSalary();
            double maxSalary = personList.get(0).getSalary();
            for (Person person : personList) {
                if (person.getSalary() < minSalary) {
                    minSalary = person.getSalary();
                }
                if (person.getSalary() > maxSalary) {
                    maxSalary = person.getSalary();
                }
            }
            List<Person> minSalaryPersons = new ArrayList<>();
            List<Person> maxSalaryPersons = new ArrayList<>();
            for (Person person : personList) {
                if (person.getSalary() == minSalary) {
                    minSalaryPersons.add(person);
                }
                if (person.getSalary() == maxSalary) {
                    maxSalaryPersons.add(person);
                }
            }
            System.out.println("Min:");
            for (Person person : minSalaryPersons) {
                System.out.println(person.getName());
            }
            System.out.println("Max:");
            for (Person person : maxSalaryPersons) {
                System.out.println(person.getName());
            }
        } else {
            System.out.println("No persons found.");
        }
    }
}
