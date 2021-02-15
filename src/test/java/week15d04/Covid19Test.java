package week15d04;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Covid19Test {

    @Test
    void findFirstThree() throws IOException {
        Covid19 covid19 = new Covid19();
        covid19.readFile(Files.newBufferedReader(Path.of("data.csv")));

        assertEquals(3, covid19.findFirstThree().size());
        assertFalse(2 == covid19.findFirstThree().size());
    }
}