package ioreader.grades;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SchoolRecordsManager {

    private List<Student> students = new ArrayList<>();

    public void readGradesFromFile(String filePathInString) {
        Path file = Path.of(filePathInString);
        try (BufferedReader bufferedReader = Files.newBufferedReader(file)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] dataInLine = line.split(" ");
                List<Integer> grades = new ArrayList<>();
                for (int i = 1; i < dataInLine.length; i++) {
                    grades.add(Integer.parseInt(dataInLine[i]));
                }
                Student student = new Student(dataInLine[0], grades);
                students.add(student);
            }

        } catch (IOException exception) {
            throw new IllegalStateException("File is non-readable!", exception);
        }
    }

    public double classAverage() {
        double sum = 0;
        for (Student student : students) {
            sum += student.average();
        }
        return sum / students.size();
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }
}
