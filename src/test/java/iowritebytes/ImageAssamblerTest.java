package iowritebytes;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ImageAssamblerTest {

    @TempDir
    public File folder;

    @Test
    void makeImageFile() throws IOException {
        ImageAssambler imageAssambler = new ImageAssambler();

        byte[][] file = readImage();
        Path path = folder.toPath();
        imageAssambler.makeImageFile(file, path);
        byte[] original = this.getClass().getResourceAsStream("src/main/resources/face_smile.png").readAllBytes();
        byte[] madeImage = Files.readAllBytes(path.resolve("image.png"));

        assertArrayEquals(original, madeImage);
    }


    private byte[][] readImage() {
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(this.getClass().getResourceAsStream("src/main/resources/face_smile.png"))) {
            ArrayList<byte[]> parts = new ArrayList<>();
            byte[] buffer = new byte[1024];
            int length;
            while ((length = bufferedInputStream.read(buffer)) > 0) {
                parts.add(Arrays.copyOf(buffer, length));
            }
            return parts.toArray(new byte[0][]);
        } catch (IOException ioException) {
            throw new IllegalStateException("File is non-readable!", ioException);
        }
    }
}