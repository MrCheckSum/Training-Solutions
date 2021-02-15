package exam03;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Histogram {

    public String createHistogram(BufferedReader reader) throws IOException {

        StringBuilder stringBuilder = new StringBuilder();
        String line;
        String repeateStr = "*";
        while ((line = reader.readLine()) != null) {
            String repeatedStr = repeateStr.repeat(Integer.parseInt(line));
            stringBuilder.append(repeatedStr + "\n");
         //   System.out.println(stringBuilder.toString());
        }
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        try (BufferedReader reader = Files.newBufferedReader(Path.of("src/main/resources/histogram.txt"))) {
            new Histogram().createHistogram(reader);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }
}
