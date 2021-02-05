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
            byte[] buffer = new byte[1000];
            int size = 0;
            while ((size = inputStream.read(buffer)) > 0) {
                for (byte item : buffer) {
                    if (item == 97) {
                        sum++;
                    }
                }
            }

        } catch (IOException ioException) {
            throw new IllegalStateException("File is non-readable!", ioException);
        }
        return sum;
    }
}
