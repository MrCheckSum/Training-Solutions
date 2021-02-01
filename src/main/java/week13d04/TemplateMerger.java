package week13d04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/*
Írj egy a TemplateMerger osztályba egy public String merge(Path file, List<Employee> employees)
metódust, ami felolvassa a fájlt, melynek tartalma:
Az alkalmazott neve: {nev}, születési éve: {ev}
Nyugodtan beolvashatod egy utasítással!
Majd a visszatérési értékként add vissza soronként az alkalmazottakat, abban a formátumban,
mint ahogy a fájlban van, azaz:
Az alkalmazott neve: John Doe, születési éve: 1980
Az alkalmazott neve: Jack Doe, születési éve: 1990
 */
public class TemplateMerger {

    public String merge(Path file, List<Employee> employees) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            String line = Files.readString(file);

            for (Employee employee : employees) {
                String replaced = line.replace("{nev}", employee.getName());
                replaced = replaced.replace("{ev}", Integer.toString(employee.getYearOfBirth()));
                //System.out.println(replaced);
                stringBuilder.append(replaced).append("\n");

            }
            return stringBuilder.toString();
        } catch (IOException ioException) {
            throw new IllegalStateException("File is non-readable!", ioException);
        }
    }

    public static void main(String[] args) {
        Path path = Path.of("employee-template.txt");
        List<Employee> employees = List.of(new Employee("John Doe", 1980), new Employee("Jack Doe", 1990));

        String result = new TemplateMerger().merge(path, employees);
        System.out.println(result);
    }
}
