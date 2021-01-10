package week10d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void findMinSumTest() {

        int[] array = new int[]{9, 7, 5, 98, 12, 43, 3, 1};
        assertEquals(16, Calculator.findMinSum(array));

    }
}
