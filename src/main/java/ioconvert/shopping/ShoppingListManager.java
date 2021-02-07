package ioconvert.shopping;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ShoppingListManager {

    public void saveShoppingList(OutputStream outputStream, List<String> shoppingList) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream))) {
            for (String str : shoppingList) {
                bufferedWriter.write(str);
                bufferedWriter.newLine();
            }
        } catch (IOException ioException) {
            throw new IllegalStateException("Cannot write file", ioException);
        }
    }

    public List<String> loadShoppingList(InputStream inputStream) {
        List<String> shoppingList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                shoppingList.add(line);
            }
            return shoppingList;
        } catch (IOException ioException) {
            throw new IllegalStateException("Cannot read file", ioException);
        }
    }
}
