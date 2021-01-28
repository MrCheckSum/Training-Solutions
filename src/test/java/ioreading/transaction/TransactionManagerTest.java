package ioreading.transaction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionManagerTest {

    private TransactionManager transactionManager = new TransactionManager();

    @Test
    void uploadListFromFile() {
        assertEquals(0, transactionManager.getBankAccounts().size());

        transactionManager.uploadListFromFile("src/main/resources/accounts.txt");

        assertEquals(5, transactionManager.getBankAccounts().size());
        assertEquals("Jack Doe", transactionManager.getBankAccounts().get(3).getName());
        assertEquals(234050200, transactionManager.getBankAccounts().get(1).getBalance(), 0.0000001);
    }

    @Test
    void makeTransactions() {

        transactionManager.uploadListFromFile("src/main/resources/accounts.txt");
        transactionManager.makeTransactions("src/main/resources/transactions.txt");

        assertEquals(1201000, transactionManager.getBankAccounts().get(0).getBalance(), 0.0000001);
        assertEquals(721220, transactionManager.getBankAccounts().get(3).getBalance(), 0.0000001);
    }
}