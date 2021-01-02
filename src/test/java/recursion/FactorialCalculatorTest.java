package recursion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FactorialCalculatorTest {

    @Test
    public void simplestCase(){
        //Given
        int number = 1;
        //When
        long actual = new FactorialCalculator().getFactorial(number);
        //Then
        Assertions.assertEquals(1L, actual);
    }

    @Test
    public void greaterNumber(){
        //Given
        int number = 5;
        //When
        long actual = new FactorialCalculator().getFactorial(number);
        //Then
        Assertions.assertEquals(120L,actual);
    }
}
