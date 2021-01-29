package iowriter.names;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class NameWriter {

    private Path file;

    public NameWriter(Path file) {
        this.file = file;
    }

    public void addAndWrite(String name) {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(file, StandardOpenOption.APPEND)) {
            bufferedWriter.write(name + "/n");
        } catch (IOException exception) {
            throw new IllegalStateException("File is non-readable!", exception);
        }
    }
}
