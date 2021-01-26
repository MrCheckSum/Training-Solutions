package week11d04;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/*
Adott az aktuális könyvtárban több, fájl, melynek a nevei: number00.txt, number03.txt, number20.txt, egészen 99-ig.
Nem minden fájl létezik, lehet, hogy bizonyos számhoz tartozó fájl kimaradt. Olvasd be az állományból a benne lévő számot, és ezt összegezd!
Használd a Files.isRegularFile() metódust arra, hogy megnézd, létezik-e a fájl! Használd a Files.readString() metódust a fájl beolvasására!
A FilesSum osztály int sumNumbers() metódusába dolgozz!

try {
        String content = Files.readString(Path.of("helloworld.txt"));
        System.out.println(content);
    } catch (IOException e) {
        throw new IllegalStateException("Can not read", e);
    }

    System.out.println(Files.isRegularFile(Path.of("kutya.txt")));
    System.out.println(Files.isRegularFile(Path.of("helloworld.txt")));
 */
public class FilesSum {

    public int readFile(String fileName) {
        try {
            String content = Files.readString(Path.of(fileName));
            return Integer.parseInt(content);
        } catch (
                IOException ioe) {
            throw new IllegalStateException("File is non-readable!", ioe);
        }
    }

    public int sumNumbers() {
        int sum = 0;
        for (int counter = 0; counter < 100; counter++) {
            String fileName = "number" + (counter < 10 ? "0" + counter : counter) + ".txt";

            if (Files.isRegularFile(Path.of(fileName))) {
                int nr = readFile(fileName);
                sum += nr;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        FilesSum filesSum = new FilesSum();
        System.out.println(filesSum.sumNumbers());
    }
}
