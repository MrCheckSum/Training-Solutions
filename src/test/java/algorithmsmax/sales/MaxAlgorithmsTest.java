package algorithmsmax.sales;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class MaxAlgorithmsTest {

    List<Salesperson> salespeople = Arrays.asList(
            new Salesperson("John", 600, 500),
            new Salesperson("Bill", 200, 300),
            new Salesperson("Kate", 700, 100),
            new Salesperson("Mary", 700, 300),
            new Salesperson("Karl", 200, 50)
    );

    @Test
    public void testSelectSalespersonWithMaxSalesAmount() {
        SalesAmountMaxSelector maxAmount = new SalesAmountMaxSelector();

        Assertions.assertEquals(700, maxAmount.selectSalespersonWithMaxSalesAmount(salespeople).getAmount());
        Assertions.assertEquals(100, maxAmount.selectSalespersonWithMaxSalesAmount(salespeople).getTarget());
    }

    @Test
    public void testSelectSalesPersonWithFurthestAboveTarget() {
        SalespersonWithFurthestAboveTargetSelector aboveTarget = new SalespersonWithFurthestAboveTargetSelector();

        Assertions.assertEquals(600, aboveTarget.selectSalespersonWithFurthestAboveTarget(salespeople).getDifferenceFromTarget());
            Assertions.assertEquals(700, aboveTarget.selectSalespersonWithFurthestAboveTarget(salespeople).getAmount());
        Assertions.assertEquals(100, aboveTarget.selectSalespersonWithFurthestAboveTarget(salespeople).getTarget());
    }

    @Test
    public void testSelectSalesPersonWithFurthestBelowTarget() {
        SalespersonWithFurthestBelowTargetSelector belowTarget = new SalespersonWithFurthestBelowTargetSelector();

        Assertions.assertEquals(-100, belowTarget.selectSalesPersonWithFurthestBelowTarget(salespeople).getDifferenceFromTarget());
        Assertions.assertEquals(200, belowTarget.selectSalesPersonWithFurthestBelowTarget(salespeople).getAmount());
        Assertions.assertEquals(300, belowTarget.selectSalesPersonWithFurthestBelowTarget(salespeople).getTarget());
    }
}
