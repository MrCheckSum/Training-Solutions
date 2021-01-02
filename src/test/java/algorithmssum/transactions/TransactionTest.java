package algorithmssum.transactions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TransactionTest {

    @Test
    public void testCreateTransaction() {
        Transaction transaction = new Transaction("1234-1324-4321", TransactionOperation.CREDIT, 10000);

        Assertions.assertEquals(10000, transaction.getAmount());
        Assertions.assertTrue(transaction.isCredit());
        Assertions.assertFalse(transaction.isDebit());

    }
}
