package ioreader.idread;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class IdManager {

    private List<String> idList = new ArrayList<>();

    public void readIdsFromFile(String filePathInString) {

        Path file = Path.of(filePathInString);
        try (BufferedReader bufferedReader = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                idList.add(line);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Wrong filename: " + filePathInString);
        }
    }

    public List<String> getIds() {
        return new ArrayList<>(idList);
    }
}