package ioconvert.products;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductWriterTest {

    @TempDir
    public File folder;

    @Test
    void saveProduct() throws IOException {
        List<Product> products = List.of(
                new Product("apple", 10),
                new Product("pear", 15),
                new Product("plum", 16),
                new Product("orange", 14)

        );
        File file = new File(folder, "test.txt");
        Path path = file.toPath();

        ProductWriter productWriter = new ProductWriter();

        try (OutputStream outputStream = Files.newOutputStream(path)) {
            productWriter.saveProduct(outputStream, products);
        }

        byte[] read = Files.readAllBytes(path);
        byte[] asserted = ("apple;10" + System.lineSeparator() + "pear;15" + System.lineSeparator() + "plum;16" + System.lineSeparator() + "orange;14" + System.lineSeparator()).getBytes();

        assertArrayEquals(asserted, read);
    }
}
