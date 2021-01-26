package week11d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivisorFinderTest {

    @Test
    void findDivisors() {

        DivisorFinder divisorFinder = new DivisorFinder();
        assertEquals(2, divisorFinder.findDivisors(102));
        assertEquals(4, divisorFinder.findDivisors(5555));
        assertEquals(2, divisorFinder.findDivisors(-1020));
    }
}