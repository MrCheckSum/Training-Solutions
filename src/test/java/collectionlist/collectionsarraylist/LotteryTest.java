package collectionlist.collectionsarraylist;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LotteryTest {

    @Test
    void wrongParameters() {

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Lottery().selectWinningNumbers(11, 10);
        });
        assertEquals("Number of all balls must be more than the number of winning balls!", ex.getMessage());
    }

    @Test
    void selectWinningNumbers() throws IllegalArgumentException {

        List<Integer> winningNumbers = new Lottery().selectWinningNumbers(6, 45);

        assertEquals(6, new HashSet<>(winningNumbers).size());
        for (int winningNumber : winningNumbers) {
            assertTrue(winningNumber > 0);
            assertTrue(winningNumber <= 45);
        }
    }
}