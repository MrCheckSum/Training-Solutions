package week07d01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MathAlgorithmsTest {

    @Test
    public void isPrimeTest() {
        Assertions.assertTrue(MathAlgorithms.isPrime(1));
        Assertions.assertTrue(MathAlgorithms.isPrime(2));
        Assertions.assertFalse(MathAlgorithms.isPrime(4));
    }
}
