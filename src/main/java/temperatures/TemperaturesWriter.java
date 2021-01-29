package temperatures;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TemperaturesWriter {

    public void writeTemperatures(Temperatures temperatures, String filePathInString) {
        Path path = Path.of(filePathInString);
        try {
            Files.write(path, temperatures.getData());

        } catch (IOException exception) {
            throw new IllegalStateException("File is non-readable!", exception);
        }
    }
}


