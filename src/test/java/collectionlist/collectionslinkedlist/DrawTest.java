package collectionlist.collectionslinkedlist;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class DrawTest {

    @Test
    public void wrongParametersShouldThrowExeption() throws IllegalArgumentException {

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Draw().drawNumbers(6, 6);
        });
        assertEquals("drawCount must not be more than maxNumber:6", ex.getMessage());
    }

    @Test
    public void drawnNumbersCountShouldBeEqualToDrawCount() throws IllegalArgumentException {

        Set<Integer> drawnNumbers = new Draw().drawNumbers(6, 45);

        for (int drawnNumber : drawnNumbers) {
            assertTrue(drawnNumber > 0);
            assertTrue(drawnNumber <= 45);
        }
    }

}
