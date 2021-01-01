package stringscanner;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StringScanner {

    public boolean isEmpty(String str) {
        return str == null || "".equals(str.trim());
    }

    public int readAndSumValues(String intString, String delimiter) {
        try (Scanner scanner = new Scanner(intString)) {
            if (!isEmpty(delimiter)) {
                scanner.useDelimiter(delimiter);
            }
            return calculateWithScanner(scanner);
        }
    }

    public int readAndSumValues(String intString) {
        return readAndSumValues(intString, null);
    }

    private int calculateWithScanner(Scanner scr) {
        int sum = 0;
        try {
            while (scr.hasNext()) {
                sum += scr.nextInt();
            }
        } catch (InputMismatchException exception) {
            throw new IllegalArgumentException("Incorrect parameter string!", exception);
        }
        return sum;
    }

    public String filterLinesWithWordOccurrences(String text, String word) {
        if (isEmpty(text) || word == null || "".equals(word)) {
            throw new IllegalArgumentException("Incorrect parameter string!");
        }
        try (Scanner scanner = new Scanner(text)) {
            StringBuilder stringBuilder = new StringBuilder();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(word)) {
                    stringBuilder.append(line);
                    stringBuilder.append("\n");
                }
            }
            return stringBuilder.toString().trim();
        }
    }
}
