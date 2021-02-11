package week14d05;

/*
A examples/week14d05/hachiko.srt van a Hachiko film felirata. Írj egy
countWords() metódust, mely paraméterül várja a fájlt, varargsban
szavakat. Megszámolja, hogy melyik szó hány sorban szerepel a
szövegben. Legyenek mondjuk a beadott szavak: "Hachiko", "haza",
"pályaudvar", "jó"
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Hachiko {

    public Map<String, Integer> countWords(BufferedReader bufferedReader, String... words) {

        Map<String, Integer> wordsOccurenceByLine = new HashMap<>();

        String line;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                //System.out.println(line);
                for (String word : words) {
                    if (line.toLowerCase().contains(word.toLowerCase())) {
                        Integer occurenceInLine = wordsOccurenceByLine.get(word);
                        if (occurenceInLine == null) {
                            wordsOccurenceByLine.put(word, 1);
                        } else {
                            wordsOccurenceByLine.put(word, occurenceInLine + 1);
                        }
                    }
                }
            }
        } catch (IOException ioException) {
            throw new IllegalStateException("File is non-readable!", ioException);
        }
        return wordsOccurenceByLine;
    }

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of("hachiko.srt"), Charset.forName("windows-1252"))) {
        //    System.out.println(new Hachiko().countWords(bufferedReader, "Hachiko", "haza", "pályaudvar", "jó"));
        } catch (IOException ioException) {
            throw new IllegalStateException("File is non radable!", ioException);
        }
    }
}