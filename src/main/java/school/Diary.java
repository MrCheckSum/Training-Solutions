package school;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Diary {

    public void newMark(Path file, int mark) {
        try {
            if (Files.exists(file)) {
                Files.writeString(file, mark + "\n", StandardOpenOption.APPEND);
            } else {
                Files.writeString(file, Integer.toString(mark));
            }
        } catch (IOException exception) {
            throw new IllegalStateException("File is non-readable!", exception);
        }
    }

    public void average(Path filePath) {
        try {
            List<String> file = Files.readAllLines(filePath);
            double sum = 0;
            for (String item : file) {
                sum += Double.parseDouble(item);
            }
            Files.writeString(filePath, "average: " + (sum / file.size()), StandardOpenOption.APPEND);
        } catch (Exception exception) {
            throw new IllegalStateException("File is non-readable!", exception);
        }
    }

    public static void main(String[] args) {
        Diary diary = new Diary();
        Path path = Path.of("src/main/resources/tanulo_neve.txt");
        diary.newMark(path, 5);
        diary.newMark(path, 2);
        diary.newMark(path, 5);
        diary.average(path);
    }

}
