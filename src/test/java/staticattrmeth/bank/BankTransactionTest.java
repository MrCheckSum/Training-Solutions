package staticattrmeth.bank;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BankTransactionTest {

    @Test
    public void testOneTransaction() {
        //Given
        BankTransaction.initTheDay();
        BankTransaction bankTransaction = new BankTransaction(10_000);
        //Then
        assertEquals(10_000L, bankTransaction.getTrxValue());
        assertEquals(10_000L, BankTransaction.getCurrentMinValue());
        assertEquals(10_000L, BankTransaction.getCurrentMaxValue());
        assertEquals(new BigDecimal("10000"), BankTransaction.getSumOfTrxs());
        assertEquals(new BigDecimal("10000"), BankTransaction.averageOfTransactions());
    }

    @Test
    public void testSeveralTransactions() {
        //Given
        BankTransaction.initTheDay();
        new BankTransaction(12_000);
        new BankTransaction(23_000);
        //Then
        assertEquals(11_000L, BankTransaction.getCurrentMinValue());
        assertEquals(23_000L, BankTransaction.getCurrentMaxValue());
        assertEquals(new BigDecimal("30000"), BankTransaction.getSumOfTrxs());
        assertEquals(new BigDecimal("15000"), BankTransaction.averageOfTransactions());
    }

    @Test
    public void testZeroTransaction() {
        //Given
        BankTransaction.initTheDay();
        //Then
        assertEquals(0L, BankTransaction.getCurrentMinValue());
        assertEquals(0L, BankTransaction.getCurrentMaxValue());
        assertEquals(new BigDecimal("0"), BankTransaction.getSumOfTrxs());
    }

}