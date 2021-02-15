package collectionsautoboxing;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IntegerOperationsTest {

    @Test
    void createList() {

        List<Integer> numbers = new IntegerOperations().createList(10, 3, 4, 5, 6, 7);

        assertEquals(10, numbers.get(0));
        assertEquals(4, numbers.get(2));
        assertEquals(6, numbers.size());

    }

    @Test
    void sumIntegerList() {

        IntegerOperations integerOperations = new IntegerOperations();
        assertEquals(35, integerOperations.sumIntegerList(integerOperations.createList(10, 3, 4, 5, 6, 7)));

    }

    @Test
    void sumIntegerObjects() {

        assertEquals(35, new IntegerOperations().sumIntegerObjects(10, 3, 4, 5, 6, 7));

    }
}