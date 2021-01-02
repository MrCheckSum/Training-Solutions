package algorithmssum.sales;

import java.util.List;

public class SalesAmountSumCalculator {

    public int sumSalesPersonAmount(List<Salesperson> salespeople) {
        int sum = 0;
        for (Salesperson salesperson : salespeople) {
            sum += salesperson.getAmount();
        }
        return sum;
    }
}
