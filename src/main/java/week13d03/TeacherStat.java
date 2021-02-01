package week13d03;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TeacherStat {

    private List<Teacher> teachers = new ArrayList<>();

    public void readFile(String filePathInString) {

        try {
            BufferedReader bufferedReader = Files.newBufferedReader(Path.of(filePathInString));
            String[] lineBlock = new String[4];
            while ((lineBlock[0] = bufferedReader.readLine()) != null) {
                teachers.add(processBlock(bufferedReader, lineBlock));
            }

        } catch (IOException ioException) {
            throw new IllegalStateException("File is non-readable!", ioException);
        }
    }

    private Teacher processBlock(BufferedReader bufferedReader, String[] block) throws IOException {
        for (int i = 1; i < 4; i++) {
            block[i] = bufferedReader.readLine();
        }
        return new Teacher(block[0], block[1], block[2], Integer.parseInt(block[3]));
    }


    public int sumOfWeeklyLessonsByName(String name) {
        int sum = 0;
        for (Teacher teacher : teachers) {
            if (teacher.getName().equals(name)) {
                sum += teacher.getNrOfWeeklyLessons();
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        TeacherStat teacherStat = new TeacherStat();
        String file = "src/main/resources/beosztas.txt";

        teacherStat.readFile(file);
        System.out.println(teacherStat.teachers);
        System.out.println(teacherStat.sumOfWeeklyLessonsByName("Pekry Petra"));
    }
}