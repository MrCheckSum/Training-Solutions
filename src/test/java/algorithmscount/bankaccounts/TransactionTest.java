package algorithmscount.bankaccounts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TransactionTest {

    @Test
    public void createTransaction() {
        Transaction transaction = new Transaction("12345", TransactionType.CREDIT, 1000);
        Assertions.assertEquals("12345", transaction.getAccountNumber());
        Assertions.assertEquals(1000, transaction.getAmount());

    }

}
