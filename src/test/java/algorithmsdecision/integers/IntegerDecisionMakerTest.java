package algorithmsdecision.integers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class IntegerDecisionMakerTest {

    IntegerDecisionMaker integerDecisionMaker = new IntegerDecisionMaker();
    List<Integer> numbers = Arrays.asList(1, 2, 2, -7, 6);

    @Test
    public void testContainsGreaterThan() {
        Assertions.assertTrue(integerDecisionMaker.containsGreaterThan(numbers, 3));
        Assertions.assertFalse(integerDecisionMaker.containsGreaterThan(numbers, 7));
    }

    @Test
    public void testContainsLowerThan(){
        Assertions.assertTrue(integerDecisionMaker.containsLowerThan(numbers, -6));
        Assertions.assertFalse(integerDecisionMaker.containsLowerThan(numbers, -7));
    }
}
