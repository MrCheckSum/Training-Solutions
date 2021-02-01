package week12d03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.IllformedLocaleException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberStatTest {


    @Test
    public void exceptionTest() {
        NumberStat numberStat = new NumberStat();
        numberStat.readFile("test.txt");
        Exception exception = assertThrows(IllegalStateException.class, () -> numberStat.findSmallestUnique() );
        assertEquals("No unique number!", exception.getMessage());
    }

    @Test
    void findSmallestUnique() {

        NumberStat numberStat = new NumberStat();
        numberStat.readFile("numbers.txt");
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> numberStat.findSmallestUnique());
        assertEquals("No unique number!", exception.getMessage());

    }
}