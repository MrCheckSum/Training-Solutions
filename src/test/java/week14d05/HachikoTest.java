package week14d05;

import org.junit.jupiter.api.Test;
import week09d03.Present;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class HachikoTest {

    @Test
    void countWords() throws IOException {
        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of("hachiko.srt"), Charset.forName("windows-1252"))) {
            Map<String, Integer> result = new Hachiko().countWords(bufferedReader, "Hachiko", "haza",
                    "pályaudvar", "jó");
            assertEquals(16, result.get("haza"));
        }
    }
}