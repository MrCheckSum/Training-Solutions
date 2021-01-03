package week09d02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FibCalculatorTest {

    @Test
    public void testFibCalculator(){
        Assertions.assertEquals(2, FibCalculator.sumEvens(4));
    }
}
