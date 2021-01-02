package algorithmssum.sales;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SalesAmountSumCalculatorTest {

    @Test
    public void testSumSalesAmount(){

        SalesAmountSumCalculator test = new SalesAmountSumCalculator();

        List<Salesperson> salespeople = Arrays.asList(
                new Salesperson("Jack", 50),
                new Salesperson("Jane", 100),
                new Salesperson("Joe", 200)
        );
        Assertions.assertEquals(350, test.sumSalesPersonAmount(salespeople));

    }
}
