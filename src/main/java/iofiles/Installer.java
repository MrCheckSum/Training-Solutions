package iofiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.IllformedLocaleException;

public class Installer {

    private static final String SOURCE_DIR = "/install/";

    public void install(String pathInString) {
        Path targetDir = Path.of(pathInString);
        if (!Files.exists(targetDir) || !Files.isDirectory(targetDir)) {
            throw new IllegalArgumentException("Directory does not exist!");
        }
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/install/install.txt")))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.endsWith("/")) {
                    Files.createDirectories(targetDir.resolve(line));
                } else {
                    Files.copy(this.getClass().getResourceAsStream(SOURCE_DIR + line), targetDir.resolve(line), StandardCopyOption.REPLACE_EXISTING);
                }
            }
        } catch (IOException ioException) {
            throw new IllegalStateException("Not able to copy files!", ioException);
        }
    }
}
