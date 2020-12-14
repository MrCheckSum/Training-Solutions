package week07d02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DigitSumTest {

    @Test
    public void sumOfDigitsTest() {
        DigitSum digitSum = new DigitSum();
        Assertions.assertEquals(6, digitSum.sumOfDigits(123));
    }
}
