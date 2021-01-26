package week12d05;

import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class WordCounterTest {

    @Test
    void countWord() {
        WordCounter wordCounter = new WordCounter();
        Path path = Path.of("index.html");
        assertEquals(10, wordCounter.countWord("koroNavÍrus", path));
    }
}