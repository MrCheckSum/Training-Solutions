package algorithmsmax.sales;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SalespersonTest {

    @Test
    public void testCreateIsOk() {
        Salesperson salesperson = new Salesperson("Somebody", 1000, 200);

        Assertions.assertEquals(1000, salesperson.getAmount());
        Assertions.assertEquals(200, salesperson.getTarget());
        Assertions.assertEquals(800, salesperson.getDifferenceFromTarget());
    }
}
