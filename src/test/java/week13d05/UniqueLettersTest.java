package week13d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniqueLettersTest {

    @Test
    void uniqueLetterCounter() {

        assertEquals(8, new UniqueLetters().uniqueLetterCounter("abcdefgh"));
        assertEquals(8, new UniqueLetters().uniqueLetterCounter("abcdefghabcdefgh"));
    }
}