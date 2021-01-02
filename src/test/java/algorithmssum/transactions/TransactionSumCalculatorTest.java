package algorithmssum.transactions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class TransactionSumCalculatorTest {

    @Test
    public void testSumAmountOfCreditEntries() {
        TransactionSumCalculator test = new TransactionSumCalculator();

        List<Transaction> transactions = Arrays.asList(
                new Transaction("1234-1324-4321", TransactionOperation.CREDIT, 1000),
                new Transaction("1234-1324-4321", TransactionOperation.DEBIT, 200),
                new Transaction("1234-1324-4321", TransactionOperation.CREDIT, 10000),
                new Transaction("1234-1324-4321", TransactionOperation.CREDIT, 150),
                new Transaction("1234-1324-4321", TransactionOperation.CREDIT, -1020),
                new Transaction("1234-1324-4321", TransactionOperation.DEBIT, 1000)
        );

        Assertions.assertEquals(10130, test.sumAmountOfCreditEntries(transactions));
    }
}
