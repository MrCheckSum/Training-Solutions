package algorithmscount.bankaccounts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankAccountTest {

    @Test
    public void createBankAccount() {
        BankAccount bankAccount = new BankAccount("John Doe", "12345", 10000);
        Assertions.assertEquals("John Doe", bankAccount.getNameOfOwner());
        Assertions.assertEquals("12345", bankAccount.getAccountNumber());
        Assertions.assertEquals(10000, bankAccount.getBalance());
    }
}
