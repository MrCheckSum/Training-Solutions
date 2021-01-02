package algorithmscount.bankaccounts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BankAccountConditionCounterTest {

    @Test
    public void testCountWithBalanceGreaterThan() {
        List<BankAccount> bankAccounts = Arrays.asList(
                new BankAccount("John Doe", "123", 1000),
                new BankAccount("Jane Doe", "123", 2000),
                new BankAccount("John Doe", "123", 3000),
                new BankAccount("Jennifer Doe", "123", 4000));

        Assertions.assertEquals(3, new BankAccountConditionCounter().countWithBalanceGreaterThan(bankAccounts, 1000));
        Assertions.assertEquals(0, new BankAccountConditionCounter().countWithBalanceGreaterThan(bankAccounts, 4000));
    }

}
