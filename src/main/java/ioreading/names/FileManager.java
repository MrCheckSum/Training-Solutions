package ioreading.names;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private Path file;
    List<Human> humans = new ArrayList<>();

    public FileManager(String fileRelativePath) {
        this.file = Path.of(fileRelativePath);
    }

    public void readFromFile() {

        try {
            List<String> fileInString = Files.readAllLines(file);
            for (String s : fileInString) {
                String[] firstNameAndLastName = s.split(" ");
                Human human = new Human(firstNameAndLastName[0], firstNameAndLastName[1]);
                humans.add(human);
            }
        } catch (IOException exception) {
            throw new IllegalStateException("File is non-readable!", exception);
        }
    }

    public Path getFile() {
        return file;
    }

    public List<Human> getHumans() {
        return humans;
    }
}
