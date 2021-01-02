package algorithmssum.sales;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SalespersonTest {

    @Test
    public void testCreateSalespersonList(){

        Salesperson salesperson = new Salesperson("Jack", 100);
        Assertions.assertEquals("Jack", salesperson.getName());
        Assertions.assertEquals(100, salesperson.getAmount());
    }
}
