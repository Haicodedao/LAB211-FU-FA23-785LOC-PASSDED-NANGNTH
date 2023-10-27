
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BoFile {

    public List<Person> getPerson(String path, double money) throws Exception {
        List<Person> personList = new ArrayList<>();
        File file = new File(path);

        if (!file.exists()) {
            throw new Exception("Path doesn't exist");
        }

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(";");
            if (parts.length >= 3) {
                String name = parts[0].trim();
                String address = parts[1].trim();
                double salary;
                try {
                    salary = Double.parseDouble(parts[2].trim());
                    if (salary < 0) {
                        salary = 0; //lương về 0 nếu nhỏ hơn 0
                    }
                } catch (NumberFormatException e) {
                    salary = 0; // lương về 0 trong trường hợp chuyển đổi không thành công
                }
                personList.add(new Person(name, address, salary));
            }
        }
        reader.close();

        if (personList.isEmpty()) {
            throw new Exception("Can't read file");
        }

        List<Person> filteredList = new ArrayList<>();
        for (Person person : personList) {
            if (person.getSalary() >= money) {
                filteredList.add(person);
            }
        }

        return filteredList;
    }

    public boolean copyWordOneTimes(String sourcePath, String destinationPath) throws Exception {
        File sourceFile = new File(sourcePath);
        File destinationFile = new File(destinationPath);

        if (!sourceFile.exists()) {
            throw new Exception("Source file does not exist.");
        }

        BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFile, true));

        String line;
        Set<String> existingLines = new HashSet<>();
        while ((line = reader.readLine()) != null) {
            if (!existingLines.contains(line)) {
                writer.write(line);
                writer.newLine();
                existingLines.add(line);
            }
        }
        reader.close();
        writer.close();
        return true;
    }

}
