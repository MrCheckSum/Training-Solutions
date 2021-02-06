package iowritebytes;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ImageAssambler {

    public void makeImageFile(byte[][] imageParts, Path folder) {
        Path file = folder.resolve("image.png");
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(Files.newOutputStream(file))) {
            for (byte[] part : imageParts) {
                bufferedOutputStream.write(part);
            }
        } catch (IOException ioException) {
            throw new IllegalStateException("File is non-readable!", ioException);
        }
    }
}
