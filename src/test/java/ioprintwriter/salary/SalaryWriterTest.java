package ioprintwriter.salary;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SalaryWriterTest {

    @TempDir
    public File folder;

    private SalaryWriter salaryWriter = new SalaryWriter(List.of("Dr. Kovács", "Mr. Nagy", "Mrs. Nagy", "Kis Géza"));

    @Test
    void writeNamesAndSalaries() throws IOException {
        Path file =new File(folder, "salary.txt").toPath();
        salaryWriter.writeNamesAndSalaries(file);
        List<String> writtenLines = Files.readAllLines(file);

        assertEquals("Dr. Kovács: 500000", writtenLines.get(0));
        assertEquals("Mr. Nagy: 200000", writtenLines.get(1));
        assertEquals("Mrs. Nagy: 200000", writtenLines.get(2));
        assertEquals("Kis Géza: 100000", writtenLines.get(3));


    }
}