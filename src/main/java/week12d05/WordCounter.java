package week12d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class WordCounter {

    public int countWord(String word, Path path){

        try (BufferedReader bufferedReader= Files.newBufferedReader(path)){
            String line;
            int c=0;
            while ((line = bufferedReader.readLine()) != null){
                if (line.toLowerCase().contains(word.toLowerCase())){
                    c++;
                }
            }return c;

        } catch (IOException e) {
            throw new IllegalStateException("File is non-readable!",e);
        }
    }

    public static void main(String[] args) {
        Path path = Path.of("index.html");
        WordCounter wordCounter= new WordCounter();
        System.out.println(wordCounter.countWord("koronavírus",path));
        System.out.println(wordCounter.countWord("Koronavírus",path));
        System.out.println(wordCounter.countWord("koRonAvírUs",path));
    }
}
