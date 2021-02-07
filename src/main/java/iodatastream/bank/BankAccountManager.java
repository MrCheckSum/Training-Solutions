package iodatastream.bank;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class BankAccountManager {

    public void saveAccount(BankAccount bankAccount, Path folder) {
        Path path = folder.resolve(bankAccount.getAccountNumber() + ".dat");
        try (DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(path)))) {
            dataOutputStream.writeUTF(bankAccount.getAccountNumber());
            dataOutputStream.writeUTF(bankAccount.getOwnerName());
            dataOutputStream.writeDouble(bankAccount.getBalance());
        } catch (IOException ioException) {
            throw new IllegalStateException("File is non-writeable!", ioException);
        }
    }

    public BankAccount loadAccount(InputStream inputStream) {
        try (DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(inputStream))) {
            String accountNumber = dataInputStream.readUTF();
            String ownerName = dataInputStream.readUTF();
            Double balance = dataInputStream.readDouble();
            return new BankAccount(accountNumber, ownerName, balance);  // így is megadható:  return new BankAccount(dis.readUTF(), dis.readUTF(), dis.readDouble());
        } catch (IOException ioException) {
            throw new IllegalStateException("File is non-readable!", ioException);
        }
    }
}