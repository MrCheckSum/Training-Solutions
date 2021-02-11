package week13d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountEnglishAphabetLettersTest {

    @Test
    void letterCounter() {

        assertEquals(6, new CountEnglishAphabetLetters().letterCounter("abcdef"));
        assertEquals(6, new CountEnglishAphabetLetters().letterCounter("abcdefa"));
    }
}