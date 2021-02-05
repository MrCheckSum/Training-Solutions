package ioreadbytes.byteacount;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class CountAChar {

    public int countACharFromByteFile(String fileName) {

        Path path = Path.of(fileName);
        int sum = 0;

        try (InputStream inputStream = Files.newInputStream(path)) {
            byte[] bytes = new byte[1000];
            int size;
            while ((size = inputStream.read(bytes)) > 0) {
                for (byte item : bytes) {
                    if (item == (byte) 'a') {
                        sum++;
                    }
                }
            }

        } catch (IOException ioException) {
            throw new IllegalStateException("File is non-readable!", ioException);
        }
        return sum;
    }

    public static void main(String[] args) {
        CountAChar cac = new CountAChar();
        System.out.println(cac.countACharFromByteFile("data.dat"));
    }
}
