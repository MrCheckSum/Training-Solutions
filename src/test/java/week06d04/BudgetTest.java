package week06d04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class BudgetTest {

    @Test
    public void getItemsByMonthTest() {
        Budget budget = new Budget(Arrays.asList(
                new Item("Termék_1", 2, 5),
                new Item("Termék_2", 5, 6),
                new Item("Termék_3", 7, 6)
        ));

        Assertions.assertEquals("[ Termék_1, 2, 5 ]", budget.getItemsByMonth(5)); //?????
    }
}
