package algorithmsmax.sales;

import java.util.List;

public class SalesAmountMaxSelector {

    public Salesperson selectSalespersonWithMaxSalesAmount(List<Salesperson> salespeople) {
        Salesperson salespersonWithMaxSalesAmount = null;
        for (Salesperson salesperson : salespeople) {
            if (salespersonWithMaxSalesAmount == null || salesperson.getAmount() > salespersonWithMaxSalesAmount.getAmount()) {
                salespersonWithMaxSalesAmount = salesperson;
            }
        }
        return salespersonWithMaxSalesAmount;
    }
}
