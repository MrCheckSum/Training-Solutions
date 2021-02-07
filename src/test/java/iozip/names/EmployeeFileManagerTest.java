package iozip.names;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeFileManagerTest {

    @TempDir
    public Path folder;

    @Test
    void saveEmployees() throws IOException {
        List<String> employees = List.of("John Doe", "Jack Doe", "Jane Doe");
        Path path = Files.createFile(folder.resolve("employees.zip"));

        EmployeeFileManager employeeFileManager = new EmployeeFileManager();

        employeeFileManager.saveEmployees(path, employees);

        byte[] saved = readEmployees(path);
        byte[] asserted = "John DoeJack DoeJane Doe".getBytes();

        assertArrayEquals(asserted, saved);
    }

    private byte[] readEmployees(Path path) throws IOException {
        try (ZipFile zipFile = new ZipFile(path.toFile())) {
            ZipEntry zipEntry = zipFile.getEntry("names.dat");
            try (InputStream is = zipFile.getInputStream(zipEntry)) {
                return is.readAllBytes();
            }
        }
    }
}