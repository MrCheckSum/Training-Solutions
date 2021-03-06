package iozip.transactions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import static org.junit.jupiter.api.Assertions.*;

class TransactionFileManagerTest {

    @TempDir
    public Path folder;

    @Test
    void saveTransactions() throws IOException {
        List<Transaction> transactions = List.of(
                new Transaction(345L, LocalDateTime.of(2018, 2, 21, 12, 5, 31), "10092385-34562856-00008701", 412000.0),
                new Transaction(1297L, LocalDateTime.of(2018, 2, 21, 13, 10, 6), "10092385-23651299-00123013", -12000.0)
        );
        Path path = Files.createFile(folder.resolve("trans.zip"));
        TransactionFileManager transactionFileManager = new TransactionFileManager();

        transactionFileManager.saveTransactions(path, transactions);

        List<Transaction> saved = readTransactions(path);
        saved.sort(Comparator.comparingLong(Transaction::getId));

        assertEquals(2, saved.size());
        assertEquals(345L, saved.get(0).getId());
        assertEquals(LocalDateTime.of(2018, 2, 21, 12, 5, 31), saved.get(0).getTime());
        assertEquals("10092385-34562856-00008701", saved.get(0).getAccount());
        assertEquals(412000.0, saved.get(0).getAmount(), 0.00001);
    }

    private List<Transaction> readTransactions(Path path) throws IOException {
        List<Transaction> transactions = new ArrayList<>();
        try (ZipFile zipFile = new ZipFile(path.toFile())) {
            Enumeration<? extends ZipEntry> zipEntries = zipFile.entries();
            zipEntries.asIterator().forEachRemaining(entry -> {
                long id = Long.parseLong(entry.getName());
                try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(zipFile.getInputStream(entry)))) {
                    LocalDateTime time = LocalDateTime.parse(bufferedReader.readLine());
                    String account = bufferedReader.readLine();
                    double amount = Double.parseDouble(bufferedReader.readLine());
                    transactions.add(new Transaction(id, time, account, amount));
                } catch (IOException ioException) {
                    throw new IllegalStateException("Cannot read entry", ioException);
                }
            });
            return transactions;
        }
    }
}