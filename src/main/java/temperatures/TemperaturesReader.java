package temperatures;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TemperaturesReader {

    public Temperatures readTemperatures(String filePathInString) {
        Path path = Path.of(filePathInString);
        try {
            byte[] data = Files.readAllBytes(path);
            return new Temperatures(data);
        } catch (IOException exception) {
            throw new IllegalStateException("File is non-readable!", exception);
        }
    }
}
