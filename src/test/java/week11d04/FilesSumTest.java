package week11d04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilesSumTest {

    @Test
    void sumNumbers() {
        FilesSum filesSum = new FilesSum();
        assertEquals(0, filesSum.sumNumbers());
    }
}