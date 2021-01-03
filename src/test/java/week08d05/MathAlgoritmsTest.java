package week08d05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MathAlgoritmsTest {

    @Test
    public void testGreatestCommonDivisor(){

        Assertions.assertEquals(17,MathAlgoritms.greatestCommonDivisor(170, 357));
    }
}
