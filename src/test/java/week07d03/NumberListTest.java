package week07d03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class NumberListTest {

    @Test
    public void isIncreasinTest() {
        NumberList numberList = new NumberList();

        Assertions.assertTrue(numberList.isIncreasing(Arrays.asList(1, 2, 3, 5, 6)));
        Assertions.assertFalse(numberList.isIncreasing(Arrays.asList(2, 1, 3, 4, 6, 5)));
    }
}
