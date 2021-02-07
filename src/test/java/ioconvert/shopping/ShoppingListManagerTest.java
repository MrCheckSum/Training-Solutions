package ioconvert.shopping;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingListManagerTest {


    @TempDir
    File folder;

    @Test
    void saveShoppingList() throws IOException {
        File file = new File(folder, "shopping.txt");
        List<String> shoppingList = List.of("milk", "butter", "ham", "eggs", "orange");
        try (OutputStream outputStream = new FileOutputStream(file)) {
            ShoppingListManager manager = new ShoppingListManager();
            manager.saveShoppingList(outputStream, shoppingList);
        }

        List<String> readList = readFromFile(file);

        assertEquals(shoppingList, readList);
    }

    @Test
    void loadShoppingList() throws IOException {
        ShoppingListManager manager = new ShoppingListManager();
        try (InputStream inputStream = this.getClass().getResourceAsStream("/shopping.txt")) {
            List<String> readList = manager.loadShoppingList(inputStream);

            assertEquals(List.of("chicken breast", "bacon", "potato", "black pepper"), readList);
        }
    }

    private List<String> readFromFile(File file) throws IOException {
        List<String> readList = new ArrayList<>();
        try (BufferedReader bufferedReader = Files.newBufferedReader(file.toPath())) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                readList.add(line);
            }
            return readList;
        }
    }
}

