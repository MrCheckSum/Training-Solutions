package ioreadstring.transaction;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TransactionManager {

    private List<BankAccount> bankAccounts = new ArrayList<>();

    public void uploadListFromFile(String file) {
        Path accounts = Path.of(file);

        try {
            List<String> accountsFromFile = Files.readAllLines(accounts);
            for (String item : accountsFromFile) {
                String[] lineItem = item.split(";");
                BankAccount bankAccount = new BankAccount(lineItem[0], lineItem[1], Integer.parseInt(lineItem[2]));
                bankAccounts.add(bankAccount);
            }
        } catch (IOException exception) {
            throw new IllegalStateException("File is non-readable!", exception);
        }
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void makeTransactions(String filePath) {

        Path transactions = Path.of(filePath);

        try {
            List<String> transactionsFromFile = Files.readAllLines(transactions);
            for (String item : transactionsFromFile) {
                String[] lineItem = item.split(";");
                for (BankAccount bankAccount : bankAccounts) {
                    if (lineItem[0].equals(bankAccount.getAccountNumber())) {
                        bankAccount.setBalance(Double.parseDouble(lineItem[1]));
                    }
                }
            }
        } catch (IOException exception) {
            throw new IllegalStateException("File is non-readable!", exception);
        }
    }
}
